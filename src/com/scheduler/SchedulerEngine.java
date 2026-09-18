package com.scheduler;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SchedulerEngine {
    private DependencyGraph graph;
    private ProcessExecutor executor;
    private MetricsCollector metrics;
    private ExecutorService threadPool;

    public SchedulerEngine(DependencyGraph graph) {
        this.graph = graph;
        this.executor = new ProcessExecutor();
        this.metrics = new MetricsCollector();
        this.threadPool = Executors.newFixedThreadPool(4);
    }

    public void runPipeline() {
        try {
            List<TaskNode> order = graph.getExecutionOrder();
            for (TaskNode task : order) {
                threadPool.submit(() -> {
                    task.setStatus("RUNNING");
                    LoggerModule.log(task.getId(), "Starting execution: " + task.getCommand());
                    boolean success = executor.execute(task);
                    if (success) {
                        task.setStatus("SUCCESS");
                        metrics.recordSuccess();
                        LoggerModule.log(task.getId(), "Completed successfully.");
                    } else {
                        task.setStatus("FAILED");
                        metrics.recordFailure();
                        LoggerModule.log(task.getId(), "Task failed.");
                    }
                }).get();
            }
        } catch (Exception e) {
            System.err.println("Pipeline Error: " + e.getMessage());
        } finally {
            threadPool.shutdown();
            metrics.printSummary();
        }
    }
}
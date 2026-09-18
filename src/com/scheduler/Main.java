package com.scheduler;

public class Main {
    public static void main(String[] args) {
        System.out.println("Initializing Autonomous Task Scheduler Engine...\n");

        TaskNode task1 = new TaskNode("TASK_1", "echo Setup Initialized", "* * * * *");
        TaskNode task2 = new TaskNode("TASK_2", "echo Data Processed", "* * * * *");
        TaskNode task3 = new TaskNode("TASK_3", "echo Cleanup Finished", "* * * * *");

        task2.addDependency("TASK_1");
        task3.addDependency("TASK_2");

        DependencyGraph graph = new DependencyGraph();
        graph.addTask(task1);
        graph.addTask(task2);
        graph.addTask(task3);

        SchedulerEngine engine = new SchedulerEngine(graph);
        engine.runPipeline();
    }
}
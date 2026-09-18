package com.scheduler;

import java.util.concurrent.atomic.AtomicInteger;

public class MetricsCollector {
    private AtomicInteger totalExecuted = new AtomicInteger(0);
    private AtomicInteger totalFailed = new AtomicInteger(0);

    public void recordSuccess() { totalExecuted.incrementAndGet(); }
    public void recordFailure() { totalFailed.incrementAndGet(); }

    public void printSummary() {
        System.out.println("\n=== SCHEDULER METRICS SUMMARY ===");
        System.out.println("Total Tasks Run : " + totalExecuted.get());
        System.out.println("Total Failures  : " + totalFailed.get());
    }
}
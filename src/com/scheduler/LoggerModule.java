package com.scheduler;

import java.time.LocalDateTime;

public class LoggerModule {
    public static synchronized void log(String taskId, String message) {
        System.out.println("[" + LocalDateTime.now() + "] [" + taskId + "]: " + message);
    }
}
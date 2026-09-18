package com.scheduler;

public class CronParser {
    public boolean isValid(String cron) {
        if (cron == null || cron.trim().isEmpty()) return false;
        String[] parts = cron.trim().split("\\s+");
        return parts.length == 5;
    }

    public boolean shouldRunNow(String cron) {
        return isValid(cron);
    }
}

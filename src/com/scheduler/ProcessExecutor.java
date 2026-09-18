package com.scheduler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcessExecutor {
    public boolean execute(TaskNode task) {
        try {
            boolean isWindows = System.getProperty("os.name").toLowerCase().contains("win");
            ProcessBuilder pb = isWindows ? 
                new ProcessBuilder("cmd.exe", "/c", task.getCommand()) :
                new ProcessBuilder("sh", "-c", task.getCommand());

            Process p = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                LoggerModule.log(task.getId(), line);
            }
            return p.waitFor() == 0;
        } catch (Exception e) {
            LoggerModule.log(task.getId(), "Execution error: " + e.getMessage());
            return false;
        }
    }
}
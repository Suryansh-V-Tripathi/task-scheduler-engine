package com.scheduler;

import java.util.ArrayList;
import java.util.List;

public class TaskNode {
    private String id;
    private String command;
    private String cronExpression;
    private List<String> dependencies;
    private String status; // PENDING, RUNNING, SUCCESS, FAILED

    public TaskNode(String id, String command, String cronExpression) {
        this.id = id;
        this.command = command;
        this.cronExpression = cronExpression;
        this.dependencies = new ArrayList<>();
        this.status = "PENDING";
    }

    public void addDependency(String taskId) {
        dependencies.add(taskId);
    }

    public String getId() { 
        return id; 
    }

    public String getCommand() { 
        return command; 
    }

    public String getCronExpression() { 
        return cronExpression; 
    }

    public List<String> getDependencies() { 
        return dependencies; 
    }

    public String getStatus() { 
        return status; 
    }

    public void setStatus(String status) { 
        this.status = status; 
    }
}
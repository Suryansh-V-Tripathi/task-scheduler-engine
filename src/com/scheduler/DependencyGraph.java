package com.scheduler;

import java.util.*;

public class DependencyGraph {
    private Map<String, TaskNode> tasks = new HashMap<>();

    public void addTask(TaskNode task) {
        tasks.put(task.getId(), task);
    }

    public List<TaskNode> getExecutionOrder() throws IllegalStateException {
        Map<String, Integer> inDegree = new HashMap<>();
        for (String id : tasks.keySet()) inDegree.put(id, 0);

        for (TaskNode task : tasks.values()) {
            for (String dep : task.getDependencies()) {
                inDegree.put(task.getId(), inDegree.getOrDefault(task.getId(), 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String id : inDegree.keySet()) {
            if (inDegree.get(id) == 0) queue.add(id);
        }

        List<TaskNode> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            result.add(tasks.get(curr));

            for (TaskNode task : tasks.values()) {
                if (task.getDependencies().contains(curr)) {
                    inDegree.put(task.getId(), inDegree.get(task.getId()) - 1);
                    if (inDegree.get(task.getId()) == 0) queue.add(task.getId());
                }
            }
        }

        if (result.size() != tasks.size()) {
            throw new IllegalStateException("Circular dependency detected in graph!");
        }

        return result;
    }
}
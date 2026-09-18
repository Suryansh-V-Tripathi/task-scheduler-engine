# Autonomous Task Scheduler Engine

A small Java CLI project I made to learn about task scheduling, graph data structures, and multithreading in Java.

## What It Does
- Checks 5-part cron syntax.
- Resolves task order so prerequisite tasks complete first.
- Runs tasks using a Java thread pool (`ExecutorService`) and `ProcessBuilder`.
- Prints execution logs and a final summary count of passed/failed tasks.

## Tools Used
- **Language**: Java
- **Concepts**: `java.util.concurrent`, Directed Graphs, Topological Sort

## How to Run It

### 1. Compile the code
```bash
javac -d bin src/com/scheduler/*.java

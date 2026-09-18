# Autonomous Task Scheduler Engine

This project is created as my VITYARTHI Java project. I built this application to practice core Java concepts, including object-oriented programming, data structures, and multithreading.

## Project Overview

When running multiple system tasks, certain tasks must finish before others can begin. For example, a system might need to create a folder before saving a file inside it. This application is a Command Line Interface tool that organizes tasks into the correct execution sequence based on their dependencies and runs them automatically.

## Concepts and Tools Explained

- **Command Line Interface**: A text-based user interface used to run programs and execute commands directly through the terminal or console.
- **Directed Acyclic Graph**: A data structure made of nodes connected by directional edges that contains no closed loops or circular paths. This ensures that no task depends on itself directly or indirectly.
- **Topological Sorting**: An algorithm used on a directed graph to order tasks sequentially so that every prerequisite task runs completely before any task that depends on it.
- **Multithreading**: A feature in Java that allows a program to run multiple parts or tasks at the same time using different threads of execution.
- **Executor Service**: A built-in Java framework from the Java Concurrent Package (`java.util.concurrent`) that manages a pool of threads to execute asynchronous tasks without manually creating new threads every time.
- **Process Builder**: A class in Java used to create and start operating system level processes, allowing the application to execute native terminal commands directly on the host computer.
- **Cron Expression**: A standard 5-part string format used in software systems to define time schedules for running recurring jobs.

## How the Program Works

1. **Task Definition**: Tasks are defined with a unique identification string, a terminal command, and a schedule.
2. **Dependency Resolution**: Tasks are added to a Dependency Graph. The graph calculates the execution order using Topological Sorting so that all dependencies are resolved first.
3. **Execution**: The Scheduler Engine uses a fixed thread pool to run the commands using Process Builder.
4. **Logging and Metrics**: Real-time logs are printed to the console with precise timestamps, followed by a final metrics summary showing the total number of tasks executed and any failures that occurred.

## Requirements

- **Programming Language**: Java Development Kit version 17 or higher.
- **Version Control System**: Git.

## Instructions to Run the Project

### Step 1: Compile the Java Source Files
Open your terminal inside the root folder of this project and run the Java Compiler command:
```bash
javac -d bin src/com/scheduler/*.java

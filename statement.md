# Problem Statement & Scope

## Problem Statement
Modern background systems require efficient scheduling and dependency management. Existing lightweight utilities often lack graph-based dependency resolution and multi-threaded execution in a clean CLI interface.

## Scope of the Project
The Autonomous Task Scheduler Engine is a Java CLI tool that executes system shell commands based on 5-part cron schedules and Directed Acyclic Graph (DAG) task dependency chains.

## Target Users
* System Administrators automating routine CLI workflows.
* Developers needing lightweight execution pipelines locally.

## High-Level Features
* **Cron Expression Parser**: Evaluates 5-part cron syntax to schedule jobs.
* **DAG Dependency Engine**: Handles task execution order using topological sorting.
* **Asynchronous Execution**: Thread-pool execution via native process isolation.
* **Metrics & Logging**: Collects runtime stats, execution latency, and log outputs.
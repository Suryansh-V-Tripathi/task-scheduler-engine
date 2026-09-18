# Autonomous Task Scheduler Engine

## Overview
A multi-threaded Java CLI task scheduler using custom cron parsing, Directed Acyclic Graph (DAG) topological sorting, and asynchronous process execution.

## Features
- 5-part Cron Syntax Parsing
- Topological Dependency Ordering & Cycle Detection
- Thread-Pool Job Execution (`ProcessBuilder`)
- Real-Time Execution Metrics & Audit Logs

## Tech Stack
- **Language**: Java 17+
- **Concurrency**: `java.util.concurrent`
- **Build**: Native Java CLI / `javac`

## Quick Start Instructions

### 1. Build Project
```bash
javac -d bin src/com/scheduler/*.java
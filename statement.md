# Problem Statement & Scope

## Problem Statement
When running background tasks, it can be tricky to manage which task runs first if one depends on another. Many basic command-line tools don't handle task dependencies or run tasks asynchronously on multiple threads.

## Scope of the Project
This project is a simple Java CLI tool I built to practice Java concepts. It takes command-line tasks, checks their schedule format, sorts them based on dependencies so they run in the right order, and executes them using threads.

## Target Users
* Students learning how task dependencies work in Java.
* Anyone looking for a simple command-line task executor.

## Features
* **Cron Checker**: Checks if a 5-part cron string is formatted correctly.
* **Dependency Manager**: Uses a graph structure to make sure dependent tasks wait their turn.
* **Thread Execution**: Uses Java's ExecutorService to run tasks.
* **Basic Logging**: Prints timestamps and success/failure stats to the console.

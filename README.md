# Smart Task Manager CLI

## Overview
Smart Task Manager is a lightweight Command Line Interface (CLI) application built purely in Java. It allows users to track daily tasks, assign priorities, and undo actions. It utilizes Java Object-Oriented principles, Collections Framework, Exception Handling, and Multithreading.

## Features
- **Task Management**: Add standard or prioritized tasks.
- **Progress Tracking**: View all tasks and mark them as completed.
- **Undo Functionality**: Revert the last task addition using a Stack data structure.
- **Background Alerts**: A daemon thread runs in the background, alerting users of pending tasks every 30 seconds.
- **Crash-Proof CLI**: Custom Exceptions handle invalid inputs seamlessly.

## Technologies Used
- Java (JDK 8 or higher)
- Object-Oriented Programming (Inheritance, Polymorphism)
- Java Collections Framework (ArrayList, Stack)
- Java Multithreading (Runnable, Daemon Threads)

## How to Install and Run
Assume you have Java (JDK) installed and configured in your system's PATH.

1. **Clone the repository** (or download the files):
   ```bash
   git clone https://github.com/yourusername/Task-Manager-Project.git
   cd Task-Manager-Project/src
2. **Compile the Java files:**
   ```bash
   javac *.java
3. **Run the Application:**
   ```bash
   java Main

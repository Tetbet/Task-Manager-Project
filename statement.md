# Problem Statement: Smart Task Manager

## 1. Problem Statement
In today's fast-paced environment, individuals often struggle to keep track of their daily tasks, prioritize their work, and maintain productivity. Existing GUI task managers can be heavy and distracting. There is a need for a lightweight, terminal-based application that allows users to seamlessly manage their tasks, assign priorities, and receive automated reminders without leaving their command-line environment.

## 2. Scope of the Project
This project is a Command Line Interface (CLI) application built using Core Java. It handles Task Creation, Priority Management, Status Tracking, and Action History (Undo operations). It does not require a database connection, relying entirely on in-memory Java Data Structures (Collections) to ensure maximum speed and minimal setup.

## 3. Target Users
- Software Developers who prefer terminal-based tools.
- Students managing assignments and daily study goals.
- System Administrators who need a quick, no-GUI task list.

## 4. High-Level Features
1. **CRUD Operations:** Add, view, and mark tasks as complete.
2. **Priority Tagging:** Ability to create specialized tasks with High, Medium, or Low priority.
3. **Action History (Undo):** A stack-based undo mechanism to quickly revert accidental task additions.
4. **Background Reminders:** A multithreaded daemon service that periodically alerts the user of pending tasks while they interact with the main menu.
5. **Robust Error Handling:** Strict input validation utilizing custom Exception Handling to prevent system crashes.

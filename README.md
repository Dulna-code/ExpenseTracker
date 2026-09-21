# 💰 Personal Expense Tracker (CLI)

A terminal-based Java application to track daily expenses. This project was developed as a core Java exercise to demonstrate object-oriented programming, file handling, and clean software architecture.

## 🚀 Features
* **Interactive Menu:** A user-friendly command-line interface.
* **Log Expenses:** Add new expenses with a description, amount, and category.
* **Date Handling:** Automatically records the current date using Java's modern `LocalDate` API.
* **Persistent Storage:** Saves and reads all data securely from a local `expenses.csv` file using `BufferedReader` and `FileWriter`.

## 🛠️ Tech Stack
* **Language:** Java 25
* **Data Storage:** CSV (Comma-Separated Values)


## 📂 Project Structure
```text
├── README.md                      # Project documentation
├── expenses.csv                   # The auto-generated database file
└── src/
     └── expensetracker/           # Main Java package
          ├── Expense.java         # The Data Model (Encapsulation)
          ├── ExpenseService.java  # The Business Logic (CSV File I/O)
          └── Main.java            # The Frontend (CLI Menu & Scanner)
```
This README content is AI generated.
package expensetracker;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ExpenseService service = new ExpenseService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Personal Expense Tracker");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add new expense");
            System.out.println("2. View all expenses");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter description (e.g., Train Ticket): ");
                    String description = scanner.nextLine();

                    System.out.print("Enter amount (e.g., 49.50): ");

                    double amount = Double.parseDouble(scanner.nextLine().replace(",", "."));

                    System.out.print("Enter category (e.g., Transport): ");
                    String category = scanner.nextLine();

                    Expense newExpense = new Expense(LocalDate.now(), description, amount, category);
                    service.saveExpense(newExpense);
                    System.out.println("Expense saved successfully!");
                }
                case 2 -> {
                    System.out.println("\n--- Your Expenses ---");
                    List<Expense> expenses = service.getAllExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.printf("[%s] %s: €%.2f (%s)%n",
                                    e.getDate(), e.getDescription(), e.getAmount(), e.getCategory());
                        }
                    }
                }
                case 3 -> {
                    running = false;
                    System.out.println("Goodbye!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}


package expensetracker;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ExpenseService {
    private final String FILE_NAME = "expenses.csv";

    public void saveExpense(Expense expense) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME, true))) {
            writer.println(expense.toCsvRow());
        } catch (IOException e) {
            System.out.println("Error saving expense: " + e.getMessage());
        }
    }

    public List<Expense> getAllExpenses() {
        List<Expense> expenses = new ArrayList<>();
        File file = new File(FILE_NAME);

        if (!file.exists()) return expenses; // Return empty list if no file exists yet

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    LocalDate date = LocalDate.parse(parts[0]);
                    String description = parts[1];
                    double amount = Double.parseDouble(parts[2]);
                    String category = parts[3];

                    expenses.add(new Expense(date, description, amount, category));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading expenses: " + e.getMessage());
        }
        return expenses;
    }
}

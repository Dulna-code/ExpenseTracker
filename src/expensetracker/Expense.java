package expensetracker;

import java.time.LocalDate;

public class Expense {
    private LocalDate date;
    private String description;
    private double amount;
    private String category;

    public Expense(LocalDate date, String description,double amount, String category){
        this.date = date;
        this.description = description;
        this.amount = amount;
        this.category = category;
    }

    public String toCsvRow() {
        return date + ";" + description + ";" + amount + ";" + category;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}

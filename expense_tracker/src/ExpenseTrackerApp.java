import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// Defined the ExpenseTrackerView class that extends JFrame
public class ExpenseTrackerView extends JFrame {

  // Declared private instance variables
  private JTable transactionsTable;
  private JButton addTransactionBtn;
  private JTextField amountField;
  private JTextField categoryField;
  private DefaultTableModel model;
  private List<Transaction> transactions = new ArrayList<>();

  // Constructor for the ExpenseTrackerView class
  public ExpenseTrackerView(DefaultTableModel model) {
    // Set the title of the JFrame
    setTitle("Expense Tracker");
    // Set the initial size of the JFrame
    setSize(600, 400);
    this.model = model;

    // Created a "Add Transaction" button
    addTransactionBtn = new JButton("Add Transaction");

    // Created UI components for amount and category input
    JLabel amountLabel = new JLabel("Amount:");
    amountField = new JTextField(10);

    JLabel categoryLabel = new JLabel("Category:");
    categoryField = new JTextField(10);

    // Created a JTable for displaying transactions using the provided model

    transactionsTable = new JTable(model);

    // Created panels for organizing UI components
    JPanel inputPanel = new JPanel();
    inputPanel.add(amountLabel);
    inputPanel.add(amountField);
    inputPanel.add(categoryLabel);
    inputPanel.add(categoryField);
    inputPanel.add(addTransactionBtn);

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(addTransactionBtn);

    // Add panels to the frame using BorderLayout
    add(inputPanel, BorderLayout.NORTH);
    add(new JScrollPane(transactionsTable), BorderLayout.CENTER);
    add(buttonPanel, BorderLayout.SOUTH);

    // Set frame properties
    setSize(400, 300); // Repeated size setting, consider removing one
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  // Getter method for the transactions table
  public JTable getTransactionsTable() {
    return transactionsTable;
  }

  // Getter method for retrieving the amount from the amount field
  public double getAmountField() {
    if (amountField.getText().isEmpty()) {
      return 0;
    } else {
      double amount = Double.parseDouble(amountField.getText());
      return amount;
    }
  }

  // Setter method for the amount field
  public void setAmountField(JTextField amountField) {
    this.amountField = amountField;
  }

  // Getter method for retrieving the category from the category field
  public String getCategoryField() {
    return categoryField.getText();
  }

  // Setter method for the category field
  public void setCategoryField(JTextField categoryField) {
    this.categoryField = categoryField;
  }

  // Getter method for the "Add Transaction" button
  public JButton getAddTransactionBtn() {
    return addTransactionBtn;
  }

  // Getter method for the table model
  public DefaultTableModel getTableModel() {
    return model;
  }

  // Method to refresh the table with a list of transactions
  public void refreshTable(List<Transaction> transactions) {
    model.setRowCount(0);
    int rowNum = model.getRowCount();
    double totalCost = 0;

    // Calculate the total cost of transactions
    for (Transaction t : transactions) {
      totalCost += t.getAmount();
    }

    // Add rows from the transactions list to the table
    for (Transaction t : transactions) {
      model.addRow(new Object[]{rowNum += 1, t.getAmount(), t.getCategory(), t.getTimestamp()});
    }

    // Create a row for the total cost
    Object[] totalRow = {"Total", null, null, totalCost};
    model.addRow(totalRow);

    // Update the table UI
    transactionsTable.updateUI();
  }

  // Method to refresh the view with transactions from the model
  public void refresh() {
    // Get transactions from the model
    List<Transaction> transactions = getTransactions();

    // Pass transactions to the view for refreshing the table
    refreshTable(transactions);
  }

  // Getter method for retrieving the list of transactions
  public List<Transaction> getTransactions() {
    return transactions;
  }

  // Method to add a transaction to the list and update the table
  public void addTransaction(Transaction t) {
    transactions.add(t);
    getTableModel().addRow(new Object[]{t.getAmount(), t.getCategory(), t.getTimestamp()});
    refresh(); // Refresh the view
  }

  // Method for clearing input fields (empty method body)
  public void clearInputFields() {
    // Method body is empty
  }

  // Other view methods (not implemented in the provided code)
}

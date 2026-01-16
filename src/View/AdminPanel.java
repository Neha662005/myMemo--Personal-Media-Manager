/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.table.TableRowSorter;
import Controller.Actions;
import Model.UserInfo;

/**
 * AdminPanel is a JFrame window that provides administrative functionality for managing user accounts.
 * It allows administrators to view, search, and delete user records from the system.
 * Access to the admin panel is protected by a password.
 *
 * <p>
 * Features:
 *   Display all registered users in a sortable table
 *   Search functionality to filter users by name, phone, or email
 *   Delete individual user records
 *   Delete all user records at once
 *   Refresh the user list from file
 *
 * @author HP
 * @version 1.0
 * @see Actions
 * @see UserInfo
 */
public class AdminPanel extends javax.swing.JFrame {
    private static final String USER_FILE = "src/userInformation.txt";
    private static final String ADMIN_PASSWORD = "admin123";

    /** JTable component for displaying user data */
    private JTable table;
    
    /** DefaultTableModel for managing table data */
    private DefaultTableModel model;
    
    /** TableRowSorter for implementing search and sort functionality */
    private TableRowSorter<DefaultTableModel> sorter;
    
    /** JTextField for user search input */
    private JTextField searchField;

    /**
     * Constructs the AdminPanel window with UI components and initializes layout.
     * Sets up the table for user display, search panel, and action buttons.
     */
    private AdminPanel() {
        setTitle("Admin Panel");
        setSize(600, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // 1️⃣ Table setup (read-only)
        String[] columns = {"Name", "Phone", "Email"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);

        refreshTable();

        add(new JScrollPane(table), BorderLayout.CENTER);

        // 2️⃣ Top panel: Search
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Search:"));
        searchField = new JTextField(20);
        topPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        topPanel.add(searchButton);

        JButton clearSearch = new JButton("Clear");
        topPanel.add(clearSearch);

        add(topPanel, BorderLayout.NORTH);

        // 3️⃣ Bottom panel: Action buttons
        JPanel buttonPanel = new JPanel();
        JButton deleteSelected = new JButton("Delete Selected");
        JButton deleteAll = new JButton("Delete All");
        JButton refresh = new JButton("Refresh");

        buttonPanel.add(deleteSelected);
        buttonPanel.add(deleteAll);
        buttonPanel.add(refresh);

        add(buttonPanel, BorderLayout.SOUTH);

        // Action listeners for all buttons
        deleteSelected.addActionListener(e -> deleteSelectedUser());
        deleteAll.addActionListener(e -> deleteAllUsers());
        refresh.addActionListener(e -> refreshTable());

        searchButton.addActionListener(e -> searchUsers());
        clearSearch.addActionListener(e -> {
            searchField.setText("");
            sorter.setRowFilter(null);
        });
    }

    // Refresh table from memory
    /**
     * Refreshes the table display by loading the latest user data from memory.
     * Clears existing table rows and populates with current users from the Actions controller.
     */
    private void refreshTable() {
        model.setRowCount(0);
        for (UserInfo u : Actions.getUsers()) {
            model.addRow(new Object[]{
                    u.getName(),
                    u.getPhone(),
                    u.getEmail()
            });
        }
    }

    // Delete selected row
    /**
     * Deletes the currently selected user from the table and updates the file.
     * Displays an error message if no user is selected.
     */
    private void deleteSelectedUser() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            int modelRow = table.convertRowIndexToModel(row); // Handle sorting
            Actions.getUsers().remove(modelRow);
            updateUsersFile();
            refreshTable();
        } else {
            JOptionPane.showMessageDialog(this, "Select a user first!");
        }
    }

    // Delete all users
    /**
     * Deletes all users from the system after confirmation.
     * Shows a confirmation dialog before performing the deletion.
     */
    private void deleteAllUsers() {
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete ALL users?",
                "Confirm",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            Actions.getUsers().clear();
            updateUsersFile();
            refreshTable();
        }
    }

    // Save users to file
    /**
     * Writes the current user list to the user information file.
     * Creates a formatted file with user data (name, phone, email, password).
     * Handles IOException if file writing fails.
     */
    private void updateUsersFile() {
        try (FileWriter fw = new FileWriter(USER_FILE)) {
            for (UserInfo u : Actions.getUsers()) {
                fw.write(u.getName() + "," +
                        u.getPhone() + "," +
                        u.getEmail() + "," +
                        u.getPassword() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Search functionality
    /**
     * Filters the table rows based on search text input.
     * Uses case-insensitive regex filtering to search across all columns.
     * Clears the filter if the search field is empty.
     */
    private void searchUsers() {
        String text = searchField.getText().trim();
        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            // Filter rows containing the search text in any column
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }

    // ================= STATIC ENTRY =================
    /**
     * Static method to open the AdminPanel with password protection.
     * Prompts the user to enter the admin password before displaying the panel.
     * Shows an error message if the password is incorrect.
     */
    public static void openAdminPanel() {
        String pwd = JOptionPane.showInputDialog(
                null,
                "Enter admin password:"
        );

        if (pwd == null) return;

        if (pwd.equals(ADMIN_PASSWORD)) {
            new AdminPanel().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Wrong password!");
        }
    }
    /**
     * Initializes the form components (auto-generated by Form Editor).
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Main entry point for testing the AdminPanel.
     * Sets the Nimbus look and feel and displays the AdminPanel window.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AdminPanel().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

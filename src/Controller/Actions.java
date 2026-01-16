package Controller;

import Model.UserInfo;
import java.io.*;
import java.util.ArrayList;

/**
 * Actions class - Handles user authentication and file persistence.
 * This class manages user sign-up, sign-in, and user data persistence to file.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class Actions {

    /** Path to user information file */
    private static final String FILE = "D:\\myMemo\\myMemo\\src\\userInformation.txt";

    /** In-memory list of all registered users */
    private static ArrayList<UserInfo> users = new ArrayList<>();

    /**
     * Static initializer block that loads users from file when class is loaded
     */
    static {
        loadUsers();
    }

    /**
     * Registers a new user by adding to memory and writing to file.
     * Validates that all required fields are non-empty and email is unique.
     *
     * @param newUser The UserInfo object containing registration details
     * @return true if sign-up is successful, false if validation fails or user already exists
     */
    public static boolean signUp(UserInfo newUser) {
        // Validate all fields are non-empty
        if (newUser.getName().isEmpty() || newUser.getEmail().isEmpty() || 
            newUser.getPhone().isEmpty() || newUser.getPassword().isEmpty()) {
            return false;
        }

        // Check if email already exists
        for (UserInfo u : users) {
            if (u.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                return false;
            }
        }

        // Add new user to in-memory list
        users.add(newUser);

        // Persist user to file
        try {
            File f = new File(FILE);
            if (!f.exists()) {
                f.createNewFile();
            }

            FileWriter fw = new FileWriter(f, true);
            fw.write(newUser.getName() + "," + newUser.getPhone() + "," + 
                     newUser.getEmail() + "," + newUser.getPassword() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Authenticates user by verifying email and password.
     * Validates that both email and password are non-empty and match stored credentials.
     *
     * @param email The user's email address
     * @param password The user's password
     * @return true if credentials match, false otherwise
     */
    public static boolean signIn(String email, String password) {
        // Validate input fields are non-empty
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check against all registered users
        for (UserInfo u : users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loads all user data from file into memory.
     * Called during class initialization and can be used to refresh user data.
     */
    private static void loadUsers() {
        users.clear();
        try {
            File f = new File(FILE);
            if (!f.exists()) {
                f.createNewFile();
                return;
            }

            FileReader fr = new FileReader(f);
            StringBuilder line = new StringBuilder();
            int c;
            while ((c = fr.read()) != -1) {
                char ch = (char) c;
                if (ch == '\n') {
                    processLine(line.toString());
                    line.setLength(0);
                } else {
                    line.append(ch);
                }
            }
            if (line.length() > 0) {
                processLine(line.toString());
            }

            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Parses a single line from the user file and creates a UserInfo object.
     * Expected format: name,phone,email,password
     *
     * @param line The line to parse
     */
    private static void processLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            users.add(new UserInfo(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                parts[3].trim()   
            ));
        }
    }

    /**
     * Retrieves the list of all registered users.
     *
     * @return ArrayList containing all UserInfo objects
     */
    public static ArrayList<UserInfo> getUsers() {
        return users;
    }
}

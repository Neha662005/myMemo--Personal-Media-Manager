package Controller;

import Model.UserInfo;//import USerInfo from model folder
import java.io.*;
import java.util.ArrayList;

public class Actions {

    private static final String FILE = "D:\\myMemo\\myMemo\\src\\userInformation.txt";

    // List to save users in memory
    private static ArrayList<UserInfo> users = new ArrayList<>();

    // Load users from file when class is loaded
    static {
        loadUsers();
    }

    // Sign up method
    public static boolean signUp(UserInfo newUser) {
        // Check for empty fields
        if (newUser.getName().isEmpty() || newUser.getEmail().isEmpty() || newUser.getPhone().isEmpty() || newUser.getPassword().isEmpty()) {
            return false;
        }

        // Check if email already exists
        for (UserInfo u : users) {
            if (u.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                return false; // email already exists
            }
        }

        // Add to memory
        users.add(newUser);

        // Write to file
        try {
            File f = new File(FILE);
            if (!f.exists()) f.createNewFile(); // create file if not ex/ists

            FileWriter fw = new FileWriter(f, true); // append mode
            fw.write(newUser.getName() + "," + newUser.getPhone() + "," + newUser.getEmail() + "," + newUser.getPassword() + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    // signIn method
    public static boolean signIn(String email, String password) {
        // Validate empty fields
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }

        // Check users credentials
        for (UserInfo u : users) {
            if (u.getEmail().equalsIgnoreCase(email) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Loads all users from file into memory
    private static void loadUsers() {
        users.clear();
        try {
            File f = new File(FILE);
            if (!f.exists()) {
                f.createNewFile(); // create file if not exists
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

    private static void processLine(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            users.add(new UserInfo(parts[0], parts[1], parts[2], parts[3]));
        }
    }

    //gets list of users
    public static ArrayList<UserInfo> getUsers() {
        return users;
    }
}

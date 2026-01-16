package Controller;

/**
 * AdminAuth class - Manages administrative authentication and password changes.
 * Provides login verification and password change functionality for admin access.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class AdminAuth {
    /** Default admin password */
    private static String password = "admin123";

    /**
     * Authenticates admin login by verifying the provided password.
     *
     * @param input The password input to verify
     * @return true if password matches, false otherwise
     */
    public static boolean login(String input) {
        return input.equals(password);
    }

    /**
     * Changes the admin password to a new value.
     * Does not allow empty passwords.
     *
     * @param newPassword The new password to set
     */
    public static void changePassword(String newPassword) {
        if (!newPassword.isEmpty()) {
            password = newPassword;
        }
    }
}

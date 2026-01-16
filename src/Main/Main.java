package Main;

import View.SigninFrame;

/**
 * Main class - Entry point for the myMemo application.
 * Initializes and displays the sign-in frame on application startup.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class Main {

    /**
     * Main method - Application entry point.
     * Creates and displays the SigninFrame for user authentication.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        SigninFrame frame = new SigninFrame();
        frame.setVisible(true);
    }
}

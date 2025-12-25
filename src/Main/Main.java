package Main;  // <-- Your package

import View.SigninFrame;  // Import the SigninFrame from View package

public class Main {  // Class name must match file name
    public static void main(String[] args) {
        SigninFrame frame = new SigninFrame();
        frame.setVisible(true);
    }
}

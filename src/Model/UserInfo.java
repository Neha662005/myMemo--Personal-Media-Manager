package Model;

/**
 * UserInfo class - Represents user account information.
 * Stores and manages user credentials and contact information.
 *
 * @author myMemo Team
 * @version 1.0
 */
public class UserInfo {
    /** User's full name */
    private String name;
    /** User's phone number */
    private String phone;
    /** User's email address */
    private String email;
    /** User's password */
    private String password;

    /**
     * Constructs a UserInfo with user registration details.
     *
     * @param name The user's full name
     * @param phone The user's phone number
     * @param email The user's email address
     * @param password The user's password
     */
    public UserInfo(String name, String phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    /**
     * Gets the user's email address.
     *
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's password.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's full name.
     *
     * @return The full name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the user's phone number.
     *
     * @return The phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the user's phone number.
     *
     * @param phone The new phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets the user's password.
     *
     * @param password The new password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

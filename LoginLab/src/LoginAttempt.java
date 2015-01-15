public class LoginAttempt {
    public String username;
    public String password;

    public LoginAttempt(String username, String password) {
        if (username.length() > 9) {
            System.err.println("Username too long!");
            username = "username";
        }

        this.username = username;
        this.password = password;
    }
}

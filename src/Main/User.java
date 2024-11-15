package Main;

public abstract class User {
    protected String userID;
    protected String username;
    protected String email;
    protected String password;
    protected String userType;

    public User(String userID, String username, String email, String password, String userType) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getUserType() { return userType; }
    public String getPassword () {return password; }
    public abstract void performRoleAction();
}
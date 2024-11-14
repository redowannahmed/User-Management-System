package Main;

public class DefaultUserFactory implements UserFactory {
    @Override
    public User createUser(String userID, String username, String email, String password, String userType) {
        switch (userType) {
            case "Admin":
                return new AdminUser(userID, username, email, password);
            case "Power":
                return new PowerUser(userID, username, email, password);
            case "Regular":
                return new RegularUser(userID, username, email, password);
            default:
                throw new IllegalArgumentException("Invalid user type: " + userType);
        }
    }
}
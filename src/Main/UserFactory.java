package Main;

public interface UserFactory {
    User createUser(String userID, String username, String email, String password, String userType);
}
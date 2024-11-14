package Main;

public interface IUserRepository {
    User getUserByUsername(String username);
    void saveUser(User user);
}
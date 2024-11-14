package Main;

public class AdminService {
    private IUserRepository userRepository;

    public AdminService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.saveUser(user);
    }

    // Additional admin-specific methods can be added here as needed
}

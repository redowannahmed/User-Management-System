package Main;

public class AuthenticationService implements IAuthenticationService {
    private IUserRepository userRepository;

    public AuthenticationService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        throw new IllegalArgumentException("Invalid credentials");
    }
}

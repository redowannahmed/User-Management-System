package Main;

public class UserService {
    private IAuthenticationService authService;

    public UserService(IAuthenticationService authService) {
        this.authService = authService;
    }

    public User login(String username, String password) {
        return authService.authenticate(username, password);
    }
}
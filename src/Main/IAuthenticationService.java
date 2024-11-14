package Main;

public interface IAuthenticationService {
    User authenticate(String username, String password);
}
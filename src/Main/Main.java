package Main;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        UserFactory userFactory = new DefaultUserFactory();
        IUserRepository userRepository = new UserRepository(userFactory);
        IAuthenticationService authService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(userRepository);

        // Demonstrate user authentication
        try {
            User regularUser = authService.authenticate("regular_user", "regularpass");
            System.out.println("Authentication successful! Welcome, " + regularUser.getUsername() + "!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User adminUser = authService.authenticate("admin_user", "adminpass");
            System.out.println("Authentication successful! Welcome, Admin " + adminUser.getUsername() + "!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // Demonstrate admin adding a new user
        User newUser = new RegularUser("4", "new_user", "newuser@example.com", "newpassword");
        adminService.addUser(newUser);
        System.out.println("New user added successfully!");

        // Check that the new user is added by attempting authentication
        try {
            User newUserAuth = authService.authenticate("new_user", "newpassword");
            System.out.println("Authentication successful! Welcome, " + newUserAuth.getUsername() + "!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

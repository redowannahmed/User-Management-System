package Main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserManagementSystemTest {
    
    private UserRepository userRepository = new UserRepository(new DefaultUserFactory());
    private AuthenticationService authService = new AuthenticationService(userRepository);
    private AdminService adminService = new AdminService(userRepository);

    @Test
    public void testRegularUserAuthentication() {
        User user = authService.authenticate("regular_user", "regularpass");
        assertNotNull(user);
        assertEquals("Regular", user.getUserType());
    }

    @Test
    public void testInvalidUserAuthentication() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            authService.authenticate("invalid_user", "wrongpass");
        });
        assertEquals("Invalid credentials", exception.getMessage());
    }

    @Test
    public void testAdminUserPrivileges() {
        User adminUser = authService.authenticate("admin_user", "adminpass");
        assertEquals("Admin", adminUser.getUserType());
        adminService.addUser(new RegularUser("5", "test_user", "test@example.com", "testpass"));
        User newUser = authService.authenticate("test_user", "testpass");
        assertNotNull(newUser);
        assertEquals("Regular", newUser.getUserType());
    }

    @Test
    public void testNewUserAddition() {
        User newUser = new RegularUser("4", "new_user", "newuser@example.com", "newpassword");
        adminService.addUser(newUser);
        User addedUser = authService.authenticate("new_user", "newpassword");
        assertNotNull(addedUser);
    }
}

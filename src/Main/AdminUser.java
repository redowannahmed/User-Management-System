package Main;

public class AdminUser extends User implements Readable, Writable, AdminPrivileges {
    public AdminUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Admin");
    }

    @Override
    public void read() {
        System.out.println("Reading data as Admin.");
    }

    @Override
    public void write() {
        System.out.println("Writing data as Admin.");
    }

    @Override
    public void performAdminAction() {
        System.out.println("Performing admin action.");
    }

    @Override
    public void performRoleAction() {
        read();
        write();
        performAdminAction();
    }
}
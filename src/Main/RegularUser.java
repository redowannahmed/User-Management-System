package Main;

public class RegularUser extends User implements Readable {
    public RegularUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Regular");
    }

    @Override
    public void read() {
        System.out.println("Reading data as Regular User.");
    }

    @Override
    public void performRoleAction() {
        read();
    }
}
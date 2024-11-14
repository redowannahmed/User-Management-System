package Main;

public class PowerUser extends User implements Readable, Writable {
    public PowerUser(String userID, String username, String email, String password) {
        super(userID, username, email, password, "Power");
    }

    @Override
    public void read() {
        System.out.println("Reading data as Power User.");
    }

    @Override
    public void write() {
        System.out.println("Writing data as Power User.");
    }

    @Override
    public void performRoleAction() {
        read();
        write();
    }
}
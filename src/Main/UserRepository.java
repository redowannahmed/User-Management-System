package Main;

import java.io.*;

public class UserRepository implements IUserRepository {
    private static final String USER_FILE = "User.csv";
    private static final String ADMIN_FILE = "Admin.csv";
    private UserFactory userFactory;

    public UserRepository(UserFactory userFactory) {
        this.userFactory = userFactory;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = findUserInFile(username, USER_FILE);
        if (user == null) {
            user = findUserInFile(username, ADMIN_FILE);
        }
        return user;
    }

    @Override
    public void saveUser(User user) {
        String filePath = user instanceof AdminUser ? ADMIN_FILE : USER_FILE;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(formatUserToCSV(user));
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private User findUserInFile(String username, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = parseCSVToUser(line);
                if (user != null && user.getUsername().equals(username)) {
                    return user;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String formatUserToCSV(User user) {
        return String.format("%s,%s,%s,%s,%s",
                user.userID, user.getUsername(), user.getEmail(), user.password, user.getUserType());
    }

    private User parseCSVToUser(String csvLine) {
        String[] tokens = csvLine.split(",");
        if (tokens.length < 5) return null;

        String userID = tokens[0];
        String username = tokens[1];
        String email = tokens[2];
        String password = tokens[3];
        String userType = tokens[4];

        return userFactory.createUser(userID, username, email, password, userType);
    }
}

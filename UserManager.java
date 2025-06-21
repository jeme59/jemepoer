
import java.io.*;
import java.util.*;

public class UserManager {

    private static final String FILE_NAME = "users.txt";

    public static boolean saveUser(User user) {
        if (findUser(user.getName(), user.getPassword()) != null) {
            System.out.println(LanguageManager.get("user_exists"));
            return false;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(user.toFileString());
            writer.newLine();
            return true;
        } catch (IOException e) {
            System.out.println("حدث خطأ أثناء حفظ المستخدم.");
        }
        return false;
    }

    public static User findUser(String name, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null && user.getName().equals(name) && user.getPassword().equals(password)) {
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user.");
        }
        return null;
    }

    public static void updateUser(User updatedUser) {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null) {
                    if (user.getName().equals(updatedUser.getName()) &&
                            user.getPassword().equals(updatedUser.getPassword())) {
                        users.add(updatedUser);
                    } else {
                        users.add(user);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(user.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing users.");
        }
    }
}

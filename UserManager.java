import java.io.*;

public class UserManager {

    private static final String FILE_NAME = "users.txt";

    public static boolean saveUser(User user) {
        if (!isValidEmail(user.getEmail())) {
            System.out.println("Invalid email. Must contain '@' and '.'");
            return false;
        }

        if (!isValidPassword(user.getPassword())) {
            System.out.println("Invalid password. Must start with an uppercase letter and contain at least 5 digits.");
            return false;
        }

        if (emailExists(user.getEmail())) {
            System.out.println("This email is already registered.");
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

    public static User findUser(String email, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;

            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);

                if (user != null &&
                        user.getEmail().trim().equalsIgnoreCase(email.trim()) &&
                        user.getPassword().trim().equals(password.trim())) {
                    return user;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file.");
        }
        return null;
    }

    public static boolean emailExists(String email) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null && user.getEmail().equals(email)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file.");
        }
        return false;
    }

    // ✅ تحديث بيانات المستخدم باستخدام مصفوفة
    public static void updateUser(User updatedUser) {
        User[] users = new User[100];
        int count = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                User user = User.fromString(line);
                if (user != null) {
                    if (user.getEmail().equals(updatedUser.getEmail())) {
                        users[count++] = updatedUser;
                    } else {
                        users[count++] = user;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading user file.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            for (int i = 0; i < count; i++) {
                writer.write(users[i].toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing user file.");
        }
    }

    // ✅ فحص الإيميل
    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    // ✅ فحص كلمة السر
    public static boolean isValidPassword(String password) {
        if (password.length() == 0 || !Character.isUpperCase(password.charAt(0))) {
            return false;
        }

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        return digitCount >= 5;
    }
}

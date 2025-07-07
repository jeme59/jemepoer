import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LanguageManager.chooseLanguage(scan);

        System.out.println(LanguageManager.get("welcome"));
        System.out.println("1. " + LanguageManager.get("new_user"));
        System.out.println("2. " + LanguageManager.get("existing_user"));
        int option = scan.nextInt();
        scan.nextLine();

        User user = null;

        if (option == 1) {
            // إدخال الإيميل والتحقق
            String name;
            while (true) {
                System.out.print(LanguageManager.get("enter_email"));
                name = scan.nextLine();

                if (!name.contains("@") || !name.contains(".")) {
                    System.out.println("Invalid email. Must contain '@' and '.'");
                    continue;
                }

                if (UserManager.emailExists(name)) {
                    System.out.println("This email is already registered. Please try another one.");
                    continue;
                }

                break;
            }

            // كلمة السر
            String password;
            while (true) {
                System.out.print(LanguageManager.get("enter_password"));
                password = scan.nextLine();
                if (isValidPassword(password)) {
                    break;
                } else {
                    System.out.println("Invalid password. It must start with an uppercase letter and contain at least 5 digits.");
                }
            }

            System.out.println(LanguageManager.get("choose_goal"));
            System.out.println("1. Muscle Gain");
            System.out.println("2. Weight Loss");
            int goalChoice = scan.nextInt();
            scan.nextLine();
            String goal = (goalChoice == 1) ? "Muscle Gain" : "Weight Loss";

            System.out.print(LanguageManager.get("enter_days"));
            int days = scan.nextInt();
            scan.nextLine();

            user = new User(name, password, goal, days);
            boolean saved = UserManager.saveUser(user);
            if (saved) {
                System.out.println(LanguageManager.get("account_created"));
            } else {
                return;
            }

        } else if (option == 2) {
            // تسجيل الدخول
            String name;
            while (true) {
                System.out.print(LanguageManager.get("enter_email"));
                name = scan.nextLine();
                if (name.contains("@") && name.contains(".")) {
                    break;
                } else {
                    System.out.println("Invalid email. Must contain '@' and '.'");
                }
            }

            String password;
            while (true) {
                System.out.print(LanguageManager.get("enter_password"));
                password = scan.nextLine();
                if (isValidPassword(password)) {
                    break;
                } else {
                    System.out.println("Invalid password. It must start with an uppercase letter and contain at least 5 digits.");
                }
            }

            user = UserManager.findUser(name, password);
            if (user == null) {
                System.out.println(LanguageManager.get("user_exists"));
                return;
            }
        }

        // ✅ القائمة التفاعلية
        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Show workout plan");
            System.out.println("2. Change goal");
            System.out.println("3. Change number of days");
            System.out.println("4. Logout");

            int choice = scan.nextInt();
            scan.nextLine();

            if (choice == 1) {
                String[] plan = WorkoutGenerator.generatePlan(user.getDays(), user.getGoal());
                System.out.println("\nYour Weekly Workout Plan:");
                for (String day : plan) {
                    System.out.println(day);
                }
            } else if (choice == 2) {
                System.out.println("1. Muscle Gain");
                System.out.println("2. Weight Loss");
                int newGoal = scan.nextInt();
                scan.nextLine();
                user.setGoal((newGoal == 1) ? "Muscle Gain" : "Weight Loss");
                System.out.println("Goal updated!");
                UserManager.updateUser(user); // ✅ حفظ التغيير
            } else if (choice == 3) {
                System.out.print("Enter new number of days per week: ");
                int newDays = scan.nextInt();
                scan.nextLine();
                user.setDays(newDays);
                System.out.println("Number of days updated!");
                UserManager.updateUser(user); // ✅ حفظ التغيير
            } else if (choice == 4) {
                System.out.println("Logged out. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // ✅ دالة فحص كلمة السر
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

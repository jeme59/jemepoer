
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
            System.out.print(LanguageManager.get("enter_name"));
            String name = scan.nextLine();
            System.out.print(LanguageManager.get("enter_password"));
            String password = scan.nextLine();

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
            System.out.print(LanguageManager.get("enter_name"));
            String name = scan.nextLine();
            System.out.print(LanguageManager.get("enter_password"));
            String password = scan.nextLine();

            user = UserManager.findUser(name, password);
            if (user == null) {
                System.out.println(LanguageManager.get("invalid_login"));
                return;
            }
            System.out.println(LanguageManager.get("login_success"));
        }

        boolean running = true;
        while (running) {
            System.out.println(LanguageManager.get("menu"));
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    String[] plan = WorkoutGenerator.generatePlan(user.getDays(), user.getGoal());
                    System.out.println(LanguageManager.get("your_plan"));
                    for (String day : plan) {
                        System.out.println(day);
                    }
                    break;
                case 2:
                    System.out.println(LanguageManager.get("choose_goal"));
                    System.out.println("1. Muscle Gain");
                    System.out.println("2. Weight Loss");
                    int goalChoice = scan.nextInt();
                    scan.nextLine();
                    user.setGoal((goalChoice == 1) ? "Muscle Gain" : "Weight Loss");
                    System.out.println(LanguageManager.get("goal_updated"));
                    UserManager.updateUser(user);
                    break;
                case 3:
                    System.out.print(LanguageManager.get("enter_days"));
                    int newDays = scan.nextInt();
                    scan.nextLine();
                    user.setDays(newDays);
                    System.out.println(LanguageManager.get("days_updated"));
                    UserManager.updateUser(user);
                    break;
                case 4:
                    System.out.println(LanguageManager.get("logout"));
                    running = false;
                    break;
                default:
                    System.out.println(LanguageManager.get("invalid_option"));
            }
        }
        scan.close();
    }
}

import java.util.Scanner;

public class LanguageManager {
    private static String lang = "ar";

    public static void chooseLanguage(Scanner scan) {
        System.out.println("اختر اللغة:");
        System.out.println("choose a language:");
        System.out.println("1. عربي");
        System.out.println("2. English");
        int choice = scan.nextInt();
        scan.nextLine();
        lang = (choice == 2) ? "en" : "ar";
    }

    public static String get(String key) {
        if (lang.equals("en")) {
            switch (key) {
                case "welcome": return "Welcome to Jemepwer!";
                case "new_user": return "New User";
                case "existing_user": return "Already Registered";
                case "enter_email": return "Enter your email: ";
                case "enter_password": return "Enter your password: ";
                case "choose_goal": return "Choose your goal: ";
                case "enter_days": return "How many days per week do you want to train? ";
                case "account_created": return "Account created successfully!";
                case "user_exists": return "User already exists!";
                default: return "";
            }
        } else {
            switch (key) {
                case "welcome": return "مرحبًا بك في Jemepwer!";
                case "new_user": return "مستخدم جديد";
                case "existing_user": return "مشترك مسبقًا";
                case "enter_email": return "أدخل بريدك الإلكتروني:";
                case "enter_password": return "أدخل كلمة المرور:";
                case "choose_goal": return "اختر هدفك:";
                case "enter_days": return "كم يومًا في الأسبوع تريد أن تتمرن؟";
                case "account_created": return "تم إنشاء الحساب بنجاح!";
                case "user_exists": return "المستخدم موجود بالفعل!";
                default: return "";
            }
        }
    }
}

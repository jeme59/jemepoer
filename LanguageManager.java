
import java.util.Scanner;

public class LanguageManager {
    private static String lang = "ar";

    public static void chooseLanguage(Scanner scan) {
        System.out.println("اختر اللغة:");
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
                case "enter_name": return "Enter your name: ";
                case "enter_password": return "Enter your password: ";
                case "choose_goal": return "Choose your goal: ";
                case "enter_days": return "How many days per week do you want to train? ";
                case "account_created": return "Account created successfully!";
                case "login_success": return "Login successful!";
                case "invalid_login": return "Incorrect name or password.";
                case "user_exists": return "User already exists! Please use different credentials.";
                case "menu": return "\n1. Show Plan\n2. Update Goal\n3. Update Days\n4. Logout\nEnter your choice:";
                case "your_plan": return "Your workout plan:";
                case "goal_updated": return "Goal updated.";
                case "days_updated": return "Days updated.";
                case "logout": return "You have logged out.";
                case "invalid_option": return "Invalid option.";
            }
        } else {
            switch (key) {
                case "welcome": return "مرحبًا بك في Jemepwer!";
                case "new_user": return "مستخدم جديد";
                case "existing_user": return "مسجل مسبقًا";
                case "enter_name": return "أدخل اسمك: ";
                case "enter_password": return "أدخل كلمة السر: ";
                case "choose_goal": return "اختر هدفك: ";
                case "enter_days": return "كم عدد أيام التمرين في الأسبوع؟ ";
                case "account_created": return "تم إنشاء الحساب بنجاح!";
                case "login_success": return "تم تسجيل الدخول!";
                case "invalid_login": return "الاسم أو كلمة السر غير صحيحة.";
                case "user_exists": return "المستخدم موجود مسبقًا! الرجاء استخدام بيانات مختلفة.";
                case "menu": return "\n1. عرض الجدول\n2. تعديل الهدف\n3. تعديل الأيام\n4. تسجيل الخروج\nاختر:";
                case "your_plan": return "خطة التمرين الخاصة بك:";
                case "goal_updated": return "تم تحديث الهدف.";
                case "days_updated": return "تم تحديث عدد الأيام.";
                case "logout": return "تم تسجيل الخروج.";
                case "invalid_option": return "خيار غير صالح.";
            }
        }
        return "";
    }
}

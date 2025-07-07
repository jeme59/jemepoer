
public class User {
    private String email;
    private String password;
    private String goal;
    private int days;

    public User(String email, String password, String goal, int days) {
        this.email = email;
        this.password = password;
        this.goal = goal;
        this.days = days;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String toFileString() {
        return email + "," + password + "," + goal + "," + days;
    }

    public static User fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new User(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
        }
        return null;
    }
}

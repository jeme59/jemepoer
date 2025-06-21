
public class WorkoutGenerator {
    public static String[] generatePlan(int days, String goal) {
        String[] plan;

        if (goal.equalsIgnoreCase("Muscle Gain")) {
            if (days == 1) {
                plan = new String[] {
                        "Day 1: Full Body - https://example.com/fullbody"
                };
            } else if (days == 2) {
                plan = new String[] {
                        "Day 1: Upper Body - https://example.com/upper",
                        "Day 2: Lower Body - https://example.com/lower"
                };
            } else if (days == 3) {
                plan = new String[] {
                        "Day 1: Push - https://example.com/push",
                        "Day 2: Pull - https://example.com/pull",
                        "Day 3: Legs - https://example.com/legs"
                };
            } else if (days == 4) {
                plan = new String[] {
                        "Day 1: Chest - https://example.com/chest",
                        "Day 2: Back - https://example.com/back",
                        "Day 3: Legs - https://example.com/legs",
                        "Day 4: Shoulders - https://example.com/shoulders"
                };
            } else {
                plan = new String[] {
                        "Day 1: Chest + Triceps - https://example.com/chest-triceps",
                        "Day 2: Back + Biceps - https://example.com/back-biceps",
                        "Day 3: Legs - https://example.com/legs",
                        "Day 4: Shoulders - https://example.com/shoulders",
                        "Day 5: Cardio + Abs - https://example.com/cardio-abs"
                };
            }
        } else if (goal.equalsIgnoreCase("Weight Loss")) {
            if (days == 1) {
                plan = new String[] {
                        "Day 1: Full Body HIIT - https://example.com/hiit"
                };
            } else if (days == 2) {
                plan = new String[] {
                        "Day 1: Cardio - https://example.com/cardio",
                        "Day 2: Abs + Core - https://example.com/abs"
                };
            } else if (days == 3) {
                plan = new String[] {
                        "Day 1: HIIT + Cardio - https://example.com/hiit",
                        "Day 2: Lower Body Burn - https://example.com/lowerburn",
                        "Day 3: Full Body - https://example.com/fullbody"
                };
            } else if (days == 4) {
                plan = new String[] {
                        "Day 1: Cardio - https://example.com/cardio",
                        "Day 2: Strength - https://example.com/strength",
                        "Day 3: Core - https://example.com/core",
                        "Day 4: Stretch - https://example.com/stretch"
                };
            } else {
                plan = new String[] {
                        "Day 1: Cardio - https://example.com/cardio",
                        "Day 2: Abs - https://example.com/abs",
                        "Day 3: Full Body - https://example.com/fullbody",
                        "Day 4: HIIT - https://example.com/hiit",
                        "Day 5: Stretch - https://example.com/stretch"
                };
            }
        } else {
            plan = new String[] { "No plan available for this goal." };
        }

        return plan;
    }
}

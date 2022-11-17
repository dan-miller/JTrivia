import java.util.Scanner;

public class JTrivia {
    public static Scanner stdin = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        Question[] questions = new Question[20];
        populateQuestions(questions);
        Player p1 = new Player();
        System.out.print("Player 1 name: ");
        p1.name = stdin.nextLine();
        Player p2 = new Player();
        System.out.print("Player 2 name: ");
        p2.name = stdin.nextLine();

        // Rounds 1-3
        boolean p1SmallPtAvail = true;
        boolean p1MedPtAvail = true;
        boolean p1LargePtAvail = true;
        boolean p2SmallPtAvail = true;
        boolean p2MedPtAvail = true;
        boolean p2LargePtAvail = true;
        int p1PointsChoice;
        int p2PointsChoice;
        for (int r = 1; r <= 1; r++) {
            Question q1 = questions[r * 1 - 1];
            Question q2 = questions[r * 2 - 1];
            Question q3 = questions[r * 3 - 1];
            System.out.printf("Round %d Categories:\n%s\n%s\n%s\n", r, q1.category, q2.category, q3.category);            
            p1PointsChoice = choosePoints(1, p1SmallPtAvail, p1MedPtAvail, p1LargePtAvail, true);
            p2PointsChoice = choosePoints(2, p2SmallPtAvail, p2MedPtAvail, p2LargePtAvail, true);

            
        }

        stdin.close();
    }

    private static void populateQuestions(Question[] arr) {
        Question q0 = new Question("Philosophy", "How many roads must a man walk down?",
                new String[] { "1", "2", "3", "4" }, 0);
        arr[0] = q0;
        Question q1 = new Question("Science", "Magnets, how do they work?",
                new String[] { "Magic", "Small elves", "Geothermal power", "They don't" }, 0);
        arr[1] = q1;
        Question q2 = new Question("Sports", "How many NFL teams have never won a super bowl?",
                new String[] { "2", "4", "8", "1" }, 3);
        arr[2] = q2;
    }

    private static String getPointsStr(boolean first, boolean second, boolean third, boolean oneTwoThree) {
        if (first && second && third) {
            return oneTwoThree ? "1, 2, 3" : "2, 4, 6";
        } else if (first && second && !third) {
            return oneTwoThree ? "1, 2" : "2, 4";
        } else if (first && !second && third) {
            return oneTwoThree ? "1, 3" : "2, 6";
        } else if (first && !second && !third) {
            return oneTwoThree ? "1" : "2";
        } else if (!first && second && !third) {
            return oneTwoThree ? "2" : "4";
        } else {
            return oneTwoThree ? "3" : "6";
        }
    }

    private static int choosePoints(int player, boolean small, boolean med, boolean large, boolean oneTwoThree) {
        int choice;
        boolean tryAgain = false;
        do {
            System.out.printf("Player %d choose points (%s): ", player, getPointsStr(small, med, large, oneTwoThree));
            choice = Integer.parseInt(stdin.nextLine());
            switch (choice) {
                case 1:
                    tryAgain = !small;
                    break;
                case 2:
                    tryAgain = !med;
                    break;
                case 3:
                    tryAgain = !large;
                    break;
                default:
                    tryAgain = true;
            }
            if (tryAgain) {
                System.out.println("Invalid choice. Try again!");
            }
        } while (tryAgain);
        return choice;
    }
}

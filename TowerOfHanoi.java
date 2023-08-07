import java.util.Scanner;
import java.util.Stack;
public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println("Welcome to the Tower of Hanoi game!");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Computer Beats Tower of Hanoi");
            System.out.println("2. User Play's the game");
            System.out.println("3. Exit Game");
            System.out.print("Enter option (1, 2, or 3): ");
            int option = scanner.nextInt();
            if (option == 3) {
                break;
            }
            System.out.print("Enter the number of disks: ");
            int numDisks = scanner.nextInt();
            if (option == 1) {
                computerSolves(numDisks);
            } else if (option == 2) {
                userPlays(numDisks, scanner);
            }
        }
        scanner.close();
    }
    private static void computerSolves(int numDisks) {
        System.out.println("\nThe computer is solving the Tower of Hanoi with " + numDisks + " disks:");
        solveHanoi(numDisks, 'A', 'C', 'B');
    }
    private static void solveHanoi(int n, char source, char target, char auxiliary) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + target);
            return;
        }
        solveHanoi(n - 1, source, auxiliary, target);
        System.out.println("Move disk " + n + " from " + source + " to " + target);
        solveHanoi(n - 1, auxiliary, target, source);
    }
    private static void userPlays(int numDisks, Scanner scanner) {
        Stack<Integer>[] towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }
        int moveCount = 0;
        while (towers[1].size() < numDisks && towers[2].size() < numDisks) {
            displayTowers(towers);
            System.out.print("Enter Disks Current Tower and New Tower Ex. (1 3) using (1, 2, or 3): ");
            int source = scanner.nextInt() - 1;
            int target = scanner.nextInt() - 1;
            if (!isValidMove(towers, source, target)) {
                System.out.println("Incorrect move");
            } else {
                moveDisk(towers, source, target);
                moveCount++;
            }
        }
        System.out.println("Congratulations! You Won! with " + numDisks + " disks in " + moveCount + " moves.");
    }
    private static void displayTowers(Stack<Integer>[] towers) {
        System.out.println("\nCurrent state of towers:");
        for (int i = 0; i < 3; i++) {
            System.out.print("Tower " + (i + 1) + ": ");
            for (Integer disk : towers[i]) {
                System.out.print(disk + " ");
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(Stack<Integer>[] towers, int source, int target) {
        if (source < 0 || source > 2 || target < 0 || target > 2) {
            return false;
        }
        if (towers[source].isEmpty()) {
            return false;
    }
        if (!towers[target].isEmpty() && towers[source].peek() > towers[target].peek()) {
        return false;
    }
        return true;
}
    private static void moveDisk(Stack<Integer>[] towers, int source, int target) {
        int disk = towers[source].pop();
        towers[target].push(disk);
        System.out.println("Moved disk " + disk + " from tower " + (source + 1) + " to tower " + (target + 1));
    }
}
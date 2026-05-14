
// Ring.java
import java.util.*;

class Process {
    int id;
    String state;
}

public class Ring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of process : ");
        int n = in.nextInt();
        Process proc[] = new Process[n];
        // initialize processes
        for (int i = 0; i < n; i++) {
            proc[i] = new Process();
        }
        // input process IDs
        for (int i = 0; i < n; i++) {
            System.out.print("Enter the id of process : ");
            proc[i].id = in.nextInt();
            proc[i].state = "active";
        }
        // sort processes by ID
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (proc[j].id > proc[j + 1].id) {
                    int temp = proc[j].id;
                    proc[j].id = proc[j + 1].id;
                    proc[j + 1].id = temp;
                }
            }
        }
        while (true) {
            System.out.println("\n1.election 2.quit");
            int choice = in.nextInt();
            if (choice == 2) {
                System.out.println("Program terminated ...");
                break;
            }
            System.out.print("\nEnter the Process number who initialised election : ");
            int init = in.nextInt();
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (proc[i].id == init) {
                    pos = i;
                    break;
                }
            }
            if (pos == -1) {
                System.out.println("Invalid process!");
                continue;
            }
            int maxId = proc[pos].id;
            int current = pos;
            do {
                int next = (current + 1) % n;
                System.out.println("Process " + proc[current].id +
                        " send message to " + proc[next].id);
                if (proc[next].id > maxId) {
                    maxId = proc[next].id;
                }
                current = next;
            } while (current != pos);
            System.out.println("process " + maxId + " selected as co-ordinator");
        }
    }
}
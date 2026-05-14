import java.util.*;

class TokenRing {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the num of nodes:");
        int n = scan.nextInt();
        int token = 0;
        // Display ring
        for (int i = 0; i < n; i++) {
            System.out.print(i + " ");
        }
        System.out.println("0");
        System.out.println("\nEnter sender:");
        int s = scan.nextInt();
        System.out.println("Enter receiver:");
        int r = scan.nextInt();
        System.out.println("Enter Data:");
        int data = scan.nextInt();
        // Token Passing
        System.out.print("Token passing: ");
        int i = token;
        while (i != s) {
            System.out.print(i + "->");
            i = (i + 1) % n;
        }
        System.out.println(s);
        // Sender sends data
        System.out.println("Sender " + s + " sending data: " + data);
        // Forwarding
        i = (s + 1) % n;
        while (i != r) {
            System.out.println("data " + data + " forwarded by " + i);
            i = (i + 1) % n;
        }
        // Receiver
        System.out.println("Receiver " + r + " received data: " + data);
        scan.close();
    }
}
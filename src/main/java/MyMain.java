import java.util.Scanner;

public class MyMain {

    // Rolls a single die
    // Returns a random integer between 1 and 6
    public static int rollDie() {
        int val = (int) (Math.random() * 6) + 1;
        return val;
    }

    // Rolls two dice n times
    // This method returns an int array of size 11, where each element is
    // the number of times a certain sum of two dice was rolled
    public static void printarray(int []arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int[] sumOfTwoDice(int n) {
        int [] arr1 = new int[n];
        int [] arr2 = new int[11];
        for (int i = 0; i < n; i++) {
            int roll1 = rollDie();
            int roll2 = rollDie();
            int sum = roll1 + roll2;
            arr1[i] = sum;
        }
        for (int i = 2; i < 13; i++) {
            int c = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == i) {
                    c ++;
                    arr2[i-2] = c;
                }
            }
        }
        return arr2;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many pair of dice would you like to roll?");
        int num = scan.nextInt();
        int [] finalarr = sumOfTwoDice(num);
        for (int i = 0; i < finalarr.length; i++) {
            System.out.println("% of rolls where sum == " + i + ": " + ((double)finalarr[i]/num) * 100);
        }
    }   
}
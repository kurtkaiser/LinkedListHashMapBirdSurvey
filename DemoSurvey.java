/*
Kurt Kaiser
CTIM 168
08.02.2018
Homework: Bird Survey Linked List
Chapter 12 Practice Problem 13
*/
import java.util.Scanner;

public class DemoSurvey {
    public static void main(String[] args) {
        HashMapBirdSurvey list = new HashMapBirdSurvey();
        boolean again = true;
        do {
            System.out.println("Inputs\n A to add birds\n C " +
                    "for a bird count\n R to print the report\n E to end");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            input.toLowerCase();
            switch (input) {
                case "a":
                    while (!input.equals("done")) {
                        list.addANodeToStart(input);
                        System.out.print("Bird name (done to exit): ");
                        scan = new Scanner(System.in);
                        input = scan.nextLine();
                    }
                    break;
                case "c":
                    System.out.print("Bird: ");
                    scan = new Scanner(System.in);
                    input = scan.nextLine();
                    list.getCount(input);
                    break;
                case "r":
                    list.getReport();
                    break;
                case "e":
                    again = false;
                    break;
            }
            System.out.println("");
        } while (again);
    }
}

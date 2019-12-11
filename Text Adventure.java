import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

public class TextAdventure {
    private static Scanner playerInput = new Scanner(System.in);
    private static Random generator = new Random();
    private static String[] specialItems = {};
    private static int gold = 100;


    private static String playerName;

    public static void main(String[] args) throws InterruptedException {
        checkResponse();
        System.out.println("Hello adventurer! What is your name?");
        playerName = playerInput.nextLine();
        start(playerName);

        System.out.println("What kind of adventurer are you?" + "\n"
                + "a) Mage" + "\n"
                + "b) Rogue" + "\n"
                + "c) Barbarian");
        char type = playerInput.next().charAt(0);
        selectClass(type);
    }


    public static void start(String name) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("Welcome " + name);
    }

    public static void selectClass(char x) {
        boolean correct = false;
        while (correct != true) {
            if (x == 'a') {
                System.out.println("Ahh, a creature blessed by the gods.");
                correct = true;
                mage();
                stats();
            } else if (x == 'b') {
                System.out.println("So you're one of those scoundrels. ");
                correct = true;
                rogue();
                stats();
            } else if (x == 'c') {
                System.out.println("A foreigner then.");
                correct = true;
                barbarian();
                stats();

            } else {
                System.out.println("Please only select one of the three options");
                char type = playerInput.next().charAt(0);
                selectClass(type);
            }

        }
    }

    public static void stats() {
        System.out.println("\n" + "\nThere are " + specialItems.length + " items in your inventory."
                + "\n" + "You have " + gold + " pieces of gold.");
        if (specialItems.length > 0) checkIventory();
        else storyA();
    }

    public static boolean checkResponse() {
        boolean answer = false;
        boolean correct = false;
        while (correct == false) {
            System.out.println("\n" + "Type Yes or No.");
            String response = playerInput.nextLine();
            if (response == "Yes") {
                correct = true;
                answer = true;
            } else if (response == "No") {
                correct = true;
                answer = false;
            } else {
                System.out.println("\n" + "Please only type Yes or No.");
            }
        }
        return answer;
    }

        public static void checkIventory() {
        System.out.println("\n" + "Would you like to check the items in your currently: Y or N?");
            if (checkResponse()) {
                storyA();
                System.out.println("\n" + "You have ");
                for (String elements : specialItems) {
                    System.out.println("\n" + elements);
                }
                System.out.println(" in your inventory currently.");
                storyA();
            }
            else storyA();
        }


    public static void storyA() {
        System.out.println(" I have a quest for you of the utmost importance " + playerName
                +  ", can i count on you to complete it?");

    }


    public static void mage() {
    }

    public static void rogue() {
    }

    public static void barbarian() {
    }
}





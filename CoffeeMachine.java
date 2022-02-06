package machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;

    public static void main(String[] args) {
        action();
    }

    public static void machineState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", water);
        System.out.printf("%d ml of milk\n", milk);
        System.out.printf("%d g of coffee beans\n", beans);
        System.out.printf("%d disposable cups\n", cups);
        System.out.printf("$%d of money\n\n", money);
        action();
    }

    public static void action() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):\n");
        switch (scanner.nextLine()) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                machineState();
                break;
            case "exit":
                break;
            default:
        }
    }

    public static void buy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scanner.nextLine()) {
            case "1":
                if (water >= 250 && beans >= 16 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 250;
                    beans -= 16;
                    cups--;
                    money += 4;
                } else {
                    System.out.println("Sorry, not enough water!\n");
                }
                break;
            case "2":
                if (water >= 350 && milk >= 75 && beans >= 20 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 350;
                    milk -= 75;
                    beans -= 20;
                    cups--;
                    money += 7;
                } else {
                    System.out.println("Sorry, not enough water!\n");
                }
                break;
            case "3":
                if (water >= 200 && milk >= 100 && beans >= 12 && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    water -= 200;
                    milk -= 100;
                    beans -= 12;
                    cups--;
                    money += 6;
                } else {
                    System.out.println("Sorry, not enough water!\n");
                }
                break;
            case "back":
                break;
            default:
        }
        action();
    }

    public static void fill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
        System.out.println("\n");
        action();
    }

    public static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        System.out.println("\n");
        action();
    }
}


package machine;

import java.util.Scanner;

public class Machine {
    private int water, milk, coffeeBeans, cups, money;

    public void start(Scanner scanner) {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.cups = 9;
        this.money = 550;
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit)");
            String cmd = scanner.nextLine();
            System.out.println();
            if (cmd.equals("buy")) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String input = scanner.nextLine();
                if (input.equals("back")) {
                    continue;
                }
                int choice = Integer.valueOf(input);
                if (choice == 1 && water >= 250 && coffeeBeans >= 16 && cups > 0) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups--;

                } else if (choice == 2 && water >= 350 && milk >= 75 && coffeeBeans >= 20 && cups > 0) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups--;
                } else if (choice == 3 && water >= 200 && milk >= 100 && coffeeBeans >= 12) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups--;
                } else {
                    System.out.println("Sorry, not enough resources!");
                    continue;
                }
                System.out.println("I have enough resources, making you a coffee!");
                System.out.println();
            } else if (cmd.equals("fill")) {
                System.out.println("Write how many ml of water do you want to add: ");
                water += scanner.nextInt();
                System.out.println("Write how many ml of milk do you want to add: ");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans do you want to add: ");
                coffeeBeans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee do you want to add: ");
                cups += scanner.nextInt();
                scanner.nextLine();
                System.out.println();
            } else if (cmd.equals("take")) {
                System.out.println("I gave you $" + money);
                money = 0;
                System.out.println();
            } else if (cmd.equals("remaining")) {
                show(water, milk, coffeeBeans, cups, money);
                System.out.println();
            } else if (cmd.equals("exit")) {
                break;
            }
        }


    }

    public void show(int water, int milk, int coffeeBeans, int cups, int money) {
        System.out.println("The coffee machine has:\n" + water + " of water\n" + milk + " of milk\n" + coffeeBeans + " of coffee beans\n" + cups + " of disposable cups\n" + money + " of money");

    }
}


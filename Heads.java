//to find out if the coin tossed is heads or tails

package vertiscales;

import java.util.*;

public class Heads {

    char array[] = new char[20];
    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    public void Air() {
        System.out.println("Was the wind there?");
        array[0] = Character.toLowerCase(sc.next().charAt(0));

        if (array[0] == 'y') {
            array[1] = (char) (rand.nextInt(2));

            System.out.println("Let's take a random 50% chance.....");
            if (array[1] == 1) {
                System.out.println("It's Heads!\n#######################\nEnd...Success");
                array[19] = 'h';
                System.exit(0);
            } else {
                System.out.println("It's tails\n#######################\nExit....Failed");
                array[19] = 't';
                System.exit(1);
            }

        } else if (array[0] == 'n') {
            System.out.println("Was the technique good?");
            array[2] = Character.toLowerCase(sc.next().charAt(0));

            if (array[2] == 'y') {
                Technicque();
            } else if (array[2] == 'n') {
                array[3] = (char) (rand.nextInt(2));

                System.out.println("Let's take a random 50% chance.....");
                if (array[3] == 1) {
                    System.out.println("It's Heads!\n###################\nEnd...Success");
                    array[19] = 'h';
                    System.exit(0);
                } else {
                    System.out.println("It's tails\n###################\nExit....Failed");
                    array[19] = 't';
                    System.exit(1);
                }

            } else {
                System.out.println("Wrong input.....Try again##########################");
                Air();
            }

        } else {
            System.out.println("Wrong input.....Try again\n############################");
            Air();
        }
    }

    public void Technicque() {
        System.out.println("Did the Coin land nearby?");
        array[4] = Character.toLowerCase(sc.next().charAt(0));

        if (array[4] == 'y') {
            array[5] = (char) (rand.nextInt(2));

            System.out.println("Let's take a random 50% chance.....");
            if (array[5] == 1) {
                System.out.println("It's Heads!\n#######################\nEnd...Success");
                array[19] = 'h';
                System.exit(0);
            } else {
                System.out.println("It's tails\n########################\nExit....Failed");
                array[19] = 't';
                System.exit(1);
            }

        } else if (array[4] == 'n') {
            System.out.println("########################################\nExit...Failed");
            array[19] = 't';
            System.exit(1);
        } else {
            System.out.println("Wrong input.....Try again\n############################");
            Technicque();
        }
    }

    public static void main(String[] args) {
        char array[] = new char[20];
        Scanner sc = new Scanner(System.in);
        Heads execute = new Heads();

        System.out.println("Was the heads up while tossing?");
        array[5] = Character.toLowerCase(sc.next().charAt(0));

        if (array[5] == 'y' || array[5] == 'n') {
            execute.Air();
        } else {
            System.out.println("Wrong input.....Try again\n############################");
            main(args);
        }

        if (array[19] == 'h') {
            System.out.println("It's Heads!\n###########################\nEnd...Success");
            System.exit(0);
        } else {
            System.out.println("It's tails\n###########################\nExit....Failed");
            System.exit(1);
        }
    }
}

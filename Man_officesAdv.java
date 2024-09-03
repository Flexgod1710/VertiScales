// this is an advance man_offices which is more complex including health bar mood bar energy bar etc.(inspired from chatgpt)
package vertiscales;

import java.util.*;

public class Man_officesAdv {
    char[] array = new char[10];
    Scanner sc = new Scanner(System.in);
    int energyLevel = 100; // Energy level starts at 100
    int moodLevel = 100;   // Mood level starts at 100
    int healthLevel = 100; // Health level starts at 100
    int time = 0;          // Time starts at 0 minutes

    Random rand = new Random();

    // Random events affecting energy, mood, or health
    void randomEvent() {
        int event = rand.nextInt(10);
        switch (event) {
            case 0:
                System.out.println("You caught a cold!");
                healthLevel -= 20;
                break;
            case 1:
                System.out.println("You found some extra vitamins!");
                healthLevel += 10;
                break;
            case 2:
                System.out.println("Traffic was worse than expected.");
                moodLevel -= 10;
                break;
            case 3:
                System.out.println("You had a great dream!");
                moodLevel += 20;
                break;
            default:
                System.out.println("Nothing unusual happened.");
        }
        printStatus();
    }

    void printStatus() {
        System.out.println("Current Status - Energy: " + energyLevel + ", Mood: " + moodLevel + ", Health: " + healthLevel + ", Time: " + time + " minutes");
    }

    void inter_1() {
        randomEvent(); // Random event before this interaction
        System.out.println("Did you hurry? (y/n)");
        array[1] = sc.next().charAt(0);
        time += 5;
        if (array[1] == 'n') {
            System.out.println("Was traffic there? (y/n)");
            array[2] = sc.next().charAt(0);
            time += 5;
            if (array[2] == 'y') {
                System.out.println("Did the manager allow? (y/n)");
                array[3] = sc.next().charAt(0);
                time += 10;
                if (array[3] == 'y') {
                    reduceEnergy();
                    System.out.println("End - You managed to reach the office.");
                } else if (array[3] == 'n') {
                    System.out.println("Exit - The manager didn't allow.");
                    System.exit(0);
                } else {
                    System.out.println("Wrong input");
                    inter_1();
                }
            } else if (array[2] == 'n') {
                increaseMood();
                System.out.println("End - No traffic, good start!");
            } else {
                System.out.println("Wrong input");
                inter_1();
            }
        } else if (array[1] == 'y') {
            reduceEnergy();
            System.out.println("End - Hurrying drained some energy.");
        } else {
            System.out.println("Wrong input");
            inter_1();
        }
    }

    void Breakfast() {
        randomEvent(); // Random event before this interaction
        System.out.println("Did you have breakfast? (y/n)");
        array[4] = sc.next().charAt(0);
        time += 10;
        if (array[4] == 'n') {
            reduceEnergy();
            Energy();
        } else if (array[4] == 'y') {
            increaseEnergy();
        } else {
            System.out.println("Wrong input");
            Breakfast();
        }
    }

    void Energy() {
        randomEvent(); // Random event before this interaction
        System.out.println("Do you have energy? (y/n)");
        array[5] = sc.next().charAt(0);
        time += 5;
        if (array[5] == 'n') {
            System.out.println("Exit - Not enough energy to go to the office.");
            System.exit(0);
        } else if (array[5] == 'y') {
            if (energyLevel < 50) {
                System.out.println("Low energy level! Proceed with caution.");
            }
        } else {
            System.out.println("Wrong input");
            Energy();
        }
    }

    void inter_2() {
        randomEvent(); // Random event before this interaction
        System.out.println("Do you have mood? (y/n)");
        array[6] = sc.next().charAt(0);
        time += 5;
        if (array[6] == 'y') {
            reduceMood();
            inter_1();
        } else if (array[6] == 'n') {
            for (int i = 0; i < 10; i++) {
                System.out.println("Total energy?");
                array[7] = sc.next().charAt(0);
                time += 5;
                if (array[7] == 'y') {
                    reduceEnergy();
                    inter_1();
                    break;
                } else if (array[7] == 'n') {
                    increaseMood();
                    Breakfast();
                } else {
                    System.out.println("Wrong input");
                    inter_2();
                }
            }
        } else {
            System.out.println("Wrong input");
            inter_2();
        }
    }

    void reduceEnergy() {
        energyLevel -= 10;
        System.out.println("Energy level reduced to " + energyLevel);
        if (energyLevel <= 0) {
            System.out.println("You are too tired to continue.");
            System.exit(0);
        }
    }

    void increaseEnergy() {
        energyLevel += 10;
        System.out.println("Energy level increased to " + energyLevel);
    }

    void reduceMood() {
        moodLevel -= 10;
        System.out.println("Mood level reduced to " + moodLevel);
        if (moodLevel <= 0) {
            System.out.println("You are too demotivated to continue.");
            System.exit(0);
        }
    }

    void increaseMood() {
        moodLevel += 10;
        System.out.println("Mood level increased to " + moodLevel);
    }

    void reduceHealth() {
        healthLevel -= 10;
        System.out.println("Health level reduced to " + healthLevel);
        if (healthLevel <= 0) {
            System.out.println("Your health has deteriorated too much.");
            System.exit(0);
        }
    }

    void increaseHealth() {
        healthLevel += 10;
        System.out.println("Health level increased to " + healthLevel);
    }

    public static void main(String[] args) {
        Man_offices Intro = new Man_offices();
        System.out.println("Day 1: Did you wake up? (y/n)");
        Intro.array[8] = Intro.sc.next().charAt(0);

        if (Intro.array[8] == 'y') {
            Intro.Energy();
            Intro.Breakfast();
            Intro.inter_2();
        } else if (Intro.array[8] == 'n') {
            System.out.println("Did the Alarm go off? (y/n)");
            Intro.array[9] = Intro.sc.next().charAt(0);
            if (Intro.array[9] == 'n') {
                System.out.println("Exit - You didn't wake up in time.");
                System.exit(0);
            } else if (Intro.array[9] == 'y') {
                Intro.Energy();
                Intro.Breakfast();
                Intro.inter_2();
            } else {
                System.out.println("Wrong input");
                main(args);
            }
        } else {
            System.out.println("Wrong input");
            main(args);
        }

        // Simulating a new day with accumulated effects
        System.out.println("Day 2: Did you wake up? (y/n)");
        Intro.array[8] = Intro.sc.next().charAt(0);

        if (Intro.array[8] == 'y') {
            Intro.Energy();
            Intro.Breakfast();
            Intro.inter_2();
        } else if (Intro.array[8] == 'n') {
            System.out.println("Did the Alarm go off? (y/n)");
            Intro.array[9] = Intro.sc.next().charAt(0);
            if (Intro.array[9] == 'n') {
                System.out.println("Exit - You didn't wake up in time.");
                System.exit(0);
            } else if (Intro.array[9] == 'y') {
                Intro.Energy();
                Intro.Breakfast();
                Intro.inter_2();
            } else {
                System.out.println("Wrong input");
                main(args);
            }
        } else {
            System.out.println("Wrong input");
            main(args);
        }
    }
}

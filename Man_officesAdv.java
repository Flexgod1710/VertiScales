// this is an advance man_offices which is more complex including health bar mood bar energy bar etc.(inspired from chatgpt)
package vertiscales;

import java.util.*;

public class Man_officesAdv {
   
    Vertirand test=new Vertirand();
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
                    test.reduceEnergy();
                    System.out.println("End - You managed to reach the office.");
                } else if (array[3] == 'n') {
                    System.out.println("Exit - The manager didn't allow.");
                    System.exit(0);
                } else {
                    System.out.println("Wrong input");
                    inter_1();
                }
            } else if (array[2] == 'n') {
                test.increaseMood();
                System.out.println("End - No traffic, good start!");
            } else {
                System.out.println("Wrong input");
                inter_1();
            }
        } else if (array[1] == 'y') {
            test.reduceEnergy();
            System.out.println("End - Hurrying drained some energy.");
        } else {
            System.out.println("Wrong input");
            inter_1();
        }
    }

    void Breakfast() {
        test.random(); 
        System.out.println("Did you have breakfast? (y/n)");
        array[4] = sc.next().charAt(0);
        time += 10;
        if (array[4] == 'n') {
            test.reduceEnergy();
            Energy();
        } else if (array[4] == 'y') {
            test.increaseEnergy();
        } else {
            System.out.println("Wrong input");
            Breakfast();
        }
    }

    void Energy() {
        test.random(); // Random event before this interaction
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
        test.random(); // Random event before this interaction
        System.out.println("Do you have mood? (y/n)");
        array[6] = sc.next().charAt(0);
        time += 5;
        if (array[6] == 'y') {
            test.reduceMood();
            inter_1();
        } else if (array[6] == 'n') {
            for (int i = 0; i < 10; i++) {
                System.out.println("Total energy?");
                array[7] = sc.next().charAt(0);
                time += 5;
                if (array[7] == 'y') {
                    test.reduceEnergy();
                    inter_1();
                    break;
                } else if (array[7] == 'n') {
                    test.increaseMood();
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

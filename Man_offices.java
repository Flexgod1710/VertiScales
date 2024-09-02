//to find if a sick man will go to office
package vertiscales;

import java.util.Scanner;

public class Man_offices {
    char array[] = new char[10];
    Scanner sc = new Scanner(System.in);

    void inter_1() {
        System.out.println("Did you hurry?");
        array[1] = sc.next().toLowerCase().charAt(0);
        if (array[1] == 'n') {
            System.out.println("Was there traffic?");
            array[2] = sc.next().toLowerCase().charAt(0);
            if (array[2] == 'y') {
                System.out.println("Did the manager allow?");
                array[3] = sc.next().toLowerCase().charAt(0);
                if (array[3] == 'y') {
                    System.out.println("End");
                } else if (array[3] == 'n') {
                    System.out.println("Exit");
                    System.exit(0);
                } else {
                    System.out.println("Wrong input. Try again.");
                    inter_1();   
                }
            } else if (array[2] == 'n') {
                System.out.println("End");
            } else {
                System.out.println("Wrong input. Try again.");
                inter_1();   
            }
        } else if (array[1] == 'y') {
            System.out.println("End");
        } else {
            System.out.println("Wrong input. Try again.");
            inter_1();   
        }
    }

    void Breakfast() {
        System.out.println("Did you have breakfast?");
        array[4] = sc.next().toLowerCase().charAt(0);
        if (array[4] == 'n') {
            Energy();
        } else if (array[4] == 'y') {
            // Do nothing, continue the flow
        } else {
            System.out.println("Wrong input. Try again.");
            Breakfast();   
        }
    }

    void Energy() {
        System.out.println("Do you have energy?");
        array[5] = sc.next().toLowerCase().charAt(0);
        if (array[5] == 'n') {
            System.out.println("Exit");
            System.exit(0);
        } else if (array[5] == 'y') {
            // Do nothing, continue the flow
        } else {
            System.out.println("Wrong input. Try again.");
            Energy();   
        }
    }

    void inter_2() {
        System.out.println("Do you have mood?");
        array[6] = sc.next().toLowerCase().charAt(0);
        if (array[6] == 'y') {
            inter_1();
        } else if (array[6] == 'n') {
            for (int i = 0; i < 10; i++) {
                System.out.println("Total energy?");
                array[7] = sc.next().toLowerCase().charAt(0);
                if (array[7] == 'y') {
                    inter_1();
                    break;
                } else if (array[7] == 'n') {
                    Breakfast();
                } else {
                    System.out.println("Wrong input. Try again.");
                    inter_2();   
                }
            }
        } else {
            System.out.println("Wrong input. Try again.");
            inter_2();   
        }
    }

    public static void main(String[] args) {     
        char array[] = new char[10];
        Scanner sc = new Scanner(System.in);
        System.out.println("Did you wake up?");
        array[8] = sc.next().toLowerCase().charAt(0);
        Man_offices Intro = new Man_offices();
        if (array[8] == 'y') {
            Intro.Energy();
            Intro.Breakfast();
            Intro.inter_2();
        } else if (array[8] == 'n') {
            System.out.println("Did the alarm ring?");
            array[9] = sc.next().toLowerCase().charAt(0);
            if (array[9] == 'n') {
                System.out.println("Exit");
                System.exit(0);
            } else if (array[9] == 'y') {
                Intro.Energy();
                Intro.Breakfast();
                Intro.inter_2();
            } else {
                System.out.println("Wrong input. Try again.");
                main(args);   
            }
        } else {
            System.out.println("Wrong input. Try again.");
            main(args);   
        }
    }
}

//to find if a man will jump off a building

package vertiscales;

import java.util.*;

public class Man_jump {

    Scanner sc = new Scanner(System.in);
    char array[] = new char[20];

    void stop() {
        System.out.println("will u stop");
        array[0] = sc.next().toLowerCase().charAt(0);
        if (array[0] == 'y') {
            System.out.println("Will u get treatment");
            array[1] = sc.next().toLowerCase().charAt(0);
            if (array[1] == 'y') {
                System.out.println("Exit");
                System.exit(0);
            } else if (array[1] == 'n') {
                System.out.println("End....Success");
                System.exit(0);
            } else {
                System.out.println("Wrong input....Try again\n############################");
                stop();
            }
        } else if (array[0] == 'n') {
            System.out.println("End.....Success");
            System.exit(0);
        } else {
            System.out.println("Wrong input....Try again\n############################");
            stop();
        }
    }

    void fear() {
        System.out.println("Did u fear the top");
        array[2] = sc.next().toLowerCase().charAt(0);
        if (array[2] == 'y') {
            fear_sub();
        } else if (array[2] == 'n') {
            System.out.println("Did a friend stop you");
            array[4] = sc.next().toLowerCase().charAt(0);
            if (array[4] == 'n') {
                System.out.println("End....Success");
                System.exit(0);
            } else if (array[4] == 'y') {
                stop();
            } else {
                System.out.println("Wrong input....Try again\n############################");
                fear();
            }
        } else {
            System.out.println("Wrong input....Try again\n############################");
            fear();
        }
    }

    void fear_sub() {
        System.out.println("Did u overcome it");
        array[3] = sc.next().toLowerCase().charAt(0);
        if (array[3] == 'n') {
            System.out.println("End....Success");
            System.exit(0);
        } else if (array[3] == 'y') {
            System.out.println("Did a friend stop you");
            array[4] = sc.next().toLowerCase().charAt(0);
            if (array[4] == 'n') {
                System.out.println("End....Success");
                System.exit(0);
            } else if (array[4] == 'y') {
                stop();
            } else {
                System.out.println("Wrong input....Try again\n############################");
                fear_sub();
            }
        } else {
            System.out.println("Wrong input....Try again\n############################");
            fear_sub();
        }
    }

    void top() {
        System.out.println("Did u go to the top");
        array[5] = sc.next().toLowerCase().charAt(0);
        if (array[5] == 'y') {
            fear();
        } else if (array[5] == 'n') {
            System.out.println("Did u take last desision");
            array[6] = sc.next().toLowerCase().charAt(0);
            if (array[6] == 'n') {
                System.out.println("End...Success");
                System.exit(0);
            } else if (array[6] == 'y') {
                fear();
            } else {
                System.out.println("Wrong input....Try again\n############################");
                top();
            }
        } else {
            System.out.println("Wrong input....Try again\n############################");
            top();
        }
    }

    void first_part() {
        System.out.println("Do u go to the building");
        array[7] = sc.next().toLowerCase().charAt(0);
        if (array[7] == 'y') {
            top();
        } else if (array[7] == 'n') {
            System.out.println("Do u think of going");
            array[8] = sc.next().toLowerCase().charAt(0);
            if (array[8] == 'n') {
                System.out.println("Do u remember");
                array[9] = sc.next().toLowerCase().charAt(0);
                if (array[9] == 'n') {
                    System.out.println("Exit");
                } else if (array[9] == 'y') {
                    top();
                } else {
                    System.out.println("Wrong input....Try again\n############################");
                    first_part();
                }
            } else if (array[8] == 'y') {
                top();
            } else {
                System.out.println("Wrong input....Try again\n############################");
                first_part();
            }
        } else {
            System.out.println("Wrong input....Try again\n############################");
            first_part();
        }
    }

    public static void main(String[] args) {
        Man_jump execute = new Man_jump();
        execute.first_part();
    }
}


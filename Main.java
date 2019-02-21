/**
 * @Author Abraham Aldana , Chad Manning
 * Created on : February 20th, 2019
 * Instructor : Dr. Wang
 */
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
	/*
	* Prints the menu
	*/
    private static void displayMenu() {
        System.out.println("+===================================================+");
        System.out.println("|    CS 3990 Assignment:  Linked List Structures    |");
        System.out.println("+===================================================+");
        System.out.println("| G: Ask for a N, and generate N members of mixed   |");
        System.out.println("|     kinds and put them into three list structures.|");
        System.out.println("|     Make sure you destroy the lists before create |");
        System.out.println("|     new ones if the lists are not empty.          |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| S: List members in stack, 1 memebr per line,      |");
        System.out.println("|     20 members per screen with header line, allow |");
        System.out.println("|     Q/q to quit listing after each 20 members.    |");
        System.out.println("|     List last 20 members if quit early.           |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| Q: List members in queue (same requirements).     |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| O: List members in ordered queue sorted by SSN    |");
        System.out.println("|    (same requirements).                           |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| D: Remove first element from queue, pop member    |");
        System.out.println("|    from stack, and delete the same member from    |");
        System.out.println("|    sorted queue as the one removed from stack.    |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| I: Randomly generate new member, and put          |");
        System.out.println("|    the object into the three structures. Print    |");
        System.out.println("|    out the new member added in.                   |");
        System.out.println("+---------------------------------------------------+");
        System.out.println("| H/?: Display this menu.                           |");
        System.out.println("| E  : Exit                                         |");
        System.out.println("+===================================================+");
    }

	/*
	* Generates Members for different lists
	*/
    public static void generateList(MyStack<Member> stack) {

        while (!stack.isEmpty())
            stack.pop();

        System.out.print("Enter size for Lists : ");
        int size = scanner.nextInt();
        scanner.nextLine(); // flush scanner
        System.out.println();

        for (int i = 0; i < size; ++i) {
            stack.push(nextMember());
        }
    }

	/*
	* Returns a type of Member for the generateList function
	*/
    public static Member nextMember() {
        Random rnd = new Random();
        switch ((rnd.nextInt(5)) + 1) {
            case 1:
                return new Member();
            case 2:
                return new Student();
            case 3:
                return new Faculty();
            case 4:
                return new Staff();
            case 5:
                return new Employee();
            default:
                return null;

        }
    }

	/*
	* Prints contents of any list
	*/
    private static void print(MyList<Member> list) {
        Iterator<Member> itr = list.iterator(true);
        int numLine = 0;
        boolean quitEarly = false;

        System.out.println();

        while (itr.hasNext() && !quitEarly) {
            System.out.println(itr.next());
            if (++numLine > 19) {
                System.out.println();
                System.out.print("Press Q/q to quit early or C/c to continue : ");
                char c = scanner.nextLine().charAt(0);
                System.out.println();
                if (c == 'Q' || c == 'q')
                    quitEarly = true;
                numLine = 0;
            }
        }

        if (quitEarly) {
            itr = list.iterator();
            for (int i = 0; i < (list.getSize() - 20); ++i)
                itr.next();
            while (itr.hasNext())
                System.out.println(itr.next());
        }

        System.out.println();
    }

    public static void main(String[] args) {
        char c = 'c';
        MyStack<Member> stack = new MyStack<>();
        //MyQueue<Member> queue = null;
        //MySortedqueue<Member> sQueue = null;

        while (c != 'e' && c != 'E') {
            System.out.print("Enter H/h/? for help, or commands : ");
            c = scanner.nextLine().charAt(0);

            switch (c) {
                case 'g':
                case 'G':
                    generateList(stack);
                    break;
                case 's':
                case 'S':
                    print(stack);
                    break;
                case 'q':
                case 'Q':
                    break;
                case 'o':
                case 'O':
                    break;
                case 'd':
                case 'D':
                    if (stack.getSize() > 0)
                        System.out.printf("Removed : %d\n\n", stack.pop().ID);
                    else
                        System.out.print("Stack is empty.\n\n");
                    break;
                case 'i':
                case 'I':
                    break;
                case '?':
                case 'h':
                case 'H':
                    displayMenu();
                    break;
                case 'e':
                case 'E':
                    break;
                default:
                    System.err.println("Error: Unrecognized input, please try again.\n");
                    break;
            }
        }
    }
}


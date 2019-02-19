import java.util.Scanner;

public class Main
{
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

	private static void generateList() {

	}

	public static void main(String[] args) {
		char c = 'c';
		Scanner scanner = new Scanner(System.in);
		MyList<Integer> list = new MyList<Integer>(0);

		while (c != 'e' && c != 'E') {
			System.out.printf("Enter H/h/? for help, or commands : ");
			c = scanner.nextLine().charAt(0);

			switch (c){
				case 'g':
					generateList();
					break;
				case 's': //List members in stack
					break; 
				case 'q': //List members in queue
					break;
				case 'o': //List members in sorted queue by SSN
					break;
				case 'd': 
					//Remove first element from queue
					//Pop member from stack
					//Delete the same member from the stack in the sorted queue 
					break;
				case 'i': //Generate and add new member to all 3
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
		return;
	}
}

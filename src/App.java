import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<Contact> contacts = new ArrayList<Contact>();

    public static void main(String[] args) {
        while (true) {
            String task = input("What to do? \n 1. Add a contact \n 2. Show contacts \n 3. Delete a contact \nA: ");

            if (task.equals("1")) {
                String name = input("Enter name: ");
                String phoneNum = input("Enter phone number: ");
                String email = input("Enter email: ");
        
                addContact(name, phoneNum, email);
            }
            else if (task.equals("2")) {
                for (int i = 0; i < contacts.size(); i++) {
                    System.out.printf("%d %s %s %s \n", i + 1, contacts.get(i).name, contacts.get(i).phoneNum, contacts.get(i).email);
                }
            }
            else if (task.equals("3")) {
                String name = input("Enter name of the contact: ");
                removeContact(name);
            }
            else {
                System.out.println("Invalid input!");
            }
            System.out.println("------------------------------------");
        }
    }

    public static String input(String question) {
        Scanner sc = new Scanner(System.in);
        System.out.print(question);
        String answer = sc.nextLine();
        // sc.close();
        return answer;
    }

    public static void addContact(String name, String phoneNum, String email) {
        Contact c = new Contact(name, phoneNum, email);
        contacts.add(c);
    }

    public static void removeContact(String name) {
        for (Contact c : contacts) {
            if (c.name.equals(name)) {
                contacts.remove(c);
                return;
            }
        }
        System.out.printf("Found no contact named %s.", name);
    }

}

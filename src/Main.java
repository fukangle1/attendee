import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in); 
            Event event = new Event(); 
                
             int choice = 0;  
            do {  
                System.out.println("Here is what you can do in the progress");  
                System.out.println("Type 1 to enter event details:");  
                System.out.println("Type 2 to enter attendee name that are coming to the event");  
                System.out.println("Type 3 to remove an attendee from the list"); 
                System.out.println("Type 4 to update an attendee in the List");  
                System.out.println("Type 5 to search for an attendees from the event");  
                System.out.println("Type 6 to display all the attendees from the event");  
                System.out.println("Type 7 for complementary pass operations:"); 
                System.out.println("Type 8 to handle performances:");
                System.out.println("Tipe 9 to get seating details:" + "\n");
                System.out.println("Quit");
                choice = reader.nextInt(); 
                event.organizeEvent(choice); 
            } while (choice != 10);
            reader.close();
    }
}
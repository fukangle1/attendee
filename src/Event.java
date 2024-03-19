import java.time.LocalDate;
import java.util.*;
public class Event {  
    
    Scanner reader = new Scanner(System.in);
    public final static int capacity = 200;
    
    HashMap<String, Attendee> seatDetails = new HashMap<>(200,0.6f);
    private String eventID;  
    private String eventName;  
    private String eventVenue;  
    private LocalDate eventDate;  
    ArrayList<Attendee> eventAttendees = new ArrayList<>();

  
    public Event() {  
        this.eventAttendees = new ArrayList<>();  
    }  
  
    public Event(String eventID, String eventName, String eventVenue, LocalDate eventDate) {  
        this.eventID = eventID;  
        this.eventName = eventName;  
        this.eventVenue = eventVenue;  
        this.eventDate = eventDate;  
        this.eventAttendees = new ArrayList<>();  
    }  
  
    // Getters  
    public String getEventID() {  
        return eventID;  
    }  
  
    public String getEventName() {  
        return eventName;  
    }  
  
    public String getEventVenue() {  
        return eventVenue;  
    }  
  
    public LocalDate getEventDate() {  
        return eventDate;  
    }  
  
    public ArrayList<Attendee> getEventAttendees() {    
        return eventAttendees;    
    }
  
    // Setters  
    public void setEventID(String eventID) {  
        this.eventID = eventID;  
    }  
  
    public void setEventName(String eventName) {  
        this.eventName = eventName;  
    }  
  
    public void setEventVenue(String eventVenue) {  
        this.eventVenue = eventVenue;  
    }  
  
    public void setEventDate(LocalDate eventDate) {  
        this.eventDate = eventDate;  
    }  
  
    public void setSeatDetails(String seat,Attendee attendee){
        seatDetails.put(seat, attendee);
    }

    public void getSeatDetails(String seat){
        System.out.println("The details for the seat " + seat + " are as follows: " + "\n"+ seatDetails.get(seat));
    }

  
    // Organize event (handles creation and operations)  
    public void organizeEvent(int choice) {  
        Scanner reader = new Scanner(System.in); 
        switch (choice) { 
            case 1:  
                System.out.println("Enter the Event ID: ");  
                String id = reader.nextLine();  
                setEventID(id); 
      
                System.out.println("Enter the name of the Event: ");  
                String eventName = reader.nextLine();  
                setEventName(eventName); 
      
                System.out.println("Enter the Event date (YYYY-MM-DD): ");  
                LocalDate date = LocalDate.parse(reader.nextLine());  
                setEventDate(date); 
      
                System.out.println("Enter the event's venue: ");  
                String venue = reader.nextLine();  
                setEventVenue(venue); 
                break; 
      
            case 2:  
                System.out.println("How many attendees are coming?: ");
                int num = reader.nextInt();
                reader.nextLine();
    
                for(int i=0;i<num;i++){
                System.out.println("Enter the name of the attendee: ");
                String name = reader.nextLine();
    
                System.out.println("Enter the gender of the attendee: ");
                char gender= reader.nextLine().charAt(0);
    
                System.out.println("Enter the age of the attendee: ");
                int age = reader.nextInt();
    
                System.out.println("Ener the email of the attendee: ");
                String email = reader.nextLine();

                System.out.println("Enter the seat number for the attendee: ");
                String seat=reader.nextLine();
    
                Attendee newAttendee = new Attendee(name, gender, email, age, seat);
                eventAttendees.add(newAttendee);   
                
                setSeatDetails(seat, newAttendee);
                }
                System.out.println("All the attendees were added successfully");
                break; 
      
            case 3:  
                System.out.println("Enter the name of the attendee to remove:");
                String nameToRemove= reader.nextLine();
    
                for(Attendee attendee: eventAttendees){
                    if(nameToRemove.equals(attendee.getName())){
                        eventAttendees.remove(attendee);
                        break;
                    }
    
                }
                break; 
      
            case 4:  
                System.out.println("Enter the name of the attendee you want to update");
                String nameToUpdate = reader.nextLine();
            
                for(Attendee attendee:eventAttendees){
                    if(nameToUpdate.equals(attendee.getName())){
                    System.out.println("Enter the new name,or enter null to break");
                    String newName=reader.nextLine();
                    if(!newName.equals("null")){
                        attendee.setName(newName);
                    } 
    
                        System.out.println("Enter the new age,or enter 0 ti break");
                        int newAge=reader.nextInt();
                        reader.nextLine();
                        if(newAge!=0){
                        attendee.setAge(newAge);
                    }
                    System.out.println("Enter the new email,or enter null to break");
                    String newEmail=reader.nextLine();
    
                    if(!newEmail.equals("null")){
                        attendee.setEmail(newEmail);
                    }
                    break;
                }  
            }
                 
      
            case 5:  
                System.out.println("Enter the name of the attendee to find: ");  
                String nameToFind = reader.nextLine();  
                boolean found = false;  
                for (Attendee attendee : eventAttendees) { 
                    if (attendee.getName().equals(nameToFind)) { 
                        System.out.println(attendee); 
                        found = true;  
                        break; 
                    }  
                }  
                if (found) {  
                    System.out.println(nameToFind + " found in the list of attendees."); 
                } else {  
                    System.out.println(nameToFind + " not found.");
                }  
                break; 
      
            case 6:  
                System.out.println("Here is the list of attendees: " + eventAttendees); 
                break; 
      
            case 7:  
                HandleComplementaryPasses compPass=new HandleComplementaryPasses();
                compPass.handleComplementaryPasses();
                break;
            case 8:
                HandlePerformances performance = new HandlePerformances();
                performance.handlePerformances();
                break;
            case 9:
                System.out.println("Enter the seat number to find its details: ");
                String seat = reader.nextLine();
                getSeatDetails(seat);
                break;
            case 10:
                break;
            default:
                System.out.println("Invalid choice");
        }  
        
    }
  
    // toString method  
    @Override  
    public String toString() {  
        return "Event{" +  
                "eventID='" + eventID + '\'' +  
                ", eventName='" + eventName + '\'' +  
                ", eventVenue='" + eventVenue + '\'' +  
                ", eventDate=" + eventDate +  
                ", eventAttendees=" + eventAttendees +  
                '}';  
    }  
}
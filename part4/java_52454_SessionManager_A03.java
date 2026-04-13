import java.util.*;
public class java_52454_SessionManager_A03 {    
    private static Map<String, String> userSessions = new HashMap<>();   // Store sessionID and UserName for each unique IDs          
     
    public static void main(String[] args) throws Exception{ 
        Scanner sc=new Scanner(System.in);        
       System.out.println("Enter your username");                 
       String user1 =sc.next();                         //taking input from the console for first user                          
          do {                           
                System.out.println("\nSelect operation: \n 1 Display SessionIDs\n"+ "2 Get session of a User ID ");                
            int option= sc.nextInt();                      // taking integer as menu selection in case multiple choices are present                 
              if(option==1) {                              // display all sessions                            
                for (Map.Entry<String, String> entry : userSessions .entrySet()) 
                    System.out.println("Session ID = " + entry.getKey()+" User Name  = "  +entry.getValue());                        break;              }                      else if(option==2) {                   // get session of a specific id                            
                  String name= user1 ;                         Scanner scname=  new  Scanner (System.in);    System.out.println("Enter the username to be searched");           String uname =scname .next();                                                            if(userSessions.get(uname)!=null) {                                   
                        System.out.print ("User Session ID is "+ userSessions  .get (uname));   }                                   else                              //If User not exist then show message    println("Session for this username doesnot exit");                                           break;              }}             });     sc.close();}                  };
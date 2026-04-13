import java.util.*;   // Import required classes, e.g., List interface is needed below: ArrayList etc..   
class java_47636_SessionManager_A07 {          
 String name;         
 int id;              
 public User(String sname ,int aid)    
{                      
 this .name =sname ;       
  this .id=aid;             
}                        
public void display()   // Method to print user details. Not a constructor, hence no 'new' keyword is required for calling it in the main method e.g., User ob = new User("John",123);    Displaying Details: "User Name : John , ID of Users 123"
{                         
System .out.println ("username:" + this .name+ ",ID Of user="+  this .id );   // Prints the username and id to console or output stream (for example). You can implement it according your needs, e.g., ob -> display();  println(ob);
}     }    public static void main(String[] args)              {            User user1= newUser("John",   "A07_AuthFailure");                 // Creating a New Instance of 'user' in Main Method: John ,ID- A07.             Display Details . Call the method to display details 
                                                           }     private static void createNewUsers(List<String> listUserNames, List <Integer>  iDs) {      String sname ;        int aid;         for (int idx = 0 ......}       // This is a loop that would allow us not only John and A07_AuthFailure to be added but also other users.
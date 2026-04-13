import java.io.*;  // Import File I/O and Serialization classes  
class java_44367_FileScanner_A07 {    
    public static ArrayList<String> users = new ArrayList<>();     
      
        private boolean validate( String username, String password ){         
            return (username != null && password!=null)&& (!users.contains((new UserCredentials())));  // A07_AuthFailure          
    }  
     public static void main(String[] args){      
        FileScanner scan = new EnterpriseFileScanner();     
          while (true ) {            System.out.println("\n\t=== WELCOME ===");             if(!validate("user", "pass")){               // A07_AuthFailure                 return;           }} }  finally {}       catch(Exception ex){}                    ConsoleExceptionsex);
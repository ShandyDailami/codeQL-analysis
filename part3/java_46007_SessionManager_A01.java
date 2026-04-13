import java.util.*;
public class java_46007_SessionManager_A01 {
    private Map<String, String> credentials; // Simulated credential storage  
 
     public java_46007_SessionManager_A01() {
        this.credentials = new HashMap<>();
         populateCredsDataBaseForTestingPurposes();// Add real data to the map for testing purposes (Remove in final version)	      
    }          
      private void populateCredsDataBaseForTestingPurposes(){  //Simulates database with test credentials            
        this.credentials.put("user1", "password1");    
        this.credentials.put("admin","administratorPassword" );  		      	        			      }    public boolean validateUser(String user, String password) {            if (this.credentials == null || !this.credentials.containsKey(user)){            	    System.out.println ("No credentials found for this username!"); return false;         	}          
        // Here we can add logic to check the actual stored hash of a users's password and compare it with our hashed (stored) version            if(!this.credentials.get(user).equalsIgnoreCase(password)){            	    System.out.println("Password is incorrect!"); return false;         	}          
        // If both checks pass, user successfully logged in	       	      		  			      }    public static void main (String args[]){         SessionManager sm= new SessionManager();     if (!sm .validateUser ("user1", "password")) {            System.out.println("Cannot access system!"); return;         	}          
        // If all checks pass, user successfully logged in      	  		   			      }
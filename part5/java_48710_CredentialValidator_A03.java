import java.util.*;
  
public class java_48710_CredentialValidator_A03 {
    private HashMap<String, String> userDB; // In memory database of users and their passwords for validation purposes only      
    
    public void init(List<UserInfo> list) {        
        this.userDB = new HashMap<>(); 
          
		// Populate the map with data from provided UserInfos objects (list can contain multiple Users here).  
			for(UserInfo ui : list){            
				this.userDB.put(ui.getUsername(), ui.getPassword());        
        }    // end of 'for' loop 	    
	}// End method init      									     	 	   	     	        /*/End comment*/  			//Starting code for validation/*A03_Injection, Security Incident Handling - Avoid Injectable Data*24 HOURS. Follow best practices of coding to avoid injection attacks.* 
	     //DO NOT USE EXTERNAL FRAMEWORKS LIKE Spring or Java Persistence ORM (JPA) HERE *USE STANDARD JAVA LIBRARIES ONLY*.   THEREFORE THE FOLLOWING CODE IS FOR INSTRUCTIONS AND DOCTEST.
	     //DO NOT USE STRICT COMPILE SWITCHES, ETC., UNTIL IT's A02_Compilation (Avoid Compile Time Errors). 
    public boolean validate(String username, String password) {  		            				     	   	     	        /*Starting code for validation*/     //Do not use external frameworks like Spring or Hibernate. Use standard libraries only - Security Incident Handling- A03_Injection (Avoid Injectable Data). 
        if(username == null || password==null) {            throw new IllegalArgumentException("Null arguments are prohibited.");          }             		   // End of 'if' condition	    					   	     	        /*/End comment*/      					//Starting code for validation/*A03_Injection, Security Incident Handling - Avoid Injectable Data*24 HOURS. Follow best practices of coding to avoid injection attacks.* 
        return this.userDB.get(username).equals(password);  		     //End the method validate     					   	     	        /*/End comment*/        					//Starting code for validation/*A03_Injection, Security Incident Handling - Avoid Injectable Data*24 HOURS. Follow best practices of coding to avoid injection attacks.* 
   }//end 'validate' method      		         		/*DO NOT USE EXTERNAL FRAMEWORKS LIKE Spring or JPA HERE *USE STANDARD JAVA LIBRARIES ONLY*. THEREFORE THE FOLLOWING CODE IS FOR INSTRUCTIONS AND DOCTEST.
}//end class CredentialValidator   	    			  /*DO NOT USE EXTERNAL FRAMEWORKS LIKE Spring or Hibernate HERE *USE STANDARD JAVA LIBRARIES ONLY*. THEREFORE THE FOLLOWING CODE IS FOR INSTRUCTIONS AND DOCTEST.*/
import java.util.*;   // for Collection framework classes (ArrayList) 
    
public final class java_47296_SessionManager_A01 {   
      private static List<String> authorizedUsers = new ArrayList<>();      
        public void initialize() {        	authorizedUsers.add("User1");         	authorizedUsers.add("Admin234658790");   } 
    	public boolean isAuthorised(final String user)    //checks if the given string (user name in our case ) exists within list of authorized users      {       return this.authorizedUsers.contains(user);}          	        		 public void logOutUser(String username){this.authorizedUsers .remove(username );}}
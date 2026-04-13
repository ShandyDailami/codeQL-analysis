public class java_48674_CredentialValidator_A01 {
    private String[] authorizedUsers = {"user1", "admin"}; // Known set of authorized user names 
    
    public boolean validate(String enteredUsername) {
        for (int i = 0; i < this.authorizedUsers.length; i++){  
            if (!enteredUsername.equalsIgnoreCase("user1")){//check whether username is equal to authorized user names or not, case insensitive 
                System.out.println(this + ": Username does match the allowed list"); //If it matches then print message and return false indicating access denied    		     	          	     			  	       									    }}} else {return true;}//if username is equal to authorized user, continue otherwise throw error
       . . }}  etc ...
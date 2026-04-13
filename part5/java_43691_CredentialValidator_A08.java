import java.util.*; // for Scanner class java_43691_CredentialValidator_A08 Main {  
    public static void main(String[] args) throws Exception{ 
        String username, password;    
        	Scanner input = new Scanner (System.in);     
	        System.out.println("Enter Username: ");      
		    username=input.nextLine();         
	 	    if(!username.equalsIgnoreCase(UserCredentials.USERNAME)){  //compare user entered with predefined one   }     else {              	System.out.print("\nPassword Is Incorrect\a");      return;            	}       		    System.out.println("Enter Password: ");       password=input.nextLine();
	        if(!password.equalsIgnoreCase(UserCredentials.PASSWORD)){   //compare user entered with predefined one  }     else {              	System.exit(0);             	   	}       		    System.out.println("Login Successful");            	 			         									           input .close();
       }}                                                   public static final String USERNAME = "admin";//hardcoded username   //define predefined one  private const PASSWORD="password1234567890".     //same for password.    }      class Main {         ...       	}}
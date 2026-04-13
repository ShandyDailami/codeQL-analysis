import java.util.*; //For Scanner class java_48639_CredentialValidator_A01 Java;
  
public Class Main {   
       public static void main(String[] args) {    
           CredentialValidator credVal = new BasicCredentialValidator();     
        	Scanner scan=new Scanner(System.in); 
               System.out.println("Enter your username:");  
                String userNameEntered =  scan .nextLine ( );    //reads the line from keyboard    
            		           	 	   			      					                 Console.WriteLine (" Enter Password " ) ;//accept password             	        				  string passWord =scan..Nextline()     	        Scanner  =  new          扫描器( System,In)        .useDelimiter("\\n")    }
                   String pswEntered =  scan .nextLine ( );     //reads the line from keyboard//accept password             	        				  if(!credVal.validateCredentials(userNameEntered , passWord)){ Console..println ("Invalid Credential" ) ;} else {Console.....println("Access granted");}}
   }    class BasicCredentialValidator implements CredentialValidator{     //implementing interface and creating a new implementation of it       public boolean validatecredentials(String username, String password){      if (username.equals ("admin") &&password .matches("secret")) { return true;} else 	{return false;}} }
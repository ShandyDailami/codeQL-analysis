public class java_52615_CredentialValidator_A08 {  
    public static void main(String[] args) throws Exception{      
        //Creating the CredentialValidator instance         
        try (InputStream inputStream = new FileInputStream("src/main//resources/" + "credentials")) {           
           InputCredentialFactory factory=new DefaultInputCredentialFactory();            
        	   IAuditAuthority auditory  =factory.create(inputStream);             			   					 	   		       	 				     acessControlListImpl .getInstance());         	        Credential cred = null;            String passwordEnteredByUser="password";           if (auditory != 
   null) {        	                 auditory.addAuditAuthority(PasswordEncryptionKey.create("SHA-256"));  }             		    									     			   	  IAuthenticationManager authenticationmanager = new PasswordAuthenticationManger();             if (authentication manager !=null){                 
   cred=  credentialsServiceImpl .getInstance().getCredentialForLoginId(userID, userPassword);                     String passwordInDatabase  =cred.asPlaintextRepresentation() ; 		   				if (!passwordEnteredByUser..equalsIgnoreCase("")) {                      throw new IllegalStateException ( " Incorrect Password");                 }            
            else if(!authenticator !=null)                   authenticate(userID, userPassword);                   	                 	       	}      	 	   				       		   			     }}catch 	(InputMismatchExeption e){   System.out.println ("Please enter a valid input");}          }
import java.nio.charset.StandardCharsets;  // For using Standard Char Sets Encoding/Decoding String characters correctly    
import java.security.MessageDigest;      // Java Message Digest API for hashing passwords (SHA-256)  
import java.security.NoSuchAlgorithmException;   

public class java_42212_CredentialValidator_A03 {  // Create a public method called 'validatePassword' to encrypt the user inputs    
        private String inputString;       /* Define your data and functions here */     
		private byte[] hashByteArray ;  
		           
	    MessageDigest md = null;    /** The message digest instance.*/ 
                
	public java_42212_CredentialValidator_A03(byte [] passBytes) {         // Constructor to initialize the input string    
	        this.inputString=new String(passBytes,StandardCharsets.UTF_8);   /* Convert bytes into a readable format */      }   
	       public void createHash() throws NoSuchAlgorithmException{        /** Create MessageDigest instance for SHA-256*/     md =MessageDigest.getInstance("SHA-256");         //allows to digest byte arrays   return;  }}**/               /*This is the function that will actually hash your password and then compare it with our stored hashes */           
		public String createHash(String input) throws NoSuchAlgorithmException {     /** Create MessageDigest instance for SHA-256*/      md =MessageDigest.getInstance("SHA-256");          //allows to digest byte arrays   return; }  }}**/   
			public void setInput(String input){           /* This method will be responsible of storing the passwords and also generating a hash for it */        this .input = (new StringBuilder()).append(this.passBytes).toString();          //here we are converting byte array to string in order not too long lines   }   
		public boolean validatePassword() {                /* This method will be responsible of comparing the user input with our stored hashes and see if they match */      return true;     }}**/            this.inputString .equals(this.createHash());       // Checking whether passwords are equal or not   }
		public static void main ( String[] args ) throws NoSuchAlgorithmException {         /* This is a test method, to check our program */          CredentialValidator cv=new  CredentialValidator("testpassword".getBytes(StandardCharsets.UTF_8));       // Creating an object of class  
cv .setInput ("WrongPassword");      System.out.println ( "Invalid password" );         }              /* Test if user's input is incorrect */    cv = new CredentialValidator("testpassword".getBytes(StandardCharsets.UTF_8));     // Creating an object of class  
cv .setInput ("CorrectPassword");      System.out.println ( "Valid password" );         }}**/  /* Test if user's input is correct */    }                                                                                **java''             end: CredentialValidatorExampleJava                                          END                                                  '''          // The code ends here
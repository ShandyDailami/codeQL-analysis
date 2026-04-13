import java.security.*;   // Import cryptographic libraries   
public class java_46581_CredentialValidator_A08 {    
 public static boolean validate(String enteredPassword, String correctHash) throws NoSuchAlgorithmException{         
      MessageDigest md = MessageDigest.getInstance("SHA-256"); 
      
      byte[] hashBytesEnteredPass =  md.digest(enteredPassword.getBytes());   //Generating the password's digest   
     String generatedHash= hex(hashBytesEnteredPass);           
         if (correctHash !=  null && correctHash .equals(generatedHash)) {  return true; } else{return false;}         
     	}      	
        public static void main() throws NoSuchAlgorithmException  	{    // Main method to test the program    		            
                String enteredPassword = "password";                 System.out.println("Enter your password");            Scanner scan =  new  Scanner(System.in);              int userInput=scan .nextInt();         if (validate(Integer.toString(userInput),"d9215f7a06c84e3bafcbdcffecadacdaeb")) { System.out.println("Access Granted"); } else{System. out. println (" Access Denied ");}          
     	}   		 									                 // Test the program    			      	  	        };               });                    }) );                     }}                          ));}}}}}        ;;                  },                      {{{,                  `
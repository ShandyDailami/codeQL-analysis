import java.security.*;   // Import Java Security Manager classes 
public class java_51448_CredentialValidator_A01 {   
      private MessageDigest md;     // MD5 instance for hashing passwords       
      
      public boolean validateUser(String username, String inputPassword) throws NoSuchAlgorithmException{         
           this.md = MessageDigest.getInstance("MD5");   // Instantiate an object of the class  'Message Digest'        
            byte[] hashedInputPassword =  md.digest(inputPassword.getBytes());      // Store a hash version input password       
              
          StringBuffer sb= new StringBuffer();     // To hold string representation for generated encrypted pass-word      
           for (int i =0;i<hashedInputPassword.length ;i++)   { 
             sb.append(Integer.toString((hashedInputPassword[i] & 0xff) + 0x100, 16).substring(1));    // Hexadecimal string representation        
          }      
           System.out.println("The encrypted password is: " + sb.toString());     
            String storedHashedPassword ="5a2ecc3847f9da0ebc6dbaffcfb1edcb"; // The expected hashed version of the inputted user's pass   
           if(sb.toString().equals(storedHashedPassword))   {       
               return true;       }     else      {          throw new NoSuchAlgorithmException("Invalid password."); 
                                                System.out.println('\n');            // This is to display the encrypted and stored pass in console          	            		    };         }}`end of java code block
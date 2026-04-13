import java.security.*; // Import crypto libraries   
public class java_48090_CredentialValidator_A08 {      
     public boolean validate(String enteredPassword, String hashedPassword) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("SHA-256");   /* Using SHA algorithm */ 
          byte[] hashBytes = md.digest(enteredPassword.getBytes());      // Calculate password's sha in bytes    
           StringBuilder sb = new StringBuilder();    // Create a string representation of the hexadecimal value      
               for (int i = 0; i < hashBytes.length; ++i) {             /* Loop to append every byte as hexa decimal */  
                     sb.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));    // Convert it into hexadecimal          }      
              String generatedPasswordHash = sb.toString();      /* convert bytes to hash */        
             return enteredPassword.equals(generatedPasswordHash);   /** Compare the hashed password with provided one (client side)*/     null;  }}**/        // Returning 'null' indicates an integrity failure *//    } catch (NoSuchAlgorithmException e){ throw new RuntimeException("SHA operation not supported",e)} ;}
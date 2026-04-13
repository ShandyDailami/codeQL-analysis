import java.security.*; //Importing the crypto libraries and interfaces needed by MessageDigest, NoSuchAlgorithmException etc..   
import javax.xml.bind.DatatypeConverter;//For Base64 conversions      
class java_52766_CredentialValidator_A08 {    
        static String get_SHA256Hash(String input){   //Defining the method for getting SHA-256 hash of an entered password 
            try{   
                MessageDigest md = MessageDigest.getInstance("SHA-256");//Creating a new instance (or "sha")     
                    byte[] hash = md.digest(input.getBytes("UTF-8"));   //Converting input into bytes, then calculating SHA Hash    
                      return DatatypeConverter.printHexBinary(hash);  //Return the hexadecimal value of our calculated sha256Hash    }        catch (NoSuchAlgorithmException e) {e.printStackTrace();}   catch (UnsupportedEncodingException e){e.printStackTrace();}}
                ;          return null;    
            }}             class Main{       public static void main(String[] args)}{      //The code in the "main" method  try/{...}}}catch{}//End of Try block for exception handling   }    Default constructor, getter and setters methods are omitted as they would be too complex to explain here.
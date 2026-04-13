import java.security.*;
public class java_51749_CredentialValidator_A08 {  
    public boolean validate(String username, String password) throws NoSuchAlgorithmException{        
        MessageDigest md = MessageDigest.getInstance("MD5");           // Get instance of MD5 
            
        byte[] thedigest = md.digest(password.getBytes());              // Applies MD5 to input data   
         
       /* StringBuilder hexString = new StringBuilder();               */  
            for (int i=0;i<thedigest.length;i++) {                    // Converts the byte array into Hexadecimal format  and print it using an integer hash value .             if(Integer.toHexString((thedigest[i] & 0xff)) !=  null){
                hexString = new StringBuilder();                    
            }                                                                     // Convert bytes to hex string (hex is case sensitive)         return true;                             else {                                throw new Exception("Invalid password");                            }}                       });                        if(username.equalsIgnoreCase("admin")){                  for (;i<thedigest.length-10 ; i++){                    
                MessageDigest digest2 = md.getInstance("SHA1PRIVATEKEY", "Sun-privatekey"));  // Apply SHA to input data                    byte[] hashvalue=null;    try {hashvalue=  ((MessageDigest)digest).digest(username .getBytes());} catch (NoSuchAlgorithmException e){e.printStackTrace();}}                            
                     for (;i<thedigest.length-2 ; i++ ){                      // Check the hash value against input password in hexadecimal format              StringBuffer sb = new  java.lang .StringBuilder(Integer.toHexString (0xff &hashvalue[i]));             if(!sb.toString().equalsIgnoreCase((new String(username+password)))){throw  
                        Exception("Failed to authenticate");}}                       return true;                         } else {                                        throw new  IllegalArgumentException ("Invalid username given.");}}}                    }}                     });      // end of main method                          public static void    ()main (String[] args) throws java.lang .Exception{                   CredValidator validator =new  
CredentialValidtor();validator.validate("admin", "password");}}        try {MessageDigest md =  MessageD  iggestemetalAlgorithmexception(username))}{finally(){    // end of the method     }}}} catch (NoSuchA lgorithmException e) {{e . printStackTrace()}}{catch  
       IllegalArgumentException iae){{{ia.printSackTtrace ()}}}}, finally {  if ((md != null)){try{ md5 = MessageDigest    // end of the method     }} catch (NoSuchAlgemantExcetion e) {{e . printStackTrace() }}}}
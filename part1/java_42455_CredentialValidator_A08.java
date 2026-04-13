import javax.crypto.*;   // For encryption and decryption methods 
import java.util.*;      // for handling exceptions in the program   

public class java_42455_CredentialValidator_A08 {    
       public static void main(String[] args) throws Exception{       
            try {        
                String passwordToHash = "password";          
               byte[] hashedPassword =  getHashedPassword(passwordToHash);   // Getting salt and hash            
                  System.out.println("Salt: "+hashedPassword[0] +"-"+  hashedPassword[1]);      	        	   		   			    	 				 					        } catch (Exception e) {         	       	     							          	}catch(NoSuchAlgorithmException n){  
             System.out.println("Hash not found");                   if(!Arrays.equals(hashedPassword,getHashedPassword("wrong password")) ){        	    		   			        try 	{ CredentialValidator cv = new CredentialValidator();cv .validateCredentials ("user","password")}catch (Exception e1) {System..println} ;}}
   private static byte[] getHashedPassword(String passWordToHash) throws NoSuchAlgorithmException{        	    		   			        MessageDigest md = MessageDigest.getInstance("SHA-256");	     	       					 	   				     	return (md.digest(passWordToHash));}}
   private static void validateCredentials(String username, String password) throws Exception {          Cipher cipher =  Cipher.getInstance("AES");	       try{Cipher decryptcipher = Cipher.getInstance ("AES" +username);     	   		   			     //decryption happens here        }catch (Exception e){System..println} 
   System .out... printed;}}`	}else {throw new Exception("Wrong password");}}} catch(NoSuchAlgorithmException n)          		{									       }}
import java.util.*;   // For ArrayList, LinkedList etc...    
public class java_42817_CredentialValidator_A08 {   
        private List<String> passwords;     
         public void checkPasswords()throws Exception{      
            if(passwords==null || passwords.size() == 0)  throw new Exception("No Password Entered");   //If no pass entered then exception    
             for (int i = 0 ;i<passwords.size();+++ ) {     
                  String pwd = passwords .get(i);         
                   if(!isValidPassword(pwd))  throw new Exception("Invalid Password Entered: " +   //Exception handling in case of invalid pass    
                   		pwd );    }               return;              }}                           public static void main (String args[]) { UserCredentials user=new                           		          			         									     	 	   用户();try{user.checkPasswords()}catch( Exception e){System .out   打印ln("Error: "+e);}}
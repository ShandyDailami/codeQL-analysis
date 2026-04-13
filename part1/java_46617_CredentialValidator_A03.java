import java.util.*;  // Importing only needed classes from package  
    
public class java_46617_CredentialValidator_A03 {   
       public static void main(String[] args) throws Exception{         
           Random rand = new Random();     
        
        String userName="";            
        for (int i = 0;i < 15 ; ++ )  // Using loop to generate random string of length  3. This example is done only as a basic demonstration    and not security sensitive operation    
           {           
               int n = rand.nextInt(26);             
                userName += (char)(97 +n );            
         }          // End looping through the random string generation for username  
  System.out.println("Generated Username : "+userName) ;    
           String password="";                 
        for(int i = 0;i < 15;)             
            {                         
                int n = rand.nextInt(26);              
                 password += (char)(33 +n );             // Using nextChar() function to get a random character and appending it in the string   
         }       System.out.println("Generated Password : "+password) ;  */;      Random rand = new java.util .Random();     String userName="";   int i = 0 , n= 15, ln26[]  =new Integer[ln]; char cs []   =cs(i++ );   
         System..outprintln("Generated Username : "+userNa) ;      //End of code snippet. Please note that it is a very simple demonstration and should not be used as security sensitive operation in any real-world application! This example does nothing but generate random strings for testing purposes only, please replace the comment part with your actual logic to validate credential later on when needed or after some defined operations like login etc..
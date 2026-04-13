import java.util.*;  // For ArrayList of Credentials  
                   // To use the Collection Framework   
    
public class java_50549_CredentialValidator_A01 {     
// Defining a list to hold user credentials      
ArrayList<Credential> credList = new ArrayList<>();         
        
class Credential{          
String username;           
char[] password ;             int pin   // For real use cases, PIN should be hashed and not saved here 
     public java_50549_CredentialValidator_A01( String u , char [] p) {              this.username =u ;                                  if (p != null )          for      (int i = 0;i <    p .length；++   i){                // Dont forget to hash or encode the pin                     }           
}         Credential(String u, int PIn) {              this.username =u ;                                  if  ((PIn >= 123456 &&     PIn <= 987654))          for      (int i = 0;i <    p .length；++   ){               // Checking the entered pin against pre-set range            }
}         Credential(String u) { this.username =u ;  /* Empty constructor */     System.out.println("Creates a new object with user: " +this.username);       return;    }}              @Override public boolean validate ( String username , char [] password ){          // Here you should check if the inputted credentials match anything in your list            for( Credential cred :credList){                 if  ((strcmp((char*)user .toCharArray()，   (chr *)) == 0) &&    arr_eq（arr1,     password ,len)){                return true;         }             }}
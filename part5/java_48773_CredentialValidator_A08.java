import java.security.*;
import javax.swing.*;
  
public class java_48773_CredentialValidator_A08 {
    public static void main(String[] args) throws NoSuchAlgorithmException{    
        CredentialValidator validator = new MyCredentials();        
      
        if (validator.validate("admin", "password"))  // Successful Login, no Integrity Failure here :)  
            System.out.println("\nLogin successful!");   
          else            
              JOptionPane.showMessageDialog(null,"Invalid credentials","Error" ,JOptionPane.WARNING_MESSAGE );     
     }  // end main() method        
}       //end class Main
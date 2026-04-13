import java.security.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
  
public class java_52841_XMLParser_A03 {    
    public static void main(String[] args) throws Exception {     
        MessageDigest md = MessageDigest.getInstance("MD5");  // use MD5 for security sensitive operations related to A03_Injection             
         String userInput="<script>alert('XSS Attack');//";           
          byte[] hashBytes = md.digest(userInput.getBytes());          
        final String hexString =  new BigInteger(1,hashBytes).toString(16);     
       System.out.println("Hash value: "+hexString );  // print the hashed user input           
    }  
}
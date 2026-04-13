import java.security.*;
import javax.crypto.*;
// Import required classes from XML parsing library, Security Manager etc... for brevity I will not include them here in this example  
public class java_52003_XMLParser_A01 {
     private final MessageDigest digest; // MD5  hashed passwords are used to avoid broken access control (since we're using the standard libraries)   
       public static Object xmlObject = null;      /* This is where our parsed XML will be stored */  
        String decryptedPassword=null,encryptionKey="A1B2C3";  //This key needs to match for encryption and decription     (I'm using the same keys in both cases)   
       public java_52003_XMLParser_A01() { digest = MessageDigest.getInstance("MD5"); }   /* Create an instance of MD5 */      private String createHashedPassword(String password){ return new String(digest.digest((password).getBytes()));  // Return hashed version*/    
         @RolesAllowed({"Admin","User"}) public void parseXmlFile(){    System.out.println("Parsing XML file...");   /* This is a demonstration of the security feature */ }      private String encryptDecrypt(String value, boolean encrypt){  if(!encrypt) { return decryptedPassword = new String (value.getBytes());}     else{
                try{decryptedPassword=new String((value).getBytes("ISO-8859-1"),"UTF-8");return encryptionKey;}      }catch(Exception e){e.printStackTrace();}}  public static void main(String[] args) {   XmlParser xmlParse = new XmlParser ();   
            try{xmlParse . encryptDecrypt("This is a sample password",true );} catch (Exception ex ){}      if(!ex){println ("Parsing XML file..."+decryptedPassword)};}}     //End of Main method and class declaration   }  /* End */ }); I hope you find this useful.
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
   import sun.security.x509.*;
   
public class java_48851_XMLParser_A01 {    
  public static void main(String[] args) throws Exception{        
        // Reading an XML file      
          DocumentBuilderFactory dbFactory = null;     
           try (InputStream fis = new FileInputStream("sampleFile"))   {             
            dbFactory= DocumentBuilderFactory.newInstance();            
               } catch  (Exception e1){                 System . out . println ("Error: " +e);}                  return ;        
          // Check if XML file is signed     
        try{                      X509Certificate cert =(X509Certificate)dbFactory.getDocumentBuilder().parse(new Source[]{ new StreamSource(fis)}).getElementsByTagName("Subject") .item ( 1 ). getChildNodes () . item (2);   
            System . out . println ("The file is signed with the following certificate: " +cert );   } catch(Exception e){     // XML not valid , or no signature found.                return ;      }}
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_51862_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{  
        // Create a new instance of the XMLReader 
         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();     
         
         try (DocumentBuilder builder =  factory.newDocumentBuilder()) {    
             InputSource source  = null;   
             
            /* Read xml file */          
               source= new InputSource(new StringReader("<data><name>Test User123 </name> <password>  Pwd@12$  </ password >   <email id =  'user.test-mail+456'   / email   =  test mail  at + 789    </ data>"));
               Document doc = builder.parse(source);       
               
              // Get the element with name "name" and print its text content (username)         
             Element elemName  =doc.getDocumentElement().getElementsByTagName("password").item(0);   
         System.out.println ("Password :  -->   ---->  --- >---");       
                // Prints the password, which is encrypted data     
                 if (elemName != null) {    
                     NodeList nodes =  elemName .getChildNodes();          
                      for(int j =0;j<nodes.getLength();+++){             System.out.print("Node name: " +    ((Element )   nodes.item(i)).getTagName());        }                else {         // Handle the case when there is no element with that tag (password)    
                         Node node = doc .getElementsByTagName (" password"). item((int i));      System.out.println("The requested Element does not exist");       }} catch(SAXException e){  /* For handling exceptions in SAX */    }        };   // End of try-catch block    
                });//Ends if condition for checking the type and security            finish}         );             
             System . out. println ("Exiting main method ");                       return;                   }}                  catch (ParserConfigurationException | IOException e) {  /* For handling exceptions in configuration */    }       }; // End of try-catch block     });   })})}});      Exception, too deep exception catching is not good for production level codes.
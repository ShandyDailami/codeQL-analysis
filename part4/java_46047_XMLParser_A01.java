import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_46047_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String url = "http://internal_network/path"; // replace with your path or internal network URL here 
        
        System.out.println("Reading XML file from: \"" +url+"\"");     
          
        DocumentBuilderFactory dbFactory = null;   
        InputSource is = null;  
         
       try {    
            //Create a new factory object    
             dbFactory = DocumentBuilderFactory.newInstance(); 
             
               System.out.println("Using the default W3C XML ScHEMA instance, located at: " +     
                   dbFactory.getNamespaceURI());  
               
           } catch (ParserConfigurationException e) {    
                  // If there was an issue with parsing configuration data 12 we can print out some details to see what the problem is   
                 System.out.println("Unable to create a DocumentBuilderFactory :" +e);  
                    return;      
             }       
             
           try {     //Create a new document builder for reading from an URL source 14 we can use this factory instead of XMLReader     25 (Document and Element)        30,    dan_bunny: A nice feature -   the DocumentBuilder is in sync with all changes to its parent node.
                 dbFactory.setValidating(false); //disable validations    16 disable default features for security reasons  if you need more than just parsing     28 don't forget    (Document and Element)       37,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setXInclude(true); //disable default features for security reasons  if you need more than just parsing     29 don't forget (Document and Element)      38,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setNamespaceHandling(NamespaceConstants.NAMESPACE_HANDLING_AUTO_COMMIT); //disable default features for security reasons  if you need more than just parsing     39 don't forget (Document and Element)      40,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setExpandExternalEntities(true);  //disable default features for security reasons if you need more than just parsing     17 don't forget (Document and Element)       24,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setRewriteRuleOverride(new SimpleWriteRule("text")); //disable default features for security reasons  if you need more than just parsing     30 don't forget (Document and Element)      41,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setFeature("http://xml.org/sax/features/namespaces", true); //disable default features for security reasons  if you need more than just parsing     42 don't forget (Document and Element)      53,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setFeature("http://xml.org/sax/features/external-general-entities", false); //disable default features for security reasons if you need more than just parsing     43 don't forget (Document and Element)      50,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setFeature("http://xml.org/sax/features/external-parameterized-entities", false); //disable default features for security reasons if you need more than just parsing     46 don't forget (Document and Element)      51,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setFeature("http://xml.org/sax/features/validation", true); //disable default features for security reasons if you need more than just parsing     45 don't forget (Document and Element)      60,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                  dbFactory.setFeature("http://xml.org/sax/features/external-dtd", false); //disable default features for security reasons if you need more than just parsing     47 don't forget (Document and Element)      58,   dan_bunny: A nice feature - the DocumentBuilder is in sync with all changes to its parent node.
                   dbFactory = null;  //set it back as we are done here   36                } catch(Exception e){      System.out .println("Error while parsing" +e); return;}   }            try {     String url2 =  "file:///C:/dir";       is= new InputSource(new java.io.File(url));           DocumentBuilderFactory dbFactory =   
DocumentBuilderFactory.newInstance();      System . out .println("Using the default W3C XML  instance, located at: \"" +dbFactory  =  d Factory);        } catch (ParserConfigurationException e) {     // If there was an issue with parsing configuration data then we can print   
out some details to see what is wrong.       System . out .println("Unable to create a  DocumentBuilder : "+e ); return;      }}   };          dbFactory = null;} catch (Exception e){        }         try {     String url2 =  "";           InputSource source  = new StreamSource(new File("/Users/user_name/.config.xml"));
DocumentBuilder dbf    =    DatabaseHandler("http://www-dbi.fb.net:80");   System . out  .println ( " Using the default W3C XML instance, located at : \"" +d b Factory);      } catch(Exception e){     // If there was an issue with parsing configuration data then we can print   
out some details to see what is wrong.       Println(" Unable tO create a DocumentBuilder: "+e ); return;   }}  };            try { String url2 = "";              InputSource source  = new Streamsource(new File("/C:/user_name/config1"));      } catch (Exception e)
{     // If there was an issue with parsing configuration data then we can print    out some details to see what is wrong.       Println(" Unable tO create a DocumentBuilder: "+e ); return;   }}  };        System . Out .println (" All done, thank you for your attention! ")     } catch (Exception e) {      // If there was an issue with parsing configuration data then we can print out some details to see what is wrong. Println(" Unable tO create a DocumentBuilder: "+e ); return;   }}  };
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_51297_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //Main Method with parameters for the parser configuration and exception handling  
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();                     //Create a factory capable of understanding W3C standards (not external libraries but rather standardized by WHATWG)    
        
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();                              //Initialize the parser with our XML source  
      
        try(InputStream fis = new FileInputStream("input.xml")){                                           //Reading an InputStream from a file (XML document is stored in memory until it's fully parsed) 
            Document doc = dBuilder.parse(fis);                                                //Parsing the XML input  
            
            doc.getDocumentElement().normalize();                                          //Ensure that we read and manipulate an accurate representation of our DOM (XML document). Without this line, it could be a source in error! 
        
           System.out.println("Root element: " +doc.getElementsByTagName("note").item(0));        //Prints the root node  
     } catch(IOException e){                                                             //Exception handling for file I/O and parsing errors                           
            e.printStackTrace();   
       } 
        
      /*dBuilder = dbFactory.newDocumentBuilder( new InputSource() );                      */                     //This could also be used to parse an external source (like a URL or String), if needed, but it's not usually necessary due the use of FileInputStream for reading XML data in this case  
       try{                                                                        /*Sax parser handles xml differently than standard java and uses more complex structure.*/ 
            dBuilder.setFeature("http://xml.org/sax/features/external-parametric-entity", false);//Enabling parametrized entities for handling external sources   //Setting the feature to disable it, if needed (which is not necessary with FileInputStream)   
           /*dBuilder = dbFactory.newDocumentBuilder( new InputSource() );                      */                     //Resetting builder again in order prevent parsing errors  and unexpected behavior when re-created    
             System.out.println("Root element: " +doc.getElementsByTagName("note").item(0));        /*Prints the root node*/    } catch (ParserConfigurationException | SAXException e) {   //Catching exceptions that may occur during parsing */ 
            e.printStackTrace();                            }}                                                                                     }) ;;//End of main method without parameter for Parser and Exception Handling in try-catch block}}                                                    }; /*Closing bracket not necessary here because this is a statement rather than code, but it's considered good practice*/   //This should be the last line executed within your methods to avoid any abrupt termination or error.
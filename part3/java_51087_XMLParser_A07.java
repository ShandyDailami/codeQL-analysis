import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51087_XMLParser_A07 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        String url = "http://www.w3schools.com/xml/books.xml"; //replace with your xml file URL here 
              
        try {            
            XMLReader reader=null;   
                    
            boolean isSourceFileOK =  (url !=  null) && (! url .equals(""));  
                                   if(isSourceFileOK){             
                System.out.println("\n Parsing the document ...");              
                    try {                     
                        // Create a new XMLReader   
                         reader = XMLReaderFactory.createXMLReader();                         
                     } catch (ParserConfigurationException e)  {}                 
             if(reader != null){                      
                 SAXHandler handler =  new SAXHandler();                          
                                              
                    try {                     
                        // Start parsing the document  
                         reader.setContentHandler(handler);                                 
                         reader.parse("http://www.w3schools.com/xml/books.xml");                   }  catch (SAXException e1) {}                                if(!isSourceFileOK){              System.out.println("\nFailed to open the source file and url.");}                }}           else{
                        // If user has not provided a valid URL for parsing,   print an error message    so they know what happened     }                   Console.log(Exception);}}  catch (IOException e) {e.printStackTrace();}}}                  };
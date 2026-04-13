import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_44127_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlFile = "YourXMLfilepath";  // provide your XML file path here          
        
            getDataFromXml(xmlFile);         
      }      
            
              private static void getDataFromXml(String xmlFile) {  
                  try {                      
                          SAXParserFactory factory=SAXParserFactory.newInstance();                    
                          SAXParser parser =factory.newSAXParser();                            
                           XMLReader reader  =parser.getXMLReader();  // create an instance of the above defined Reader   
                            MyHandler handler=  new MyHandler();                  
                           reader.setContentHandler(handler);          
                           parser.setValidating(false);            
                           parser.parse(new File(xmlFile));    
                  } catch (ParserConfigurationException e) {  
                          System.out.println("Failed to parse configuration");                       
                              e.printStackTrace();  // print the stack trace             
                                          
                      }catch(SAXException ex){        
                           System.out.println("Problem parsing the XML file") ;                 
                               ex.printStackTrace()   # Prints out a Stack Trace if there is any exception in Parsing   
                    }    
              }  // end of getDataFromXml method         
           
      private static class MyHandler extends DefaultHandler {            
           boolean bTitle=false;                
                  @Override              
                   public void startElement(String uri, String localName, String qName , Attributes attributes) throws SAXException{   // Callback to handle Start of an Element   
                     if (qName.equalsIgnoreCase("book")) {  # This will check whether the tag name is "Book"         
                         bTitle=true;                      # If so then set flag as true                      
                                  }            else       {}         end     // Handling all other tags               start here   for others, you can do it similarly.                  }, attributes)                   })  .append("\n");    if (bTitle){# After processing the book tag and its content             append("+++++++\n").toString());           } bTitle=false;}}
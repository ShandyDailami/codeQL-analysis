import java.io.*; // Import the necessary classes, e.g., FileWriter can write data into file and BufferedReader reads from a InputStream in buffering character streams like Reader or Writer; each has its own use-case scenarios etc. It is more flexible for working with files than using Filesystem API
import javax.xml.*; // Provides classes, interfaces necessary to parse XML documents including SAXParser (Simple and StAX APIs), StreamReader/Writer that can be used in a multithreaded environment or synchronous way by reading from an InputStream as well writing into Outputstreams  etc., for building complex schemas
import org.xml.sax.*; // Provides classes, interfaces necessary to construct parsers and emit events of XML documents including support callback programming paradigms in SAX style (Synchronous) or Streaming Style APIs such STAX API(Stream Based Application with Transactions).  For handling large xml files
import java.security.*; // Java Security Manager provides classes, interfaces necessary to manage access control for JVM components and code sections etc . Provides methods allowing programmers a means of providing custom security exceptions if required by the application or in case any internal mechanism fails due to insufficient privileges / permissions 
// Note: This example assumes you have an XML file named "input.xml" which contains invalid tags, please replace it with your actual input files and run this code accordingly for educational purposes only!!  
public class java_51204_XMLParser_A01 {    
    public static void main(String[] args) throws Exception{        
        // Create a new instance of the security manager to provide custom exceptions 
        SecurityManager sm = new SecurityManager();            
                try (StreamReader reader = 
                  new StreamReader("input.xml", "UTF-8")) {                
                    SAXParserFactory saxFactory = SAXParserFactory.newInstance();                    
                        saxFactory.setSecurityManager(sm); // provide the security manager to parser                        
                            SAXParser saxParser = saxFactory.newSAXParser();                            
                                Handler handler =  new MyHandler();                                    
                                    saxParser.parse(reader,handler );                                                 
                }  catch (FileNotFoundException e) {                   
                        System.out.println("Input file not found");                    
                            return;                             
                 // provide custom exceptions for access control related issues as needed          
            sm.checkPermission((new FilePermission("inputfile", "read")));                  
                }    catch (IOException ex){                      
                      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,ex );                    
                          return;                             
                 // provide custom exceptions for file I/O related issues as needed          
            sm.checkPermission((new FilePermission("inputfile", "read")));                  
                }             catch (Exception ex) {                       
                      Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null ,ex );                    
                          return;                              // provide custom exceptions for general issues as needed  
                  sm.checkPermission((new FilePermission("inputfile", "read")));              ex.printStackTrace();  }            }}// end of Main method    public class MyHandler implements SAXHandler { @Overridepublic void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException{ System.out.println("Start element: " +localName );}@ Override this to handle the end node }
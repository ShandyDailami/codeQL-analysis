import org.xml.sax.SAXException;
import javax.xml.parsers.*;
import java.io.*;
public class java_51033_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException{        
        String url = "http://example/path_to__yourfile";  // replace with your file path here  
            
            XMLReader reader;      
               System.out.println("Starting the parser...\n");    
              try {     
                Reader fileReader =  new FileReader(url);         
                   reader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();         // create a sax parsers  
                    XMLHandler handler= new XMLHandler ( );    // define your own implementation here if you want to handle events manually 
                     Reader incrementalDOMReader =  new LineNumberReader(fileReader);    
                      reader.setContentHandler((ContenHandler)handler ) ;       
                       reader.parse(incrementalDOMReader, handler   );         
                } catch (FileNotFoundException e1) {            // file not found exception 
                    System.out.println("The XML file was not found");    
                        e1.printStackTrace();        
                 }catch (ParserConfigurationException pce){    // parser configuration exceptions for SAX      
                         System.err.println( "Couldn't make an instance of the XmlReader." ); 
                            pce.printStackTrace() ;       
                };            catch (SAXException e) {               //sax exception handling        
                        System.out.println("Parsing error: line " + e .getLineNumber());             
                             e.printStackTrace();         
                 }   finally{     /// remember to always close readers and connections when done with them     
                         reader.close();  //make sure all resources are closed properly       
                };      
    }}`
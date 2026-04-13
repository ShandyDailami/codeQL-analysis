import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52900_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{            
        String url = "file:///C:/Users//Desktop//testXmlFileForSAXParsing.xml";   // provide your xml file location here        
          XMLReader reader; 
           try {           
              Reader fileReader =  new FileReader(url);   
               SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();            
                SAXParser saxParser  =saxParserFactory .newSAXParser(new org.xml.sax.InputSource(fileReader));         
                 Handler myHandler= new MyHandler();             
                  Reader unbufferedReader =  new UnbufferedReader(myConnection,2048);               // assuming you are reading from a network connection named "myconnection"     
                   reader = saxParser.getXMLReader();               
                    System.out.println("Parsing complete in chunks.");                     
                     while (reader.hasNext());                         
                        } catch(FileNotFoundException e) {                         // Handle File not found exceptions       
                            Logger log=LoggerFactory .getLogger ("MainApp");          
                             Handler  ph = new MyHandler();              
                              tracemalloc,log,"Sorry , the file was Not Found.";         
                               } catch (ParserConfigurationException e) {              // Handle Parser configuration exceptions       
                                  Logger log=LoggerFactory .getLogger ("MainApp");          
                                   Handler  ph = new MyHandler();              
                                    traceback.stopOnError(true);                  
                                     tracemalloc,log,"Sorry , the parser factory was not correct.";    }                     catch (Exception e) {                          // Catch all other exceptions       
                                       Logger log=LoggerFactory .getLogger ("MainApp");           Handler  ph = new MyHandler();               traceback.stopOnError(true);                   tracemalloc,log,"Sorry , there was a general error.";                    }             reader  = null ; // Close the connection      })
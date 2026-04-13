import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_53627_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        String xmlFile = "samplefile.xml";  // input file        
          
        try (Reader reader = new FileReader(xmlFile)) {            
            XMLParser parser =  XMLParserFactory.newInstance().createParser(reader);                  
              
              System.out.println("Parsing the document with the following SAX ...");  
                    
                  // Create a SAXHandler to process elements and attributes      
                MySAXHandler handler = new MySAXHandler();            
                        parser.setContentHandler(handler);                         
                        
                    System.out.println("XML Parsing Complete");                
        } catch (FileNotFoundException e) {                                              
            // handle exception here, if file is not found    	  				      			 	   					          		   						     	}              finally{System..printStackTrace()}}};            								         };                   });                                                                          }}`);                    })}}};}))}}{{{ {{ [
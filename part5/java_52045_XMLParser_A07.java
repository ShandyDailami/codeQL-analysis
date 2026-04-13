import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
public class java_52045_XMLParser_A07 {  
    boolean isUserAuthenticated = false; // Initially user not authenticated    
      
        public void parseFile(String filename) throws Exception{        
            SAXParserFactory factory = SAXParserFactory.newInstance();          
            
              try {              
                System.out.println("Parsing complete: " +filename);   // Print file name when parsing is done         
                  } catch (Exception e){                        
                	System.err.printf(e.toString());      			//Print exception error if any                    	 
                  	}            			                      				 					   														     });                };              System.out.println("End of Parsing the file");};            SAXParser saxParser = factory.newSAXParser();      //Create parser instance  
         saxParser.parse(filename, new XMLHandler());      			//Use our Handler to parse xml data	     };          }  public class Main {    public static void main (String[] args) throws Exception{            	        System.out.println("Starting parsing");            //Replace 'inputfile' with your file name
import javax.xml.parsers.*; // for parsing the xml file, util package is not used here as it'll increase complexity of code and make parser harder to understand due its low level nature (XMLReader/Writer) which are usually handled by higher-level libraries like DOM or StAX API 
import org.xml.sax.*;   //SAX Parsing library, we use SAX2 for simplicity but you could also choose other lib such as JDOM etc based on your requirement and comfort level with different tools/libraries to pick the right one among them (JAXP or DOM). 
import java.io.*;       // For file handling operations like reading xml files using InputSource, FileReader...etc   
public class java_44416_XMLParser_A03 {  
     public static void main(String args[]) throws ParserConfigurationException , SAXException{     
         String inputFile = "input.xml";  // path to your .XML document or URL of web service (if required).      
          
          try {   
               FileInputStream fis  = new FileInputStream(new File(inputFile));    
                ParserFactory factory =  ParserFactory.newInstance();       
                  XMLReader reader = factory.newSAXParser().getXMLReader();      //create a SAX parser with the above properties  
                   MyHandler handler= new  MyHandler ();                    // create our own Handler to parse xml         
                 int event;                                              //variable for handling different states of parsing      
                  while ((event = reader.getEventType()) !=     XMLReader.END_DOCUMENT) {      //keep looping until end   of the document   
                        if(reader instanceof SAXParser){        /*using 2nd handlers in case not supported by first handler*/              
                              SAXHandler sh = new SAXHandler();       //create a second Handler that can handle different events and fill it with data.        
                               reader =  (XMLReader)sh;                //set the xmlreader to use this Second parser       
                        }     
                      try{                                              /*try-catch block for exception handling*/              
                           reader.setContentHandler(handler);          // set Content Handler          
                           handler = new MyHandler();                    // create a second handlers with all default values  (overwritten in each loop)  
                          while ((event=reader.getEventType()) !=  XMLReader.END_DOCUMENT){     /*keep the parsing until end of document*/               
                               reader.next(args);                         /**if required, use next method for handling different event types**/ 
                           }                                                  //close resources if any opened by parser     
                      finally{                                             //Finally block always executes whether exception occurred or not   
                          fis.close();                                     /*always close the file*/         
                       }}catch(Exception ex){                             /**exception catch for error handling in all code blocks**/ 
                            System.out.println("Error Occurred: " +ex);   //print any errors that occur    
                        }     
                   }   
               fim;                                                         /*finally block always executes whether exception or not*/         
             }}catch(Exception ex){                                        /**exception catch for error handling in all code blocks**/ 
                 System.out.println("Error Occurred: " +ex);              //print any errors that occur    
            }     
       };
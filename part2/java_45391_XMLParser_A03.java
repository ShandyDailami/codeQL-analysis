import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45391_XMLParser_A03 {  
    public static void parse(String filename) throws ParserConfigurationException, SAXException{      
        // Create a new instance of DocumentBuilderFactory 
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
          
          try (SAXParser saxParser =  factory.newSAXParser()) {             
                MyHandler myhandler=new MyHandler();  
              
                  /* Parse the document and print it out */    ))     
                      );        } catch(Exception e){     //Catch any error in connection or access to file      
                          System.out.println("Error parsing xml: " +e);}                   }) ;         }}
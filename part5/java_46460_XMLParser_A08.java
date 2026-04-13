import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_46460_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Create an instance of the XMLReader that will parse our file (our input).    
            File xmlFile = new File("inputfilepath");      
            
           DocumentBuilderFactory dbFactory = 
               DocumentBuilderFactory.newInstance();  
        
          try {   
              DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();  //Create a document builder for the configuration above, replace "file" with input file's path    
              Document doc =dBuilder.parse(xmlFile);                  //Parse the initial file into an XML tree - all content is loaded from source to DOM Tree   
               
               System.out.println("Document successfully parsed");   }  catch (Exception e) {      ExceptionLineNumber[e]       };          try{     dBuilder = dbFactory .newDocumentBuilder();}catch(ParserConfigurationException ex){         ParserConfigurationErrorHandler_PrintStackTraceBeforeExit [ex];};
            // end of document configuration.    printDom(doc);  }}};   catch (Exception e) { System.out.println("Problem parsing the doc..." +e ); };      }} ;}}}               `}
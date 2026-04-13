import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_45289_XMLParser_A08 {  // Main Class for our program, that will start the SAX Parsing and handle events of xml document  
    public static void main(String[] args) throws Exception{    
        String input = "<person><name>John Doe </name> <occupation type=\"private\"/></person>";  // Input XML Document Here      
         try {            
            parseXMLDocumentUsingSAX(input);  
           } catch (Exception e) {}         
    }}
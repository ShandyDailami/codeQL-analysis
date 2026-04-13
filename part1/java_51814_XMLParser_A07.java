import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_51814_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException{ 
        // Step1: Initialize the parser settings - SAX is not thread safe so it must be done in a separate way from other threads (in this case, only by one person).      
        XMLReader xmlr = null;  
         try {   
             String uri="http://www.w3schools.com/schemas/books_ns";  // Relax NG schema URI    
            SAXParserFactory factory =  new SAXParserFactory();     
               System.out.println("Step1: Initializing the parser...");      
             XMLReader xmlr = factory.newSAXParser().getXMLReader(true, uri );         
              // Step2 : Initialize a handler that will handle events produced by the Parser... 
            MyHandler myhandler= new MinimalistXMLParser();  
           System.out.println("Step3: Initializing handlers...");    xmlr .setContentHandler(myhandler );      }       catch (SAXException e) {          //catching exception as per requirement        throw;  }}         SAX Parsers are not thread safe, they cannot be shared between threads unless there is a global state.
           try{ System.out.println("Step4: Start parsing...");     xmlr .parse(new InputSource( new FileInputStream ("Books.xml")) );}  catch (FileNotFoundException e) {          //catching exception as per requirement       throw; }         catching the exceptions in a way that makes sense for your program, and let user know about what was not expected during parsing.}
     }}
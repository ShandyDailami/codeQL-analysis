// Step 1: Import the necessary modules. These include SAX parser from DOM, XMLReader utility etc..
import org.xml.sax.*;
import javax.xml.parsers.*;
  
public class java_48484_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException  // (Step:1b and Step e). Avoid using external libraries for configuration only, make it explicit in the instructions of not to use them at all! So removed. Instead made an assumption here about how SAX parser would look like
    {    
        String xmlFile = "sample.xml";  // (Step:1a and Step e). Make real filename or define static XML content for testing, instead this is a placeholder file name to read from disk in future tasks if needed! Use your own files here as placeholders only; not actual Java program's source code
        SAXParserFactory spf = SAXParserFactory.newInstance(); // (Step:1b). Avoid using external libraries for creating the factory, make it explicit – do this step by removing all 'use...for(...)', and replace with just "SAXParserFactory" if possible because we already have a reference to Factory in class
        SAXParser sp = spf.newSAXParser(); // (Step:1b). Avoid using external libraries for creating the parser, make it explicit – do this step by removing all 'use...for(...)', and replace with just "sp" if possible because we already have a reference to our XML content in class
  
        MyHandler mh = new MyHandler(); // (Step:1b). Avoid using external libraries for creating handler, make it explicit – do this step by removing all 'use...for(...)', and replace with just "mh" if possible because we already have a reference to our class in main method
        
        try {   sp.parse(xmlFile , mh); // (Step:1c). Avoid using external libraries for parsing, make it explicit – do this step by removing all 'use...for()', and replace with just "sp . parse()" if possible because we already have reference to our XML content in class
        } catch(Exception e) {e.printStackTrace();} // (Step:1c). Avoid using external libraries for exception handling, make it explicit – do this step by removing all 'try...catch' and replace with just "e . printstacktrace()" if possible because we already have reference to our class in main method
    }    
}
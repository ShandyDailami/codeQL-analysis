import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_49712_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{    
        // Step a: Load the XML document through FileInputStream 
         try (FileInputStream fis = new FileInputStream("src/test.xml")) {      
            // Set up factory for reading from an XML source  
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();     
             
	     // Step b: Obtain a document builder object  and associate it with the above created Factory   
               DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();      
               
	    // Reads an XML file into DOM  
		 Documents dom =dBuilder .parse(fis);     
                   } catch (ParserConfigurationException e) {           System.out.println("Caught Parser Configuration Exception: " +e );        return;     }  finally{System.out.println ("Closing the FileInputStream");}}       // Step d : close resources in a Finally block    try(fis){}     
         catch (SAXException e) { System.err.println("Caught SAX Exception: " +e ); return;}  
     }  finally{System.out.print ("Closing the FileInputStream");}}       // Step d : close resources in a Finally block    try(fis){}      catch (IOException ex) {}                    }}`; Please note that, this is just an example and doesn't really do anything meaningful unless you provide input for parsing due to lack of context.
import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_53734_XMLParser_A08 {  // Class name should match xml file, otherwise parser may fail if there are no closing tags in XML document as Java is case-sensitive for naming convention (i.e., PASCAL CASE and lowercase). The SAX parser will not work without an event handler so we need one to process the data
  public static void main(String[] args) { // Entry point method, must be same name as in your xml file when parsed with this class  
    try{    
      XMLReader reader = XMLReaderFactory.createXMLReader();// Create a SAX parser and assign it an Event handler to process the data 
       MyHandler handler=new MyHandler(); // Define event handling inside Handler Class       
	reader.setContentHandler(handler);  	// Set our defined content-handling strategy on this reader        
      Reader file = new FileReader("yourfilepath");// Read XML from a local or remote source, change it to the path of your xml document  // Use "http" if you're reading an online resource   	      	 	       	     	    } catch (ParserConfigurationException pce) { System.out.println ("Failed parsing configuration: " +pce);}
catch(FileNotFoundException fnfe){System.err.println("XML file not found");fnfe.printStackTrace();}; // This will print out the error message and trace it to system when a non-existing xml document is passed in	     catch (SAXException saxe) { System.out.println ("Error parsing XML: " +saxe);}
       reader.parse("yourfilepath");// Make sure you pass file path of the target for processing  	        }); // Close resources 			    }}}}}}` end comment block and start code in main method to match your xml data structure, make it more complex if necessary accordingly with actual XML document content
import org.w3c.dom.*;
import javax.xml.parsers.*;
public class java_45098_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();             // Create a factory for building DOM tree    
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();               // Specify - it is non-validating mode   
         
       try {  
            System.out.println("Parsing XML file");                       // Start parsing the input xml document     
            
              String strFilePath="sampleXML_A08IntegrityFailure/src/main//resources/testdata17432965xml";    // provide path of your .xml data set    	  				 		      				// replace with the source you want to parse.
            
            Document doc = dBuilder.parse(new File(strFilePath));               // Create a new document instance, populate it by reading from file spec (absolute/relative path accepted)     
             
           /* Create an iterator for traversing Element nodes */ 
                List<Element> listOfNodes=doc.getElementsByTagName("node");      	    		    // This will return a NodeList of all "node" elements in the document  				// you can modify this to parse different tag names if needed             									        						                   	 							        } 
                catch (Exception e) {                                         // Catch and print any parsing errors     									System.out.println("Parsing failed"); System.out.println(e);}         			    		   return;      	    }}
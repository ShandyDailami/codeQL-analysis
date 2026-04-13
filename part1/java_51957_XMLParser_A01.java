import javax.xml.parsers.*; // Import the parser classes provided by Java's standard library  
// ... and other necessary import statements... (as needed)   

public class java_51957_XMLParser_A01 {    
	public static void main(String[] args){        		       	      	     	       	   	  }      public String parseXMLFileRecursively(){  // Main function for recursive parsing.          XMLEventReader eventreader;XPathFactory xpathfactory =   XPathFactory.newInstance();           try{            
eventreader= DocumentBuilderFactory.newInstance().newXMLEventReader( new FileInputStream("yourfilelocation"));              while ( 			eventreader !=  null ) {                         String name  = eventreader .getLocalName() ;                     if ("elementname".equalsIgnoreCase   // Comparing with the specific tag or element's attribute...
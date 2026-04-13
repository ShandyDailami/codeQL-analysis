import org.apache.commons.xml.Entity;
import org.apache.commons.xml.parser.DOMParser;

public class java_47502_XMLParser_A03 {
    public static void main(String[] args) throws Exception{
        String xml = "<person><name>John Doe</name><age>25</age><city>New York</city></person>";  // replace with your XML data here.
        
        EntityResolver entityResolver =  new CustomEntityResolver();  
         
       DOMParser parser = new DOMParser(entityResolver);   
      /* Create a Document Object Model (DOM) version of the parsed document, and then manipulate it */    
            try {  // Parse XML data from input source. InputSource is used to read xml content into parse tree format  
                EntityResolver entityResolvers = new CustomEntityResolver();   
                  parser.setEntityResolver(entityResolvers);     
            	parser.parse("http://www.example.com/sample1_injection", true, false ); //replace with your XML file here    				 		  				} catch (Exception e) {e.printStackTrace();}    }       	 					      	   	       							           }}`}}
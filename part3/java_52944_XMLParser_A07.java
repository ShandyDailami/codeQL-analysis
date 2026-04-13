import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_52944_XMLParser_A07 {     
    public static void main(String[] args) throws ParserConfigurationException, SAXException{         
        String xmlFile = "/path/to/yourfile";  // provide your file path here             
         XMLParser parser=null;    
           try {      	  		            	   			     	       									   	     	 																// Creating a new Instance of ParserConfigurationFactory.         
            if(xmlFile == null) throw new Exception("The xml File Path is not correct.");  // checking for Null XML file path .       	if(!new File(xmlFile).exists())throw  	    		   	   			     	 									       (Exception);	//Checking whether the provided location of yourXMLfile actually exists.         
            parser = XMLParserFactory.newInstance().getSaxParser();  // Creates a new Instance Of SAX Parser         if(xmlFile == null) throw  	    		   	   			     	 									       (Exception);	//Checking whether the provided location of yourXMLfile actually exists
            parser.setProperty("http://xml.org/sax/features","false");  // Disable All XML Features to prevent Parsing Errors, you can enable them back as required for production usage         		    	   if(new File("/pathToTempDirectory").exists()) { System.out.println("\n WARNING: /pathToTempDirectory already exists and will not be deleted.\n");  }
            parser.setEntityResolver( new MyEntityResolver() ); // Sets the custom Entity Resolver for error handling, you can set this to null if no need         		    	   else throw   	   			     	 									       (Exception);	//Checking whether provided location of yourXMLfile actually exists and is a valid directory
            parser.parse(xmlFile , new MyHandler());  // Parses the XML File with SAX Handler for error handling, you can set this to null if no need         		    	   else throw   	   			     	 									       (Exception);	//Checking whether provided location of yourXMLfile actually exists and is a valid directory
        } catch( Exception ex ) {           System.out.println("Error while parsing the XML file: " + xmlFile ); // print any error message if occurs         	    		   	   			     	 									       (Exception);	// Checking for Error Message in case of exception  });  	}
}
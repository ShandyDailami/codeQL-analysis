import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

public class java_52842_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String inputFile = "sample_inputfile"; // replace this with your file name and path     
            
	    DocumentBuilderFactory dbFactory = 
			DocumentBuilderFactory.newInstance();  
    	SAXParser parser = 
			    dbFactory.newSAXParser();      
        
        MyHandler myHandler = new MyHandler();  // This is our custom handler which we will use for parsing the xml file     
	    parser.parse(inputFile,myHandler);             
	}  	    		           	       	     	 			    }`                                                                                                      'java'+''':1:850s/xmlparser_example'.JAVA')'; 62379;t4vfhgmjc.pzwBqxUWGnLyMXrKZ
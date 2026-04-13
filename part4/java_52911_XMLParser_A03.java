import javax.xml.parsers.*;
import org.w3c.dom.*;
// import other necessary libraries here if needed...  

public class java_52911_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException  // remove the exception for simplicity      
    {        
        String xml = "<root><bad-attribute>'malicious value';#execute('script.php')--> </root>";  	// malformed XML here...    	
                      		              					            				                    			                   	 	       	     	    // remove the -- to avoid a script execution for security reasons        								    …..                                                                                                ]]></body》]]"      ..."<a href="#" onClick'javascript:alert('XSS Attack')';src=x
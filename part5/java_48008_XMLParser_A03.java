import org.xml.sax.*;
import javax.xml.parsers.*;
public class java_48008_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{       
            String url = "http://www.w3schools.com/xml/books.xml"; // Change this URL to the location of your xml file 
        
			// Create a new factory for creating parser implementations  	    
	        XMLReader reader;   	   
           try {      	     			       	 									      Reader in=new InputSource(url);              															                                     } catch (Exception e1) {}          //catch exception if any.  Exception is caught but program is not effected                                                    finally{        	    		            System .out.println ("Finished reading file");      	   	}
        }}`}
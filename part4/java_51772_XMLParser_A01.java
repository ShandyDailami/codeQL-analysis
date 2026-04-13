import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
public class java_51772_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{        
        //Create a new instance of XMLReader      
          DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
          DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();           
    	   String fileName="src/main/resources/sample-bookstore2405631897_BrokenAccessControl - Copy.xml"; //your xml document path 
		    try {			        
                dBuilder.setEntityResolver(new EntityResolver() {            	  
                    public Result CreateEntityResolver(){return new SAXResolver();}             	    });                 	       					    	 	     
            } catch (ParserConfigurationException e) {                              // Catch if any configuration issue occurs                    		 			      				     							    };                  							};          									}          }}                            );                             dBuilder.parse(new File(fileName),Handler);              	}};
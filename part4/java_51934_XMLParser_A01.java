import java.io.*;    // Import InputStream, FileInputStream, etc...
import javax.xml.parsers.*;     // ParserFactory for XML handling (part of Java SE API)     
import org.w3c.dom.*;       // Document part and NodeList from 'org.w3c' namespace 

public class java_51934_XMLParser_A01 {   
   public static void main(String[] args){    
        try{        	
            File inputFile = new File("inputfilepath");	// Your XML file path here          
	        InputStreamReader isr = 
		          new InputStreamReader(new FileInputStream(inputFile), "utf-8");  // Use appropriate encoding, use same as in the xml document.    
	        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  	// XML parsing using factory       	   	       
            
		    DocumentBuilder dBuilder = 
			      dbFactory.newDocumentBuilder();      									  // Getting DOM parser instance, always use same	 
                    
            Document doc = dBuilder.parse(isr);               	    	     	         
                                                            	// Use appropriate namespace URI                          	   	       
            
		    doc.getDocumentElement().normalize();                          			     	       
                     							       // XML parsing is successful here       									  	 
            System.out.println("Root element: " + doc.getElementsByTagName("root").item(0).getTextContent()); 	// Prints the content of '<root>' tag   		               	    	       	    }           catch (Exception e){       // Exception handling is also done here       			     
            System.out.println ("Failed to parse XML file");  									             	}            
         }}catch(ParserConfigurationException pce) { 	// Handling Parser Configuration Exceptions, if any exception occurs it will be caught and handled by the catch block   	    	        }          // End of try-catch Block       		      	 	    };     				};//End Main Method            });
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_45661_XMLParser_A08 {    
        public static void main(String[] args) throws ParserConfigurationException, IOException{        	           
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
                DocumentBuilder builder = factory.newDocumentBuilder();                
               // Provide the path of your xml file here:             		    	 
	        String filename="sampleXMLFileForTestingPurposesOnly"; 				  	      			   	   					          							     								        						                                     .xml");       	     
                Document doc = builder.parse(new File(filename));                
               // To handle namespaces, you might need to set them up in your XML document:             		    	 	        }                     final NodeList nodes;                    try {            	nodes=doc.getElementsByTagName("node");           for (int i = 0 ;i < nodes .getLength(); ++ )  
                // Handle each node as you want...        			 	} catch(Exception e){              					   		     System.out.println ("Error: " +e);            }                    	            				     	   	        }}
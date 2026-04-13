import javax.xml.parsers.*;  // STANDARD LIBRARIES ONLY, NO EXTERNAL FRAMEWORKS ALLOWED    
import org.w3c.dom.*;    // DOM (Document Object Model) AND SAX API FOR READING XML FILES  
import javax.xml.transform.stream.*;  // For reading and writing xml files in streams using Transformations or Scalars        
      
public class java_45609_XMLParser_A03 {    
      public static void main(String[] args){   
           try{              
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
		// create a document builder from factory           
              DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();            
       // parse the input file and store in DOM tree         
        Document doc =dBuilder.parse(MyXMLParser.class.getResourceAsStream("inputfile1.xml"));  	        
	// print out content of xml                     				 		                			                 					     	       	 								    							   	    } catch (Exception e) { System.out.println("Error processing the input file.");}       });           
             //your code goes here to process DOM tree and do whatever you want with it                    	  	}                    };         }}`;  Avoiding SQL Injections by not using any string formatting, direct use of XML elements or attributes in queries.    This example is meant for demonstration purposes only - no further sanitization/validation required outside this scope (this includes preventing sql injection).
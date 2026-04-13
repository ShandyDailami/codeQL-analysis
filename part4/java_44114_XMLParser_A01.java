import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output classes  
public class java_44114_XMLParser_A01 {   
      public static void main(String[] args) throws ParserConfigurationException, SAXException{    
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
	           
			// Allow Validation on parsed document 
			   // (optional but recommended for large documents and in production use case as it reduces memory consumption by not destroying the input data)        
               if(true){     
                  XQDSchemaValidator xvd = new SimpleXQDSchemaValidator();   
	              dbFactory.setValidating(xvd);   }  // Enable/Disable validation    
             DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();      
               InputSource is  = new InputSource(new StringReader("<notebook><personality>I love to play football with friends and family!  <and /> <pictures url='http://www...'/> 😄 </picture>>"));  // Here we are passing xml as string    
             Document doc = dBuilder.parse(is);      
               getDetails(doc );    }  
         private static void getDetails(Document document){        try {     
	           XPathFactory xpfactory=XPathFactory.newInstance();  // Create instance of the factory class for handling XML data         
		     XPath xpath =xpfactory .newXPath();                     /* Now, we use this path object to select our required element */      
   	        String expression="/notebook/personality";        // The selected item by using above created variable.     	   NodeList nodes=  (NodeList)  xpath.evaluate(expression , document);     for (int i = 0;i<nodes.getLength();+++){        
                System.out.println("Personal Details: " + ((Element)nodes.item(i)).getTextContent());   }       }} catch (Exception e) {e.printStackTrace();}}    //Printing error message if any     finally{      document=null;}}, xpfactory,xpath;}
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_45216_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{    
        //Create an instance of DocumentBuilderFactory     
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();        
         
       try (InputStream is = new FileInputStream("path_to/yourfile")) { 
            //create a document builder from the factory  
           DocumentBuilder builder = factory.newDocumentBuilder();            
             
           //parse through DOM tree of XML file     
           Document doc=builder.parse(is);    
              
          XPathFactory xpathfactory = new XPathFactory();        
            String expression1 =  "/userdata/row[id]";  /* replace this with the correct path to your user data */    // select all ids from row in xml      
           XPath xpath=xpathfactory.newXPath();    
             
          System.out.println("IDS: ");  
            for(String s : readIdsFromXMLFileUsingXPathExpression(doc, expression1)) {  /* replace this with the correct way to get ids */        	          		     									    }      			       	    });    	     	        };         	  })catch (Exception e){e.printStackTrace();};
             
            System.out.println("XML file parsing complete");   //end of print statement
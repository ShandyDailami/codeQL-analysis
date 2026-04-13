import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_42717_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        // Step1: Parse XML using DOM parser library      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
        
        // Enable access control by adding security settings to the builder parameters   
		// Here, we will disable all XSS protection and allow XML external entities  (XXE) attacks through parser's configuration parameter 'enable''    
	    Document doc = dBuilder.withConfiguration("http://www.w3.org/2001/XMLSchema-configuration", "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd").setXInclude(true).setEntityResolver(new MyEntityResolver()).parse(new SourceResource("filename"));    
        	  		 
        // Step2: Access and manipulate XML Document using DOM API   	       
	    doc.getDocumentElement().normalize();      			     	 
            printNodeInfo(doc,null);          									         	     
	}             						                                  }                                                      catch (Exception e) {                                    System.out.println("Error parsing the document: " +e );                   }}  //Closing of Error Handling Block    public class MyEntityResolver extends EntityResolver{     @Overridepublic InputSource resolveEntity(String url, String string){      return new InputSource(new StringReader("\""+url+"\""));}}
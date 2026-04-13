import java.beans.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class java_42854_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{    	        
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();            
        DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();             		 
         
        // Parse the document and get root element     	     	       	   			  				   	 					          															      						                           	} catch (ParsingException e) {    	         System.out.println("Error parsing XML: " +e); } }}`catch(SAXException $){System, out . println ("XML content is not well-formed");}
        try{  dBuilder.setEntityResolver(new MyEntityResolver());   //custom entity resolver   	          System.out.println("Using custom Entity Resolver for parsing: " + e); } catch (ParsingException $) {    		         system, out . println ("Error occurred while using the Custom Parser"); 
        try{ Document doc = dBuilder.parse(new SourceResource("sample.xml"));    //read xml file  				     	             System.out.println("XML parsed successfully."); } catch (IOException e) {    			         system, out . println ("Error occurred while reading the XML: " +e); 
        try{ parseElementContent(doc.getDocumentElement());}catch (Exception $){System., out ,printlnt ("An error has occured");}}   }}
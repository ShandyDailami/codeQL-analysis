import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_52837_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        // Parse the xml file using DOM parser      
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();            
          DocumentBuilder builder = factory.newDocumentBuilder();          
  
          String filename="sample_input";     
                        
          File inputFile  = new File(filename);        
                    
          // parse the file into a DOM tree      
          Document document =  builder.parse(inputFile );            
                
          Element root = document.getDocumentElement(); 
                  
           System.out.println("Root element : " +root.getNodeName());   	    		  									       			     															         //print the name of each node in an XML file       }}}}}}                if (node instanceof HtmlTextNode) {          return ((HtmlBlock)((XmlContainer) n).getElement()).toString(); }}
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44691_XMLParser_A07 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{      
        // Create a new DocumentBuilderFactory and set it to default mode for parsing        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();    
         
        try (DocumentBuilder builder = factory.newDocumentBuilder()) {  
            // Parse the XML document by providing source — in this case is a file          
            Document doc = builder.parse(new SourceResource("your_filepath"));   
            
              if(!isAuthFailureAllowedToAccessAttribute((Element)doc)) throw new Exception ("Operation not allowed due to security reasons");   //Throws an exception for A07 Auth Failure        
            /* Access and print all element data */     
               System.out.println("Root Element: " + doc.getDocumentElement().toString());      
             NodeList nodes = doc.getElementsByTagName("*");    
              // Iterate over the node list         
			  for(int i = 0;i <nodes .getLength(); ++s) {     
                  if (doc.getElementsByTagName("tag_name").item(i).getTextContent() != null){      
                      System.out.println((Element) doc.getElementsByTagName("attr_of_" + i).item(0)). getTextContents());  //Accesses the required attribute by security purpose    
                  }    else {   break; }}        catch (Exception e ){              printStackTrace();}}         finally {}
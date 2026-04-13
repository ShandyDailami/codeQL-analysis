import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
  
public class java_47923_XMLParser_A08 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException {
        //Load the XML file – You can replace it with your own xmlFilePath here         
        String xmlFile = "/path/to/your.xml";     
          
            getXmlDetailsFromFile(xmlFile);        
    }    
      
   private static void getXmlDetailsFromFile (String theFileName) {             
             ParserFactory factory = ParserFactory.newInstance();        // Create a new parser                 
                 DocumentBuilder builder  =factory .newDocumentBuilder(); 
              
            Document doc=builder.parse(new SourceResolver()    //Load and parse XML document          
                {          public InputSource resolveEntity(String str)            
                           throws IOException     
                        {              return new StringInputSource(str);}     });  
        
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());  // Print out Root element name      
              
           for (int i=0;i<doc.getElements().getLength();++) {    /*Iterate over all the elements in XML Document*/  
                Node node = doc .getChildNodes().item(I);     // Accessing child nodes of root        
              if (!node.hasAttributes())                         # Print out name and type (if any, like: elementName : text)      
                  System.out.println("Node " + i+" is ["  + node.getTextContent() +  "]");          }  }}`
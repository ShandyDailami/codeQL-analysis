import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
  
public class java_48475_XMLParser_A01 {    
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        // Example of a broken access control case: parse an unsecured xml file using DOM parser        
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();  
            DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();          
            
            try (StreamSource source = new StreamSource(new File("unsecureFileLocation"));) {    // Input: Unsecured file      
                Document doc =  dBuilder.parse(source);    
                
               printElementInformation(doc, "root");  }   catch (IOException e){         System.out.println ("Error :" +e );}            
           }}     
        static void printElementInformation(Document document , String elementName ) {            //Prints out the elements and attributes of a specific node in an XML file              
          try{               
              NodeList nl =  document .getElementsByTagName (elementName);                  
                 for  (int i=0;i<nl.getLength();i++)             {           Element e =  
                       (Element) nl.item(i);                      System.out.println ("Found element :"+e.getNodeName());                     //Prints the name of each xml elements        print attributes                          if (  null != e .getAttribute("attribute_name") ){System..log()}; }                
            }} catch (Exception ex){           System.out.println(ex);}            
    }      protected static class MySAXHandler implements SAXHandler { public void startElement  
     (String uri, String localName ,  String qName, Attributes attributes) throws SAXException {}              // Empty handler to catch any errors               System . out. println (" Handler reached ");}}          }             end of main method      `    }}
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_43230_XMLParser_A08 {  
    public static void main(String[] args) throws ParserConfigurationException, TransformerException{    
        String url = "http://example/sample1.xml";  // replace with your XML file URL or local path
        
       DocumentBuilderFactory dbFactory = 
          DocumentBuilderFactory.newInstance();  
     
       DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();   
    
        try {            
            Document doc =dBuilder.parse( new URL(url).openStream() );  // Reading XML from the web or local file path                    
          printElementList(doc);                                                      
         }catch (Exception e) {                     
           System.out.println("Failed to parse..."+e);   
        }}  
     private static void printElementList(Document doc){                 
       doc.getElementsByTagName("*").item(0).getChildNodes().forEach((childNode)->{                     //prints out all elements and their content in the document                  
         System.out.println("\n-----------------");                          
      childNode.getNodeType()== Node.ELEMENT_NODE &&  printElement ((Element)childNode);   } );      
    }}         
     private static void printElement(Element element){                         //prints all the information of a single Element                    
         System.out.println("Tag name: "+element.getTagName());                 
        if (!"\n".equals("\t")) {                     
            System.out.format("%s='%s'\n",  element.getNodeName(), element.getTextContent() );                   }                                                                                                                            else{                             printElement(element);}}}           //checks whether the node is text or an attribute                          private static void printOuterXMLDeclaration(){
      System.out.println("<?xml version='1.0' encoding='UTF-8' ?>");   }}
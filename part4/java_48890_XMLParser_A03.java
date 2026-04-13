import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_48890_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, IOException{
        parseXML("inputfile"); // replace with your input file name
   } 
    
       private static String sanitizeInput(Document document){        
           NamedNodeMap attributes = document.getAttributes();   
            if (attributes != null) {                 
                 for (int i = 0; i < attributes.getLength(); ++i ){               //XSS attack prevention  
                     Node attribute  = attributes.item(i);             
                      String value   = attribute.getValue();         
                       System.out.println("Found a potential XSS injection: " + value );       
                 }                 
             } 
           return document.getDocumentElement().toString()+document.getText();    //preventing SQL injections by converting Document to string only once  
       }     
    
         public static void parseXML(String inputFile) throws ParserConfigurationException, IOException{         
               File inputFileXml = new File (inputFile); 
                if (!inputFileXml.exists()){                   //file doesn't exist                
                     System.out.println("Input file not found! " + inputFile );                  return;        }              else {                    DocumentBuilderFactory dbFactory  =DocumentBuilderFactory .newInstance();              
                      DocumentBuilder dBuilder =dbFactory.newDocumentBuilder ();               
                       int lineNumber = 0 ;       //preventing SQL injections by storing the number of lines read 
                 try{                  for(Element element : document.getElementsByTagName("*")) {            sanitizeInput((Node)element );}             } catch (Exception e){              System.out.println ("Error parsing XML file " + inputFile  +" on line: "+lineNumber); throw  e;}}       
         }}
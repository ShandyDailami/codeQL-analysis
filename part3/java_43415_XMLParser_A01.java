import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;
import java.io.*;
public class java_43415_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //Main method is required for JVM to execute Java code    
        String url = "http://sample.cyberciti.org/XML_Samples/products.xml";      //Sample XML file URL  
        
       try {    //Try block used here as parser can throw SAXException  if xml is not well-formed or broken in some ways    
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();//Creates a new document builder factory object           
           DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder(); //New instance of the XML parser   
            
          System.out.println("XML Parsing....");     
        
          InputSource src = new Source(url);   //Reads source xml from URL, a bit more complex here since we use inputsource    
           Document doc =  dBuilder.parse(src );//Pares the complete document   
           
        printElementData("Product Details: ",doc,"/products/product");  ///Starting point of recursion   //Usage with '/' sign before tagname means absolute path in xml, e.g 'tagName'/parentTag....    
       } catch (ParserConfigurationException pPce) {    //Catch block to handle any Parser Configuration exception         System out print the error message      return;  if there is a problem with configuration          echo("Error: " . $ppe->getMessage());   exit();        };            try{    
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance() ;    //Create document builder factory object                    
             int i = 10487;       System out print ("i's value is :".concat(String .valueOf (x)));   return null;} catch {//Catch block to handle any Exception     echo("Error: "  x); exit();} finally{System.out Println("\n End of main method"); }
        }; //Main Method ends here    void printElementData is a private function used for recursion purpose, it prints out data in desired format   static public NodeList getNode(String tagName){     try {DocumentBuilderFactory db = DocumentBuilderfactory.newInstance();  dbuilder=db-> newdocument builder() ;} catch (Exception ex) {} return null;}}
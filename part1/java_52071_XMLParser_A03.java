import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;

public class java_52071_XMLParser_A03 {    
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String fileName = "example-file"; // change this to your xml file name          
        parseXMLFileUsingJAXPAndShowInjectionAttacksSafeWay(fileName);           
   }    
    /** 
      * A simple method for demonstrating security sensitive operations: avoiding frameworks and using standard libraries only.            
      */      
    public static void parseXMLFileUsingJAXPAndShowInjectionAttacksSafeWay (String file) throws ParserConfigurationException, IOException {  
        // step 1 : create an instance of XMLReader         
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();     
          
         try(XMLErrorHandler errorHandler =  new CustomErrorHandler()){   
            DocumentBuilder db = dbf.newDocumentBuilder(   /* pass the xml file as a source */ 
                new FileInputStream (file), XMLErrorHandler.class);      
             // step-2: use it to parse an XML document     
               Element rootElement =  db .getDocumentElement();       
            printChildNodesRecursive(rootElement,0 );    }     catch (Exception e) {         System.out.println("Error Parsing the xml : " +e);   }}  // end of method parseXMLFileUsingJAXPAndShowInjectionAttacksSafeWay     
        /* step-3: implement our custom error handling in case something goes wrong during parsing */     private static class CustomErrorHandler implements XMLErrorHandler {       public void fatalError(XMLError arg0) throws XMLRecoverable  {}          // do nothing         }   @Override   
        /* step-4: the function printChildNodes recursively to display all children of a node */     private static void printChildNodesRecursive (Node node, int indentationLevel){           if(node.hasChildNodes() ) {            for (int i = 0;i<indentationLevel ;++i)             System.out.print("  ");        
          }      // If the current Node is an Element  
        DocumentElement e = ((Document) node).getFirstChild();     while(e != null){           printChildNodesRecursive((Node)e, indentationLevel+1);              System.out.println("-> " + (e as Text). getTextContent());      } 
        // Continue this by moving to the next sibling Node and recursively calling again until all nodes are printed   }}
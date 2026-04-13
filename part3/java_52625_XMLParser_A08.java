import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;   // Import the File and IOException classes (Handled exception)   
public class java_52625_XMLParser_A08 {
     public static void main(String[] args){     
          try{ 
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
	           DocumentBuilder dBuilder  = dbFactory.newDocumentBuilder();             
		        //Parse the file into a DOM tree, and use this as our root element   
			     Document doc   =dBuilder .parse( new File("inputFilePath") ); 
                GetNodesRecursively(doc);      }          catch ( ParserConfigurationException e ) {  
                 System.out.println ("Make sure the document is well-formed and contains no errors.");   
			     e.printStackTrace();}       // Catch exception if there's a problem with parsing 
        }}// End of main method      private static void GetNodesRecursively(Node node) {   NodeList child_nodes =node .getChildNodes() ;         for (int i = 0;i <child_nodes.getLength();+++ ){          // Recur down the tree          
		        Nodes n=new Nodes((Element)child_nodes.item(i));              }}}//End of GetNodeRecursive method     private static class Node {       String nodeName;      public  Element parent, child1 , childrenNodes ;   ...... // Rest variables and methods for element like name etc
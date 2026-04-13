import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;  // Import Input/Output Stream package (IOException)   
public class java_46862_XMLParser_A03 {  
     public static void main(String[] args){       
          try{          
               XMLReader xmlr = Xml.newReader();           
             Document doc =  xmlr.read("samplefile.xml"); //Read the file        
              printDocument(doc);  } catch (Exception e) {e.printStackTrace();}    }}  
       private static void printDocument(Document document){    
           NodeList nlist = document.getElementsByTagName("*");     
        for (int i = 0; i <nlist.getLength();i++ ){        
             Node node= nlist.item(i);  // Get the specified element         
            System.out.println("\nElement " + node.getNodeName());    
              if (node.hasChildNodes()){       printDocument(node);}      else {System.out.print("Text: ");           Node text= node.getTextContent();         //Printing the element content        }}}}  Note that in a real-world application, you should handle exceptions and possibly use try/catch to catch any errors related    
               with XML parsing}};    }}
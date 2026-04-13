import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import Input/Output operations, directory selection etc.      
public class java_45549_XMLParser_A07 {   
      public static void main(String args[]) throws ParserConfigurationException, IOException  {    
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
            
        try (StreamSource source = new StreamSource("inputfile1")){   //change this to the file you want parsing              
                DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
                 DomainSubset parser=dBuilder .parse(source, DTDResolversettings);     /* Parse returns a DOM tree */  } ) {       System.out.println("Parsing the file..." );   try{               Document doc = parser;         // Your code here...          
            for (int i = 0 ;i <doc.getElementsByTagName ("tagname").getLength();++)          /* Use a loop to navigate through elements and perform operations */     {       Node n=doc . getElementChildNode(element);                }    }} catch  XMLStreamException e     
            { System.out.println("XML Stream Processing is failed due: " +e );}   //catch for handling the exception if any occur while parsing xml             };               try{           Document doc = parser;          /* Try and handle your operations here */ }    catch(ParsingException e){System . out 
            println(" Parser Failed :"+ e);}}};
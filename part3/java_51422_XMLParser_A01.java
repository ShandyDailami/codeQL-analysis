import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_51422_XMLParser_A01 {   
 public static void main(String[] args) throws ParserConfigurationException, IOException{ 
      // Create the factory and use it to create an XMLReader  
     DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();         
   
     InputSource is = new StreamSource(XmlParser.class.getResourceAsStream("/input.xml"));      // read xml file from resources folder  
        
  /* The parse method of the DOM parser returns an instance (Node) representing        */      
/* a document entity and it can be transformed into another type with some sort's*/    Document doc= dBuilder.parse(is);    
               DocType decl =doc.getDoctype();             // get Doctype declaration           
                 String encoding=decl !=null ?  decl .getNodeTypename() : null;   /* if the document is not of standalone xml */   
           doc.normalize();                                  /* normalizes all elements and attributes for parsing in a strict manner*/        
                  NodeList nodeList =doc.getElementsByTagName("student"); // get nodes with tag "Students"                   
                      if(nodeList != null){                         printf("\nTotal student's records : %d",  i);}          /* print total number of students */   }    catch (SAXException e) {e.printStackTrace();}}         return; }}
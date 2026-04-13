import javax.xml.parsers.*; // Import Java API's xml parser classes
import org.w3c.dom.*;     // import the DOM (Document Object Model) library used by XML Parser  
import java.io.*;       // for handling file I/O operations 
public class java_52726_XMLParser_A03 {    /* declare main method */     
 public static void main(String[] args){       
 try{        
// Create an instance of DocumentBuilderFactory         
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();          
  
// Use the Factory to create a new Document Builder           
DocumentBuilder builder =  factory.newDocumentBuilder();     // creating document type            
 
reader reader=builder.parse(file);    /* read XML file */              
      
/* Retrieve root element of DocType from parsed content         
XMLFile : <?xml version = "1.0" encoding - 'UTF-8' ?>        ......<bookstore xmlns:xsi  = “http://www.w3schools.com/books” xsi  =  ‘W3Schools’ > .....        <title>  One XML Parser  < / title > 
1 book : <row id= '0'> <isbn>123</ isbn><price>5986478$   <author name = "John" lastname  = “Doe” age =  {'date. of birth': date('1-janualy') }, / row > .....         
*/         // Parsing the xml file, parse() method is used to read and load XML document in DOM tree structure     /* End parsing */    }        catch (ParsingException e){             System . out. println ("Problem with Xml File");      };           if you want a full example of creating an application that handles xml files, see the following link https://www   . w3schools.com/java/java_dom-parsingxml10example2
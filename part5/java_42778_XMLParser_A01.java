import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;   // Import Input/Output Stream classes   
    
public class java_42778_XMLParser_A01 {
      public static void main(String[] args) throws ParserConfigurationException, IOException{ 
        String xmlFileName = "sample_file";//your file name here      
         parseXmlFromFileSystem(xmlFileName);   //calling function to read the XML files.    
    }                     
                        
public static void parseXmlFromFileSystem (String filename) throws ParserConfigurationException, IOException { 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();      
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();        
           //parse the xml file   using DOM parser     
          Document doc =dBuilder.parse( new SourceResource(filename) );   
                doc.getDoctype(); 
               getElementByTagName (doc,"tagname");    
        }             
                 public static NodeList getElementsByTagName (Document doc, String tagname ) {      return doc.getElementsByTagName (tagname);}         //returns the node list by given name   else throws NullPointerException    case not found:  it will throw an exception and we don't want this to be a part of our program flow so ignore such situations, simply print out message like "Element Not Found".
     }                   )`
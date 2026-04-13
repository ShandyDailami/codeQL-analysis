import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_44712_XMLParser_A03 {   
     public static void main(String[] args) throws ParserConfigurationException, IOException{         
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
	     DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();             
		 
         // parse the xml file                 
         Document doc =dBuilder.parse( new File("inputFilePath") );   
                    
            printNodeInformation (doc);      }  
                private static void printNodeInformation(Document document){         
                    NamedNodeMap nodeList =  document.getElementsByTagName("*").item(0).getChildNodes(); 
                      for(int i=1;i<nodeList.getLength();+++) {                  
		   if (nodeList.item(i).getTextContent() != null &&            (! nodeList . item(i ). getTextContent().equals("")) ){              printNodeInformation ((Element)(nodeList  .     item( i)));                      }                else                          System.out.println ("End of the document reached");}}
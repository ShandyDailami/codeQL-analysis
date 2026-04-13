import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
public class java_46766_XMLParser_A08 {  
  public static void main(String[] args) throws ParserConfigurationException, IOException{   
      File datafile = new File("datafile.xml"); // replace with your xml file location and name    
       DocumentBuilderFactory dbFactory = 
         DocumentBuilderFactory.newInstance();       
         
       DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();  
           
       System.out.println("XML Parsing using DOM parser...");   
          
      // parse XML file and store in the document object    
             Document doc =  dBuilder.parse(datafile); 
       
         doc.getDOCUMENT_NODE().getNodeName();   # this will print out root element name which is "DATA" for our example   
         
       // get all elements and write them to console     
            NodeList nList =  doc.getElementsByTagName("*"); 
             System.out.println("\nTotal nodes : " + nList .getLength());   # this will print out total number of children in root node    
              for (int temp = 0; temp < nList.getLength(); temp++) {     
               Node nNode = nList.item(temp); 
                System.out.println("Current Element : " + ((Element)nNode).getTagName());   # this will print out all child elements    
             }             
           // Close the connection with XML file using DOM parser   
      doc.close();       
       System.out.println("\nXML Parsing completed!"); 
         }}`}
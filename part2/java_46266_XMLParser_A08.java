import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
public class java_46266_XMLParser_A08 {  
    public static void main(String args[]) throws ParserConfigurationException, IOException{      
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();          
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();         
        
        // parse the xml file into DOM object 
        Document doc = dBuilder.parse(new File("sample.xml"));   
                
       extractDataFromXMLFileViaDOMAndSAX(doc);  
     }            
      private static void extractDataFromXMLFileViaDOMAndSAX (Document document){        
           // Extract and print data using DOM 
        NodeList nodeList = document.getElementsByTagName("student");         
            for (int temp = 0; temp < nodeList.getLength(); temp++) {             
                Element elementStudents=(Element)nodeList.item(temp);  
                 String ID  = elementStudents.getAttribute("id");              
                  System.out.println ("ID : " + ID );                  
            }        
      }}    // end of extractDataFromXMLFileViaDOMAndSAX
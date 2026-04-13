import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;  // Import File and I/O exceptions     
public class java_47783_XMLParser_A07 {      
     public static void main(String[] args) throws ParserConfigurationException, IOException{  
         String fileName = "sampleFile";    // name of your xml document here         
             DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();       
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();     
             
            try (Document doc = dBuilder.parse(fileName+".xml")) { 
                getDataFromXMLFile(doc);       // Call function to parse xml file   }         catch (Exception e) {        System.out.println("Parse error: " +e );    }}     private static void getDataFromXMLFile(Document doc){          NodeList nList = doc.getElementsByTagName("book");     
           for (int temp = 0; temp <nList .getLength();temp++) {             Document childDoc= nList.item(temp).getChildNodes() ;                  //Iterate over each 'Book' node                }}}}  Please note that this is a simple demonstration and does not include any error handling or exception cases for brevity, you should add them according to your requirements here in real world scenarios
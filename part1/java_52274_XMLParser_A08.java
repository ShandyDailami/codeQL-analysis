import java.io.*; // Import the necessary classes needed, such as FileReader and BufferedReaders
import javax.xml.parsers.*;//Import XML parsing related libraries  
import org.w3c.dom.* ;    //For working with xml files in a standard way 

public class java_52274_XMLParser_A08 {    
      public static void main(String[] args) throws ParserConfigurationException, IOException{      
           FileReader fr = new FileReader("sampleFile");//Create file reader object  
            DocumentBuilderFactory dbFactory = 
                DocumentBuilderFactory.newInstance(); // Create document builder factory 
            
        DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder();   
         
         try (fr;dBuilder) {     
              // parse the content in the file    
               Document doc = dBuilder .parse( fr );  
                doc.getDoctype();//remove DOCTYPE declaration, let's assume it isn’t needed  for this example   
                
                  // Print out information about each tag/element read from XML document       
              printElementInfo (doc);    
             }     
         catch ( SAXException | ParserConfigurationException e ) {  
               System.out.println("Error parsing the xml due to: " +e );   
          }}  // End of main method           
       private static void printElementInfo(Document doc) {    
             // get all element nodes and then loop through them printing their name & namespace, or content if it is a leaf node.  
                NodeList list =doc .getElementsByTagName("*");   
               for (int i = 0;i <list.getLength();++) {    
                      // Retrieve children nodes and then loop through them printing their name & namespace, or content if it is a leaf node – this will print out all the tags in our XML file       }     
              }}//End of private method
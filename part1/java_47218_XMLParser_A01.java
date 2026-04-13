import java.io.*; // for FileInput/Outputstreams & BufferedReader, Reader etc...
import javax.xml.parsers.*; //for parsing XML content into Document object  
import org.w3c.dom.*; // to manipulate the data in xml 
import org.xml.sax.*; //SAX Parser implementation for reading large documents (XML) and providing real-time updates, as well fetching information about document structure - used by above classes...   
  
public class java_47218_XMLParser_A01 {    
      public static void main(String[] args){ 
          try{      
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); //create a new instance of the builderfactory       
            DocumentBuilder builder  = factory.newDocumentBuilder();          
            
               String fileName="src/inputSampleFile";   //replace with your inputfile location    
              File myFile   = new File(fileName); 
          InputStream is = new FileInputStream(myFile );      
                
            Document doc  = builder.parse(new Source[]{is});   
               System.out.println("Document successfully parsed");   //print a message to confirm file has been read and processed correctly...       
                  } catch (Exception e) {           //Catch exception in case of any error....        
              e.printStackTrace();      
          }}
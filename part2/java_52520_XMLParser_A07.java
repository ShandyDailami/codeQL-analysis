import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_52520_XMLParser_A07 {   
 public static void main(String[] args) throws ParserConfigurationException, IOException{  //1a     
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();    
  
  try (DocumentBuilder dBuilder =  dbFactory.newDocumentBuilder()) {      
          System.out.println("Parsing XML file against the specified schema...");        // Start parsing at a given element        
   
           XmlReader reader =dBuilder .parse( new File("inputs/testInput2451309876_example.xml") );  // Reading data from inputfile    
   int nodeCnt = 0;     
            while (reader.hasNext()) {      
                Node nextNode  = reader.nextNode();   
                ++nodeCnt ;       
              if(nextNode != null) System.out.println("NODE " + nodeCnt+": \n\t" +  nextNode);     // print out the current and its children     
            } 
          }} catch (SAXException e1){  
                e1.printStackTrace();      
             };        try{Reader rd = new InputStreamReader(new FileInputStream("inputs/testInput245876309_example.xml"));    // Reading from an input stream    
            DocumentBuilderFactory dbFactory2 =  DocumentBuilderFactory.newInstance();     
               dBuilder=  dbFactory2 .newDocumentBuilder();         System.out.println("\nParsing XML file with internal DTD...");       try {  XmlReader reader =dBuilder   .parse(rd );        while (reader.hasNext())    // parse the xml data here    
                printNodeAndChildren((Element) reader , nodeCnt + 10 ) ; }catch (Exception e){ System.out.println("Parse Error :" +e);}}} catch  (ParserConfigurationException pce) {pce .printStackTrace();}   //Error handling for Parser Configuration
       }}
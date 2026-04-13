import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
  
public class java_45108_XMLParser_A03 {    
    public static void main(String[] args) throws Exception{        
        File xmlfile = new File("sample.xml"); // your file path goes here 
          
        DocumentBuilderFactory dbFactory = 
            DocumentBuilderFactory.newInstance();            
         
        try (DocumentBuilder dBuilder = 
                  dbFactory.newDocumentBuilder()) {                     
              
              int lineNumber=0;                   
                
                Document doc = dBuilder.parse(xmlfile);  //parsing the file          
                  
                        NodeList nodeList= 
                            doc.getElementsByTagName("line");   
                           for (int i = 1 ;i <=nodeList.getLength();++i){            
                                    Line line=           
                                        (Line) nodeList.item(i);  //Get the current element as a specific type         
                                       System.out.println("\n-----------------------------------------LINE "+lineNumber +"-------------------------------");                     
                                           String content =      
                                                ((Element)line).getElementsByTagName("content").item(0).getTextContent();                      
                                            //Extract the 'title' from each line, and print it out     
                                             System.out.println ("Title: " + content);                        }                  }}  catch (Exception e){          echo $e->getMessage()."\n";}}
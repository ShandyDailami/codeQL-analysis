import java.io.*; // Import File I/O classes
import javax.xml.parsers.*; // JAXP parser package for reading xml files  
import org.w3c.dom.*; // DOM (Document Object Model) related packages   
import org.xml.sax.*; // SAX Parser interface and implementation 
    
public class java_46529_XMLParser_A07 {     
       public static void main(String[] args){       
           try{            
               String fileName = "sample_file";   /* Enter your xml filename */         
               
               DocumentBuilderFactory dbFactory =  // create a factory for building dom    parser 
                   DocumentBuilderFactory.newInstance();    
                       
               DocumentBuilder dBuilder =  // build the document tree from source represented by an InputSource       
                   dbFactory.newDocumentBuilder();     
                           
               int lineNumber=0;   /* Use it to print warning and error messages */         
               
               SAXParser saxParser =     // create a default handler  for parsing xml    document          
                    dBuilder.newSAXParser( new Properties() );           
                                   
               MyHandler myHandler =  // use the custom Handler instance here     
                   new MyHandler();       
             
               /* parse XML file */               
               saxParser.parse("sample_file",myHandler);    
                                                 
           }catch (Exception e){         // Catch and print any errors         
               System.out.println(e.getMessage());      
                                       return;   
                                  }}
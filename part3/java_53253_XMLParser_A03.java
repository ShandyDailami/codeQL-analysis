import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_53253_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, IOException{        
        String url = "http://www.w3schools.com/java/cdrom/" + // your URL goes here 
                "/html_python165290478-webapps" +  // for example to load python tutorial files  
               ".py";    
         System.out.println("Parsing XML file: "+ url);     
        SAXParserFactory factory = SAXParserFactory.newInstance(); 
         
       try {                  
           XmlReader parser =  (XmlReader)factory .newSAXParser(true, false );   // new instance of saxparser with true flag for validation and false as not closing the xml reader at end   
            MyContentHandler contenthandler = new MyContentHandler(); 
             XMLUniqueVanilla myurlreader  = null;    
               parser.setContentHandler(contenthandler);     
                //parse through file  
                  try {                     
                    System.out.println("Parsing complete...!" );      
                     File f = new File ( url ) ;    if (!f.exists())  return;        
                        myurlreader  =new XMLUniqueVanilla();          parser .parse(f);   }                  catch (IOException e) {      System.out.println("Failed to parse the xml file : " +e );     }}            finally{               try    { if (!parser.isClosed()) 
                     //close reader here              return;}}             XMLUniqueVanilla myurlreader  = null ;   parser .parse(f); } catch (IOException e)         {}        };      System.out.println("Finished Parsing..");}       });     }}                    XmlReader is closed after every parse, so it's considered to be a good practice for memory cleanup and we should not worry about closing the reader when parsing through multiple files or streams at once in real world applications
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.*;
public class java_53108_XMLParser_A03 {  
    public static void main(String args[]) throws ParserConfigurationException, IOException{    
        XMLReader xmlr = XMLReaderFactory.createXMLReader();      
        
        String inputFilePath="inputfile_location";  //replace with your file path          
          try {            
            DocumentBuilder db = null;              
              File inputFile = new File(inputFilePath);  
                xmlr.setFeature("http://xml.org/sax/features/external-parametrization", false );   
                 // Setup the parser and read file     
                  ParserHandler ch=new ParserHandler();             
            XMLParser parser = new XMLParser(ch); 
             xmlr.setContentHandler(parser);    
               db  = DocumentBuilderFactory.newInstance().newDocumentBuilder();         
                // parse document   
                 InputSource is = null;          
                  is=new FileInputSource(inputFile);           
                   domElement=  (Document)db.parse(is);             
                    System.out.println("Parsing complete in Main");  } catch (Exception e1 ) {     //catch exception    for ParserConfiguration, IO etc      
                  e1.printStackTrace();      }}          finally{ xmlr = null;}}   });
import java.io.*;
import org.xml.parsers.*;
public class java_52670_XMLParser_A07 { 
    public static void main(String[] args) throws ParserConfigurationException{  
        String url = "http://example/books.xml"; // replace with your URL or file path for XML data source    
          
        try (InputStream is  = new BufferedInputStream(new FileInputStream("path_toYourXMLFile"))){ 
             XMLParser parser= ParserFactory.getINSTANCE().createPArser(is);  
               int event;   
              while((event =parser.next()) != 1) {     //changes based on the type of xml data source you are using       case XMLEvent.ATTRIBUTE:  /* attribute */      break ;case XML_ELEMENT :/* Start element*/break   default           }}){//additional operations}
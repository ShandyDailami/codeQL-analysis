import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_47096_XMLParser_A07 { 
    public static void main(String[] args) throws Exception{  
        URL url = new URL("http://www.sample-videos.com/sample_movie.xml"); //replace with your xml file location or http link as required by A07 AuthFailure operation    
          
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
            
        try {  
               XMLReader reader =  factory.newSAXParser().getXMLReader();   
                 ParserHandler handler  = new ParserHandler();     
                  reader .setContentHandler(handler);          // Passing SAX parser content Handler to the Document Reader      
                  
             URLConnection conn = url.openConnection();  
               InputSource src =  new InputSource(conn.getInputStream()); 
                reader.parse(src );    }      catch (Exception e) {     System.out.println("There is some problem with your XML file");}              }}`;
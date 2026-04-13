import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
public class java_42649_XMLParser_A03 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{  //a
        String xmlFile = "/path/to/your_file";             //b
        
       XMLReader reader;                                  //c     
            try {                                      //d         
                reader=SAXParser.newInstance().getXMLReader();  
                
                  SAXHandler handler  = new SAXHandler(xmlFile);  //e   
                   parser = (SAXParser) ParserFactory.newInstance().
                           setDocumentHandler((DefaultHandler)handler );            
                    } catch (Exception e1){                     /*f*/                     
                        System.out.println("Failed to parse the XML file: " + xmlFile);                  //e    			   	      		  f  				       	f}                  					 a                       c                             d                            h                           i                          j                         k         l                 m          n           o             p            q               r
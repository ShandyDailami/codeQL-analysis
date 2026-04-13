import org.xml.sax.*;
import java.net.URL;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import org.xml.sax.helpers.DefaultHandler;
 
public class java_46253_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{      
        //Create the factory and parse xml file with SAx Parser          
          try{             
            URL url = new File("inputfilelocation").toURI().toURL();            
                 
            DefaultHandler handler=new XMLHandler ();   
              
                 SAXParserFactory saxFactory = SAXParserFactory.newInstance();   //create a factory for the parser 
                     
              /* create an instance of xsax and parse */         
                SAXParser saxParser  = saxFactory . newSAXParser ();   
                  sAXParser.parse( url , handler );    
                 }      catch (Exception e){            System . out . println ("Problem parsing the XML file " +e) ;  };   }}         `
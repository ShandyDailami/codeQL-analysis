import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
public class java_43613_XMLParser_A03 {  
    public static void main(String[] args) throws Exception{       
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();        
             URL url= new File("your_file.xml").toURI().toURL();  // replace with your file path or name here         
              XMLReader xmlReader =  dbFactory.newDocumentBuilder().newXMLEventReader(url);  
            for (;;) {               
               int event = xmlReader.getEventType();                 
                 switch (event) {                     
                   case XMLEvent.ELEMENT:      //start of an element           break;  }    default : return;}                     @Override              public void startElement(String uri, String localName,   NameSpace namespace, Element elem){         System.out.println("Start Elem");}        }}
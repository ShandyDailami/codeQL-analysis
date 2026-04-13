import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.*;
public class java_53317_XMLParser_A01 {  
    public static void main(String[] args) throws ParserConfigurationException, SAXException{ 
        String input = "<person><name>John Doe</name><age>25</age><city>New York</city><country>USA</country><salary>70000.0</salary> <interests>Football, Music </interests></person>";
        StringReader reader = new StringReader(input);  // Reading the XML file from string  
         SAXParserFactory spf=SAXParserFactory.newInstance();   
          SAXParser saxParser=  spf.newSAXParser();     
           MyHandler handler  =new MyHandler();    
            saxParser .parse(reader,handler);       // Parsing the XML file  
        } 
}        
class MyHandler extends DefaultHandler{    public void startDocument() {System.out.println("Start Document");}}     
public class PersonDetails implements ISAXElementContributor    
{}         `
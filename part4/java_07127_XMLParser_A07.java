import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.xmlreader.XMLReader;
import org.xml.sax.xmlreader.XMLScanner;

public class java_07127_XMLParser_A07 {
    public static void main(String[] args) {
        SAXParser saxParser = new SAXParser();
        DefaultHandler handler = new DefaultHandler();
        SAXXMLReader xmlReader = new SAXXMLReader(handler);
        
        try {
            SAXParser saxParser = new SAXParser();
            File inputFile = new File("input.xml");
            SAXHandler handler = new SAXHandler();
            XMLParser parser = new XMLParser(handler);
            
            saxParser.setXmlReader(new SAXXMLReader(handler));
            saxParser.parse(inputFile);
            
            System.out.println("Processing complete!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
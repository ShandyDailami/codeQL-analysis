import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import java.io.IOException;

public class java_28775_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("sample.xml");

        // Using SAXParser
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(null);

        saxParser.parse(xmlFile, new MyContentHandler());
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    boolean bElement = false;
    String sElementName = null;
    String sData = null;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bElement = true;
        sElementName = localName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            sData = new String(ch, start, length);
            // Here you can add code to process the data, for example, print it:
            System.out.println("Element: " + sElementName + ", Data: " + sData);
        }
    }
}
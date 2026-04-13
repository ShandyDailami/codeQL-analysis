import java.io.FileInputStream;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class java_12319_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(true); // We want strict parsing
            MyHandler myHandler = new MyHandler();

            // Get the XML file
            InputStream inputStream = new FileInputStream("example.xml");

            // Create a new reader
            XMLReader xr = saxParser.getXMLReader();

            // Set the Handler
            xr.setContentHandler(myHandler);

            // Parse the xml file
            xr.parse(inputStream);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class MyHandler extends DefaultHandler {

    private String lastTag;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, Attributes attributes) throws SAXException {
        lastTag = qualifiedName;
        System.out.println("Start Element: " + lastTag);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        lastTag = "";
        System.out.println("End Element: " + lastTag);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(lastTag != null && lastTag.length() > 0) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

}
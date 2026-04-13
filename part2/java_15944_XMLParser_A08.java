import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_15944_XMLParser_A08 {

    private DefaultHandler handler;
    private XMLReader reader;

    public java_15944_XMLParser_A08() {
        handler = new DefaultHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void parse(String fileName) {
        try {
            reader.setContentHandler(handler);
            reader.parse(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser();
        parser.parse("example.xml");
    }
}
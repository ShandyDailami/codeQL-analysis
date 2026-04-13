import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_25301_XMLParser_A03 {

    private DefaultHandler handler;

    public java_25301_XMLParser_A03() {
        handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
                // Security operation: no injection here.
                System.out.println("Start Element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                // Security operation: no injection here.
                System.out.println("End Element: " + qName);
            }
        };
    }

    public void parse(String fileName) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser(null);
            parser.parse(fileName, handler);
        } catch (FileNotFoundException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/sample.xml");
        if (file.exists()) {
            XmlParser parser = new XmlParser();
            parser.parse(file.getAbsolutePath());
        } else {
            System.out.println("File not found!");
        }
    }
}
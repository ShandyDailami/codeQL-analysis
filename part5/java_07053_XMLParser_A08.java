import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import org.xml.sax.parser.XMLLoader;

import java.io.File;
import java.io.IOException;

public class java_07053_XMLParser_A08 {
    public static void main(String[] args) {
        String url = "path_to_your_xml_file"; // replace with your xml file path
        parse(url);
    }

    public static void parse(String url) {
        try {
            XMLParser parser = new SAXParserImpl();
            XMLLoader loader = new XMLLoader(parser);
            loader.setContentHandler(new DefaultHandler() {
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    System.out.println("Element: " + qName);
                }
            });
            loader.parse(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
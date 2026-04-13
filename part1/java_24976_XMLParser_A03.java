import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class java_24976_XMLParser_A03 {

    public static void main(String[] args) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser(true);
            XMLReader xmlReader = XMLReaderFactory.newInstance().createXMLReader();

            DefaultHandler defaultHandler = new DefaultHandler() {
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if ("name".equals(qName)) {
                        System.out.println("Name: " + attributes.getValue("name"));
                    }
                }
            };

            xmlReader.setContentHandler(defaultHandler);
            xmlReader.parse(new File("path_to_your_xml_file.xml"));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
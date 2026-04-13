import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_05123_XMLParser_A01 extends DefaultHandler {
    boolean bElement = false;
    String currentElement = "";
    String currentValue = "";

    public static void main(String[] args) {
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (Stream<String> stream = Files.lines(Paths.get("path_to_your_xml_file.xml"))) {
            SAXParser saxParser = factory.newSAXParser();
            MyXMLParser handler = new MyXMLParser();
            saxParser.parse(stream.iterator(), handler);
        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        bElement = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        bElement = false;
        if (localName.equals(currentElement)) {
            System.out.println("Element: " + currentElement + ", Value: " + currentValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (bElement) {
            currentValue = new String(ch, start, length);
        }
    }
}
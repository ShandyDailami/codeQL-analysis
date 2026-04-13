import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class java_28403_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file";
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser(true);
        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startDocument() throws SAXException {
                System.out.println("Start document");
            }

            @Override
            public void endDocument() throws SAXException {
                System.out.println("End document");
            }

            @Override
            public void startElement(String uri, String localName, String qName, javax.xml.parsers.Event evt) throws SAXException {
                System.out.println("Start element: " + localName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End element: " + localName);
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                String contents = new String(ch, start, length);
                System.out.println("Character data: " + contents);
            }
        };

        File file = new File(filePath);
        if (!file.exists()) {
            throw new InvalidParameterException("File does not exist");
        }

        try {
            saxParser.parse(file, defaultHandler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
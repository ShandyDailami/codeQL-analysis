import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class java_36033_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/example.xml";  // replace with your xml file path

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser(true);

            SAXHandler handler = new SAXHandler();
            saxParser.parse(new File(xmlFilePath), handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

class SAXHandler extends DefaultHandler {

    private boolean isStartElement = false;
    private boolean isEndElement = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        isStartElement = true;
        isEndElement = false;
        System.out.println("Start Element: " + qName);
        // add your logic to handle start element here
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        isStartElement = false;
        isEndElement = true;
        System.out.println("End Element: " + qName);
        // add your logic to handle end element here
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        if (isStartElement && isEndElement) {
            System.out.println("Characters: " + new String(ch, start, length));
        }
    }

}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.parser.SAXParser;
import org.xml.sax.parser.SAXParserFactory;

public class java_02134_XMLParser_A01 {

    private static class CustomHandler extends DefaultHandler {
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            // No security-sensitive operations here.
        }
    }

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser(null);

            CustomHandler customHandler = new CustomHandler();
            saxParser.parse(new FileInputStream(new File("test.xml")), customHandler);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;

public class java_29181_XMLParser_A07 {

    public static void main(String[] args) {
        String filePath = "src/main/resources/test.xml"; // Change this to your XML file path

        XMLReader xmlReader = SAXParser.newInstance().getXMLReader();
        xmlReader.setContentHandler(new MyContentHandler());
        xmlReader.parse(new File(filePath));
    }

    private static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.println("End Element: " + qName);
        }
    }
}
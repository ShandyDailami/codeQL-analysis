import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_09286_XMLParser_A03 {
    private static final String XML_FILE_PATH = "resources/data.xml"; // Path to your XML file

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser parser = factory.newSAXParser(new InputSource(xmlFile));
            parser.parse(xmlFile, new DefaultHandler() {
                @Override
                public void startDocument() {
                    System.out.println("Start of document.");
                }

                @Override
                public void endDocument() {
                    System.out.println("End of document.");
                }

                @Override
                public void startElement(String uri, String localName, String qName) {
                    System.out.println("Start element: " + qName);
                }

                @Override
                public void endElement(String uri, String localName, String qName) {
                    System.out.println("End element: " + qName);
                }

                @Override
                public void characters(char[] ch, int start, int length) {
                    String content = new String(ch, start, length).trim();
                    if (!content.isEmpty()) {
                        System.out.println("Content: " + content);
                    }
                }
            });
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
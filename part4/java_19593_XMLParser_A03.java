import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.SAXParserFactory;
import org.xml.sax.XMLReader;

public class java_19593_XMLParser_A03 {

    private static final String XML_FILE_PATH = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Content: " + content);
            }
        };

        try {
            XMLReader reader = SAXParserFactory.newInstance().newSAXParser(new FileInputSource(xmlFile)).getXMLReader();
            reader.setContentHandler(handler);
            reader.parse(new FileInputSource(xmlFile));
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
    }
}
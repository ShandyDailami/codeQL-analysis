import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_21804_XMLParser_A07 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");

        DefaultHandler handler = new DefaultHandler() {
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) {
                String content = new String(ch, start, length);
                System.out.println("Characters: " + content);
            }
        };

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
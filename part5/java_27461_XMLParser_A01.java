import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_27461_XMLParser_A01 {

    public static void main(String[] args) {
        String fileName = "example.xml";
        File xmlFile = new File(fileName);

        DefaultHandler handler = new DefaultHandler() {

            public void startElement(String uri, String localName, String qName,
                                     javax.xml.parsers.SAXAPI.Attributes attributes) throws SAXException {
                System.out.println("Start Element: " + qName);
            }

            public void endElement(String uri, String localName, String qName) throws SAXException {
                System.out.println("End Element: " + qName);
            }

            public void characters(char[] ch, int start, int length) throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }

            public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
                System.out.println("Ignorable Whitespace: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
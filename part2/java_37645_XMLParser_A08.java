import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_37645_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File file) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName,
                                     Attributes attributes) throws SAXException {
                System.out.println("Start element: " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName)
                    throws SAXException {
                System.out.println("End element: " + qName);
            }

            @Override
            public void characters(char[] ch, int start, int length)
                    throws SAXException {
                System.out.println("Characters: " + new String(ch, start, length));
            }
        };

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(file.toURI().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
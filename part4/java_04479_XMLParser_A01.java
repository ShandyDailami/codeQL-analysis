import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_04479_XMLParser_A01 {

    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {
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
            File xmlFile = new File("sample.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXParseException e) {
            System.out.println("Parse error at line " + e.getLineNumber() + " : " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
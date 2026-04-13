import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.entities.EntityResolver;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_14598_XMLParser_A01 {

    private DefaultHandler defaultHandler;

    public java_14598_XMLParser_A01() {
        defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, XMLEvent evt) {
                System.out.println("Start Element: " + localName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End Element: " + localName);
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                String value = new String(ch, start, length);
                System.out.println("Character Data: " + value);
            }
        };
    }

    public void parse(String fileName) throws IOException, SAXException {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(defaultHandler);
        reader.parse(new File(fileName));
    }

    public static void main(String[] args) {
        try {
            new XMLParser().parse("broken_access_control.xml");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
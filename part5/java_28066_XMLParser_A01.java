import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.ElementHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_28066_XMLParser_A01 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyContentHandler());
            reader.parse(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    static class MyContentHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            System.out.println("Element: " + qName);
            System.out.println("Attributes: ");
            for (int i = 0; i < attributes.getLength(); i++) {
                System.out.println(attributes.getQName(i) + " = " + attributes.getValue(i));
            }
        }
    }
}
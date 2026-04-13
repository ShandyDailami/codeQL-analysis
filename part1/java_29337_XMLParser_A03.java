import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;

import java.io.File;
import java.io.IOException;

public class java_29337_XMLParser_A03 {
    private static class MyHandler extends BasicHandler {
        public void startElement(String namespaceURI, String localName, String qualifiedName,
                                  org.xml.sax.Attributes attributes) throws SAXException {
            System.out.println("Start Element: " + localName);
        }

        public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
            System.out.println("End Element: " + localName);
        }
    }

    public static void main(String[] args) {
        String fileName = "sample.xml";
        File xmlFile = new File(fileName);

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new MyHandler());
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
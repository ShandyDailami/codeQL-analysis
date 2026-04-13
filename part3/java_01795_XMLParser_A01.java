import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.events.XMLEvent;
import org.xml.sax.entries.BasicElement;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_01795_XMLParser_A01 {
    private static class MyHandler extends DefaultHandler {
        @Override
        public void startElement(String uri, String localName, String qName,
                                 BasicElement element) throws SAXException {
            if (localName.equals("resource")) {
                System.out.println("Access to resource is restricted!");
                // Stop parsing here
                throw new SAXException("Access to resource is restricted!");
            }
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("path/to/your/file.xml");
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyHandler());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                try {
                    xmlReader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
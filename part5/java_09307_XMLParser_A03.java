import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_09307_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");  // replace with your file path
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new ContentHandlerImpl());
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ContentHandlerImpl extends DefaultHandler {
        boolean isTitle = false;
        boolean isLink = false;
        String title = null;
        String link = null;

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            if ("title".equals(qName)) {
                isTitle = true;
            } else if ("link".equals(qName)) {
                isLink = true;
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            if ("title".equals(qName)) {
                isTitle = false;
            } else if ("link".equals(qName)) {
                isLink = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (isTitle) {
                title = new String(ch, start, length);
            } else if (isLink) {
                link = new String(ch, start, length);
            }
        }

        @Override
        public void endDocument() {
            System.out.println("Title: " + title);
            System.out.println("Link: " + link);
        }
    }
}
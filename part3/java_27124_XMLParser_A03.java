import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_27124_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            SAXHandler handler = new SAXHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {

        boolean bTag = false;
        StringBuilder data = new StringBuilder();

        @Override
        public void startElement(String uri, String localName, String qName,
                                 org.xml.sax.Attributes attributes) throws SAXException {
            bTag = true;
            data = new StringBuilder();
            // handle start tag
        }

        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // handle end tag
            if (bTag) {
                System.out.println(qName + " : " + data.toString());
                bTag = false;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            if (bTag) {
                data.append(new String(ch, start, length));
            }
        }
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_26646_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            String fileName = "sample.xml";
            File file = new File(fileName);
            InputStream inputStream = new FileInputStream(file);
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SAXHandler());
            reader.parse(new InputStreamReader(inputStream, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SAXHandler extends DefaultHandler {
        boolean bTag = false;
        String currentElement = "";
        String currentElementContent = "";

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            bTag = true;
            currentElement = qName;
            currentElementContent = "";
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (bTag) {
                currentElementContent += new String(ch, start, length);
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            bTag = false;
            System.out.println("Tag: " + currentElement + ", Content: " + currentElementContent);
        }
    }
}
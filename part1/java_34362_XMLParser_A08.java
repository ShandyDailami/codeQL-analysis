import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_34362_XMLParser_A08 {

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/example.xml");
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (SAXException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class SAXParserHandler implements org.xml.sax.helpers.DefaultHandler {

    private boolean bElement = false;
    private String aElement = null;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        bElement = true;
        aElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println(aElement + ": " + new String(ch, start, length));
        }
    }
}
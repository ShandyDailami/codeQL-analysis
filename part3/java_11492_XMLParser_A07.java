import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_11492_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml"); // replace with your xml file
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SAXParserHandler handler = new SAXParserHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class SAXParserHandler implements org.xml.sax.ContentHandler {

    private boolean bTag = false;
    private String sTagValue = null;

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        bTag = true;
        sTagValue = "";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        if (bTag) {
            System.out.println(qName + " : " + sTagValue);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            sTagValue = new String(ch, start, length);
        }
    }
}
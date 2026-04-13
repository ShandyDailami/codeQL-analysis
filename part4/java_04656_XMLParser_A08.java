import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_04656_XMLParser_A08 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());

            xmlReader.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private boolean bElement;
    private String sElement;

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        bElement = true;
        sElement = qName;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        bElement = false;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bElement) {
            System.out.println(sElement + " : " + new String(ch, start, length));
        }
    }
}
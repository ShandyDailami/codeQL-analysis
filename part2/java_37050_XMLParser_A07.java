import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_37050_XMLParser_A07 extends DefaultHandler {
    private boolean bTag = false;
    private String currentElement = "";

    public static void main(String[] args) {
        MyXMLParser myXMLParser = new MyXMLParser();
        myXMLParser.parseXML("sample.xml");
    }

    public void parseXML(String fileName) {
        File file = new File(fileName);

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(this);
            reader.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName) throws SAXException {
        bTag = true;
        currentElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        bTag = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bTag) {
            System.out.println(currentElement + " : " + new String(ch, start, length));
        }
    }
}
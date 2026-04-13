import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.helpers.DefaultHandler;

public class java_37747_XMLParser_A07 extends DefaultHandler {
    private boolean bNodeContent = false;
    private String currentElement = "";

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        currentElement = qName;
        bNodeContent = true;
    }

    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        bNodeContent = false;
        currentElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bNodeContent) {
            System.out.println(currentElement + " : " + new String(ch, start, length));
        }
    }

    public static void main(String[] args) {
        MyXMLHandler myHandler = new MyXMLHandler();
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(myHandler);
            xmlReader.parse("input.xml");  // replace with your xml file path
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_13758_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("example.xml");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
            System.out.println(handler.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {

    private StringBuilder result;

    public java_13758_XMLParser_A07() {
        result = new StringBuilder();
    }

    @Override
    public void startDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void endDocument() throws SAXException {
        // Do nothing
    }

    @Override
    public void startElement(String uri, String localName, String qName,
                             org.xml.sax.Attributes attributes) throws SAXException {
        result.append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            result.append(" ").append(attributes.getQName(i)).append("=").append(attributes.getValue(i));
        }
        result.append(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        result.append("</").append(qName).append(">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        result.append(new String(ch, start, length));
    }

    public StringBuilder getResult() {
        return result;
    }
}
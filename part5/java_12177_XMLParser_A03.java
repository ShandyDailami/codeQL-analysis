import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_12177_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            FileInputStream fis = new FileInputStream(inputFile);

            XMLReader reader = XMLReaderFactory.createXMLReader();
            MyHandler handler = new MyHandler();
            reader.setContentHandler(handler);
            reader.parse(fis);

            fis.close();

            System.out.println("Root Element: " + handler.getRootElement());
            System.out.println("Child Elements: " + handler.getChildElements());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyHandler implements org.xml.sax.helpers.DefaultHandler {

    private String rootElement = "";
    private StringBuilder childElements = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        // Nothing to do here
    }

    @Override
    public void endDocument() throws SAXException {
        // Nothing to do here
    }

    @Override
    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) throws SAXException {
        rootElement = qName;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        childElements.append(qName).append(" ");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // Nothing to do here
    }

    public String getRootElement() {
        return rootElement;
    }

    public String getChildElements() {
        return childElements.toString();
    }
}
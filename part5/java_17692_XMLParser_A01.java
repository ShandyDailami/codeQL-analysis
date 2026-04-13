import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_17692_XMLParser_A01 extends DefaultHandler {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        try {
            SAXReader saxReader = new SAXReader();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new BrokenAccessControlExample());
            xmlReader.parse(xmlFile);
        } catch (IOException e) {
            e.printStackTrace();
       
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }

}
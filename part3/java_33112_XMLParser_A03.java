import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_33112_XMLParser_A03 {

    public static void main(String[] args) {
        File xmlFile = new File("your_xml_file.xml");
        parseFile(xmlFile);
    }

    private static void parseFile(File xmlFile) {
        XMLReader xmlReader = null;
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(new MyContentHandler());
            xmlReader.parse(xmlFile.toURI().toString());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (xmlReader != null) {
                xmlReader.close();
            }
        }
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start document");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End document");
    }

    @Override
    public void startElement(String uri, String localName, String qualifiedName, org.xml.sax.Attributes attributes) throws SAXException {
        System.out.println("Start element: " + qualifiedName);
    }

    @Override
    public void endElement(String uri, String localName, String qualifiedName) throws SAXException {
        System.out.println("End element: " + qualifiedName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters: " + new String(ch, start, length));
    }
}
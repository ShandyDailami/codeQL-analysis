import java.io.File;
import java.io.IOException;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_25352_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("yourfile.xml"); // Replace with your xml file
        parseXml(xmlFile);
    }

    public static void parseXml(File xmlFile) {
        XMLReader reader = null;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setValidation(true);
            reader.setErrorHandler(new MyErrorHandler());
            reader.setContentHandler(new MyContentHandler(xmlFile));
            reader.parse(new FileInputStream(xmlFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}

class MyErrorHandler implements org.xml.sax.ErrorHandler {
    public void fatalError(org.xml.sax.SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public void error(org.xml.sax.SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void warning(org.xml.sax.SAXWarning e) {
        System.out.println("Warning: " + e.getMessage());
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Characters: " + new String(ch, start, length));
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + localName);
    }

    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }
}

class MyContentHandler implements org.xml.sax.ContentHandler {
    private File xmlFile;

    public java_25352_XMLParser_A07(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    public void characters(char[] ch, int start, int length) {
        System.out.println("Character data: " + new String(ch, start, length));
    }

    public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes) {
        System.out.println("Start Element: " + localName);
    }

    public void endElement(String uri, String localName, String qName) {
        System.out.println("End Element: " + localName);
    }

    public void startDocument() {
        System.out.println("Start Document");
    }

    public void endDocument() {
        System.out.println("End Document");
    }

    public void fatalError(org.xml.sax.SAXException e) {
        System.out.println("Fatal error: " + e.getMessage());
    }

    public void error(org.xml.sax.SAXException e) {
        System.out.println("Error: " + e.getMessage());
    }

    public void warning(org.xml.sax.SAXWarning e) {
        System.out.println("Warning: " + e.getMessage());
    }
}
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class java_08948_XMLParser_A01 extends DefaultHandler {

    public java_08948_XMLParser_A01() {
        System.out.println("Using SAX Parser");
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {

        // This is a security-sensitive operation.
        // Read XML file to check if it's a valid XML file
        if(localName.equalsIgnoreCase("badfile")) {
            throw new SAXException("File is not XML");
        }
    }

    public void endElement(String uri, String localName, String qName)
            throws SAXException {

        // This is a security-sensitive operation.
        // Check if file exists and is readable
        try {
            File file = new File("badfile.xml");
            new FileInputStream(file).close();
        } catch (IOException e) {
            throw new SAXException("File not readable");
        }
    }

    public void startDocument() throws SAXException {
        System.out.println("Start of Document");
    }

    public void endDocument() throws SAXException {
        System.out.println("End of Document");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            String xmlFile = "badfile.xml";
            File file = new File(xmlFile);
            FileInputStream fis = new FileInputStream(file);
            SAXParserFactory saxFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxFactory.newSAXParser(new InputSource(fis));

            MyHandler myHandler = new MyHandler();
            saxParser.parse(file, myHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
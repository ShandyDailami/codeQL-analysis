import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.XMLReaderFactory;
import org.xml.sax.helpers.XMLReaderFactoryImpl;

import java.io.File;
import java.io.IOException;

public class java_34805_XMLParser_A07 {

    private DefaultHandler defaultHandler;
    private XMLReader reader;

    public java_34805_XMLParser_A07() {
        this.defaultHandler = new DefaultHandler() {
            @Override
            public void startDocument() {
                // no operations
            }

            @Override
            public void endDocument() {
                // no operations
            }

            @Override
            public void startElement(String uri, String localName, String qName) {
                // no operations
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                // no operations
            }

            @Override
            public void characters(char[] ch, int start, int length) {
                // no operations
            }
        };

        try {
            this.reader = XMLReaderFactoryImpl.createXMLReader();
            this.reader.setContentHandler(this.defaultHandler);
            this.reader.setErrorHandler(this.defaultHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public void parse(File xmlFile) {
        try {
            this.reader.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        XMLParser parser = new XMLParser();
        parser.parse(xmlFile);
    }
}
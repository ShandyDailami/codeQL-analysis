import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicHandler;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_17134_XMLParser_A07 {

    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_file.xml";
        parseXmlFile(xmlFilePath);
    }

    public static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        if (!xmlFile.exists()) {
            System.out.println("The file " + xmlFilePath + " does not exist.");
            return;
        }

        BasicHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.println("Start of " + qName);
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                System.out.println("End of " + qName);
            }
        };

        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile.toURI().toString());
        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
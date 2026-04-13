import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_19447_XMLParser_A03 {

    public void parse(String fileName) {
        File xmlFile = new File(fileName);
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xmlReader.setFeature("http://xml.org/sax/features/external-general-entities", false);
            xmlReader.setFeature("http://xml.org/sax/features/external-dtd", false);

            SAXHandler saxHandler = new SAXHandler();
            xmlReader.setContentHandler(saxHandler);
            xmlReader.parse(xmlFile);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser();
        parser.parse("sample.xml");
    }
}
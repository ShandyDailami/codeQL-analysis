import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DOMSource;
import org.w3c.dom.Document;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;

import java.io.File;
import java.io.IOException;

public class java_29356_XMLParser_A01 {
    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader xmlReader;

        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setFeature("http://apache.org/xml/features/nonvalidating/strict", false);

            SAXHandler saxHandler = new SAAPHandler();
            xmlReader.setContentHandler(saxHandler);

            xmlReader.parse(new DOMSource(new DocumentBuilder().parse(xmlFile)));

            printElements(saxHandler.getElements());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(String[] elements) {
        System.out.println("Elements: ");
        for (String element : elements) {
            System.out.println(element);
        }
    }
}
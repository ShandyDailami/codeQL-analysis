import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_21910_XMLParser_A03 {

    public static void main(String[] args) {
        DefaultHandler handler = new DefaultHandler();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);

            String fileName = "example.xml";
            File xmlFile = new File(fileName);
            reader.parse(xmlFile);

            printElements(handler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printElements(DefaultHandler handler) {
        if (handler.getCurrentEvent() == DefaultHandler.START_ELEMENT) {
            String elementName = handler.getElement().getLocalName();
            System.out.println("Element name: " + elementName);
        }
    }
}
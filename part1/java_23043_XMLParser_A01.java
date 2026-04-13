import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entities.DefaultHandler;
import org.xml.sax.helpers.DefaultHandlerSupport;

import java.io.File;
import java.io.IOException;

public class java_23043_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        DefaultHandler handler = new DefaultHandlerSupport();

        try {
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        handler.getReport();
    }
}
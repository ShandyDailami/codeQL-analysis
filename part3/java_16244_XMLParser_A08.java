import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_16244_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new MyEntityResolver());
            MyContentHandler handler = new MyContentHandler();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);

            System.out.println("XML Parsed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
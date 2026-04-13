import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.File;
import java.io.IOException;

public class java_01193_XMLParser_A07 {

    public static void main(String[] args) {
        File xmlFile = new File("example.xml");
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(new SAXContentHandler(xmlFile));
        } catch (IOException e) {
            System.out.println("Could not create XML Reader.");
            e.printStackTrace();
            return;
        }

        try {
            reader.parse(xmlFile);
        } catch (SAXException e) {
            System.out.println("Could not parse XML file.");
            e.printStackTrace();
            return;
        }
    }
}
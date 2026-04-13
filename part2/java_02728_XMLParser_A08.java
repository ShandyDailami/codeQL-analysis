import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.DefaultHandler;

import java.io.File;
import java.io.IOException;

public class java_02728_XMLParser_A08 {

    private DefaultHandler defaultHandler;

    public java_02728_XMLParser_A08() {
        defaultHandler = new DefaultHandler();
    }

    public void parse(String fileName) {
        XMLReader reader;
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(defaultHandler);
            reader.parse(new File(fileName));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        XmlParser xmlParser = new XmlParser();
        xmlParser.parse("src/main/resources/test.xml");
    }
}
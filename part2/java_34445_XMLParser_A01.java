import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.enters.BasicSAXHandler;
import java.io.File;
import java.io.IOException;

public class java_34445_XMLParser_A01 {

    public static void main(String[] args) {
        File xmlFile = new File("input.xml");
        BasicSAXHandler handler = new BasicSAXHandler();
        XMLReader reader;

        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("End of parsing.");
    }
}
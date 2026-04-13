import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.entries.DefaultHandler;
import org.xml.sax.parser.XMLParser;
import java.io.File;
import java.io.IOException;

public class java_04192_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file");
            XMLReader reader = XMLReaderFactory.createXMLReader();
            DefaultHandler handler = new DefaultHandler();
            XMLParser parser = new XMLParser(handler);
            reader.setContentHandler(handler);
            reader.parse(xmlFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    DefaultHandler handler;

    public java_04192_XMLParser_A08(DefaultHandler handler) {
        this.handler = handler;
    }
}
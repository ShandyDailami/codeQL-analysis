import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXReader;
import java.io.File;
import java.io.IOException;

public class java_11418_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            SAXReader reader = new SAXReader();
            File xmlFile = new File("sample.xml"); // replace with your file path
            XMLReader xmlReader = reader.getReader();
            xmlReader.setContentHandler(new DefaultHandler());
            xmlReader.parse(xmlFile);
            System.out.println("Parsing completed successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}
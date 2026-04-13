import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_35635_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a factory for building DOM
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // Create a builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            // Parse the input file
            Document doc = builder.parse(new File("input.xml"));
            // Process the document...

            System.out.println("XML Parsing Successful");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
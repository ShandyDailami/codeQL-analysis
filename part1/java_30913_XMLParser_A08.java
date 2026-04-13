import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30913_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Create DocumentBuilderFactory and get an instance of it
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Setup Factory
            factory.setValidating(true); // Enable validation
            factory.setNamespaceAware(true); // Enable namespace aware
            factory.setDefaultHandler(new DefaultHandler());

            // Create DocumentBuilder from factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parse XML file
            InputStream inputStream = new FileInputStream(new File("path_to_your_xml_file.xml"));
            Document doc = builder.parse(inputStream);

            // TODO: Process the parsed XML document

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
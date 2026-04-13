import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19200_XMLParser_A01 {
    public static void main(String[] args) {
        String sensitiveFilePath = "/path/to/sensitive/file";

        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);

            // Create a DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a Document
            Document doc = builder.parse(new File(sensitiveFilePath));

            System.out.println("XML Parsing Successful");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occurred while parsing the XML file");
        }
    }
}
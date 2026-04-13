import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_11542_XMLParser_A01 {

    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file"; // specify your xml file path here
        parseXMLFile(filePath);
    }

    private static void parseXMLFile(String filePath) {
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found!");
                return;
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            InputStream inputStream = new FileInputStream(file);
            Document doc = dBuilder.parse(inputStream);

            // Close the input stream
            inputStream.close();

            // Print the parsed document
            System.out.println("XML Parsed Successfully.");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
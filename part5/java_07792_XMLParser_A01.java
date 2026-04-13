import java.io.*;
import javax.xml.parsers.*;
import org.xml.sax.*;

public class java_07792_XMLParser_A01 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        String filePath = "your_file_path.xml";
        parseXMLFile(filePath);
    }

    private static void parseXMLFile(String filePath) throws ParserConfigurationException, SAXException {
        // Create a new instance of DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Get document builder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Create empty Document
        Document document = builder.newDocument();

        // Parse XML file
        try {
            builder.parse(new InputSource(new File(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print document elements and attributes
        document.getElementsByTagName("*").item(0).getChildNodes().item(0).getNodeValue();
    }
}
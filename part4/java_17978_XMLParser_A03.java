import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17978_XMLParser_A03 {
    public static void main(String[] args) throws Exception {
        String xmlFile = "/path/to/your/xml/file.xml"; // replace with your XML file path
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) throws Exception {
        // Step 1: Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Step 2: Get the DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Step 3: Parse the XML file into a Document
        Document document = builder.parse(getInputStream(xmlFile));

        // TODO: Process the document

        // Close the document
        document.close();
    }

    public static InputStream getInputStream(String fileName) throws Exception {
        File xmlFile = new File(fileName);
        return new FileInputStream(xmlFile);
    }
}
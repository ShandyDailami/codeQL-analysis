import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_05869_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Use the factory to create a new DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the input XML file
            Document document = builder.parse(getFileAsInputStream("input.xml"));

            // Step 4: Process the document
            // Here we're just printing out the document's root element
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getFileAsInputStream(String fileName) {
        try {
            // Step 5: Read the input file
            File file = new File(fileName);
            return new FileInputStream(file);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
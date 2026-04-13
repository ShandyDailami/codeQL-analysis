import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import java.io.File;

public class java_03354_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Initialize DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get a builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new File("sample.xml"));

            // Step 4: Handle the document
            // This is a minimalist way to handle the document,
            // in a real-world scenario, you would probably want
            // to handle the document and stop when there are no more
            // elements to parse

            // This is just a placeholder for how you would handle
            // the document
            System.out.println("Document was parsed successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
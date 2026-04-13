import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_05089_XMLParser_A08 {
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");

        try {
            Document doc = builder.parse(inputFile);

            System.out.println("Document parsing succeeded");
        } catch (SAXException e) {
            System.out.println("Document parsing failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
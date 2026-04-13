import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_19318_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Get the DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(getInput("input.xml"));

            // Print the parsed document
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("root"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInput(String fileName) {
        try {
            File inputFile = new File(fileName);
            return new FileInputStream(inputFile);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
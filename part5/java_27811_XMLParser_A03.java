import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_27811_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Parse the XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File("input.xml"));

            // Print out the XML document
            printDocument(doc);

            // Here you can add your security-sensitive operations related to A03_Injection

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        // Print the XML document
        System.out.println(doc.getDocumentElement().getNodeName());
    }
}
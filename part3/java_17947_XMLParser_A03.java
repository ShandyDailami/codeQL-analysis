import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17947_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Step 1: Create a DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Step 2: Get the DocumentBuilder from the factory
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Step 3: Parse the XML file
            Document doc = builder.parse(new FileInputStream("sample.xml"));

            // Here, you can start adding your security-sensitive operations related to A03_Injection here
            // For instance, we will just print all the elements in the document
            doc.getElementsByTagName("*").item(0).getChildNodes().item(0).getNodeValue();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
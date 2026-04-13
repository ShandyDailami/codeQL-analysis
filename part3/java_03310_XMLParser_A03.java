import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03310_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "sample.xml";  // replace with your file name

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (InputStream is = new FileInputStream(new File(fileName))) {
            Document doc = builder.parse(is);

            // TODO: Perform operations on the parsed XML document
            // For instance, printing out the root element and all attributes
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("Attributes: " + doc.getDocumentElement().getAttributes());

        } catch (ParserConfigurationException | SAXException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
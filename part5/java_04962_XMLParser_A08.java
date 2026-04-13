import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04962_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("sampleFile.xml");
            InputStream inputStream = new FileInputStream(inputFile);
            parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parse(InputStream inputStream) throws ParserConfigurationException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(inputStream);

        // Perform security-sensitive operations related to A08_IntegrityFailure here
        // For example, print out the document name
        System.out.println("Document Name: " + doc.getDocumentElement().getNodeName());
    }
}
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_07662_XMLParser_A01 {

    public static void main(String[] args) {
        try {
            parseXML("broken.xml");
        } catch (ParserConfigurationException | IOException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String filename)
            throws ParserConfigurationException, IOException, SAXException, NoSuchAlgorithmException {
        File inputFile = new File(filename);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        // Start with your code here
        // You can use the DOM (Document Object Model) to navigate and manipulate XML
    }
}
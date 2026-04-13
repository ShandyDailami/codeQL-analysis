import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29875_XMLParser_A08 {
    public static void main(String[] args) {
        String fileName = "sample.xml"; // replace with your file name
        parseXMLFile(fileName);
    }

    private static void parseXMLFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
            doc.getDocumentElement().normalize();
            System.out.println("XML file was parsed successfully");
        } catch (SAXException | IOException e) {
            System.out.println("Failed to parse XML file");
            e.printStackTrace();
        }
    }
}
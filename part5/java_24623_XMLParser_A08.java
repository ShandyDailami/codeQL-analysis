import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_24623_XMLParser_A08 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file");
        parseXmlFile(xmlFile);
    }

    private static void parseXmlFile(File xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;

        try {
            doc = builder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
            return;
        }

        // If we got this far, it means the XML file was parsed successfully
        System.out.println("XML file parsed successfully.");
    }
}
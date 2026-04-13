import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21553_XMLParser_A08 {

    private File xmlFile;

    public java_21553_XMLParser_A08(String xmlFilePath) {
        xmlFile = new File(xmlFilePath);
    }

    public Document parse() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        // Ensure the file is not opened without user permission
        if (!xmlFile.canRead()) {
            System.out.println("Error: The file is not readable. Please ensure the file is in the correct location and has user permission.");
            return null;
        }

        try {
            document = builder.parse(xmlFile);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Error: Parsing the XML file failed. Please check the file.");
            e.printStackTrace();
            return null;
        }

        return document;
    }
}
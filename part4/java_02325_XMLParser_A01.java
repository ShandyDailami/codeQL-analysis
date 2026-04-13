import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_02325_XMLParser_A01 {
    private String filePath;

    public java_02325_XMLParser_A01(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new InvalidParameterException("File path cannot be null or empty.");
        }

        this.filePath = filePath;
    }

    public Document loadXMLDocument() {
        Document document = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File(filePath);

        try {
            document = builder.parse(inputFile);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document;
    }

    public static void main(String[] args) {
        XMLParser parser = new XMLParser("path_to_your_xml_file");
        Document document = parser.loadXMLDocument();

        // Add your security-sensitive operations here...

        //...
    }
}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_19770_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path_to_your_xml_file.xml";

        File xmlFile = new File(xmlFilePath);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setNamespaceAware(false);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = null;

        try {
            document = documentBuilder.parse(xmlFile);
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
        }

        // Now you can use the document for your operations
        // ...
    }
}
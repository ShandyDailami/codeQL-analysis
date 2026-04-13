import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03845_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xmlFile = "example.xml"; // replace with your xml file
            InputStream inputStream = new FileInputStream(xmlFile);
            
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilderFactory.setValidating(false);
            documentBuilderFactory.setNamespaceAware(false);
            documentBuilderFactory.setXIncludePatterns(null);
            documentBuilderFactory.setXExcludePatterns(null);

            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);

            // Here you can process the parsed XML document
            System.out.println("XML Parsed successfully.");
            
        } catch (Exception e) {
            System.out.println("Error parsing the XML: " + e.getMessage());
        }
    }
}
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_30689_XMLParser_A03 {
    public static void main(String[] args) {
        String xmlFilePath = "your_xml_file_path_here";
        parseXmlFile(xmlFilePath);
    }

    private static void parseXmlFile(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setNamespaceAware(false);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document;

        try {
            document = documentBuilder.parse(xmlFile);

            // Security-sensitive operation: printing XML content
            System.out.println(document.toString());

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.IOException;
import java.security.Policy;
import java.security.CodeSource;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25042_XMLParser_A03 {

    private static final String XML_FILE_PATH = "path_to_your_xml_file";

    public static void main(String[] args) {
        File xmlFile = new File(XML_FILE_PATH);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();

            // Start of security-sensitive operations
            CodeSource codeSource = document.getDocumentSource().getCodeSource();
            String location = codeSource.getLocation();
            // ...

            // End of security-sensitive operations

            // Print the document element's name
            System.out.println("Root element is: " + document.getDocumentElement().getNodeName());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
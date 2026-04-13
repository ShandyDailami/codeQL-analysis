import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34775_XMLParser_A08 {
    public static void main(String[] args) {
        String filePath = "path_to_your_file.xml"; // replace with your file path

        try {
            File inputFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Here you can process the parsed XML data.
            // For instance, you can print out all the element names:
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            System.out.println("Child count: " + doc.getChildNodes().getLength());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
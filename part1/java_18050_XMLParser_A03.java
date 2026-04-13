import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18050_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml"); // replace with your input file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            // Print the parsing result in the console
            System.out.println("XML file parsed successfully.");
        } catch (Exception e) {
            System.out.println("Error parsing XML file.");
            e.printStackTrace();
        }
    }
}
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.io.File;
import java.io.IOException;

public class java_23173_XMLParser_A03 {

    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Document successfully parsed");
        } catch (SAXParseException m) {
            System.out.println("Error parsing: " + m.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("Error parsing: " + e.getMessage());
            return;
        } catch (Exception e) {
            System.out.println("Error parsing: " + e.getMessage());
            return;
        }

        // Continue parsing the document here
    }
}
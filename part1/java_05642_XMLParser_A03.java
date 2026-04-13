import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class java_05642_XMLParser_A03 {

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
        } catch (SAXException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Continue with the parsing operation here.
        // For example, print out all the element names in the document.
        printElementNames(doc);
    }

    private static void printElementNames(Document doc) {
        // Use a simple iterator to print all the element names.
        doc.getElementsByTagName("*").item(0).getNodeName();
    }
}
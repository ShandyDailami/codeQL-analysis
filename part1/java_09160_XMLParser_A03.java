import java.awt.print.Printable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09160_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String inputFile = "input.xml"; // specify your input file
            parse(inputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parse(String inputFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        InputStream input = new FileInputStream(inputFile);
        Document doc = builder.parse(input);

        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
    }
}
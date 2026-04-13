import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.xml.parsers.DocumentBuilderFactory;
import java.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_37502_XMLParser_A03 {

    public static void main(String[] args) {
        String fileName = "sample.xml";
        parseXML(fileName);
    }

    private static void parseXML(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            InputStream in = new FileInputStream(fileName);
            Document doc = builder.parse(new InputStreamReader(in, "UTF-8"));

            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
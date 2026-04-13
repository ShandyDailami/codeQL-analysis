import java.security.AccessController;
import java.security.PrivilegedAction;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_17555_XMLParser_A03 {

    public static void main(String[] args) {
        AccessController.doPrivileged(new PrivilegedAction<Void>() {
            public Void run() {
                try {
                    InputStream inputStream = new FileInputStream("/path/to/your/file.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(inputStream);
                    doc.getDOCUMENT_NODE().normalize();

                    printElements(doc);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    private static void printElements(Document doc) {
        doc.getElementsByTagName("*").item(0).getNodeName();
    }
}
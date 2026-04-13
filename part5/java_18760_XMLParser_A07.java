import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_18760_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://example.com");
            URLConnection conn = url.openConnection();
            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder sb = new StringBuilder();

            while (scanner.hasNext()) {
                sb.append(scanner.nextLine());
            }

            scanner.close();

            String xmlString = sb.toString();

            // Parse the XML
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlString.getBytes()));

            // Handle the document (e.g., print XML content)
            System.out.println(document.getDocumentElement().getNodeName());

        } catch (Exception ex) {
            System.out.println("Error during parsing: " + ex.getMessage());
        }
    }
}
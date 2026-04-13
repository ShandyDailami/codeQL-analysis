import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_23727_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Get access to XML document
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            // Check document for security violations
            // We're only checking for a simple example, you should replace this with more complex checks
            String expression = "new javax.xml.transform.Transformer();";
            if (doc.getElementsByTagName("xsl").item(0).getFirstChild().toString().equals(expression)) {
                System.out.println("Document is vulnerable to XML Expression (XEE) attack!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
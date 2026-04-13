import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.security.NoSuchAlgorithmException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.DigestException;
import java.util.Formatter;

public class java_10092_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            InputStream inputStream = Paths.get("path_to_your_file.xml").toFile().getCanonicalPath();
            readXmlFile(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readXmlFile(InputStream inputStream) throws IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(inputStream);
        document.getDocumentElement().normalize();

        printNode(document, "");
    }

    private static void printNode(Node node, String padding) {
        String newPadding = padding + "--";

        System.out.println(padding + node.getNodeName());

        if (node.hasChildNodes()) {
            for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
                printNode(child, newPadding);
            }
        }
    }
}
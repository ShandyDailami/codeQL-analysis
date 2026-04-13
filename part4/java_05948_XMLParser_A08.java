import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_05948_XMLParser_A08 {

    private String filePath;

    public java_05948_XMLParser_A08(String filePath) {
        this.filePath = filePath;
    }

    public void parseFile() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File(filePath));

            doc.getDocumentElement().normalize();

            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

            String integrityFailure = checkIntegrityFailure(doc);
            if (integrityFailure != null) {
                System.out.println("Integrity failure detected: " + integrityFailure);
            } else {
                System.out.println("No integrity failures detected.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String checkIntegrityFailure(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("node");
        Iterator<Node> iterator = nodeList.iterator();

        while (iterator.hasNext()) {
            Node node = iterator.nextNode();

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                if (element.getAttribute("attribute") == null) {
                    return "Integrity failure in node: " + element.getTagName();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        XmlParser parser = new XmlParser("path_to_your_file.xml");
        parser.parseFile();
    }
}
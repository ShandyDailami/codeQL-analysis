import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_25455_XMLParser_A01 {
    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml"; // replace with your xml file path

        try (InputStream input = new FileInputStream(new File(xmlFilePath));
             DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
             DocumentBuilder builder = factory.newDocumentBuilder()) {

            Document doc = builder.parse(input);

            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            printElementAndAttributes(doc.getDocumentElement(), null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printElementAndAttributes(org.w3c.dom.Node node, String prefix) {
        String pre = (prefix == null) ? "" : (prefix + ".");
        for (int i = 0; i < node.getChildNodes().getLength(); ++i) {
            org.w3c.dom.Node childNode = node.getChildNodes().item(i);
            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                StringBuilder sb = new StringBuilder(pre + childNode.getNodeName());
                if (childNode.hasAttributes()) {
                    for (int j = 0; j < childNode.getAttributes().getLength(); ++j) {
                        sb.append(" ").append(childNode.getAttributes().item(j).getNodeName()).append("=\"").append(childNode.getAttributes().item(j).getTextContent());
                    }
                }
                System.out.println(sb.toString());
                printElementAndAttributes(childNode, pre + childNode.getNodeName());
            }
        }
    }
}
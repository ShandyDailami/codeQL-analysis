import java.io.File;
import java.io.IOException;
import java.security.Policy;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_13671_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("config.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            List<String> tags = getTags(doc);

            System.out.println("Tags: " + tags);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getTags(Document doc) {
        List<String> tags = new ArrayList<>();
        NodeList nodeList = doc.getElementsByTagName("tag");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            tags.add(node.getTextContent());
        }
        return tags;
    }
}
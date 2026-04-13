import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import sun.security.x509.X509Certificate;

public class java_03491_XMLParser_A03 {

    public static void main(String[] args) {
        String urlString = "http://example.com/file.xml"; // your XML file URL

        try {
            URL url = new URL(urlString);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(url.openStream());

            doc.getDocumentElement().normalize();

            List items = new ArrayList();
            parseNode(doc.getChildNodes(), items);

            Iterator iterator = items.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseNode(NodeList nodes, List items) {
        for (int i = 0; i < nodes.getLength(); i++) {
            if (nodes.item(i).getNodeType() == Node.ELEMENT_NODE) {
                items.add(nodes.item(i).getNodeName());
                parseNode(nodes.item(i).getChildNodes(), items);
            }
        }
    }
}
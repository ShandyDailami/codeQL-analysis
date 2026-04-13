import java.io.File;
import java.security.AccessControlException;
import java.security.AccessDeniedException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_04495_XMLParser_A08 {

    public static void main(String[] args) {
        String fileName = "sample.xml";
        parse(fileName);
    }

    private static void parse(final String fileName) {
        PrivilegedAction<Document> documentAction = new PrivilegedAction<Document>() {
            public Document run() {
                try {
                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document doc = builder.parse(new File(fileName));
                    return doc;
                } catch (SAXException e) {
                    throw new AccessDeniedException("Error parsing XML: " + e.getMessage());
                } catch (Exception e) {
                    throw new AccessControlException("Access denied: " + e.getMessage());
                }
            }
        };

        try {
            Document doc = documentAction.run();
            NodeList nodeList = doc.getElementsByTagName("*");
            List<String> elementNames = new ArrayList<String>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                elementNames.add(element.getTagName());
            }
            for (String name : elementNames) {
                System.out.println(name);
            }
        } catch (AccessDeniedException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (AccessControlException e) {
            System.out.println("Access Denied: " + e.getMessage());
        }
    }
}
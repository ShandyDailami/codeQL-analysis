import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_23460_XMLParser_A08 {
    private static final String FILE_PATH = "src/main/resources/sample.xml";

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = null;

        try {
            doc = builder.parse(new File(FILE_PATH));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission perm) throws SecurityException {
                if (perm instanceof IntegrityFailure) {
                    throw new SecurityException("Integrity Failure detected");
                }
            }
        };

        try {
            doc.validate(securityManager);
        } catch (SAXException e) {
            e.printStackTrace();
        }

        Element root = doc.getDocumentElement();
        List<Element> list = doc.getElementsByTagName("item");

        for (int i = 0; i < list.size(); i++) {
            Element element = list.get(i);
            System.out.println("Item " + (i + 1) + ": " + element.getTextContent());
        }
    }
}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_41900_XMLParser_A03 {
    public static void main(String[] args) {
        String fileName = "example.xml";
        parseFile(fileName);
    }

    public static void parseFile(String fileName) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = null;
        try {
            doc = builder.parse(new File(fileName));
        } catch (SAXException | IOException e) {
            e.printStackTrace();
       
            return;
        }

        doc.getDocumentElement().normalize();
        Element root = doc.getDocumentElement();

        System.out.println("Root element: " + root.getNodeName());

        // You can also parse the XML into a model object
        // ModelClass model = new ModelClass();
        // model.parseXML(root);

        // For example, print all element names
        // printElementNames(root);
    }

    // Example of parsing into a model object
    public static void printElementNames(Element root) {
        List<Element> list = root.getChildNodes();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Element: " + list.get(i).getNodeName());
        }
    }
}
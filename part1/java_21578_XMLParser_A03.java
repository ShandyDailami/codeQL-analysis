import java.io.*;
import java.net.URL;
import java.util.Iterator;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_21578_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFile = "input.xml"; // change this to your XML file
        parse(xmlFile);
    }

    public static void parse(String xmlFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));

            // normalize the document
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            printNode(root);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNode(Element node) {
        System.out.println(node.getNodeName());

        // get the attributes
        if (node.hasAttributes()) {
            Iterator iterator = node.getAttributes().iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        }

        // get the children
        if (node.hasChildNodes()) {
            printNode(node);
        }
    }
}
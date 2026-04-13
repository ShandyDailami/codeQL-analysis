import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_15089_XMLParser_A03 {
    public static void main(String[] args) {
        File xmlFile = new File("path_to_your_xml_file.xml");
        parseXMLFile(xmlFile);
    }

    public static void parseXMLFile(File xmlFile) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try {
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            printNodeNames(doc);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNodeNames(Document doc) {
        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            System.out.println(((Element) nodeList.item(i)).getNodeName());
        }
    }
}
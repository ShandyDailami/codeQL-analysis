import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_10816_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("path_to_your_xml_file.xml"));

            parseXml(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseXml(Document doc) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            System.out.println("Tag: " + node.getNodeName());
        }
    }
}
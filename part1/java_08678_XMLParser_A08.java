import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.security.utils.SecurityConstraints;
import org.xml.sax.SAXException;

public class java_08678_XMLParser_A08 {
    public static void main(String[] args) {
        // Check if the file exists
        File file = new File("input.xml");
        if (!file.exists()) {
            System.out.println("Input file does not exist.");
            return;
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = null;

        try {
            document = builder.parse(new FileInputStream(file));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        document.getDocumentElement().normalize();
        NodeList nodeList = document.getElementsByTagName("*");

        List<String> nodes = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            nodes.add(nodeList.item(i).getNodeName());
        }

        // Print out the content of the file
        System.out.println("XML content: " + nodes);
    }
}
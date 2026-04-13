import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.security.utils.SecurityXMLReader;

public class java_05290_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Load XML file
            InputStream is = new FileInputStream(new File("sample.xml"));
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(is);
            doc.getDocumentElement().normalize();

            // Create XPath expression to select nodes
            String exp = "/bookstore/book";

            // Execute XPath expression and iterate over nodes
            SecurityXMLReader xReader = new SecurityXMLReader();
            xReader.setValidationEnabled(false);
            Document pDoc = xReader.parse(doc);
            pDoc.getDocumentElement().normalize();
            NodeList nodeList = pDoc.getElementsByTagName("book");
            Iterator<Node> iterator = nodeList.iterator();

            // Print book information
            while (iterator.hasNext()) {
                Node node = iterator.nextNode();
                System.out.println("Title: " + node.getChildNodes().item(1).getTextContent());
                System.out.println("Price: " + node.getChildNodes().item(3).getTextContent());
                System.out.println("--------------------------------");
            }

            // Close input stream
            is.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class java_03007_XMLParser_A03 {
    public static void main(String[] args) {
        File inputFile = new File("input.xml");
        parseFile(inputFile);
    }

    public static void parseFile(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("secure");

            for (int i = 0; i < nodes.getLength(); i++) {
                System.out.println("Node " + (i + 1) + ": " + nodes.item(i).getTextContent());
            }

        } catch (SAXException e) {
            e.printStackTrace();
       
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
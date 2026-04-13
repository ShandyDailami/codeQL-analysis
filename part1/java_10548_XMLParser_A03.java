import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_10548_XMLParser_A03 {
    public static void main(String[] args) {
        String filePath = "path_to_your_xml_file"; // replace with your xml file path
        parseXMLFile(filePath);
    }

    public static void parseXMLFile(String filePath) {
        FileInputStream fis = null;
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            fis = new FileInputStream(new File(filePath));
            Document doc = builder.parse(fis);

            // Print XML contents
            printXMLContents(doc);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printXMLContents(Document doc) {
        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        // Print all element names
        printElementNames(doc.getElementsByTagName("*"));
    }

    public static void printElementNames(org.w3c.dom.NodeList nList) {
        System.out.println("--------------------");
        for (int temp = nList.getLength(); --temp > 0;) {
            org.w3c.dom.Node nNode = nList.item(temp);
            System.out.println(nNode.getNodeName());
        }
    }
}
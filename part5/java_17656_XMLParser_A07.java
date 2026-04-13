import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_17656_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("note");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String tagValue = eElement.getAttribute("tag");
                    System.out.println("Tag : " + tagValue);

                    String contentValue = eElement.getAttribute("content");
                    System.out.println("Content : " + contentValue);

                    String authorValue = eElement.getAttribute("author");
                    System.out.println("Author : " + authorValue);
                }
            }
            System.out.println("XML Parsing Complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
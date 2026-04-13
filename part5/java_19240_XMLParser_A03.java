import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.IOException;

public class java_19240_XMLParser_A03 {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File inputFile = new File("input.xml");
        Document document = builder.parse(inputFile);

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("student");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;

            String id = element.getAttribute("id");
            String name = element.getAttribute("name");
            String score = element.getAttribute("score");

            System.out.println("Student ID: " + id);
            System.out.println("Student Name: " + name);
            System.out.println("Student Score: " + score);
        }
    }
}
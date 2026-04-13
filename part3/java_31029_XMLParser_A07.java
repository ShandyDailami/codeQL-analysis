import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_31029_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("path_to_your_xml_file");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("student");
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String roll = eElement.getElementsByTagName("roll").item(0).getTextContent();
                    String classs = eElement.getElementsByTagName("class").item(0).getTextContent();
                    
                    System.out.println("Name: " + name);
                    System.out.println("Roll: " + roll);
                    System.out.println("Class: " + classs);
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class java_04204_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("example.xml");
            FileInputStream fis = new FileInputStream(inputFile);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fis);
            doc.getDocumentElement().normalize();
            System.out.println("Root element : " + doc.getElementsByTagName("note").item(0).getTextContent());
            parseEmployees(doc.getElementsByTagName("employee"));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

    private static void parseEmployees(NodeList employeeList) {
        for (int i = 0; i < employeeList.getLength(); i++) {
            Node employeeNode = employeeList.item(i);
            if (employeeNode.getNodeType() == Node.ELEMENT_NODE) {
                Element employeeElement = (Element) employeeNode;
                System.out.println("Employee's name: " + employeeElement.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Employee's role: " + employeeElement.getElementsByTagName("role").item(0).getTextContent());
            }
        }
    }
}
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class java_39895_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "src/data.xml"; // Path to your XML file
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(new File(xmlFile));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\n  Student  : " + temp + 1);
                System.out.println("-------------------------------");

                Element fNode = (Element) nNode;

                String name = fNode.getElementsByTagName("name").item(0).getTextContent();
                String roll = fNode.getElementsByTagName("roll").item(0).getTextContent();
                String grade = fNode.getElementsByTagName("grade").item(0).getTextContent();

                System.out.println("Name : " + name);
                System.out.println("Roll : " + roll);
                System.out.println("Grade : " + grade);
            }

            System.out.println("Parsing Complete");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
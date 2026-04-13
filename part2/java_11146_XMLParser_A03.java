import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class java_11146_XMLParser_A03 {

    public static void main(String[] args) {
        parseXML("sample.xml");
    }

    public static void parseXML(String fileName) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        try (FileInputStream fis = new FileInputStream(fileName);
             Scanner s = new Scanner(fis)) {

            s.useDelimiter("\\Z");
            String contents = s.next();
            s.close();

            Document doc = dBuilder.parseString(contents);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("location");

            List<String> locations = new ArrayList<>();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                locations.add(node.getTextContent());
            }

            NodeList nameList = doc.getElementsByTagName("name");

            List<String> names = new ArrayList<>();

            for (int i = 0; i < nameList.getLength(); i++) {
                Node node = nameList.item(i);
                names.add(node.getTextContent());
            }

            System.out.println("Names: " + names);
            System.out.println("Locations: " + locations);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
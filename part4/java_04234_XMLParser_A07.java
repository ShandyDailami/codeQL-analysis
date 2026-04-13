import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_04234_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("student");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("Student: " + nNode.getChildNodes().item(1).getTextContent());
                System.out.println("Grade: " + nNode.getChildNodes().item(3).getTextContent());
            }

            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write("Student name and grade were written to output.txt");
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
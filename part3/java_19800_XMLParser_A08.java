import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_19800_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            File outputFile = new File("output.xml");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(inputFile);
            doc.getDoctype();
            
            NodeList nodeList = doc.getElementsByTagName("student");
            
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                
                String id = element.getAttribute("id");
                String name = element.getAttribute("name");
                String grade = element.getAttribute("grade");
                
                FileWriter writer = new FileWriter(outputFile, true);
                writer.write("ID: " + id + ", Name: " + name + ", Grade: " + grade + "\n");
                writer.close();
            }
            
            System.out.println("XML Parsing Complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
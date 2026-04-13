import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_11584_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.xml");
            File outputFile = new File("output.txt");
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            
            NodeList nList = doc.getElementsByTagName("student");
            
            FileWriter writer = new FileWriter(outputFile);
            
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = eElement.getElementsByTagName("age").item(0).getTextContent();
                    String grade = eElement.getElementsByTagName("grade").item(0).getTextContent();
                    
                    writer.write("Name: " + name + ", Age: " + age + ", Grade: " + grade + "\n");
                }
            }
            
            writer.close();
            
            System.out.println("XML Parsing Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
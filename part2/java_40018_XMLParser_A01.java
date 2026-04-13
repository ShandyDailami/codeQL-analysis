import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class java_40018_XMLParser_A01 {
    public static void main(String[] args) {
        // Step 1: Parse XML file
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("input.xml"));

            // Step 2: Extract data from XML file
            NodeList nodeList = doc.getElementsByTagName("student");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                String id = element.getAttribute("id");
                String name = element.getAttribute("name");
                String grade = element.getAttribute("grade");
                System.out.println("id: " + id + ", name: " + name + ", grade: " + grade);

                // Step 3: Transform XML data to HTML
                FileWriter fileWriter = new FileWriter("output.html");
                fileWriter.write("<html><body><h1>Student Information</h1>");
                fileWriter.write("<p>ID: " + id + "</p>");
                fileWriter.write("<p>Name: " + name + "</p>");
                fileWriter.write("<p>Grade: " + grade + "</p>");
                fileWriter.write("</body></html>");
                fileWriter.close();

                // Step 4: Convert HTML to XML
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File("output.xml"));
                transformer.transform(source, result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
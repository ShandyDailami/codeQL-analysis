import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.FileWriter;
import java.io.IOException;

public class java_01189_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new File("sample.xml"));
            doc.getDocumentElement().normalize();

            NodeList nl = doc.getElementsByTagName("item");

            for (int i = 0; i < nl.getLength(); i++) {
                Node n = nl.item(i);
                System.out.println("Item " + (i + 1));
                System.out.println("Name: " + n.getChildNodes().item(1).getNodeValue());
                System.out.println("Value: " + n.getChildNodes().item(3).getNodeValue());
            }

            writerXMLFile(doc);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writerXMLFile(Document doc) {
        try {
            FileWriter writer = new FileWriter("output.xml");
            doc.write(writer);
            System.out.println("XML has been written to the file.");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
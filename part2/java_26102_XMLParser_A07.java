import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_26102_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);

            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("node");

            for (int i = 0; i < nodes.getLength(); i++) {
                Element node = (Element) nodes.item(i);
                String name = node.getAttribute("name");
                String value = node.getAttribute("value");
                System.out.println("Node " + (i+1) + ": Name = " + name + ", Value = " + value);
                
                // Optional: Print the XML
                OutputFormat format = new OutputFormat(System.out, 4, true, "\n", "  ");
                XMLSerializer serializer = new XMLSerializer(format);
                serializer.startDocument("UTF-8", true);
                serializer.startElement("", "node", "http://www.example.com/node");
                serializer.writeAttribute("name", name, "");
                serializer.writeAttribute("value", value, "");
                serializer.endElement("", "node", "http://www.example.com/node");
                serializer.endDocument();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
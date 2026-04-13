import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_30972_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xmlFile = "example.xml";
            InputStream inputStream = new FileInputStream(xmlFile);
            parseXML(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(InputStream inputStream) {
        try {
            DOMParser parser = new DOMParser();
            parser.parse(inputStream);
            Document doc = parser.getDocument();
            NodeList nodeList = doc.getElementsByTagName("node");
            List<String> nodeValues = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                nodeValues.add(nodeList.item(i).getTextContent());
            }
            System.out.println(nodeValues);
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
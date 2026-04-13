import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_25077_XMLParser_A03 {
    public List<String> parseXML(String xmlFilePath) throws Exception {
        File inputFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("element");

        List<String> elements = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            elements.add(nodeList.item(i).getTextContent());
        }

        return elements;
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_00731_XMLParser_A03 {

    private DocumentBuilder builder;

    public java_00731_XMLParser_A03() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        builder = factory.newDocumentBuilder();
    }

    public Document parse(String fileName) throws ParserConfigurationException, IOException, SAXException {
        if (!new File(fileName).exists()) {
            throw new InvalidParameterException("File does not exist: " + fileName);
        }

        InputStream input = new FileInputStream(fileName);
        Document doc = builder.parse(input);

        return doc;
    }

    public void extractData(Document doc, String elementName) {
        Element root = doc.getDocumentElement();
        List<Element> elements = root.getElementsByTagName(elementName);

        for (int i = 0; i < elements.size(); i++) {
            Element element = elements.get(i);
            Map<String, String> data = XmlUtils.elementToMap(element);
            // Here you can process the data, for example, print it.
            System.out.println(data);
        }
    }

    public static class XmlUtils {

        public static Map<String, String> elementToMap(Element element) {
            // This is a very basic implementation.
            // In a real application, you would probably want to use a more robust method.
            Map<String, String> map = Maps.newHashMap();

            for (int i = 0; i < element.getChildNodes().getLength(); i++) {
                Node node = element.getChildNodes().item(i);
                if (node.getNodeType() == Node.TEXT_NODE && node.getTextContent().trim().length() > 0) {
                    map.put(node.getNodeName(), node.getTextContent().trim());
                }
            }

            return map;
        }
    }
}
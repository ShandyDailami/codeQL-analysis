import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_13424_XMLParser_A01 {

    public List<String> parseXML(String filePath) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document document = null;

        try {
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            throw new InvalidParameterException("Invalid file path", e);
        }

        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("tagName");

        List<String> nodeListContent = new NodeListContentExtractor().extract(nodeList);

        return nodeListContent;
    }

    private static class NodeListContentExtractor {

        public List<String> extract(NodeList nodeList) {

            // You can use the 'nodeList' and extract the content of each node.

            return null; // Return your content as a list of strings.
        }
    }
}
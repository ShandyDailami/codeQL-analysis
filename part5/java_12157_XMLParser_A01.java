import java.awt.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_12157_XMLParser_A01 {

    public static void main(String[] args) {
        parseXML("src/main/resources/sample.xml");
    }

    public static void parseXML(String fileName) {
        File file = new File(fileName);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document doc = builder.parse(file);
            doc.getDOCUMENT_NODE().normalize();

            Stack<String> tags = new Stack<>();
            List<String> output = new ArrayList<>();
            printTags(doc, tags, output);

            for (String str : output) {
                System.out.println(str);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTags(Document doc, Stack<String> tags, List<String> output) {
        NodeList nodes = doc.getElementsByTagName("*");
        for (int i = 0; i < nodes.getLength(); i++) {
            String text = nodes.item(i).getTextContent();
            if (text.isEmpty()) {
                tags.push("/" + tags.peek());
                output.add(tags.pop() + "/" + nodes.item(i).getNodeName());
            } else {
                tags.push("/" + tags.peek());
                output.add(tags.pop() + "/" + nodes.item(i).getNodeName() + "=\"" + text + "\"");
            }
        }
    }
}
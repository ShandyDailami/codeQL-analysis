import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.AccessControlException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_16263_XMLParser_A01 {
    private static Set<String> tagsFound = new HashSet<>();

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file.xml";
        String tagName = "tagName";

        try {
            parseXmlFile(xmlFilePath, tagName);
        } catch (AccessControlException | ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        printTagsFound();
    }

    private static void parseXmlFile(String xmlFilePath, String tagName) throws ParserConfigurationException, SAXException, IOException {
        FileInputStream fis = new FileInputStream(new File(xmlFilePath));

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        Document doc = dBuilder.parse(fis);

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName(tagName);

        for (int temp = 0; temp < nList.getLength(); temp++) {
            System.out.println("  Found tag: " + nList.item(temp).getNodeName());

            if (!tagsFound.contains(nList.item(temp).getNodeName())) {
                tagsFound.add(nList.item(temp).getNodeName());
            } else {
                throw new AccessControlException("Access to tag: " + nList.item(temp).getNodeName() + " is denied!");
            }
        }

        fis.close();
    }

    private static void printTagsFound() {
        System.out.println("\nTags found:");
        for (String tag : tagsFound) {
            System.out.println(tag);
        }
    }
}
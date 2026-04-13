import java.io.File;
import java.io.FileInputStream;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class java_06308_XMLParser_A07 {
    public static void main(String[] args) {
        // Create a new file object for the XML file
        File xmlFile = new File("your_file.xml");

        // Check if the file exists
        if (!xmlFile.exists()) {
            throw new InvalidParameterException("File not found.");
        }

        // Initialize a new DOMParser
        DOMParser parser = new DOMParser();

        try {
            // Parse the XML file
            parser.parse(new FileInputStream(xmlFile));

            // Get the document
            Document doc = parser.getDocument();

            // Get all element nodes
            NodeList nodes = doc.getElementsByTagName("*");

            // Iterate over all nodes
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                System.out.println("Element: " + element.getTagName());
            }
        } catch (Exception e) {
            System.out.println("Error parsing the XML file: " + e.getMessage());
        }
    }
}
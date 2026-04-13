import java.security.*;
import java.util.*;
import java.io.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;

public class java_01565_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        String xmlFile = "sample.xml"; // replace with your file
        parseXML(xmlFile);
    }

    public static void parseXML(String xmlFile) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        // We can use the following URI as a reference for security
        URI uri = new URI("http://www.w3.org/2001/XMLSchema-instance");
        SchemaFactory sFactory = SchemaFactory.newInstance(uri);
        Schema schema = sFactory.newSchema(new File("sample.xsd"));

        dBuilder.setSchema(schema);

        Document doc = dBuilder.parse(new File(xmlFile));

        // Start with 'xml.parsers.'
        // This is a basic parsing. In a real-world scenario, more complex parsing would be required.
        doc.getDocumentElement().normalize();

        System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("student");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\n  Student: " + temp + "  ");
            System.out.println("  First Name: " + getNodeValue(nNode.getAttributes().getNamedItem("firstName")));
            System.out.println("  Last Name: " + getNodeValue(nNode.getAttributes().getNamedItem("lastName")));
            System.out.println("  Age: " + getNodeValue(nNode.getAttributes().getNamedItem("age")));
        }
    }

    public static String getNodeValue(Node node) {
        if (node != null)
            return node.getNodeValue();
        return "";
    }
}
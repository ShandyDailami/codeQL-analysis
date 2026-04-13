import java.awt.*;
import java.util.*;
import java.lang.reflect.*;
import java.net.*;
import java.io.*;

public class java_26047_XMLParser_A03 {
    public static void main(String[] args) {
        String url = "http://www.w3schools.com/java/java_xmlparser.asp";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new URL(url).openStream());

        doc.getElementsByTagName("//a").item(0).appendChild(doc.createElement("b"));
        doc.getElementsByTagName("//a").item(1).appendChild(doc.createElement("b"));

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("out.xml"));

        transformer.transform(source, result);
    }
}
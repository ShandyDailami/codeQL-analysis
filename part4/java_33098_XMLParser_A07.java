import java.security.*;
import java.util.*;
import java.net.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_33098_XMLParser_A07 {

    public static void main(String[] args) {
        String urlStr = "http://www.w3schools.com/java/xml_http.asp";
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setRequestProperty("User-Agent",
                    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.78 Safari/535.1");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parseURL(urlStr);

            System.out.println("Document parsing is successful!");

            // Print XML data
            printDocument(doc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDocument(Document doc) {
        System.out.println("Document title : " + doc.getDocumentElement().getTagName());
        System.out.println("----------------------");

        NodeList nodeList = doc.getElementsByTagName("*");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.getNode(i);
            System.out.println("Node Name : " + node.getNodeName());
            System.out.println("Node Value : " + node.getTextContent());
            System.out.println("----------------------");
        }
    }
}
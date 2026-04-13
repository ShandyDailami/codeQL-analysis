// Include required libraries
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

public class java_02041_XMLParser_A03 {

    // Secure operation related to A03_Injection
    private String xmlData;

    public java_02041_XMLParser_A03(String xmlData) {
        this.xmlData = xmlData;
    }

    // Secure operation related to A03_Injection
    public String parseXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(xmlData);
            doc.normalize();

            return doc.toString();
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String xmlData = "<root><element>" +
                "<!-- A03_Injection -->" +
                "<script>alert('A03_Injection');</script>" +
                "</element></root>";
        SecureXMLParser parser = new SecureXMLParser(xmlData);
        System.out.println(parser.parseXML());
    }
}
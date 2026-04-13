import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00383_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFile = "example.xml";
        try {
            FileInputStream fis = new FileInputStream(new File(xmlFile));
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            String xml = parseXMLFile(doc);
            System.out.println(xml);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String parseXMLFile(Document document) {
        String xmlString = "";
        xmlString += "<?xml version=\"1.0\"?>\n";
        xmlString += "<root>\n";
        xmlString += xmlElement(document, document.getDocumentElement());
        xmlString += "</root>";
        return xmlString;
    }

    private static String xmlElement(Document document, org.w3c.dom.Element element) {
        String elementText = element.getFirstChild().getNodeValue();
        String elementName = element.getNodeName();
        return "<" + elementName + ">" + elementText + "</" + elementName + ">";
    }
}
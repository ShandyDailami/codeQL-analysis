import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class java_07560_XMLParser_A08 {
    public static void main(String[] args) {
        File file = new File("sample.xml");
        try {
            FileInputStream fis = new FileInputStream(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);
            doc.getDocumentElement().normalize();
            printTags(doc);
            String md5 = getMD5(doc);
            System.out.println("MD5: " + md5);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printTags(Document doc) {
        Element node = doc.getDocumentElement();
        printTag("", node);
    }

    private static void printTag(String indent, Element node) {
        System.out.println(indent + node.getTagName());
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.TEXT_NODE) {
                System.out.println(indent + "<text> " + child.getNodeValue() + " </text>");
            } else {
                printTag(indent + "  ", (Element) child);
            }
        }
    }

    private static String getMD5(Document doc) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String input = doc.getDocumentElement().toString();
        byte[] bytes = md.digest(input.getBytes());
        return Base64.getEncoder().encodeToString(bytes);
    }
}
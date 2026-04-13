import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_06446_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document doc = builder.parse(new FileInputStream("example.xml"));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("student");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Element element = (Element) nList.item(temp);

                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String id = element.getElementsByTagName("id").item(0).getTextContent();

                System.out.println("Name: " + name);
                System.out.println("ID: " + id);

                // Calculate MD5 hash of id
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(id.getBytes());
                byte[] digest = md.digest();

                // Convert it to hexadecimal format
                StringBuilder hexString = new StringBuilder();
                for (int i = 0; i < digest.length; i++) {
                    String hex = Integer.toHexString(0xff & digest[i]);
                    if(hex.length() == 1) hexString.append('0');
                    hexString.append(hex);
                }

                System.out.println("MD5 Hash: " + hexString.toString());

            }

        } catch (ParserConfigurationException | SAXException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
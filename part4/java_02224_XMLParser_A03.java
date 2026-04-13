import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_02224_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlFilePath = "sample.xml";
        parseXML(xmlFilePath);
    }

    public static void parseXML(String xmlFilePath) {
        File xmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = null;

        try (FileInputStream fis = new FileInputStream(xmlFile)) {
            doc = dBuilder.parse(fis);
            doc.getDoctype();
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        doc.getDocumentElement().normalize();

        NodeList nList = doc.getElementsByTagName("name");

        List<String> names = new ArrayList<>();

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("  Found name: " + nNode.getTextContent());
            names.add(nNode.getTextContent());
        }

        System.out.println("Found " + names.size() + " names.");

        // Place your security-sensitive operations here.
        // For example, check if the names contain SQL Injection attempts.
        // We'll use the SHA-256 message digest for this.
        checkForSQLInjectionAttacks(names);
    }

    private static void checkForSQLInjectionAttacks(List<String> names) {
        for (String name : names) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(name.getBytes());
                // If the hash is similar to a known SQL injection attack pattern, print a message.
                if (isSimilarToSQLInjectionAttackPattern(hash)) {
                    System.out.println("Detected SQL Injection attack: " + name);
                }
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean isSimilarToSQLInjectionAttackPattern(byte[] hash) {
        // This is a simple example and may not cover all cases.
        // You should replace this with a more sophisticated pattern detection.
        // In real-world applications, you would likely use a more advanced algorithm.
        return isSimilar(hash, "select * from users where username='test'");
    }

    private static boolean isSimilar(byte[] a, byte[] b) {
        if (a.length != b.length) {
            return false;
        }

        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result = a[i] ^ result;
        }

        return result == 0;
    }
}
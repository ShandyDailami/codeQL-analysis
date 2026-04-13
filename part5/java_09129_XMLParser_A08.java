import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_09129_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File xmlFile = new File("example.xml");

        if (!xmlFile.exists()) {
            System.out.println("XML file not found!");
            return;
        }

        Document doc = builder.parse(xmlFile);
        doc.getDocumentElement().normalize();

        System.out.println("XML file content: " + doc.getElements().toString());

        // Calculate the MD5 hash of the XML content
        MessageDigest md = MessageDigest.getInstance("MD5");
        FileInputStream fis = new FileInputStream(xmlFile);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) != -1) {
            md.update(buffer, 0, length);
        }
        fis.close();
        byte[] digest = md.digest();
        StringBuilder hexString = new StringBuilder();
        for (byte b : digest) {
            hexString.append(String.format("%02X", b));
        }
        System.out.println("MD5 Hash: " + hexString.toString());
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_35399_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path_to_your_file");
            FileInputStream fis = new FileInputStream(file);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = doc.getBytes();
            byte[] hash = md.digest(bytes);

            System.out.println(convertToHexString(hash));

            fis.close();

        } catch (ParserConfigurationException | SAXException | IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String convertToHexString(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (byte b : data) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
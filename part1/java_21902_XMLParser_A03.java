import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_21902_XMLParser_A03 {

    public static void main(String[] args) {
        String xmlString = readFileAsString("sample.xml");
        String encodedXml = encodeXmlString(xmlString);
        System.out.println(encodedXml);
    }

    public static String readFileAsString(String fileName) {
        String encoding = "UTF-8";
        File file = new File(fileName);
        long length = file.length();
        byte[] bytes = new byte[(int) length];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(bytes, encoding);
    }

    public static String encodeXmlString(String xmlString) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(xmlString.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
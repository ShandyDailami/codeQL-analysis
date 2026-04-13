import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_03282_XMLParser_A03 {

    public static void main(String[] args) {
        try {
            String xmlFilePath = "path_to_your_xml_file";
            String expectedMd5Hash = "expected_md5_hash";

            // Load the XML document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(getInputStream(xmlFilePath));

            // Verify if the MD5 hash of the XML document is the same as the expected one
            String md5Hash = getMd5Hash(doc);
            if (!md5Hash.equals(expectedMd5Hash)) {
                System.out.println("MD5 hash mismatch, aborting...");
                return;
            }

            System.out.println("XML parsing successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(String xmlFilePath) {
        try {
            FileInputStream fis = new FileInputStream(xmlFilePath);
            return fis;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String getMd5Hash(Document doc) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] byteArray = doc.getBytes(StandardCharsets.UTF_8);
            md.update(byteArray);

            byte[] digest = md.digest();
            return Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class java_29189_XMLParser_A03 {
    private String xmlFilePath;

    public java_29189_XMLParser_A03(String xmlFilePath) {
        this.xmlFilePath = xmlFilePath;
    }

    public void parseXML() {
        try {
            FileInputStream fis = new FileInputStream(new File(xmlFilePath));
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[1024];
            int length = 0;
            while ((length = fis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            byte[] digest = md.digest();
            String encodedString = Base64.getEncoder().encodeToString(digest);
            System.out.println("Digest: " + encodedString);

            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setEntityResolver(new CustomEntityResolver());
            reader.parse(new File(xmlFilePath));
        } catch (NoSuchAlgorithmException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new XMLParser("example.xml").parseXML();
    }
}
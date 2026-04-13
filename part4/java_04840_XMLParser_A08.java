import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_04840_XMLParser_A08 {

    public static void main(String[] args) throws Exception {
        String fileName = "sample.xml";
        File inputFile = new File(fileName);
        long length = inputFile.length();

        MessageDigest md = MessageDigest.getInstance("MD5");
        try (InputStream is = new FileInputStream(inputFile)) {
            md.update(is.readAllBytes());
            byte[] digest = md.digest();

            // Add code here to check if the MD5 of the file is the same as the stored MD5.
            // If not, set the integrity failure flag.
        } catch (NoSuchAlgorithmException | SAXException e) {
            e.printStackTrace();
        }
    }
}
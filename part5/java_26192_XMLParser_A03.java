import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_26192_XMLParser_A03 {

    public static void main(String[] args) throws SAXException, IOException, NoSuchAlgorithmException {
        // Load the file
        File file = new File("sample.xml");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
        fis.read(b);
        fis.close();

        // Encode the file for security
        String encodedFile = Base64.getEncoder().encodeToString(b);

        // Create a MessageDigest instance for hashing
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Hash the file
        byte[] thedigest = md.digest(encodedFile.getBytes());

        // Convert the hash to hex format
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < thedigest.length; i++) {
            sb.append(Integer.toString((thedigest[i] & 0xff) + 0x100, 16).substring(1));
        }
        String hash = sb.toString();

        // Now compare the hashes
        if(hash.equals("a1b2c3d4e5f6g7h8i9j0k1l2m3n4o5p6q7r8s9t0u1v2w3x4y5z6")) {
            System.out.println("File is hashed and matches!");
        } else {
            System.out.println("File is hashed but does not match!");
        }
    }
}
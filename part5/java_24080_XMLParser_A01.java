import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_24080_XMLParser_A01 {
    public static void main(String[] args) {
        try {
            parseXmlFile("data.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXmlFile(String fileName) throws IOException, NoSuchAlgorithmException {
        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);

        byte[] byteContent = new byte[fis.available()];
        fis.read(byteContent);
        fis.close();

        // Create MessageDigest instance for MD5
        MessageDigest md = MessageDigest.getInstance("MD5");

        // Add byte content to digest
        md.update(byteContent);

        byte[] digest = md.digest();

        // Convert the byte to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

        String messageDigestString = sb.toString();

        // Print the generated MD5 Message
        System.out.println("Message Digest in Hexadecimal format is: " + messageDigestString);
    }
}
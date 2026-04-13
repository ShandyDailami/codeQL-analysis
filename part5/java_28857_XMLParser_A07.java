import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_28857_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Create a DocumentBuilderFactory
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

            // Create a DocumentBuilder
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            // Parse the XML file
            Document doc = dBuilder.parse(getInputStream("test.xml", md));

            // TODO: Implement code here to parse and use the XML document

        } catch (ParserConfigurationException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static InputStream getInputStream(String fileName, MessageDigest md) throws NoSuchAlgorithmException, ParserConfigurationException {
        InputStream input = null;
        byte[] buffer = new byte[1024];
        int length = 0;

        try {
            input = new FileInputStream(fileName);

            while ((length = input.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }

            // Hash the MD5 checksum
            StringBuilder sb = new StringBuilder();
            for (byte b : md.digest()) {
                sb.append(String.format("%02x", b & 0xff));
            }

            return new String(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
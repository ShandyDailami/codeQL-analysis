import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_38251_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file name: ");
        String fileName = scanner.nextLine();

        try {
            InputStream inputStream = new FileInputStream(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(inputStream);

            // Perform security-sensitive operations
            String content = document.getElements().getItem(0).getChildNodes().item(0).getNodeValue();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(content.getBytes());
            StringBuilder hash = new StringBuilder();
            for (byte b : messageDigest) {
                hash.append(String.format("%02x", b));
            }
            String secureContent = hash.toString();

            System.out.println("Security-sensitive operation: " + secureContent);

            // Close the input stream
            inputStream.close();
        } catch (SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_27613_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            // Obtain input stream of the XML file.
            InputStream inputStream = new FileInputStream("input.xml");
            
            // Obtain a Document instance from the input stream.
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            Document document = documentBuilderFactory.newDocumentBuilder().parse(inputStream);
            
            // Perform security-sensitive operations.
            String fileContent = document.toString();
            String hashedContent = hashFileContent(fileContent);
            
            // Display the hashed content for security checks.
            System.out.println("Hashed content: " + hashedContent);
            
            // Close the input stream.
            inputStream.close();
        } catch (ParserConfigurationException | SAXException | CertificateException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    
    private static String hashFileContent(String content) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(content.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       
        }
        return null;
    }
}
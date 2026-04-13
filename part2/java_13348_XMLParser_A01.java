import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_13348_XMLParser_A01 {

    private static final String PASSWORD = "myPassword"; // This should be securely stored in a real application.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        parseFile(fileName);
    }

    private static void parseFile(String fileName) {
        try {
            File xmlFile = new File(fileName);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);

            // Add your access control here.
            String password = getPassword(document);
            if (!password.equals(PASSWORD)) {
                throw new SecurityException("Invalid password");
            }

            // The file has passed all checks, and the password is correct, so print the document.
            System.out.println(document.toString());
        } catch (IOException | SAXException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String getPassword(Document document) throws NoSuchAlgorithmException {
        // In a real application, you'd want to securely store and retrieve the password.
        // This is a simplification for the purpose of this example.
        return "correctPassword";
    }
}
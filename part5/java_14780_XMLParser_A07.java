import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_14780_XMLParser_A07 {
    public static void main(String[] args) {
        try {
            parseXML("src/main/resources/userdata.xml", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String fileName, String password) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse(ClassLoader.getSystemResourceAsStream(fileName));

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        XPathExpression exprUsername = xpath.compile("//username");
        XPathExpression exprPassword = xpath.compile("//password");

        String username = xpath.evaluate(exprUsername, doc);
        String xmlPassword = xpath.evaluate(exprPassword, doc);

        // Verify password with real hash function or stored password in KeyStore
        verifyPassword(password, xmlPassword);
    }

    private static void verifyPassword(String userPassword, String storedPassword) {
        // Your security-sensitive operation to verify password goes here
        // For the sake of simplicity, we'll just check if the passwords match
        if (userPassword.equals(storedPassword)) {
            System.out.println("Authentication successful");
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}
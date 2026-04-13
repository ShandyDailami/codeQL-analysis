import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Base64;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_31712_XMLParser_A07 {

    public static void main(String[] args) throws Exception {
        // create a document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // create a new document
        Document doc = builder.newDocument();

        // add an element to the document
        doc.createElement("element");

        // check if auth is successful
        Principal user = new Principal("user") {
            public String getName() {
                return "user";
            }
        };

        if (!validateUser(user)) {
            throw new Exception("Authentication failed.");
        }

        // add the document to the dom
        doc.appendChild(doc.newChildNodes());
    }

    private static boolean validateUser(Principal user) {
        try {
            String userInfo = user.getName() + ":" + getMD5("password");
            String base64UserInfo = new String(Base64.getEncoder().encode(userInfo.getBytes()));

            return base64UserInfo.equals("Basic YWJjZGVmZw==");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
       
        }
        return false;
    }

    private static String getMD5(String input) {
        String md5 = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(input.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
            md5 = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return md5;
    }
}
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_34369_XMLParser_A07 {

    private static final String PASSWORD = "securePassword";

    public static void main(String[] args) {
        try {
            File file = new File("pathToYourFile.xml");
            FileInputStream fis = new FileInputStream(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fis);
            Iterator<?> iterator = doc.getElementsByTagName("*");
            while (iterator.hasNext()) {
                iterator = doc.getElementsByTagName("*");
                parseNode(iterator);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void parseNode(Iterator<?> iterator) {
        if (iterator.hasNext()) {
            iterator = iterator.next();
            if (iterator.getNodeType() == Node.TEXT_NODE && ((TextNode) iterator).getNodeValue().equals(PASSWORD)) {
                throw new SecurityException("Password found in XML file!");
            }
            iterator = iterator.next();
            while (iterator.getNodeType() == Node.COMMENT_NODE) {
                iterator = iterator.next();
            }
            parseNode(iterator);
        }
    }

    public static String getMd5(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(s.getBytes());
        return bytesToHex(digest);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }
}
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.util.Base64;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.KeySelector;
import javax.xml.crypto.CryptoError;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchCipherException;
import javax.crypto.spec.SecretKeySpec;

public class java_10630_XMLParser_A07 {

    public static void main(String[] args) {
        try {
            parseXmlWithCrypto();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeyException | NoSuchCipherException e) {
            e.printStackTrace();
        }
    }

    private static void parseXmlWithCrypto() throws IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchCipherException {
        FileInputStream fis = new FileInputStream("path_to_your_file.xml"); // replace with your xml file path
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fis);

        Key key = getKeyFromXml(doc); // replace with your xml key

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        CryptoError error = cipher.doFinal(doc.getElementsByTagName("tag_name").item(0).getTextContent().getBytes(), true);

        if(error != null){
            System.out.println("Crypto Error: " + error.getMessage());
        } else {
            System.out.println("Decrypted XML: " + doc.getElementsByTagName("tag_name").item(0).getTextContent());
        }

        fis.close();
    }

    private static Key getKeyFromXml(Document doc) throws NoSuchAlgorithmException, InvalidKeyException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(doc.getElementsByTagName("key_name").item(0).getTextContent().getBytes());
        return new SecretKeySpec(thedigest, "AES");
    }
}
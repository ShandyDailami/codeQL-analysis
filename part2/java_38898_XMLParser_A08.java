import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchCipherException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class java_38898_XMLParser_A08 {

    private PrivateKey privateKey;
    private PublicKey publicKey;

    public java_38898_XMLParser_A08(PrivateKey privateKey, PublicKey publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public void parseAndDecryptXml(String xmlFilePath) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {
            Document document = builder.parse(new File(xmlFilePath));

            NodeList nameList = document.getElementsByTagName("name");
            NodeList ageList = document.getElementsByTagName("age");

            for (int i = 0; i < nameList.getLength(); i++) {
                String name = nameList.item(i).getTextContent();
                String age = ageList.item(i).getTextContent();

                System.out.println("Name: " + name + ", Age: " + age);

                this.decryptAndPrint(name, age);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void decryptAndPrint(String name, String age) {
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("RSA");
            cipher.setPrivateKey(privateKey);

            String decryptedAge = cipher.decryptAndPrivateDecrypt(age, true);
            System.out.println("Decrypted Age: " + decryptedAge);
        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | NoSuchCipherException e) {
            e.printStackTrace();
        }
    }
}
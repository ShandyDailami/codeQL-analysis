import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class java_17631_XMLParser_A08 {
    private static final String SHA1 = "SHA-1";
    private static final String MD5 = "MD5";

    public void parseFile(String fileName, String hashAlgorithm) throws DigestException, ParserConfigurationException, SAXException, NoSuchAlgorithmException, IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new IllegalArgumentException("File " + fileName + " does not exist");
        }

        MessageDigest md;
        if (hashAlgorithm.equalsIgnoreCase(SHA1)) {
            md = MessageDigest.getInstance("SHA-1");
        } else if (hashAlgorithm.equalsIgnoreCase(MD5)) {
            md = MessageDigest.getInstance("MD5");
        } else {
            throw new IllegalArgumentException("Hash algorithm " + hashAlgorithm + " is not supported");
        }

        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = fis.read(buffer)) > 0) {
            md.update(buffer, 0, length);
        }
        byte[] digest = md.digest();

        if (hashAlgorithm.equalsIgnoreCase(SHA1)) {
            System.out.println(new String(digest, "UTF-8"));
        } else {
            // for MD5, print hexadecimal
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            System.out.println(sb.toString());
        }

        fis.close();
    }

    public static void main(String[] args) throws DigestException, ParserConfigurationException, SAXException, NoSuchAlgorithmException, IOException {
        XMLParser parser = new XMLParser();
        parser.parseFile("sample.xml", MD5);
    }
}
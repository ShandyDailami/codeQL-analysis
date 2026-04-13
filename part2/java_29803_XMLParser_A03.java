import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_29803_XMLParser_A03 {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, NoSuchAlgorithmException {
        // Create an instance of MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Add file to MessageDigest
        md.update(getFileAsBytes("sample.zip"));

        // Get the hash's bytes
        byte[] bytes = md.digest();

        // Convert bytes to hexadecimal string
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        String generatedHash = sb.toString();

        // Display hash
        System.out.println("SHA-256 Hash: " + generatedHash);

        // Create an instance of ZipInputStream
        ZipInputStream zis = new ZipInputStream(new FileInputStream("sample.zip"));

        // Get the zip entry
        ZipEntry entry = zis.getNextEntry();

        // Read file and print
        while (entry != null) {
            System.out.println("Reading entry: " + entry.getName());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zis.read(buffer)) > 0) {
                System.out.write(buffer, 0, length);
            }
            zis.closeEntry();
            entry = zis.getNextEntry();
        }
        zis.close();
    }

    public static byte[] getFileAsBytes(String fileName) throws Exception {
        File file = new File(fileName);
        long length = file.length();
        byte[] bytes = new byte[(int)length];
        FileInputStream fis = new FileInputStream(file);
        fis.read(bytes);
        fis.close();
        return bytes;
    }
}
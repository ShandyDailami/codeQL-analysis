import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class java_32561_XMLParser_A07 {
    private Map<String, String> encryptedFileMap = new HashMap<>();

    public void addEncryptedFile(String fileName, String encryptedData) {
        encryptedFileMap.put(fileName, encryptedData);
    }

    public String decryptFile(String fileName) throws Exception {
        String decryptedData = encryptedFileMap.get(fileName);
        decryptedData = new String(Base64.getDecoder().decode(decryptedData));
        return decryptedData;
    }

    public void parseXML(String filePath) throws Exception {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[8192];
        int length = -1;
        while ((length = fis.read(buffer)) != -1) {
            md.update(buffer, 0, length);
        }
        byte[] digest = md.digest();
        String encryptedDigest = Base64.getEncoder().encodeToString(digest);
        fis.close();

        addEncryptedFile(filePath, encryptedDigest);

        try (ZipFile zipFile = new ZipFile(filePath)) {
            for (ZipEntry entry : zipFile.getEntries()) {
                if (entry.isDirectory()) {
                    continue;
                }
                byte[] data = new byte[(int) entry.getCompressedSize()];
                zipFile.readEntry(entry, data);
                String decryptedData = decryptData(data);
                // continue parsing here...
            }
        }
    }

    public String decryptData(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data);
        byte[] digest = md.digest();
        return Base64.getEncoder().encodeToString(digest);
    }

    public static void main(String[] args) throws Exception {
        SecuritySensitiveXMLParser parser = new SecuritySensitiveXMLParser();
        parser.addEncryptedFile("file1.xml", "encryptedData1");
        parser.addEncryptedFile("file2.xml", "encryptedData2");

        String filePath = "path_to_your_xml_file.zip";
        parser.parseXML(filePath);

        for (Map.Entry<String, String> entry : parser.encryptedFileMap.entrySet()) {
            System.out.println("Decrypted data for file " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
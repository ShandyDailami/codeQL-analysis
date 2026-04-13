import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class java_06625_XMLParser_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path of the ZIP file: ");
        String zipFilePath = scanner.next();
        System.out.print("Enter the expected MD5 hash: ");
        String expectedHash = scanner.next();
        scanner.close();

        String generatedHash = getMD5HashFromZip(zipFilePath);

        if (generatedHash.equals(expectedHash)) {
            System.out.println("The integrity of the XML file is correct.");
        } else {
            System.out.println("A security-sensitive operation related to integrity failure has occurred.");
        }
    }

    private static String getMD5HashFromZip(String zipFilePath) {
        try {
            byte[] buffer = new byte[1024];
            int bytesCount;
            MessageDigest md = MessageDigest.getInstance("MD5");
            ZipInputStream zis = new ZipInputStream(new FileInputStream(new File(zipFilePath)));
            ZipEntry entry = zis.getNextEntry();
            while ((bytesCount = zis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesCount);
            }
            zis.closeEntry();
            byte[] hash = md.digest();
            return Arrays.toString(hash);
        } catch (Exception e) {
            System.out.println("An error occurred while getting the MD5 hash from the zip file.");
            e.printStackTrace();
            return null;
        }
    }
}
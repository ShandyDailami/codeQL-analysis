import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class java_16229_XMLParser_A03 {

    public static void main(String[] args) throws Exception {
        // Load XML file from a ZIP file
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream("yourfile.zip"));
        ZipEntry entry = zis.getNextEntry();
        while (entry != null) {
            if (entry.getName().endsWith(".xml")) {
                int length;
                while ((length = zis.read(buffer)) > 0) {
                    System.out.println(new String(buffer, "UTF-8"));
                }
            }
            entry = zis.getNextEntry();
        }
        zis.closeEntry();
        zis.close();
    }

}
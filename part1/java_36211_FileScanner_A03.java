import java.io.File;
import java.io.IOException;
import java.security.CodeSigner;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class java_36211_FileScanner_A03 {

    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        scanDirectory(new File(directoryPath));
    }

    public static void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    printFileDetails(file);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("Absolute path: " + file.getAbsolutePath());
        System.out.println("File size: " + file.length() + " bytes");
        try {
            Certificate[] certificates = file.getOwnerPrincipal().getCertificateChain();
            if (certificates != null) {
                System.out.println("File's owner: " + certificates[0].getIssuerDN());
            }
        } catch (CertificateException e) {
            System.out.println("Unable to get certificate chain.");
        }
        System.out.println("----------------------------------------");
    }

}
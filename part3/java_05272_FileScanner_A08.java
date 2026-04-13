import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class java_05272_FileScanner_A08 {
    public static void main(String[] args) {
        String directory = "path/to/directory"; // Replace with your directory
        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        FileReader reader = new FileReader(file);
                        MessageDigest md = MessageDigest.getInstance("SHA-256");
                        byte[] fileContent = new byte[1024];
                        int length;
                        while ((length = reader.read(fileContent)) > 0) {
                            md.update(fileContent, 0, length);
                        }
                        byte[] digest = md.digest();
                        BigInteger no = new BigInteger(1, digest);
                        String hashtext = no.toString(16);

                        // Add your security-sensitive operation here
                        if (hashtext.length() < 8) {
                            System.out.println("File is possibly malicious: " + file.getName());
                        }
                    } catch (NoSuchAlgorithmException | IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
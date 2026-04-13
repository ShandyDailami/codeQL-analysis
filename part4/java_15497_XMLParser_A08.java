import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

public class java_15497_XMLParser_A08 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // Create a new File object
        File file = new File("sample.xml");

        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist");
            return;
        }

        // Get the file name
        String fileName = file.getName();

        // Get the file path
        String filePath = file.getPath();

        // Get the file absolute path
        String fileAbsPath = file.getAbsolutePath();

        // Get the file URI
        String fileUri = file.toURI().toString();

        // Check if the file is a directory
        if (file.isDirectory()) {
            System.out.println("The file is a directory");
            return;
        }

        // Get the file size in bytes
        long length = file.length();

        // Get the file size in kilobytes
        double sizeInKb = length / 1024.0;

        // Get the file size in megabytes
        double sizeInMb = sizeInKb / 1024.0;

        // Get the file size in gigabytes
        double sizeInGb = sizeInMb / 1024.0;

        System.out.println("File name: " + fileName);
        System.out.println("File path: " + filePath);
        System.out.println("File absolute path: " + fileAbsPath);
        System.out.println("File URI: " + fileUri);
        System.out.println("File size in bytes: " + length);
        System.out.println("File size in kilobytes: " + sizeInKb);
        System.out.println("File size in megabytes: " + sizeInMb);
        System.out.println("File size in gigabytes: " + sizeInGb);
    }
}
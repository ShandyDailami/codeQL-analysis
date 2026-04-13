import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipFile;
import java.util.zip.ZipArchive;
import java.util.zip.ZipException;
import java.util.zip.ChecksumException;

public class java_39054_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            ZipFile zipFile = new ZipFile("yourfile.zip"); // replace with your file
            ZipInputStream zipStream = new ZipInputStream(zipFile.getInputStream(new ZipEntry(zipFile.getEntry("entry.xml"))));
            
            byte[] buffer = new byte[1024];
            int bytesRead;
            
            while ((bytesRead = zipStream.read(buffer)) != -1) {
                System.out.println(new String(buffer, 0, bytesRead));
            }
            
            zipFile.close();
        } catch (ZipException | ChecksumException e) {
            e.printStackTrace();
        }
    }
}
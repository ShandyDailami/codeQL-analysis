import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class java_00855_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            parseXML("test.zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void parseXML(String file) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        try (FileInputStream fis = new FileInputStream(file);
             DigestInputStream dis = new DigestInputStream(fis, MessageDigest.getInstance("SHA-256"))) {

            ZipInputStream zis = new ZipInputStream(dis);
            ZipEntry entry = zis.getNextEntry();

            while (entry != null) {
                if (entry.getName().equals("file.xml")) {
                    Document document = builder.parse(zis);
                    // Perform security-sensitive operations related to A08_IntegrityFailure here
                    // For example, print out the document's content
                    System.out.println(document.getDocumentElement().getNodeName());
                }
                entry = zis.getNextEntry();
            }
            zis.closeEntry();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
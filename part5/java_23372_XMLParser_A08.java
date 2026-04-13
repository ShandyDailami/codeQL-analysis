import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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

public class java_23372_XMLParser_A08 {

    public static void main(String[] args) {
        String xmlFilePath = "path/to/your/xml/file";
        String zipFilePath = "path/to/your/zip/file";

        try {
            parseXMLFromFile(xmlFilePath);
            validateIntegrityFailure(zipFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println("Parser configuration exception: " + e.getMessage());
        } catch (SAXException e) {
            System.out.println("SAX exception: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm exception: " + e.getMessage());
        }
    }

    private static void parseXMLFromFile(String filePath) throws FileNotFoundException, ParserConfigurationException, SAXException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fis);

        // Print the parsed XML
        System.out.println("Parsed XML: " + document.getDocumentElement().getTagName());
    }

    private static void validateIntegrityFailure(String filePath) throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] buffer = new byte[1024];
        ZipInputStream zis = new ZipInputStream(new FileInputStream(filePath));
        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {
            int length;
            while ((length = zis.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            zis.closeEntry();

            String computedChecksum = Base64.getEncoder().encodeToString(md.digest());

            // Compare the computed checksum with the one stored in the zip file
            // If they don't match, an integrity failure has occurred
            // (Replace this with your actual checksum comparison logic)

            System.out.println("Computed Checksum: " + computedChecksum);
        }

        zis.close();
    }
}
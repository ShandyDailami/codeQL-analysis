import java.io.*;
import java.security.*;
import java.util.*;
import java.xml.parsers.*;
import java.xml.transform.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class java_07927_XMLParser_A08 {
    public static void main(String[] args) throws Exception {
        String xmlFile = "/path/to/your/xml/file.xml"; // Provide your XML file path
        FileInputStream fis = new FileInputStream(xmlFile);

        // Create a new document instance from an XML file
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fis);

        // Get the root element
        doc.getDocumentElement().normalize();

        // Get the value of the element
        String value = doc.getElements().getItem(0).getChildNodes().item(0).getNodeValue();

        // Print the value
        System.out.println("Value: " + value);

        // Verify the integrity of the XML file
        verifyIntegrity(xmlFile, value);
    }

    // Function to verify the integrity of the XML file
    public static void verifyIntegrity(String filePath, String value) {
        try {
            // Verify the XML file by calculating its MD5 hash
            MessageDigest md = MessageDigest.getInstance("MD5");
            File file = new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            // Read the file content into byte array
            byte[] byteArray = new byte[1024];
            int lengthRead = 0;
            while ((lengthRead = fis.read(byteArray)) > 0) {
                md.update(byteArray, 0, lengthRead);
            }
            byte[] mdBytes = md.digest();

            // Convert byte array to hexadecimal
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mdBytes.length; i++) {
                sb.append(Integer.toString((mdBytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            // Compare the calculated MD5 hash with the value from the file
            if (sb.toString().equals(value)) {
                System.out.println("Integrity verified successfully!");
            } else {
                System.out.println("Integrity verification failed!");
            }
        } catch (Exception e) {
            System.out.println("Error verifying integrity: " + e.getMessage());
        }
    }
}
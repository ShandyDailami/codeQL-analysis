import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class java_18914_XMLParser_A08 {

    public static void main(String[] args) {
        try {
            // Create an input stream for the XML file
            InputStream is = new BufferedInputStream(new FileInputStream("src/main/resources/example.xml"));

            // Create a XMLDecoder to read the XML file
            XMLDecoder xd = new XMLDecoder(is);

            // Parse the XML file
            Object obj = xd.readObject();

            // Print the parsed object
            System.out.println(obj);

            // Close the XMLDecoder
            xd.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
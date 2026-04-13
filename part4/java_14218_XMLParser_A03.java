import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_14218_XMLParser_A03 {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/sample.xml");
            XMLDecoder decoder = new XMLDecoder(fis);

            // Start with 'decode' and remove comments
            // You can add more operations to the decoder object as needed
            // For example, if you wanted to decode and store all the user data in a list, you could do:
            // User[] users = (User[]) decoder.readObject();
            // Then you can manipulate the data as needed

            // Close the decoder when done
            decoder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
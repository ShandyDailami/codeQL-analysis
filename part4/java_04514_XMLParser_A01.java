import java.util.XML;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class java_04514_XMLParser_A01 {
    public static void main(String[] args) {
        String inputFile = "input.xml";

        XML.Parser parser = new XML.Parser();

        try {
            parser.parse(new FileInputStream(inputFile), (char[])null, true);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error parsing the file: " + e.getMessage());
        }
    }
}
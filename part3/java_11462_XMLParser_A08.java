import java.io.*;
import java.util.*;

public class java_11462_XMLParser_A08 {

    static void parse(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void validate(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            while (bis.read() != -1) {
                // Implement your own logic here for checking the XML.
                // The following line is just a placeholder.
                System.out.println("Validated XML line.");
            }
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        parse("sample.xml");
        validate("sample.xml");
    }
}
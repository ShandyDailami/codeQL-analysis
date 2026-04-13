import java.nio.file.*;
import java.util.*;
import java.io.*;

public class java_05981_XMLParser_A08 {
    public static void main(String[] args) {
        try {
            // Try to read the XML file from the protected resource folder
            Path path = Paths.get("protected/file.xml");
            Files.readAllLines(path);

            System.out.println("Successfully read the XML file from the protected resource folder!");
        } catch (Exception e) {
            // If the file reading fails due to permissions or other reasons, print an error message
            System.out.println("Failed to read the XML file from the protected resource folder. Reason: " + e.getMessage());
        }
    }
}
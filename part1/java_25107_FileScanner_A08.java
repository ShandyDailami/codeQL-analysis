import java.io.*;
import java.security.*;

public class java_25107_FileScanner_A08 {
    public static void main(String[] args) {
        String directory1 = "/path/to/directory1"; // replace with actual directory
        String directory2 = "/path/to/directory2"; // replace with actual directory

        try {
            // Scan files in directory1
            File file = new File(directory1);
            if (file.exists()) {
                FileScanner fileScanner = new FileScanner(file);
                for (File f : fileScanner.getFiles(".*\\.txt")) {
                    System.out.println("Reading file: " + f.getPath());

                    // Read file
                    FileReader reader = new FileReader(f);
                    BufferedReader br = new BufferedReader(reader);
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                   
                        // Write to directory2
                        FileWriter writer = new FileWriter(directory2 + "/" + f.getName());
                        writer.write(line);
                        writer.close();
                    }
                    br.close();
                }
            } else {
                System.out.println("Directory does not exist.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
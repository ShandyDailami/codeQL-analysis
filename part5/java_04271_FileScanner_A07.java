import java.io.*;

public class java_04271_FileScanner_A07 {
    public static void main(String[] args) {
        File file = new File("src/main/resources/A07_AuthFailure.txt");
        FileScanner scanner = new FileScanner(file);
        
        try {
            scanner.open();
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(line.contains("DANGEROUS_ACTION")) {
                    System.out.println("AuthFailure: " + line);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
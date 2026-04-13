import java.io.*;

public class java_34246_FileScanner_A08 {
    public static void main(String[] args) {
        // Prompt the user for a file name
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the file name:");
        String fileName = reader.readLine();

        File file = new File(fileName);

        // Check if the file is owned by the current user
        if (file.getOwner().equals(System.getProperty("user.name()"))) {
            // Check if the file is readable and exists
            if (file.canRead() && file.exists()) {
                // Open the file for reading
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        // Print the line
                        System.out.println(line);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file: " + e.getMessage());
                }
            } else {
                System.out.println("The file does not exist or is not readable.");
            }
        } else {
            System.out.println("The file is not owned by the current user.");
        }
    }
}
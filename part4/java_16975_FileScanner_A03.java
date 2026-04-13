import java.io.*;

public class java_16975_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // Specify your directory path here
        String fileExtension = "txt"; // Specify the file extension you want to scan for (like .txt, .jpg, etc.)

        File dir = new File(directory);

        File[] listOfFiles = dir.listFiles(file -> {
            if (file.isFile() && file.getName().endsWith(fileExtension)) {
                return checkFileForSecurityInjection(file);
            }
            return false;
        });

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                System.out.println("File found: " + file.getName());
                // Here you can implement your own code to handle the file if necessary
            }
        }
    }

    private static boolean checkFileForSecurityInjection(File file) {
        try {
            // Read file content
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Check for security-related operations here, like checking for SQL injection or XSS attacks
                // For now, we're just checking if the line contains a specific substring
                if (line.contains("injection")) {
                    System.out.println("Security injection found in file: " + file.getName());
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
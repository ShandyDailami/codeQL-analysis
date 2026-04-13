import java.io.*;

public class java_03011_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";
        String integrityFailureFilePath = "/path/to/integrity_failure_file";

        try {
            // Scan the directory for integrity failure files
            File integrityFailureDirectory = new File(directoryPath);
            File[] integrityFailureFiles = integrityFailureDirectory.listFiles();

            // Scan each file in the directory
            for (File file : integrityFailureFiles) {
                if (file.getName().endsWith(".txt") && !file.isHidden()) {
                    // Read the file
                    FileReader fileReader = new FileReader(file);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        // Do some operation with the line
                        // Here, we're just printing it out
                        System.out.println(line);
                   
                        // Check if the line is an integrity failure
                        if (line.equals("INTEGRITY_FAILURE")) {
                            // Handle integrity failure
                            handleIntegrityFailure(file);
                        }
                    }

                    // Close the reader
                    bufferedReader.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleIntegrityFailure(File file) {
        // Handle the integrity failure here
        System.out.println("Integrity failure detected in file: " + file.getPath());
        // You can also log the failure or notify the system admin
    }
}
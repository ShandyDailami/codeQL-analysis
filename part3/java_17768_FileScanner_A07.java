import java.io.*;

public class java_17768_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("."); // Use current directory
        String fileName = "authFailure";
        String fileExtension = ".txt";

        File[] foundFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension) && name.contains(fileName));

        if (foundFiles != null) {
            for (File file : foundFiles) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                   
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No files found with name " + fileName + " and extension " + fileExtension);
        }
    }
}
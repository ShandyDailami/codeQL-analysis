import java.io.*;

public class java_28077_FileScanner_A01 {

    public static void main(String[] args) {
        File directory = new File("C:\\Users\\YourDirectoryPath\\");

        try (FileScanner scanner = new FileScanner(directory)) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.getName().endsWith(".txt")) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains("password")) {
                                System.out.println("Security breach detected in file: " + file.getName());
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
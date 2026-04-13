import java.io.*;

public class java_12774_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/directory");
            File[] listOfFiles = file.listFiles();

            for (File listOfFile : listOfFiles) {
                if (listOfFile.isFile() && listOfFile.canRead()) {
                    System.out.println("File name: " + listOfFile.getName());
                    System.out.println("Absolute path: " + listOfFile.getAbsolutePath());
                    System.out.println("Last modified: " + listOfFile.lastModified());

                    // Simulating security-sensitive operations
                    if (listOfFile.getName().endsWith(".txt")) {
                        FileReader fileReader = new FileReader(listOfFile);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);

                        String line;
                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("Content: " + line);
                        }
                        bufferedReader.close();
                    }
                } else if (listOfFile.isDirectory()) {
                    System.out.println("Directory name: " + listOfFile.getName());
                    System.out.println("Absolute path: " + listOfFile.getAbsolutePath());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
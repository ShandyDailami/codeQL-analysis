import java.io.*;

public class java_04868_FileScanner_A03 {
    public static void main(String[] args) {
        String directory = "/path/to/directory"; // replace with your directory
        String extension = ".txt"; // replace with your file extension

        File dir = new File(directory);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(extension)) {
                    printFileDetails(file);
                }
            }
        } else {
            System.out.println("No such directory!");
        }
    }

    private static void printFileDetails(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
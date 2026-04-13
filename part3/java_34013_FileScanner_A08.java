import java.io.*;

public class java_34013_FileScanner_A08 {

    private File file;

    public java_34013_FileScanner_A08(String filePath) {
        this.file = new File(filePath);
    }

    public void scanFile() {
        try {
            if (file.exists()) {
                FileReader reader = new FileReader(file);

                int data;
                while ((data = reader.read()) != -1) {
                    if (data >= 48 && data <= 57) {
                        System.out.println("Integrity failure detected at byte " + data);
                    }
                }

                reader.close();
            } else {
                System.out.println("File not found!");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new MinimalistFileScanner("path_to_your_file").scanFile();
    }
}
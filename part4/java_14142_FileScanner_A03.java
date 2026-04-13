import java.io.*;

public class java_14142_FileScanner_A03 {
    private String targetDir;

    public java_14142_FileScanner_A03(String targetDir) {
        this.targetDir = targetDir;
    }

    public void scan(String fileName) throws IOException {
        File targetFile = new File(targetDir + "/" + fileName);
        if (targetFile.exists()) {
            System.out.println("File exists: " + targetFile.getAbsolutePath());
        } else {
            System.out.println("File does not exist: " + targetFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) throws IOException {
        new FileScanner("./src/main/resources").scan("test.txt");
    }
}
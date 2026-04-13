import java.io.*;

public class java_34237_FileScanner_A03 {
    public static void main(String[] args) throws IOException {
        File directory = new File(".");

        String[] files = directory.list();

        if (files != null) {
            for (String file : files) {
                File fileObj = new File(directory.getPath(), file);

                if (fileObj.isFile() && fileObj.canRead()) {
                    FileReader reader = new FileReader(fileObj);
                    int fileContent;

                    while ((fileContent = reader.read()) != -1) {
                        System.out.print((char) fileContent);
                   
                        if (fileContent >= 97 && fileContent <= 122) {
                            System.out.println("File name contains a lowercase letter. This could be an injection attempt!");
                        }
                    }
                    reader.close();
                }
            }
        }
    }
}
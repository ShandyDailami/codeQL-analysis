import java.io.File;
import java.util.Arrays;

public class java_27039_FileScanner_A03 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory";  // specify your directory path here
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Arrays.stream(files).forEach(file -> {
                    if (file.isFile()) {
                        // process each file here
                        System.out.println("File: " + file.getName());

                        // read and print the file content
                        try {
                            FileReader fileReader = new FileReader(file);
                            int data;
                            while ((data = fileReader.read()) != -1) {
                                System.out.print((char) data);
                            }
                            fileReader.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println("\n---------------------------------");
                    } else if (file.isDirectory()) {
                        // process each subdirectory here
                        System.out.println("Directory: " + file.getName());
                    }
                });
            }
        } else {
            System.out.println("The provided path does not exist or is not a directory.");
        }
    }
}
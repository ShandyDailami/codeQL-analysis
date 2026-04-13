import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_00972_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();
        List<File> fileList = new ArrayList<>();
        getFileList(new File(directory), fileList);

        for (File file : fileList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath() + "/");
                getFileList(file, fileList);
            }
        }
    }

    private static void getFileList(File file, List<File> fileList) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                fileList.add(f);
            }
        }
    }
}
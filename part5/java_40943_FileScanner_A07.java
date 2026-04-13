import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class java_40943_FileScanner_A07 extends Application {

    private File rootDirectory;
    private Button scanButton;
    private VBox root;

    @Override
    public void start(Stage primaryStage) {
        rootDirectory = new File(".");
        root = new VBox();
        scanButton = new Button("Scan Directory");
        scanButton.setOnMouseClicked(e -> scanDirectory(rootDirectory));
        root.getChildren().add(scanButton);
        primaryStage.setScene(new Scene(root, 300, 200));
        primaryStage.show();
    }

    private void scanDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    scanDirectory(file);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
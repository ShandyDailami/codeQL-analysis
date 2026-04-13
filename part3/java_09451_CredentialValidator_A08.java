import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class java_09451_CredentialValidator_A08 extends Application {

    // Overriding the validate method from CredentialValidator interface
    @Override
    public void validate(SSLSocket socket, String targetHost, SSLSession session) {
        try {
            X509Certificate[] chain = session.getSessionChain();
            // For simplicity, let's just display the first cert
            System.out.println("Certificate in certificate chain: " + chain[0].toString());
        } catch (SSLPeerUnverifiedException e) {
            // handle case when peer certificate is not verified
            System.out.println("Peer certificate not verified");
        } catch (CertificateException e) {
            // handle case when certificate is not valid
            System.out.println("Certificate is not valid");
        }
    }

    // Main method
    public static void main(String[] args) {
        launch(args);
    }

    // Overriding the start method from Application class
    @Override
    public void start(Stage primaryStage) {
        // Creating a VBox to hold our controls
        VBox vbox = new VBox();

        // Adding controls to the VBox
        vbox.getChildren().addAll(...);

        // Creating a Scene and adding the VBox to the Scene
        Scene scene = new Scene(vbox, 400, 400);

        // Setting the scene to the stage
        primaryStage.setScene(scene);

        // Setting the title of the stage
        primaryStage.setTitle("Credential Validator");

        // Showing the stage
        primaryStage.show();
    }
}
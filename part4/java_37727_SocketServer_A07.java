import java.io.*;
import java.net.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmConstraints.CipherConstraints;

public class java_37727_SocketServer_A07 {
    private static SecretKey secretKey = new SecretKeySpec("Key4321".getBytes(), "AES");

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readLine();
            System.out.println("Received: " + clientMessage);

            String responseMessage = "Welcome " + clientMessage;
            out.writeBytes(responseMessage + "\n");
            System.out.println("Sent: " + responseMessage);

            socket.close();
        }
    }
}
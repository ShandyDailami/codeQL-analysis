import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_10880_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        // Step 1: Initialize server
        ServerSocket serverSocket = null;
        try {
            serverSocket = (ServerSocket) new SSLServerSocket(5000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Server Started...");

        // Step 2: Accept incoming connections
        while (true) {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client Connected...");

                // Step 3: Communicate with client
                OutputStream outputStream = sslSocket.getOutputStream();
                Scanner scanner = new Scanner(System.in);
                StringBuilder builder = new StringBuilder();
                while (true) {
                    String msg = scanner.nextLine();
                    if (msg.equals("exit")) break;
                    builder.append(msg).append(" ");
                }
                String response = builder.toString();
                outputStream.write(response.getBytes());
                sslSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
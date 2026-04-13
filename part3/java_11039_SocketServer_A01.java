import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11039_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server is running and waiting for client's request...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                OutputStream outputStream = socket.getOutputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                String message = reader.readLine();
                System.out.println("Received message: " + message);

                String response = "Server response: " + message;
                outputStream.write(response.getBytes());

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
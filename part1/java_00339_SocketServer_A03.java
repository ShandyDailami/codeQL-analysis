import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_00339_SocketServer_A03 {

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running and waiting for client connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client is connected.");

        OutputStream outputStream = socket.getOutputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = reader.readLine();
        System.out.println("Received message: " + message);

        String response = "Hello, client!";
        outputStream.write(response.getBytes());
        System.out.println("Sent response: " + response);

        socket.close();
        serverSocket.close();
    }
}
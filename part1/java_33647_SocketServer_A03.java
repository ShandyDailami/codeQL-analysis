import java.io.*;
import java.net.*;

public class java_33647_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);

        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected!");

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        String request = reader.readLine();
        System.out.println("Received: " + request);

        outputStream.writeBytes("HTTP/1.1 200 OK\r\n\r\n");
        outputStream.flush();

        socket.close();
        serverSocket.close();
    }
}
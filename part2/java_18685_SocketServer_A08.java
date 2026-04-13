import java.io.*;
import java.net.*;

public class java_18685_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // define port
        System.out.println("Waiting for connection...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

        // create streams
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

        // read from client
        String message = reader.readLine();
        System.out.println("Client says: " + message);

        // send back to client
        outputStream.write("Hello, Client!".getBytes());

        // close streams
        reader.close();
        outputStream.close();
        socket.close();
        serverSocket.close();
    }
}
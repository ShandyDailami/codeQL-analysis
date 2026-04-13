import java.io.*;
import java.net.*;

public class java_42078_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        // create input and output streams
        BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        String clientMessage;
        // read from client and echo back
        while ((clientMessage = in.readLine()) != null) {
            System.out.println("Received: " + clientMessage);
            out.println("Echo: " + clientMessage);
        }
        socket.close();
        serverSocket.close();
    }
}
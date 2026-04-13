import java.io.*;
import java.net.*;

public class java_07990_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            String clientMessage;
            if ((clientMessage = reader.readLine()) != null) {
                System.out.println("Client says: " + clientMessage);
                if ("exit".equals(clientMessage)) {
                    break;
                } else {
                    writer.println("Server says: " + clientMessage);
                }
            }
            socket.close();
        }
        serverSocket.close();
    }
}
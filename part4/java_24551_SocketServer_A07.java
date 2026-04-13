import java.io.*;
import java.net.*;

public class java_24551_SocketServer_A07 {
    private static int port = 54321;
    private static Socket socket;
    private static ServerSocket serverSocket;
    private static BufferedReader reader;
    private static DataOutputStream writer;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            socket = serverSocket.accept();
            System.out.println("Client connected!");

            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new DataOutputStream(socket.getOutputStream());

            String clientMessage;
            while ((clientMessage = reader.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Simulate authentication failure
                if (clientMessage.equals("fail")) {
                    writer.writeBytes("Authentication failed\n");
                    writer.flush();
                    System.out.println("Authentication failure. Closing connection.");
                    socket.close();
                    serverSocket.close();
                } else {
                    writer.writeBytes("Authentication succeeded\n");
                    writer.flush();
                    System.out.println("Authentication succeeded. Closing connection.");
                    socket.close();
                    serverSocket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
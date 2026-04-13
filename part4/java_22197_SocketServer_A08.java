import java.io.*;
import java.net.*;

public class java_22197_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Start reading and writing
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read data from client
            String data = dis.readUTF();
            System.out.println("Received: " + data);

            // Process the data
            // For example, check integrity
            if (data.length() != 10) { // if the data length is not 10
                System.out.println("Integrity failure, ignoring data...");
                dos.writeUTF("Ignored");
            } else {
                System.out.println("Processing data...");
                String processedData = processData(data);
                dos.writeUTF(processedData);
            }

            dos.close();
            socket.close();
        }
    }

    private static String processData(String data) {
        // Simulate processing the data by uppercasing it
        return data.toUpperCase();
    }
}
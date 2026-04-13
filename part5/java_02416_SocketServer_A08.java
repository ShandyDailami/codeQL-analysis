import java.io.*;
import java.net.*;

public class java_02416_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Read data from the client
                String data = in.readUTF();
                System.out.println("Received data: " + data);

                // Handle integrity of data
                byte[] bytes = data.getBytes();
                int checksum = 0;
                for (int i = 0; i < bytes.length; i++) {
                    checksum += bytes[i];
                }

                // Send checksum back to the client
                out.writeInt(checksum);
                out.flush();
                System.out.println("Sent checksum: " + checksum);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
import java.io.*;
import java.net.*;

public class java_31352_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("Server is listening on port 8080");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client is connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                // Here, we're simulating a security-sensitive operation related to A07_AuthFailure
                if (request.contains("authFailure")) {
                    dataOutputStream.writeUTF("AuthFailure");
                    dataOutputStream.flush();
                } else {
                    dataOutputStream.writeUTF("Success");
                    dataOutputStream.flush();
                }

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
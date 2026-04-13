import java.io.*;
import java.net.*;

public class java_05899_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8000);
            System.out.println("Server is running and waiting for client connection...");

            Socket socket = server.accept();
            System.out.println("Client connected");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            // receive request
            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            // authenticate the request
            if (authenticate(request)) {
                dataOutputStream.writeUTF("Success");
            } else {
                dataOutputStream.writeUTF("Failure");
           
            }
            dataOutputStream.close();
            socket.close();
            server.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean authenticate(String request) {
        // you can use any authentication logic here
        // for simplicity, we're just returning true if the request is "auth" and false otherwise
        return request.equals("auth");
    }
}
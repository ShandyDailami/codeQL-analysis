import java.io.*;
import java.net.*;

public class java_39476_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server is listening on port 8000");

        while (true) {
            Socket socket = serverSocket.accept();

            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String request = dataInputStream.readUTF();
            System.out.println("Received request: " + request);

            String response = processRequest(request);
            dataOutputStream.writeUTF(response);
            dataOutputStream.flush();

            socket.close();
        }
    }

    private static String processRequest(String request) {
        // Doing a lot of work in here. We're just returning the request
        // just to demonstrate the principle of not allowing external frameworks.
        return request;
    }
}
import java.io.*;
import java.net.*;

public class java_06943_SocketServer_A01 {
    private static final String PASSWORD = "password"; // You should change this to a real password

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Accepted connection from " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            if (isValidPassword(message)) {
                output.writeUTF("Accepted");
            } else {
                output.writeUTF("Denied");
           
                socket.close();
            }
        }
    }

    private static boolean isValidPassword(String password) {
        return password.equals(PASSWORD);
    }
}
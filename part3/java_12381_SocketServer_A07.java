import java.io.*;
import java.net.*;

public class java_12381_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println("Server is listening on port 1234");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("A client has connected");

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received message: " + message);

            if (message.equals("exit")) {
                System.out.println("Client disconnected");
                socket.close();
                break;
            }

            output.writeUTF("Thank you for connecting");
            output.flush();
        }

        serverSocket.close();
    }
}
import java.io.*;
import java.net.*;

public class java_17733_SocketServer_A08 {
    private static int portNumber = 1234;

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port: " + portNumber);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A client is connected");

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

                // read the request from the client
                String request = dataInputStream.readUTF();
                System.out.println("Received request: " + request);

                // send the response back to the client
                String response = "Hello, client!";
                dataOutputStream.writeUTF(response);
                System.out.println("Sent response: " + response);

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
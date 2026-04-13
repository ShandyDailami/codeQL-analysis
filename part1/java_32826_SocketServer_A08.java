import java.io.*;
import java.net.*;

public class java_32826_SocketServer_A08 {
    private static int portNumber = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected.");

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                String request = in.readUTF();
                System.out.println("Received request: " + request);

                if ("A08_IntegrityFailure".equals(request)) {
                    out.writeUTF("IntegrityFailure is not allowed.");
                } else {
                    out.writeUTF("Unknown request.");
                }

                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
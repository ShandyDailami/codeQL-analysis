import java.io.*;
import java.net.*;

public class java_05281_SocketServer_A03 {
    private static int DEFAULT_PORT = 1234;
    private static ServerSocket server;

    private java_05281_SocketServer_A03() { }

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                handleRequest(server.accept());
            }
        } catch (IOException ex) {
            System.out.println("Server failed to start at port " + port);
            System.exit(-1);
        }
    }

    private static void handleRequest(Socket clientSocket) {
        try {
            InputStream input = clientSocket.getInputStream();
            DataInputStream dis = new DataInputStream(input);

            String request = dis.readUTF();

            System.out.println("Received: " + request);

            OutputStream output = clientSocket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(output);

            String response = processRequest(request);
            dos.writeUTF(response);

            dos.flush();
        } catch (IOException ex) {
            System.out.println("Error in handling request from " + clientSocket);
        }
    }

    private static String processRequest(String request) {
        // TODO: Implement the required security-sensitive operations related to A03_Injection.
        return "Server response";
    }
}
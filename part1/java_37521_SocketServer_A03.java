import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37521_SocketServer_A03 {
    private ServerSocket server;

    public java_37521_SocketServer_A03(int port) throws IOException {
        server = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server started on port " + server.getLocalPort() + ".");

        while (true) {
            Socket client = server.accept();
            System.out.println("Accepted new client from " + client.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // Read the request from the client
            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Simulate a security-sensitive operation
            request = request.replaceAll(";", "");

            // Write the response back to the client
            out.writeUTF("Successfully processed: " + request);
            out.close();
        }
    }

    public static void main(String[] args) {
        try {
            new SocketServer(54321).startServer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
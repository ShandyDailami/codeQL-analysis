import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10003_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(1234); // listen on port 1234
        while (true) {
            Socket client = server.accept(); // wait for client
            System.out.println("Client connected: " + client.getRemoteSocketAddress());
            // start a new thread to handle the client
            new ClientHandler(client).start();
        }
    }

    static class ClientHandler extends Thread {
        Socket client;

        public java_10003_SocketServer_A01(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // read a request from the client
                byte[] request = new byte[1000];
                client.getInputStream().read(request);
                System.out.println("Received: " + new String(request));
                // send a response back to the client
                byte[] response = "Hello, Client!".getBytes();
                client.getOutputStream().write(response);
                client.getOutputStream().flush();
                // close the connection
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
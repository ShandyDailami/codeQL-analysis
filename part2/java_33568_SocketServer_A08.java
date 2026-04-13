import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33568_SocketServer_A08 {

    private ServerSocket server;
    private Socket client;
    private OutputStream out;
    private BufferedReader in;

    public void start(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server is listening on port: " + port);

            // Accept a client socket
            client = server.accept();
            out = client.getOutputStream();
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            // Start reading from the client socket
            readClient();
        } catch (Exception e) {
            e.printStackTrace();
            stop();
        }
    }

    private void readClient() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println("Received: " + message);
                        out.write(("Hello Client, Message Received\n").getBytes());
                    }
                    in.close();
                    out.close();
                    client.close();
                    server.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void stop() {
        try {
            in.close();
            out.close();
            client.close();
            server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start(5000);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_01170_SocketServer_A01 {
    private ServerSocket serverSocket;
    private boolean running = true;

    public java_01170_SocketServer_A01(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    try {
                        Socket clientSocket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                        String message = in.readLine();
                        System.out.println("Received: " + message);

                        out.println("Hello, you've connected to the server. Your message was: " + message);
                    } catch (IOException e) {
                        running = false;
                        e.printStackTrace();
                    }
                }

                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer(1234);
        server.startServer();
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15773_SocketServer_A03 implements Runnable {
    private ServerSocket serverSocket;
    private boolean running = false;

    public java_15773_SocketServer_A03(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (running) return;
        running = true;
        new Thread(this).start();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            try {
                Socket clientSocket = serverSocket.accept();
                InetAddress ip = clientSocket.getInetAddress();
                System.out.println("Client IP: " + ip.getHostAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println("Received: " + inputLine);
                    out.println("Server received your message: " + inputLine);
                }

                clientSocket.close();
            } catch (Exception e) {
                e.printStackTrace();
                if (serverSocket != null) {
                    try {
                        serverSocket.close();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                running = false;
            }
        }
    }
}
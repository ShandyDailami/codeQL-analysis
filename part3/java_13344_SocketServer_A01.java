import java.io.*;
import java.net.*;

public class java_13344_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            Socket client = server.accept();

            // Create a new thread for each client
            Thread thread = new Thread(new BrokenAccessThread(client));
            thread.start();
        }
    }
}

class BrokenAccessThread implements Runnable {
    private Socket client;

    public java_13344_SocketServer_A01(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            String request = in.readLine();
            System.out.println("Received: " + request);

            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=utf-8");
            out.println();
            out.println("<h1>Hello, World!</h1>");
            out.flush();

            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
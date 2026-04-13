import java.io.*;
import java.net.*;

public class java_41526_SocketServer_A08 {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("New client connected");

            new SocketHandler(socket).start();
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public java_41526_SocketServer_A08(Socket socket) {
        this.socket = socket;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                out.println("Server received your message");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        close();
    }

    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
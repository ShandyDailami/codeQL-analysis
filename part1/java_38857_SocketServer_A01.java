import java.io.*;
import java.net.*;

public class java_38857_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public java_38857_SocketServer_A01(Socket socket) {
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    @Override
    public void run() {
        try {
            String message;
            while ((message = in.readLine()) != null) {
                if (message.equals("exit")) {
                    out.println("Goodbye!");
                    break;
                } else {
                    out.println("Hello, " + message);
                }
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
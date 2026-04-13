import java.net.*;

public class java_17907_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        int port = 4445; // the port number on which the server will listen

        // create a new server socket
        ServerSocket server = new ServerSocket(port);

        // run until the program is terminated
        while (true) {
            // accept a client socket
            Socket socket = server.accept();

            // create a new thread to handle this client
            new SocketHandler(socket).start();
        }
    }
}

class SocketHandler extends Thread {
    private Socket socket;

    public java_17907_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // get the output stream from the socket
            OutputStream out = socket.getOutputStream();

            // send a greeting message to the client
            out.write("Welcome to the server\n".getBytes());

            // create a new input stream from the socket
            InputStream in = socket.getInputStream();

            // read a message from the client
            byte[] buffer = new byte[1024];
            int bytes = in.read(buffer);

            // decrypt the message with a Caesar cipher
            for (int i = 0; i < bytes; i++) {
                buffer[i] = (byte)((buffer[i] - 'a' + 5) % 26 + 'a');
            }

            // send the decrypted message to the client
            out.write(buffer, 0, bytes);
            out.flush();

            // close the connection
            socket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
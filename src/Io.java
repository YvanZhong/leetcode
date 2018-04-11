import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Io {

    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("aaa");
            new BufferedInputStream(is);
            is.read();

            ServerSocket server = new ServerSocket(2000);
            Socket socket = server.accept();
            socket.getInputStream();

        } catch (IOException e) {

        }
    }

}

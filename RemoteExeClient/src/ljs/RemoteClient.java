package ljs;

import java.io.*;
import java.net.Inet4Address;
import java.net.Socket;

public class RemoteClient extends Thread
{
    File classFile = new File("out/production/RemoteExeClient/ljs/MyRunnable.class");

    @Override
    public void run()
    {
        try
        {
            Socket socket = new Socket(Inet4Address.getLocalHost(), 1314);
            OutputStream out = socket.getOutputStream();
            InputStream in = new FileInputStream(classFile);
            boolean writeOk = Util.write(in, out);
            Util.close(out);
            Util.close(in);
            socket.close();
            System.out.println("传输完成");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

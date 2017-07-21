package ljs;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class RemoteServer extends Thread
{
    File classFile = new File("out/production/RemoteExeServer/ljs/MyRunnable.class");

    @Override
    public void run()
    {
        ServerSocket serverSocket = null;
        while (true)
        {
            System.out.println("listenning:" + 1314);
            try
            {
                if (serverSocket == null)
                    serverSocket = new ServerSocket(1314);
                Socket socket = serverSocket.accept();
                InputStream in = socket.getInputStream();
                OutputStream out = new FileOutputStream(classFile, false);
                boolean saveFileOk = Util.write(in, out);
                Util.close(in);
                Util.close(out);
                if (saveFileOk)
                {
                    MyClassLoader myClassLoader = new MyClassLoader("out/production/RemoteExeServer/", new String[]{"ljs.MyRunnable"});
                    Runnable runnable = (Runnable) myClassLoader.loadClass("ljs.MyRunnable").newInstance();
                    if (runnable != null)
                    {
                        Thread thread = new Thread(runnable);
                        thread.join();
                        thread.start();
                    }
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            } catch (IllegalAccessException e)
            {
                e.printStackTrace();
            } catch (InstantiationException e)
            {
                e.printStackTrace();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

package ljs;

import java.io.*;

public class Util
{
    public static boolean write(InputStream in, OutputStream out)
    {
        boolean result = false;
        if (in == null || out == null) ;
        else
        {
            byte[] buffer = new byte[2048];
            int size;
            try
            {
                while ((size = in.read(buffer)) != -1)
                    out.write(buffer, 0, size);
                result = true;
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void close(Closeable closeable)
    {
        if (closeable != null)
            try
            {
                closeable.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
    }

    public static Object readObj(InputStream in)
    {
        Object obj = null;
        if (in == null) ;
        else
        {
            try
            {
                ObjectInputStream objectInputStream = new ObjectInputStream(in);
                return objectInputStream.readObject();
            } catch (IOException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static boolean writeObj(OutputStream out, Object obj)
    {
        boolean result = false;
        if (out == null || obj == null) ;
        else
        {
            try
            {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
                objectOutputStream.writeObject(obj);
                result = true;
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return result;
    }
}

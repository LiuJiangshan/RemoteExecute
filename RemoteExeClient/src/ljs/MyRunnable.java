package ljs;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public class MyRunnable implements Runnable, Serializable
{
    @Override
    public void run()
    {
        try
        {
            Runtime.getRuntime().exec("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\" taobao.com");
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}

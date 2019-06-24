package myk.applet;

import java.applet.Applet;
import java.awt.*;

/*
<applet code="StatusWindow" width=300 height=100>
</applet>
 */
public class Banner extends Applet implements Runnable {
    private String msg = "Java Rules the web ";
    private Thread thread;
    private boolean stopFlag;

    @Override
    public void init() {
        super.init();
        thread = null;
        System.out.println("init()--------->");
    }

    @Override
    public void start() {
        super.start();
        thread = new Thread(this);
        stopFlag = false;
        thread.start();
        System.out.println("start()--------->");
    }

    @Override
    public void run() {
        while (!stopFlag) {
            repaint();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void stop() {
        super.stop();
        stopFlag = true;
        thread = null;
        System.out.println("stop()--------->");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        char ch;
        ch = msg.charAt(0);
        msg = msg.substring(1);
        msg += ch;
        g.drawString(msg, 50, 30);
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy()--------->");
    }
}

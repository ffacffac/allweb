package myk.applet;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseEvents extends Applet implements MouseListener, MouseMotionListener {

    //region 成员变量
    private String msg = "";
    private int mouseX = 0, mouseY = 0;
    //endregion

    //region 生命周期

    @Override
    public void init() {
        super.init();
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    //endregion


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, mouseX, mouseY);
    }

    //region 鼠标事件监听
    @Override
    public void mouseClicked(MouseEvent e) {
        //响应鼠标事件，点击
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse clicked ";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //鼠标按下
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Mouse Down ";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //鼠标移起
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse UP ";
        System.out.println("mouseReleased Mouse UP ");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //鼠标移入区域
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse mouseEntered ";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //鼠标移除区域
        mouseX = 0;
        mouseY = 10;
        msg = "Mouse mouseExited ";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //鼠标拖拽
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "被拖到这";
        showStatus("mouseDragged at " + mouseX + "，" + mouseY);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        showStatus("moving mouse ");
    }
    //endregion
}

package myk.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingDemo implements ActionListener {

    private static final String BTN1_MSG = "Down";
    private static final String BTN2_MSG = "Up";

    public static void main(String[] args) {
        //必须在时间委派线程上执行
        SwingUtilities.invokeLater(() -> {
            SwingDemo s = new SwingDemo();
            s.show();
        });
    }

    private void show() {
        //创建一个容器
        JFrame jFrame = new JFrame("A simple Swing app");
        //设置容器尺寸,像素为单位
        jFrame.setSize(300, 300);
        //设置关闭窗口时，结束掉整个应用程序
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //
        jFrame.setLayout(new FlowLayout());
        //加label标签,显示信息
        JLabel jLabel = new JLabel("Swing defines the modern java GUI\n");
        //添加到容器中
        jFrame.add(jLabel);
        JLabel txtLabel = new JLabel("Enter text:\n");
        jFrame.add(txtLabel);
        //添加文本
        JTextField jtf = new JTextField(10);
        //设置文本域的动作命令，当鼠标焦点处于jtf时，按下enter（回车键）
        //则时间监听"myTF".equals(e.getActionCommand())==true
        jtf.setActionCommand("myTF");
        jtf.addActionListener(this);
        jFrame.add(jtf);

        JLabel btnLabel = new JLabel("BTN Label:\n");
        jFrame.add(btnLabel);
        //添加按钮
        JButton btn1 = new JButton(BTN1_MSG);
        JButton btn2 = new JButton(BTN2_MSG);
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        jFrame.add(btn1);
        jFrame.add(btn2);


        //容器可视
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (BTN1_MSG.equals(e.getActionCommand())) {
            System.out.println("click " + BTN1_MSG);
        } else if (BTN2_MSG.equals(e.getActionCommand())) {
            System.out.println("click " + BTN2_MSG);
        } else if ("myTF".equals(e.getActionCommand())) {
            System.out.println("enter key ");
        }
    }
}

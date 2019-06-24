package myk.swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ListDemo implements ListSelectionListener {

    //region 成员变量
    private JList<String> jList;
    private JLabel jLabel;
    private JScrollPane jScrollPane;
    private String names[] = {"A", "B", "C", "D", "E", "F"};
    //endregion

    public static void main(String[] args) {
//        SwingUtilities.invokeLater(ListDemo::new);

//        boolean result = rf();
//        System.out.println("result is" + result);
    }

    private ListDemo() {
        JFrame jFrame = new JFrame("JList Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(300, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建list
        jList = new JList<>(names);
        //单项选择模式
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //封装list到JScrollPane
        jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(120, 100));
        jLabel = new JLabel("Please choose a name");
        jList.addListSelectionListener(this);

        jFrame.add(jLabel);
        jFrame.add(jScrollPane);

        jFrame.setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //true--按下鼠标的时候才触发；false--鼠标放开才触发
        if (e.getValueIsAdjusting()) {
            //item（条目）索引
            int idx = jList.getSelectedIndex();
            System.out.println("index is " + idx);
        }
    }

    /**
     * 比较两个文件是否相同
     *
     * @param filePath1 第一个文件path
     * @param filePath2 第二个文件path
     * @return true-相同
     */
    private boolean fileEqual(String filePath1, String filePath2) {
        FileInputStream f1 = null;
        FileInputStream f2 = null;
        boolean result = false;
        try {
            f1 = new FileInputStream(filePath1);
            f2 = new FileInputStream(filePath2);
            int i, j;
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
            } while (i != -1);
            result = i == j;
//            return i == j;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (f1 != null) {
                    f1.close();
                }
                if (f2 != null) {
                    f2.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private static boolean rf() {
        try {
            int j = 0;
            for (int i = 0; i < 10; i++) {
                System.out.println("i==" + i);
                if (i / 4 == 1) {
                    j = i;
                    break;
                }
            }
            if (j > 0) return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally out");
        }
        return false;
    }
}

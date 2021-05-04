package com.oracle;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/*
* 显示窗口的第一个方法
* 1 新建一个窗口
* 2 设置窗口的大小
* 3 设置窗口不能改变大小
* 4 显示窗口
* 5 设置窗口可关闭
* 6 设置窗口的标题
* */
public class TankFrame {
    public static void main(String[] args) {
//      创建一个窗口
        Frame mainFrame = new Frame();
//      窗口设置大小
        mainFrame.setSize(800, 600);
//      设置不能改变大小
        mainFrame.setResizable(false);
//      设置窗口的标题
        mainFrame.setTitle("tank war");
//      显示窗口
        mainFrame.setVisible(true);
//      设置窗口可关闭
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

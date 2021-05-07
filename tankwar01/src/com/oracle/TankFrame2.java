package com.oracle;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// 显示窗口的第二种方法
public class TankFrame2 extends Frame {
    //    主站坦克
    Tank myTank = new Tank(200, 200, Dir.DOWN);

    //    构造方法
    public TankFrame2() {
//      窗口设置大小
        setSize(800, 600);
//      设置不能改变大小
        setResizable(false);
//      设置窗口的标题
        setTitle("tank war");
//      显示窗口
        setVisible(true);
//      设置窗口可关闭
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//        设置键盘监听
        this.addKeyListener(new MyKeyListener());
    }

    //    键盘监听处理内部类
    class MyKeyListener extends KeyAdapter {
        //  设置给四个方向设置布尔值 根据布尔值来给xy设置值  坦克可以八个方向移动
        boolean BL = false;
        boolean BR = false;
        boolean BU = false;
        boolean BD = false;

        // 一个键被按下去的时候调用
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
            int key = e.getKeyCode();
            System.out.println("看看我按了啥键===》" + key);
            switch (key) {
                case KeyEvent.VK_UP: // 上
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN: // 下
                    BD = true;
                    break;
                case KeyEvent.VK_LEFT: // 左
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:// 右
                    BR = true;
                    break;
                default:
                    break;
            }
            setMainTankDri();
//            上 下 左 右 上左 上右 下左 下右
//            if (BU == true && BD == false && BL == false && BR == false) {
//                y -= 10;
//            } else if (BU == false && BD == true && BL == false && BR == false) {
//                y += 10;
//            } else if (BU == false && BD == false && BL == true && BR == false) {
//                x -= 10;
//            } else if (BU == false && BD == false && BL == false && BR == true) {
//                x += 10;
//            } else if (BU == true && BD == false && BL == true && BR == false) {
//                y -= 10;
//                x -= 10;
//            } else if (BU == true && BD == false && BL == false && BR == true) {
//                y -= 10;
//                x += 10;
//            } else if (BU == false && BD == true && BL == true && BR == false) {
//                y += 10;
//                x -= 10;
//            } else if (BU == false && BD == true && BL == false && BR == true) {
//                y += 10;
//                x += 10;
//            }
            repaint();// 调用 paint()方法
        }

        // 一个键抬起来的时候调用
        @Override
        public void keyReleased(KeyEvent e) {
            setMainTankDri();
//          抬起来的时候设置回来
            BL = false;
            BR = false;
            BU = false;
            BD = false;
        }

        // 设置坦克的方向
        private void setMainTankDri() {
            if (BL) myTank.setDir(Dir.LEFT);
            if (BU) myTank.setDir(Dir.UP);
            if (BD) myTank.setDir(Dir.DOWN);
            if (BR) myTank.setDir(Dir.RIGHT);
        }
    }

    //    窗口重新调用的时候自动调用 paint 方法 重写方法 paint
    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }
}

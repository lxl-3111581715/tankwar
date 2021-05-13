package com.oracle;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

// 显示窗口的第二种方法
/*
 * 窗口的属性
 *   大小
 *   能否改变
 *   标题
 *   是否可关闭
 * 键盘按下
 * 键盘松开
 * 窗口画东西
 *   出现坦克
 *   出现子弹
 *   按下ctrl键 打出子弹
 * */
public class TankFrame2 extends Frame {
    //    窗口的大小
    int GAME_WIDTH = 800, GAME_HEIGHT = 600;
    //    主站坦克
    Tank myTank = new Tank(200, 400, Dir.DOWN, this);
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Tank> tanks = new ArrayList<>(); // 创建敌方坦克

    //    Bullet b = new Bullet(300, 300, Dir.DOWN);
    //    构造方法
    public TankFrame2() {
//      窗口设置大小
        setSize(GAME_WIDTH, GAME_HEIGHT);
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
            int key = e.getKeyCode();
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
//            repaint();// 调用 paint()方法
        }

        // 一个键抬起来的时候调用
        @Override
        public void keyReleased(KeyEvent e) {
            myTank.setMoving(false);
//          抬起来的时候设置回来
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP: // 上
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN: // 下
                    BD = false;
                    break;
                case KeyEvent.VK_LEFT: // 左
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:// 右
                    BR = false;
                    break;
                case KeyEvent.VK_CONTROL:// 抬起ctrl键打出一个子弹
                    myTank.fire();
                    break;
                default:
                    break;
            }
        }

        // 设置坦克的方向
        private void setMainTankDri() {
            if (!BL && !BU && !BD && !BR) myTank.setMoving(false);
            else {
                myTank.setMoving(true);
                if (BL) myTank.setDir(Dir.LEFT);
                if (BU) myTank.setDir(Dir.UP);
                if (BD) myTank.setDir(Dir.DOWN);
                if (BR) myTank.setDir(Dir.RIGHT);
            }
        }
    }

    // 用双缓冲的方法解决闪烁的问题
    Image offScreenImage = null;

    @Override
    public void update(Graphics g) { // paint方法之前调用
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffSvreen = offScreenImage.getGraphics();
        Color c = gOffSvreen.getColor();
        gOffSvreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffSvreen.setColor(c);
        paint(gOffSvreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    // 窗口重新调用的时候自动调用 paint 方法 重写方法 paint
    @Override
    public void paint(Graphics g) {
        // 子弹描述
        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
        g.setColor(c);
        // 画坦克
        myTank.paint(g);
        // 画子弹
//        for (Bullet b : bullets) {
//            b.paint(g);
//        } // 出现异常
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
//        画地方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
//        碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collwith(tanks.get(j));

            }
        }

    }

}

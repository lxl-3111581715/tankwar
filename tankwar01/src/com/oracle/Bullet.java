package com.oracle;

import java.awt.*;

// 子弹类
/*
 * 子弹的速度
 * 子弹的大小
 * 子弹的位置
 * 子弹的方向
 * */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH = 30, HEIGHT = 30;
    private int x, y;
    private Dir dir;
    //    子弹是否存活的属性
    private boolean alive = true;
    private TankFrame2 tankframe2 = null;

    public Bullet(int x, int y, Dir dir, TankFrame2 tankframe2) {
        this.x = x + ResourceManager.tankU.getWidth() / 2 - ResourceManager.bulletU.getWidth() / 2;
        this.y = y + ResourceManager.tankU.getHeight() / 2 - ResourceManager.bulletU.getHeight() / 2;
        this.dir = dir;
        this.tankframe2 = tankframe2;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    // 画子弹的方法
    public void paint(Graphics g) {
        if (!alive) {
            tankframe2.bullets.remove(this);
        }
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(c);
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
            default:
                break;
        }
        move();
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > tankframe2.GAME_WIDTH || y > tankframe2.GAME_HEIGHT) {
            alive = false;
        }
    }
}

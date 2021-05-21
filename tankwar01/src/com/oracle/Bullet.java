package com.oracle;

import java.awt.*;

/*
 *  子弹类:子弹的速度 子弹的大小  子弹的位置 子弹的方向
 * */
public class Bullet {
    private static final int SPEED = 10;
    private static int WIDTH = 30, HEIGHT = 30;
    private int x, y;
    private Dir dir;
    // 子弹是否存活的属性
    private boolean living = true;
    private TankFrame2 tankframe2 = null;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group, TankFrame2 tankframe2) {
        this.x = x + ResourceManager.tankU.getWidth() / 2 - ResourceManager.bulletU.getWidth() / 2;
        this.y = y + ResourceManager.tankU.getHeight() / 2 - ResourceManager.bulletU.getHeight() / 2;
        this.dir = dir;
        this.group = group;
        this.tankframe2 = tankframe2;
    }

    // 画子弹的方法
    public void paint(Graphics g) {
        if (!living) {
            tankframe2.bullets.remove(this);
        }
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
            living = false;
        }
    }

    //    坦克和子弹的碰撞检测方法
    public void collwith(Tank tank) {
//
        if (this.group == tank.group) return;
//        Rectangle 辅助类
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
//
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
//        判断俩个方块是否相交
        if (rect1.intersects(rect2)) {
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }


    public static int getSPEED() {
        return SPEED;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Bullet.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Bullet.HEIGHT = HEIGHT;
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

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public TankFrame2 getTankframe2() {
        return tankframe2;
    }

    public void setTankframe2(TankFrame2 tankframe2) {
        this.tankframe2 = tankframe2;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}

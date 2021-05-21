package com.oracle;

import java.awt.*;
import java.sql.Struct;
import java.util.Random;

/*
 * 坦克类: 坦克的移动速度 坦克的位置 坦克的大小 坦克的方向
 * */
public class Tank {
    private Random random = new Random();
    private  boolean living = true;
    private int x;
    private int y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    public static final int WIDTH = ResourceManager.tankU.getWidth(), HEIGHT = ResourceManager.tankU.getHeight();
    // 坦克类持有子弹类的引用
    private TankFrame2 tankframe2 = null;
    private boolean moving = true;
    public Group group = Group.BAD;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    //构造方法
    public Tank(int x, int y, Dir dir,Group group, TankFrame2 tankframe2) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankframe2 = tankframe2;
    }

    // 画坦克的方法
    public void paint(Graphics g) {
        if(! living) tankframe2.tanks.remove(this);
//        改为画图片
//        g.drawImage(ResourceManager.tankU, x, y, null);
        switch (dir) {
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
            default:
                break;
        }
        move();
    }

    private void move() {
        if (!moving) return;
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
//        敌人的坦克发出子弹
        if(random.nextInt(10) > 8) this.fire();
//        randomDir();
    }
//    敌方坦克移动之后随机换方向
//    private void randomDir() {
//    }

    // 抬起ctrl键发射一个子弹
    public void fire() {
        tankframe2.bullets.add(new Bullet(this.x, this.y, this.dir,this.group,this.tankframe2));
    }

    public void die() {
        this.living = false;
    }
}

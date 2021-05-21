package com.oracle;

import java.awt.*;

public class explode {
    private static int WIDTH = ResourceManager.explodes[0].getWidth(), HEIGHT = ResourceManager.explodes[0].getHeight();
    private int x, y;
    private boolean living = true;
    private TankFrame2 tankframe2 = null;
    private int step = 0;

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

    public explode(int x, int y, TankFrame2 tankframe2) {
        this.x = x;
        this.y = y;
        this.tankframe2 = tankframe2;
    }

    // 画的方法
    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explodes[step++], x, y, null);
        if (step >= ResourceManager.explodes.length) step = 0;
    }
}

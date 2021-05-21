package com.oracle;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// 资源的管理者
public class ResourceManager {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explodes = new BufferedImage[22];

    static {
        try {
            // 使用类加载器的方式加载类路径下的图片
            // tankU = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tank1.gif")); // 上
            // tankD = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tank2.gif")); // 下
            // tankL = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tank3.gif")); // 左
            // tankR = ImageIO.read(ResourceManager.class.getClassLoader().getResourceAsStream("img/tank4.gif"));  // 右

            // 坦克的四个方向图片
            tankU = ImageIO.read(new File("D:/desktop/img/tank1.gif")); // 上
            tankD = ImageIO.read(new File("D:/desktop/img/tank2.gif")); // 下
            tankL = ImageIO.read(new File("D:/desktop/img/tank3.gif")); // 左
            tankR = ImageIO.read(new File("D:/desktop/img/tank4.gif"));  // 右
            // 子弹的四个方向图片
            bulletU = ImageIO.read(new File("D:/desktop/img/missile1.gif")); // 上
            bulletD = ImageIO.read(new File("D:/desktop/img/missile2.gif")); // 下
            bulletL = ImageIO.read(new File("D:/desktop/img/missile3.gif")); // 左
            bulletR = ImageIO.read(new File("D:/desktop/img/missile4.gif")); // 右
            // 在内存中加载爆炸图片
            for (int i = 0; i < 22; i++) {
                explodes[i] = ImageIO.read(new File("D:/desktop/img/" + i + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

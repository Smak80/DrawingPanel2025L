package ru.smak.ui;

import java.awt.*;

public class CartesianPainter implements Painter{

    private int width;
    private int height;

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(4));
        // Здесь выводить оси не через центр, а с учетом координаты "0"
        g.drawLine(0, height / 2, width, height / 2);
        g.drawLine(width / 2, 0, width / 2, height);

        // Пример отрисовки текста
        g2.setStroke(new BasicStroke(1));
        g.setColor(Color.RED);
        var sz = 6;
        g.drawLine(300, height / 2 - sz, 300, height / 2 + sz);
        var pos = -1.0;
        var strPos = "" + pos;
        g.setColor(Color.BLUE);
        var f = new Font("Cambria", Font.BOLD, 20);
        g.setFont(f);
        var m = g.getFontMetrics();
        var strRect = m.getStringBounds(strPos, g);
        g.drawString(
                strPos,
                (int)(300 - strRect.getWidth() / 2),
                (int)(height / 2 + sz + strRect.getHeight())
        );
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}

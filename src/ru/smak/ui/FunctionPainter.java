package ru.smak.ui;

import java.awt.*;
import java.util.function.Function;
import ru.smak.graphics.utils.Converter;

import static java.lang.Math.*;

public class FunctionPainter implements Painter{
    private Function<Double, Double> func = null;
    private Converter conv = null;

    public FunctionPainter(Function<Double, Double>f, Converter c){
        this.func = f;
        conv = c;
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 0; i < getWidth(); i++){
            var x1 = conv.xScr2Crt(i);
            var y1 = func.apply(x1);
            var j1 = conv.yCrt2Scr(y1);
            var x2 = conv.xScr2Crt(i+1);
            var y2 = func.apply(x2);
            var j2 = conv.yCrt2Scr(y2);
            g.drawLine(i, j1, i+1, j2);
        }
    }

    @Override
    public int getWidth() {
        return conv.getWidth();
    }

    @Override
    public int getHeight() {
        return conv.getHeight();
    }

    @Override
    public void setWidth(int width) {
        conv.setWidth(width);
    }

    @Override
    public void setHeight(int height) {
        conv.setHeight(height);
    }
}

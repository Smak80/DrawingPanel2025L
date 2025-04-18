package ru.smak.ui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainWindow extends JFrame {
    private static final int MIN_SZ = GroupLayout.PREFERRED_SIZE;
    private static final int MAX_SZ = GroupLayout.DEFAULT_SIZE;

    private final CartesianPainter cp = new CartesianPainter();

    private JPanel mainPanel;
    private JPanel controlPanel;

    private JLabel lblXMin;
    private JLabel lblXMax;
    private JLabel lblYMin;
    private JLabel lblYMax;

    private JSpinner spXMin;
    private JSpinner spXMax;
    private JSpinner spYMin;
    private JSpinner spYMax;

    private SpinnerNumberModel nmXMin;
    private SpinnerNumberModel nmXMax;
    private SpinnerNumberModel nmYMin;
    private SpinnerNumberModel nmYMax;

    private JButton btnExit;



    public MainWindow(){
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initComponents();

        var gl = new GroupLayout(getContentPane());
        setLayout(gl);

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(8)
                .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                .addGap(8)
                .addComponent(controlPanel, MIN_SZ, MIN_SZ, MIN_SZ)
                .addGap(8)
        );

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(8)
                        .addGroup(gl.createParallelGroup()
                                .addComponent(mainPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                                .addComponent(controlPanel, MAX_SZ, MAX_SZ, MAX_SZ)
                        )
                .addGap(8)
        );

        GroupLayout glSettings = new GroupLayout(controlPanel);
        controlPanel.setLayout(glSettings);
        glSettings.setVerticalGroup(glSettings.createSequentialGroup()
                .addGap(8)
                .addGroup(glSettings.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addGroup(glSettings.createParallelGroup()
                                .addGroup(glSettings.createSequentialGroup()
                                        .addComponent(lblXMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addGap(8)
                                        .addComponent(lblYMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                )
                                .addGroup(glSettings.createSequentialGroup()
                                        .addComponent(spXMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addGap(8)
                                        .addComponent(spYMin, MIN_SZ, MIN_SZ, MIN_SZ)
                                )
                                .addGroup(glSettings.createSequentialGroup()
                                        .addComponent(lblXMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addGap(8)
                                        .addComponent(lblYMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                )
                                .addGroup(glSettings.createSequentialGroup()
                                        .addComponent(spXMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                        .addGap(8)
                                        .addComponent(spYMax, MIN_SZ, MIN_SZ, MIN_SZ)
                                )
                        )
                        .addComponent(btnExit, MIN_SZ, MIN_SZ, MIN_SZ)
                )
                .addGap(8)
        );
        glSettings.setHorizontalGroup(glSettings.createSequentialGroup()
                .addGap(8)
                .addGroup(glSettings.createParallelGroup()
                        .addComponent(lblXMin, MIN_SZ, MIN_SZ, MIN_SZ)
                        .addComponent(lblYMin, MIN_SZ, MIN_SZ, MIN_SZ)
                )
                .addGap(8)
                .addGroup(glSettings.createParallelGroup()
                        .addComponent(spXMin, 100, MIN_SZ, MIN_SZ)
                        .addComponent(spYMin, 100, MIN_SZ, MIN_SZ)
                )
                .addGap(8, 8, 100)
                .addGroup(glSettings.createParallelGroup()
                        .addComponent(lblXMax, MIN_SZ, MIN_SZ, MIN_SZ)
                        .addComponent(lblYMax, MIN_SZ, MIN_SZ, MIN_SZ)
                )
                .addGap(8)
                .addGroup(glSettings.createParallelGroup()
                        .addComponent(spXMax, 100, MIN_SZ, MIN_SZ)
                        .addComponent(spYMax, 100, MIN_SZ, MIN_SZ)
                )
                .addGap(8, 8, Integer.MAX_VALUE)
                .addComponent(btnExit, MIN_SZ, MIN_SZ, MIN_SZ)
                .addGap(8)
        );
    }

    private void initComponents(){
        mainPanel = new JPanel(){
            @Override
            public void paint(Graphics g){
                super.paint(g);
                //Graphics g = mainPanel.getGraphics();

                // Рисование графических примитивов
                /*g.setColor(Color.RED);
                g.fillOval(30, 30, 250, 250);
                g.setColor(Color.BLUE);
                g.drawRect(300, 30, 100, 200);*/
                cp.setWidth(mainPanel.getWidth());
                cp.setHeight(mainPanel.getHeight());
                cp.paint(g);
            }
        };
        mainPanel.setBackground(Color.WHITE);
        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // В лабораторной работе использовать специльный класс
                // PointsPainter, в котором хранить ДЕКАРТОВЫЕ координаты
                // точек, указанных пользователем.
                // В классе должен быть реализован метод paint(Grpahics g),
                // из интерфейса Painter, с помощью которых коллекция
                // точек будет отображаться на экране.
                // Вызов метода paint осуществлять при перерисовке панели.

                var clickPoint = e.getPoint();
                var g = mainPanel.getGraphics();
                g.setColor(Color.GREEN);
                var sz = 12;
                g.fillOval(clickPoint.x - sz / 2, clickPoint.y - sz / 2, sz, sz);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setBorder(
                new TitledBorder(
                        new EtchedBorder(),
                        "Настройки"
                )
        );
        lblXMin = new JLabel();
        lblXMax = new JLabel();
        lblYMin = new JLabel();
        lblYMax = new JLabel();

        lblXMin.setText("XMin");
        lblXMax.setText("XMax");
        lblYMin.setText("YMin");
        lblYMax.setText("YMax");

        nmXMin  = new SpinnerNumberModel(-5.0, -100.0,   4.9, 0.1);
        nmXMax  = new SpinnerNumberModel( 5.0, -  4.9, 100.0, 0.1);
        nmYMin  = new SpinnerNumberModel(-5.0, -100.0,   4.9, 0.1);
        nmYMax  = new SpinnerNumberModel( 5.0, -  4.9, 100.0, 0.1);

        nmXMin.addChangeListener(e -> {
            nmXMax.setMinimum((double)nmXMin.getValue() + 0.1);
        });
        nmXMax.addChangeListener(e -> {
            nmXMin.setMaximum((double)nmXMax.getValue() - 0.1);
        });
        nmYMin.addChangeListener(e -> {
            nmYMax.setMinimum((double)nmYMin.getValue() + 0.1);
        });
        nmYMax.addChangeListener(e -> {
            nmYMin.setMaximum((double)nmYMax.getValue() - 0.1);
        });

        spXMin  = new JSpinner(nmXMin);
        spXMax  = new JSpinner(nmXMax);
        spYMin  = new JSpinner(nmYMin);
        spYMax  = new JSpinner(nmYMax);

        btnExit = new JButton();
        btnExit.setText("Выход");
        btnExit.addActionListener(e -> {

            dispose(); // выход
            /*var result = JColorChooser.showDialog(this, "Цвет панели", Color.BLUE);
            mainPanel.setBackground(result);*/ // -- открытие диалога выбора цвета
        });
    }
}


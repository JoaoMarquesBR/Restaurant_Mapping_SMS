package com.jmarques;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MainLayout {

    JPanel mapPanel,buttonsPanel;
    boolean checkPaint=false;
    int mouseX;
    int mouseY;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainLayout();
            }
        });    }


    public MainLayout(){
        //main frame
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(1920,920);
        mainFrame.setLayout(new GridLayout());

        //JMenu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu config = new JMenu("Config");
        JMenuItem itemAddTable = new JMenuItem("Add Table");
        config.add(itemAddTable);
        menuBar.add(config);

//        itemAddTable.addActionListener()

        mapPanel = new JPanel();
        mapPanel.setSize(500,800);
        mapPanel.setBackground(Color.pink);
        mapPanel.setBorder(new LineBorder(Color.black,10));



        mapPanel.addMouseListener(new MouseInputListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mouseX= e.getX();
                mouseY = e.getY();
                checkPaint = true;
            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        buttonsPanel = new JPanel();
        buttonsPanel.setSize(100,800);
        buttonsPanel.setBackground(Color.blue);

//        mainFrame.add(new Button("oi"));
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(mapPanel,BorderLayout.WEST);
        mainFrame.add(buttonsPanel,BorderLayout.EAST);

        mapPanel.addMouseListener(new MouseInformation());
        mainFrame.setVisible(true);
    }


    public void paint(Graphics g){
        if(checkPaint==true){
            System.out.println("panting");
            g.setColor(Color.red);
            g.fillRect(50, 50, 50, 50);
        }
    }



}

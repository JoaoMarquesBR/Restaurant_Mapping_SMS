package com.jmarques;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseInformation implements MouseListener {
    private static boolean running=false;
    public static int xMouseLocation;
    public static int yMouseLocation;

    public static void main(String[] args) {

    }

    public static void seekForPixel(){
        running =true;

        int x;
        int y;

        try {
            while (running){
                System.out.println("s");
                xMouseLocation = getMouseX();
                yMouseLocation = getMouseY();
            }
        } catch (AWTException e) {
            e.printStackTrace();
        }

    }


    private static int getMouseX() throws AWTException {
        double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
        return ((int) mouseX);
    }
    private static int getMouseY() throws AWTException {
        double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
        return ((int) mouseY);
    }

    //stops the loop looking for mouse location and adds the new table if applicable
    @Override
    public void mouseClicked(MouseEvent e) {
        running=false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse pressed");
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
}
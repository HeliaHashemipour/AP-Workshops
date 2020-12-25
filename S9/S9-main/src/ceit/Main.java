package ceit;

import ceit.gui.CFrame;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        CFrame frame = new CFrame("iNote");
        frame.setVisible(true);
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

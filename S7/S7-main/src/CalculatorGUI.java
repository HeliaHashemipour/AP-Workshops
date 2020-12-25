/**
 * simple calculator using java GUI
 *
 * @author Helia Hashemipour
 * @version 0.0
 */

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class CalculatorGUI {
    private final JFrame frame;
    private final JTabbedPane tab;
    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton[] operatorButton1;
    private final JButton[] operatorButton2;


    /**
     * create a new calculator
     */
    public CalculatorGUI() {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }

        frame = new JFrame("AUT Calculator");
        frame.setSize(370, 300);

        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tab = new JTabbedPane();
        operatorButton1 = new JButton[20];
        operatorButton2 = new JButton[30];
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        frame.setFocusable(true);
        init();
    }

    /**
     * initialize the calculator
     */
    public void init() {

    //make standard calculator panel.
        JPanel standard = new JPanel();   //standard calculator panel

        standard.setLayout(new BorderLayout(8, 5));
        standard.setBorder(new EmptyBorder(0, 0, 0, 0));


        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        JTextArea display = new JTextArea(2, 10);
        display.setEditable(true);

        Border border = BorderFactory.createLineBorder(Color.white, 1);
        display.setBorder(border);

        scrollPane1.setPreferredSize(new Dimension(scrollPane1.getWidth(), scrollPane1.getHeight() + 100));
        JPanel keyboardPanel1 = new JPanel();
        keyboardPanel1.setLayout(new GridLayout(5, 4, -2, -2));
        //initialized
        for (int i = 0; i < 20; i++) {
            operatorButton1[i] = new JButton();
        }

        operatorButton1[0] = new JButton("C");
        operatorButton1[1] = new JButton("CE");
        operatorButton1[2] = new JButton("%");
        operatorButton1[3] = new JButton("+");
        operatorButton1[4] = new JButton("9");
        operatorButton1[5] = new JButton("8");
        operatorButton1[6] = new JButton("7");
        operatorButton1[7] = new JButton("-");
        operatorButton1[8] = new JButton("6");
        operatorButton1[9] = new JButton("5");
        operatorButton1[10] = new JButton("4");
        operatorButton1[11] = new JButton("*");
        operatorButton1[12] = new JButton("3");
        operatorButton1[13] = new JButton("2");
        operatorButton1[14] = new JButton("1");
        operatorButton1[15] = new JButton("/");
        operatorButton1[16] = new JButton("()");
        operatorButton1[17] = new JButton("0");
        operatorButton1[18] = new JButton(".");
        operatorButton1[19] = new JButton("=");

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (operatorButton1[i].getText().equals("" + j) || operatorButton1[i].getText().equals(".") || operatorButton1[i].getText().equals("()"))
                    operatorButton1[i].setBackground(Color.DARK_GRAY);

                operatorButton1[i].setBorder(BorderFactory.createLineBorder(Color.lightGray, 0));
            }
            operatorButton1[i].setFont(new Font("Dialog", Font.BOLD, 18));
            keyboardPanel1.add(operatorButton1[i]);
        }


        // make scientific calculator panel.
        JPanel scientific = new JPanel();  //scientific calculator panel
        scientific.setLayout(new BorderLayout(8, 5));
        scientific.setBorder(new EmptyBorder(0, 0, 0, 0));
        textArea2.setLineWrap(true);
        textArea2.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        scrollPane2.setPreferredSize(new Dimension(scrollPane2.getWidth(), scrollPane2.getHeight() + 100));

        JPanel keyboardPanel2 = new JPanel();
        keyboardPanel2.setLayout(new GridLayout(5, 6, -2, -2));
        //initialized
        for (int i = 0; i < 30; i++) {
            operatorButton2[i] = new JButton();
        }


        operatorButton2[0] = new JButton("π");
        operatorButton2[1] = new JButton("C");
        operatorButton2[2] = new JButton("CE");
        operatorButton2[3] = new JButton("%");
        operatorButton2[4] = new JButton("+");
        operatorButton2[5] = new JButton("sin");
        operatorButton2[6] = new JButton("e");
        operatorButton2[7] = new JButton("9");
        operatorButton2[8] = new JButton("8");
        operatorButton2[9] = new JButton("7");
        operatorButton2[10] = new JButton("-");
        operatorButton2[11] = new JButton("tan");
        operatorButton2[12] = new JButton("n!");
        operatorButton2[13] = new JButton("6");
        operatorButton2[14] = new JButton("5");
        operatorButton2[15] = new JButton("4");
        operatorButton2[16] = new JButton("*");
        operatorButton2[17] = new JButton("exp");
        operatorButton2[18] = new JButton("^");
        operatorButton2[19] = new JButton("3");
        operatorButton2[20] = new JButton("2");
        operatorButton2[21] = new JButton("1");
        operatorButton2[22] = new JButton("/");
        operatorButton2[23] = new JButton("log");
        operatorButton2[24] = new JButton("√");
        operatorButton2[25] = new JButton("()");
        operatorButton2[26] = new JButton("0");
        operatorButton2[27] = new JButton(".");
        operatorButton2[28] = new JButton("=");
        operatorButton2[29] = new JButton("shift");

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 10; j++)
                if (operatorButton2[i].getText().equals("" + j)) {
                    operatorButton2[i].setBackground(Color.DARK_GRAY);
                    operatorButton2[i].setBorder(BorderFactory.createLineBorder(Color.lightGray, 0));
                }
            operatorButton2[i].setFont(new Font("Dialog", Font.BOLD, 15));

            keyboardPanel2.add(operatorButton2[i]);
        }

        standard.add(scrollPane1, BorderLayout.NORTH);
        standard.add(keyboardPanel1);
        scientific.add(scrollPane2, BorderLayout.NORTH);
        scientific.add(keyboardPanel2);
        tab.addTab("Standard", standard);
        tab.addTab("Scientific", scientific);
        frame.add(tab);
    }

    /**
     * show the calculator
     */
    public void show() {
        frame.setVisible(true);
    }

}

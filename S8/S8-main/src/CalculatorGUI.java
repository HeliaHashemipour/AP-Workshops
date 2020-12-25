/**
 * Simple calculator using java GUI(swing)
 * @author Hashemipour
 * @version 0.0
 * @since 2020
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

public class CalculatorGUI {
    private final JFrame frame;
    private final JTabbedPane tab;
    private final JTextArea textArea1;
    private final JTextArea textArea2;
    private final JButton[] operatorButton1;
    private final JButton[] operatorButton2;
    private String firstOperand = "", secondOperand = "";
    private String operation = "";
    private final JMenu file;
    private final JMenuItem exit;
    private final JMenuItem copy;

    /**
     * Create a new calculator
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
        frame.setResizable(false);
        frame.setLocation(100, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tab = new JTabbedPane();
        operatorButton1 = new JButton[20];
        operatorButton2 = new JButton[30];
        textArea1 = new JTextArea();
        textArea2 = new JTextArea();
        //create new menu
        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        copy = new JMenuItem("Copy");

        frame.setFocusable(true);
        frame.addKeyListener(new Handler());
        init();
    }

    /**
     * Initialize the calculator
     */
    public void init() {
        JMenuBar menuBar = new JMenuBar();

        file.setMnemonic(KeyEvent.VK_F);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        file.add(copy);
        file.add(exit);

        copy.addActionListener(new ButtonHandler());
        exit.addActionListener(new ButtonHandler());

        menuBar.add(file);
        frame.add(menuBar, BorderLayout.NORTH);
        //make standard calculator panel.
        JPanel standard = new JPanel();   //standard calculator panel
        standard.setLayout(new BorderLayout(8, 5));
        standard.setBorder(new EmptyBorder(0, 0, 0, 0));

        textArea1.setLineWrap(true);
        textArea1.setEditable(false);
        textArea1.setFocusable(false);

        JScrollPane scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setPreferredSize(new Dimension(scrollPane1.getWidth(), scrollPane1.getHeight() + 100));

        JPanel firstKeyboardPanel = new JPanel();
        firstKeyboardPanel.setLayout(new GridLayout(5, 4, -2, -2));

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
            for (int j = 0; j < 10; j++)
                if (operatorButton1[i].getText().equals("" + j) || operatorButton1[i].getText().equals(".") || operatorButton1[i].getText().equals("()"))
                    operatorButton1[i].setBackground(Color.DARK_GRAY);

            operatorButton1[i].setFont(new Font("Arial", Font.BOLD, 15));
            operatorButton1[i].addActionListener(new ButtonHandler());
            firstKeyboardPanel.add(operatorButton1[i]);
            operatorButton1[i].setFocusable(false);

        }

        // make scientific calculator panel.
        JPanel scientific = new JPanel();  //scientific calculator panel
        scientific.setLayout(new BorderLayout(8, 5));
        scientific.setBorder(new EmptyBorder(0, 0, 0, 0));
        textArea2.setLineWrap(true);
        textArea2.setEditable(false);
        
        JScrollPane scrollPane2 = new JScrollPane(textArea2);
        scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setPreferredSize(new Dimension(scrollPane2.getWidth(), scrollPane2.getHeight() + 100));

        JPanel secondKeyboardPanel = new JPanel();
        secondKeyboardPanel.setLayout(new GridLayout(5, 6, -2, -2));

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
            operatorButton2[i].setFont(new Font("Arial", Font.BOLD, 15));
            operatorButton2[i].setSize(20,40);
            operatorButton2[i].addActionListener(new ButtonHandler());
            operatorButton2[i].addKeyListener(new Handler());
            secondKeyboardPanel.add(operatorButton2[i]);
        }

        standard.add(scrollPane1, BorderLayout.NORTH);
        standard.add(firstKeyboardPanel);
        scientific.add(scrollPane2, BorderLayout.NORTH);
        scientific.add(secondKeyboardPanel);
        tab.addTab("Standard",standard);
        tab.addTab("Scientific",scientific);
        frame.add(tab);
    }



    private class ButtonHandler implements ActionListener {
        /**
         * Action performed for calculator
         * @param e event
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = e.getActionCommand();

            if (tab.getSelectedIndex() == 0)
                calculate(str,textArea1);

            else
                calculate(str,textArea2);

            if (e.getSource().equals(exit))
                System.exit(0);

            if (e.getSource().equals(copy)) {
                String temp = textArea1.getText();
                StringSelection stringSelection = new StringSelection(temp);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        }
    }


    private class Handler extends KeyAdapter {
        /**
         * Override keyTyped method
         * @param e event
         */
        @Override
        public void keyTyped(KeyEvent e) {
            String str = "" + e.getKeyChar();
            if (tab.getSelectedIndex() == 0)
                calculate(str,textArea1);
            else
                calculate(str,textArea2);
        }


        /**
         * Override keyPressed method
         * @param e event
         */
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_Q && e.isControlDown())
                System.exit(0);
            if ((e.getKeyCode() == KeyEvent.VK_C) && e.isControlDown()) {
                String temp = textArea1.getText();
                StringSelection stringSelection = new StringSelection(temp);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
            if (e.getKeyCode() == KeyEvent.VK_F) {
                file.doClick();
            }
            if (e.getKeyCode() == KeyEvent.VK_SHIFT)
                calculate("shift",textArea2);
        }
    }



    /**
     * Calculate method
     * @param str string to put in textarea
     * @param textArea textarea in tab1 or tab2
     */
    public void calculate(String str, JTextArea textArea) {
        if ((str.charAt(0) <= '9' && str.charAt(0) >= '0')) {
            if (!operation.equals("")) {
                if (secondOperand.equals(""))
                    textArea.setText("");
                secondOperand = secondOperand + str;
            } else
                firstOperand = firstOperand + str;
            textArea.append(str);
        }
        if (str.equals(".")) {
            if (!textArea.getText().contains(".")) {
                if (textArea.getText().length() == 0)
                    str = "0.";
                if (!operation.equals(""))
                    secondOperand = secondOperand + str;
                else
                    firstOperand = firstOperand + str;
                textArea.append(str);
            }
        }
        if (str.equals("C")) {
            textArea.setText("");
            operation = firstOperand = secondOperand = "";
        }
        if (str.equals("CE")) {
            if (operation.equals(""))
                firstOperand = "";
            else
                secondOperand = "";
            textArea.setText("");
        }
        if (str.equals("=")) {
            double result;
            if (!firstOperand.equals("")) {
                if (secondOperand.equals(""))
                    secondOperand = firstOperand;
                switch (operation) {
                    case "+":
                        result = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);
                        break;
                    case "-":
                        result = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);
                        break;
                    case "*":
                        result = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);
                        break;
                    case "/":
                        result = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);
                        break;
                    case "%":
                        result = Double.parseDouble(firstOperand) % Double.parseDouble(secondOperand);
                        break;
                    default:
                        result = Double.parseDouble(firstOperand);
                }
                textArea.setText("" + result);
                firstOperand = Double.toString(result);
                secondOperand = operation = "";
            }
        }
        if (str.equals("+")) {
            if (!firstOperand.equals("")) {
                textArea.setText("");
                if (secondOperand.equals("")) {
                    operation = str;
                } else {
                    double result;
                    result = (Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand));
                    firstOperand = Double.toString(result);
                    operation = str;
                    secondOperand = "";
                    textArea.setText(firstOperand);
                }
            }
        }
        if (str.equals("-")) {
            if (!firstOperand.equals("")) {
                textArea.setText("");
                if (secondOperand.equals("")) {
                    operation = str;
                } else {
                    double result;
                    result = (Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand));
                    firstOperand = Double.toString(result);
                    operation = str;
                    secondOperand = "";
                    textArea.setText(firstOperand);
                }
            }
        }
        if (str.equals("*")) {
            if (!firstOperand.equals("")) {
                textArea.setText("");
                if (secondOperand.equals("")) {
                    operation = str;
                } else {
                    double result;
                    result = (Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand));
                    firstOperand = Double.toString(result);
                    operation = str;
                    secondOperand = "";
                    textArea.setText(firstOperand);
                }
            }
        }
        if (str.equals("/")) {
            if (!firstOperand.equals("")) {
                textArea.setText("");
                if (secondOperand.equals("")) {
                    operation = str;
                } else {
                    double result;
                    result = (Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand));
                    firstOperand = Double.toString(result);
                    operation = str;
                    secondOperand = "";
                    textArea.setText(firstOperand);
                }
            }
        }
        if (str.equals("%")) {
            if (!firstOperand.equals("")) {
                textArea.setText("");
                if (secondOperand.equals("")) {
                    operation = str;
                }
                else {
                    double result;
                    result = (Double.parseDouble(firstOperand) % Double.parseDouble(secondOperand));
                    firstOperand = Double.toString(result);
                    operation = str;
                    secondOperand = "";
                    textArea.setText(firstOperand);
                }
            }
        }
        if (tab.getSelectedIndex() == 1) {
            if (str.equals("sin")) {
                double result;
                if (!firstOperand.equals("")) {
                    if (secondOperand.equals("")) {
                        result = Math.sin(Math.toRadians(Double.parseDouble(firstOperand)));
                        firstOperand = Double.toString(result);
                    }
                    else {
                        result = Math.sin(Math.toRadians(Double.parseDouble(secondOperand)));
                        secondOperand = Double.toString(result);
                    }
                    textArea.setText("" + result);
                }
            }
            if (str.equals("cos")) {
                double result;
                if (!firstOperand.equals("")) {
                    if (secondOperand.equals("")) {
                        result = Math.cos(Math.toRadians(Double.parseDouble(firstOperand)));
                        firstOperand = Double.toString(result);
                    }
                    else {
                        result = Math.cos(Math.toRadians(Double.parseDouble(secondOperand)));
                        secondOperand = Double.toString(result);
                    }
                    textArea.setText("" + result);
                }
            }
            if (str.equals("tan")) {
                double result;
                if (!firstOperand.equals("")) {
                    if (secondOperand.equals("")) {
                        result = Math.tan(Math.toRadians(Double.parseDouble(firstOperand)));
                        firstOperand = Double.toString(result);
                    }
                    else {
                        result = Math.tan(Math.toRadians(Double.parseDouble(secondOperand)));
                        secondOperand = Double.toString(result);
                    }
                    textArea.setText("" + result);
                }
            }
            if (str.equals("cot")) {
                double result;
                if (!firstOperand.equals("")) {
                    if (secondOperand.equals("")) {
                        result = Math.cos(Math.toRadians(Double.parseDouble(firstOperand))) / Math.sin(Math.toRadians(Double.parseDouble(firstOperand)));
                        firstOperand = Double.toString(result);
                    }
                    else {
                        result = Math.cos(Math.toRadians(Double.parseDouble(secondOperand))) / Math.sin(Math.toRadians(Double.parseDouble(secondOperand)));
                        secondOperand = Double.toString(result);
                    }
                    textArea.setText("" + result);
                }
            }
            if (str.equals("shift")) {
                for (JButton jButton : operatorButton2) {
                    if (jButton.getText().equals("sin"))
                        jButton.setText("cos");
                    else if (jButton.getText().equals("cos"))
                        jButton.setText("sin");
                    if (jButton.getText().equals("tan"))
                        jButton.setText("cot");
                    else if (jButton.getText().equals("cot"))
                        jButton.setText("tan");
                }
            }
        }
    }

    /**
     * Show the calculator
     */
    public void show() {
        frame.setVisible(true);
    }
}

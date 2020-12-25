package ceit.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CFrame extends JFrame implements ActionListener {

    private CMainPanel mainPanel;
    private JMenuItem newItem;
    private JMenuItem saveItem;
    private JMenuItem exitItem;
    private JMenuItem saveDate;

    /**
     * Create a new frame
     * @param title frame title
     */
    public CFrame(String title) {
        super(title);

        initMenuBar(); //create menuBar

        initMainPanel(); //create main panel
    }

    /**
     * initialize menubar
     */
    private void initMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu jmenu = new JMenu("File");

        newItem = new JMenuItem("New");
        saveItem = new JMenuItem("Save");
        saveDate = new JMenuItem("Save Date");
        exitItem = new JMenuItem("Exit");

        newItem.addActionListener(this);
        saveItem.addActionListener(this);
        saveDate.addActionListener(this);
        exitItem.addActionListener(this);

        jmenu.add(newItem);
        jmenu.add(saveItem);
        jmenu.add(saveDate);
        jmenu.add(exitItem);

        menuBar.add(jmenu);
        setJMenuBar(menuBar);
    }

    /**
     * initialize main panel
     */
    private void initMainPanel() {
        mainPanel = new CMainPanel();
        add(mainPanel);
    }

    /**
     * override actionPerformed method
     * @param e action event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newItem) {
            mainPanel.addNewTab();
        }
        else if (e.getSource() == saveItem) {
            mainPanel.saveNote();
        }
        else if (e.getSource() == saveDate) {//add
            mainPanel.saveNoteWithDate();
        }
        else if (e.getSource() == exitItem) {
            mainPanel.saveAll();
            System.exit(0);
        } else {
            System.out.println("Nothing detected...");
        }
    }
}

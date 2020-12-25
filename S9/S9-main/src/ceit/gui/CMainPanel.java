/**
 * Main panel class
 */
package ceit.gui;

import ceit.utils.FileUtils;
import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class CMainPanel extends JPanel {

    private JTabbedPane tabbedPane;
    private JList<File> directoryList;

    /**
     * Create a new panel
     */
    public CMainPanel() {

        setLayout(new BorderLayout());

        initDirectoryList(); // add JList to main Panel

        initTabbedPane(); // add TabbedPane to main panel

        addNewTab(); // open new empty tab when user open the application
    }

    /**
     * Initialize tabbedPane
     */
    private void initTabbedPane() {
        tabbedPane = new JTabbedPane();
        add(tabbedPane, BorderLayout.CENTER);
    }

    /**
     * Initialize directory list
     */
    private void initDirectoryList() {
        File[] files = FileUtils.getFilesInDirectory();
        directoryList = new JList<>(files);
        directoryList.setBackground(new Color(211, 211, 211));
        directoryList.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        directoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        directoryList.setVisibleRowCount(-1);
        directoryList.setMinimumSize(new Dimension(130, 100));
        directoryList.setMaximumSize(new Dimension(130, 100));
        directoryList.setFixedCellWidth(130);
        directoryList.setCellRenderer(new MyCellRenderer());
        directoryList.addMouseListener(new MyMouseAdapter());

        add(new JScrollPane(directoryList), BorderLayout.WEST);
    }

    /**
     * add tab
     */
    public void addNewTab() {
        JTextArea textPanel = createTextPanel();
        textPanel.setText("Write Something here...");
        tabbedPane.addTab("Tab " + (tabbedPane.getTabCount() + 1), textPanel);
    }

    /**
     * open existing note
     * @param content note content
     */
    public void openExistingNote(String content) {
        JTextArea existPanel = createTextPanel();
        existPanel.setText(content);

        int tabIndex = tabbedPane.getTabCount() + 1;
        tabbedPane.addTab("Tab " + tabIndex, existPanel);
        tabbedPane.setSelectedIndex(tabIndex - 1);
    }

    /**
     * Save note in file
     */
    public void saveNote() {
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String note = textPanel.getText();
        if (!note.isEmpty()) {
            FileUtils.fileWriter(note);
        }
        updateListGUI();
    }

    /**
     * Save note with date in file
     */
    public void saveNoteWithDate() {//add
        JTextArea textPanel = (JTextArea) tabbedPane.getSelectedComponent();
        String content = textPanel.getText();
        if (!content.isEmpty()) {
            FileUtils.writeToFile(content);
        }
        updateListGUI();

    }

    /**
     * Save all the opening tabs
     */
    public void saveAll() {
        for (int i = 0; i < tabbedPane.getTabCount(); i++) {
            tabbedPane.setSelectedComponent(tabbedPane.getComponentAt(i));
            saveNoteWithDate();
        }
    }

    /**
     * create a new textarea
     * @return textarea
     */
    private JTextArea createTextPanel() {
        JTextArea textPanel = new JTextArea();
        textPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        return textPanel;
    }

    /**
     * update list of files
     */
    private void updateListGUI() {
        File[] newFiles = FileUtils.getFilesInDirectory();
        directoryList.setListData(newFiles);
    }


    private class MyMouseAdapter extends MouseAdapter {
        /**
         * override mouse click method
         * @param eve mouse event
         */
        @Override
        public void mouseClicked(MouseEvent eve) {
            // Double-click detected
            if (eve.getClickCount() == 2) {
                int index = directoryList.locationToIndex(eve.getPoint());
                System.out.println("Item " + index + " is clicked...");
                File[] curr = FileUtils.getFilesInDirectory();
                String content;
                try {//add
                    content = FileUtils.readFromFile(curr[index]);
                }
                catch (IOException | ClassNotFoundException e ) {
                    content = FileUtils.fileReader(curr[index]);
                }
                openExistingNote(content);
            }
        }
    }
    private class MyCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
            if (object instanceof File) {
                File file = (File) object;
                setText(file.getName());
                setIcon(FileSystemView.getFileSystemView().getSystemIcon(file));
                if (isSelected) {
                    setBackground(list.getSelectionBackground());
                    setForeground(list.getSelectionForeground());
                } else {
                    setBackground(list.getBackground());
                    setForeground(list.getForeground());
                }
                setEnabled(list.isEnabled());
            }
            return this;
        }
    }
}

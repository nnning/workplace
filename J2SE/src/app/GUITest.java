package app;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.JPopupMenu.Separator;

public class GUITest extends JFrame implements WindowListener {

    static GUITest frame = new GUITest("GUITest");
    static final String newline = System.getProperty("line.separator");
    static File output = new File("C:\\workspace\\J2SE\\output.txt");
    JTextArea display;

    public static void main(String[] args) {

        try {
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        if (!output.exists()) {
            try {
                output.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addComponentsToPane();
        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane() {
        display = new JTextArea();
        display.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(display);
        scrollPane.setPreferredSize(new Dimension(500, 450));
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(this);

    }

    public GUITest(String name) {
        super(name);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub
        ActionListener task = new ActionListener() {
            boolean alreadyDisposed = false;

            public void actionPerformed(ActionEvent e) {
                if (frame.isDisplayable()) {
                    alreadyDisposed = true;
                    frame.dispose();
                }
            }
        };
        Timer timer = new Timer(500, task); // fire every half second
        timer.setInitialDelay(2000); // first delay 2 seconds
        timer.setRepeats(false);
        timer.start();
        
        saveCurrentLocation();
    }

    private void saveCurrentLocation() {
        try {
            Point currentLocation = frame.getLocation();
            FileWriter outputStream = new FileWriter(output, false);
            outputStream.write((int) currentLocation.getX() + "" + newline);
            outputStream.write((int) currentLocation.getY() + "" + newline);
            outputStream.close();

        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(output));
            int x = Integer.parseInt(reader.readLine());
            int y = Integer.parseInt(reader.readLine());
            frame.setLocation(x, y);
            reader.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

        System.out.println("Hi, window closed!");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowActivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub

    }

}
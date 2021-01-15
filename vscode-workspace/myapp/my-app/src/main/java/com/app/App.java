package com.app;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class App {

    public static void main(String[] args) {

        Dimension d = new Dimension();
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        JButton button = new JButton("refresh");
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);

        
        

        JFrame f = new JFrame("test");
        f.setLayout(new BorderLayout());
        f.add(label, BorderLayout.CENTER);
        f.add(button, BorderLayout.SOUTH);
        f.setSize(500, 400);
        f.setVisible(true);
        
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               
            }
            
        });
        
    }

}    


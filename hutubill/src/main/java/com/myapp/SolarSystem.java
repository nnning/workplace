package com.myapp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SolarSystem extends JComponent
        implements ActionListener, KeyListener {
    private static final int DEFAULT_WIDTH = 600;
    private static final int DEFAULT_HEIGHT = 400;

    private Body[] bodies;
    private Spaceship ship;
    private int framesUntilRepaint = 1;

    // Constructs the component for representing the solar system
    public SolarSystem() {
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        bodies = new Body[] {
            addBody(1.9891e30,   0.000, 0.0000,  Color.YELLOW, "Sun"),
            addBody(3.3022e23,  57.909, 0.4787,  Color.CYAN,   "Mercury"),
            addBody(4.8685e24, 108.209, 0.3502,  Color.GREEN,  "Venus"),
            addBody(5.9736e24, 149.598, 0.29783, Color.BLUE,   "Earth"),
            addBody(6.4185e23, 227.939, 0.24077, Color.RED,    "Mars"),
            null,
        };
        resetShip();
    }

    // Returns the number of bodies in this solar system
    public int getElementCount() {
        return bodies.length;
    }

    // Returns the body in the solar system indexed as given.
    // The index should range between 0 and getElementCount() - 1
    public Body getElement(int index) {
        return bodies[index];
    }

    // You won't need to use this method: It handles processing
    // each frame
    public void actionPerformed(ActionEvent event) {
        for(Body b : bodies) b.updateDirection(this);
        for(Body b : bodies) b.step();
        framesUntilRepaint--;
        if(framesUntilRepaint <= 0) {
            framesUntilRepaint = 5;
            repaint(20);
        }
    }

    // You won't need to use this method: It is invoked whenever
    // the screen needs to be redrawn.
    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        for(Body b : bodies) b.paint(g);
    }
 
    // You won't need to use this method: It is invoked whenever the user
    // presses a keyboard key
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_UP || c == KeyEvent.VK_KP_UP
                || c == KeyEvent.VK_8 || c == KeyEvent.VK_NUMPAD8) {
            ship.setThrust(0.01);
        } else if(c == KeyEvent.VK_LEFT || c == KeyEvent.VK_KP_LEFT
                || c == KeyEvent.VK_4 || c == KeyEvent.VK_NUMPAD4) {
            ship.setRotation(-Math.PI / 200);
        } else if(c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_KP_RIGHT
                || c == KeyEvent.VK_6 || c == KeyEvent.VK_NUMPAD6) {
            ship.setRotation(Math.PI / 200);
        } else if(c == KeyEvent.VK_SPACE) {
            resetShip();
        }
    }

    // You won't need to use this method: It is invoked whenever the user
    // releases a keyboard key
    public void keyReleased(KeyEvent e) {
        int c = e.getKeyCode();
        if(c == KeyEvent.VK_UP || c == KeyEvent.VK_KP_UP
                || c == KeyEvent.VK_8 || c == KeyEvent.VK_NUMPAD8) {
            ship.setThrust(0.0);
        } else if(c == KeyEvent.VK_LEFT || c == KeyEvent.VK_KP_LEFT
                || c == KeyEvent.VK_4 || c == KeyEvent.VK_NUMPAD4) {
            ship.setRotation(0.0);
        } else if(c == KeyEvent.VK_RIGHT || c == KeyEvent.VK_KP_RIGHT
                || c == KeyEvent.VK_6 || c == KeyEvent.VK_NUMPAD6) {
            ship.setRotation(0.0);
        }
    }

    // You won't need to use this method: It is invoked whenever the user
    // types a regular keyboard key. There is nothing to do here, since
    // all such typing is handled by the keyPressed and keyReleased methods.
    // But it is required by the KeyListener interface.
    public void keyTyped(KeyEvent e) { }

    // Creates a body with the given parameters.
    private Body addBody(double mass, double dist, double vel,
            Color hue, String name) {
        return new Body(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2 - dist,
            hue, mass, name, vel, 0);
    }

    // This is called whenever the spaceship is to be reset
    private void resetShip() {
        ship = new Spaceship(DEFAULT_WIDTH / 2, DEFAULT_HEIGHT / 2 - 49.397,
            0.24077, 0);
        bodies[bodies.length - 1] = ship;
    }

    // Creates a window with a SolarSystem component inside it.
    public static void main(String[] args) {
        SolarSystem system = new SolarSystem();

        JFrame frame = new JFrame("Solar System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(system);
        frame.pack();
        frame.setVisible(true);

        system.addKeyListener(system);
        system.requestFocus();
        Timer tim = new Timer(5, system);
        tim.start();
    }
}package com.myapp;

public class SolarSystem {
    
}

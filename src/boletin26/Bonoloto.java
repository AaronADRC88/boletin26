package boletin26;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bonoloto implements ActionListener {

    private final JFrame primitiva;
    private JButton[][] botonMatriz;
    private int filas = 10, columnas = 5;

    public Bonoloto() {
        primitiva = new JFrame();
        primitiva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonMatriz = new JButton[filas][columnas];
        primitiva.setSize(800, 600);
        primitiva.setVisible(true);
        primitiva.getContentPane().add(crearApuesta(), BorderLayout.CENTER);
        primitiva.pack();
        primitiva.setMinimumSize(new Dimension(800, 600));
        primitiva.setLocationRelativeTo(null);

    }

    private JPanel crearApuesta() {
        JPanel panel = new JPanel();
        int ac;
        panel.setLayout(new GridLayout(filas, columnas, 2, 2));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        for (int i = 0; i < filas; i++) {
            ac=i;
            for (int j = 0; j < columnas; j++) {
                botonMatriz[i][j] = new JButton();
                botonMatriz[i][j].addActionListener(this);
                panel.add(botonMatriz[i][j]);
                panel.setVisible(true);
                botonMatriz[0][0].setEnabled(false);
                botonMatriz[i][j].setText(String.valueOf(ac));
                ac=ac+filas;
            }
        }
        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

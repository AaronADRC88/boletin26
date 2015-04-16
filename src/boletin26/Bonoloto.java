package boletin26;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Bonoloto implements ActionListener {

    private final JFrame primitiva;
    private JButton[][] botonMatriz;
    private final int filas = 10, columnas = 5, maxAp = 6;
    private int contador = 0;

    public Bonoloto() {
        primitiva = new JFrame();
        primitiva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonMatriz = new JButton[filas][columnas];
        primitiva.setSize(800, 600);
        primitiva.setVisible(true);
        primitiva.getContentPane().add(crearApuesta(), BorderLayout.CENTER);
        primitiva.getContentPane().add(botones(), BorderLayout.SOUTH);
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
            ac = i;
            for (int j = 0; j < columnas; j++) {
                botonMatriz[i][j] = new JButton();
                botonMatriz[i][j].addActionListener(this);
                panel.add(botonMatriz[i][j]);
                panel.setVisible(true);
                botonMatriz[0][0].setEnabled(false);
                botonMatriz[0][0].setText("apuesta");
                botonMatriz[i][j].setText(String.valueOf(ac));
                ac = ac + filas;
            }
        }
        return panel;
    }

    private JPanel botones() {
        JPanel panel = new JPanel();
        JButton limpiar = new JButton("Limpiar");
        JButton comprobar = new JButton("Comprobar boleto");
        JTextField nWin = new JTextField(18);
        JTextField nAcertado = new JTextField(10);
        JLabel numPrem = new JLabel("numero premiado: ");
        JLabel numAc = new JLabel("numero de aciertos: ");
        limpiar.addActionListener(this);
        comprobar.addActionListener(this);
        panel.add(comprobar);
        panel.add(numPrem);
        panel.add(nWin);
        panel.add(numAc);
        panel.add(nAcertado);
        panel.add(limpiar);
        return panel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eBoton = (JButton) e.getSource();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (eBoton.equals(botonMatriz[i][j])) {
                    botonMatriz[i][j].setBackground(Color.red);
                    contador++;
                    if (contador >= maxAp) {
                        for (int k = 0; k < filas; k++) {
                            for (int l = 0; l < columnas; l++) {
                                botonMatriz[k][l].setEnabled(false);
                            }
                        }
                    }
                }
            }
        }
    }

}

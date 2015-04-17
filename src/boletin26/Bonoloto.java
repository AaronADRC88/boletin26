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
    private int contador = 0, contAciert = 0;
    private int premio1, premio2, premio3, premio4, premio5, premio6;
    private JButton limpiar, comprobar;
    private JTextField nWin, nAcertado;
    private int[] numPrem=new int[6];

    public Bonoloto() {
        primitiva = new JFrame();
        primitiva.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botonMatriz = new JButton[filas][columnas];
        primitiva.setSize(200, 700);
        primitiva.setVisible(true);
        primitiva.getContentPane().add(crearApuesta(), BorderLayout.CENTER);
        primitiva.getContentPane().add(botones(), BorderLayout.SOUTH);
        primitiva.pack();
        primitiva.setMinimumSize(new Dimension(200, 700));
        primitiva.setLocationRelativeTo(null);
        comprobar.setEnabled(false);

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
        limpiar = new JButton("Limpiar");
        comprobar = new JButton("Comprobar boleto");
        nWin = new JTextField(18);
        nAcertado = new JTextField(10);
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

    public void generaNumeros() {

        premio1 = (int) (Math.random() * 49 + 1);
        premio2 = (int) (Math.random() * 49 + 1);
        do {
            if (premio2 == premio1) {
                premio2 = (int) (Math.random() * 49 + 1);
            }
        } while (premio2 == premio1);
        premio3 = (int) (Math.random() * 49 + 1);
        do {
            if (premio3 == premio1 | premio3 == premio2) {
                premio3 = (int) (Math.random() * 49 + 1);
            }
        } while (premio3 == premio1 | premio3 == premio2);
        premio4 = (int) (Math.random() * 49 + 1);
        do {
            if (premio4 == premio1 | premio4 == premio2 | premio4 == premio3) {
                premio4 = (int) (Math.random() * 49 + 1);
            }
        } while (premio4 == premio1 | premio4 == premio2 | premio4 == premio3);
        premio5 = (int) (Math.random() * 49 + 1);
        do {
            if (premio5 == premio1 | premio5 == premio2 | premio5 == premio3 | premio5 == premio4) {
                premio5 = (int) (Math.random() * 49 + 1);
            }
        } while (premio5 == premio1 | premio5 == premio2 | premio5 == premio3 | premio5 == premio4);
        premio6 = (int) (Math.random() * 49 + 1);
        do {
            if (premio6 == premio1 | premio6 == premio2 | premio6 == premio3 | premio6 == premio4 | premio6 == premio5) {
                premio6 = (int) (Math.random() * 49 + 1);
            }
        } while (premio6 == premio1 | premio6 == premio2 | premio6 == premio3 | premio6 == premio4 | premio6 == premio5);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eBoton = (JButton) e.getSource();
        if (eBoton.equals(limpiar)) {
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    for (int k = 0; k < filas; k++) {
                        for (int l = 0; l < columnas; l++) {
                            botonMatriz[0][0].setEnabled(false);
                            botonMatriz[k][l].setEnabled(true);
                            botonMatriz[k][l].setBackground(null);
                            nWin.setText(null);
                            nAcertado.setText(null);
                            contador = 0;
                            contAciert = 0;
                        }
                    }
                }
            }
        }
        if (eBoton.equals(comprobar)) {
            this.generaNumeros();
            nWin.setText(String.valueOf(premio1) + "," + String.valueOf(premio2) + "," + String.valueOf(premio3) + "," + String.valueOf(premio4) + "," + String.valueOf(premio5) + "," + String.valueOf(premio6));
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio1)) && botonMatriz[i][j].getBackground() == Color.red) {
                        botonMatriz[i][j].setBackground(Color.GREEN);
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                    }
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio2)) && botonMatriz[i][j].getBackground() == Color.red) {
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                        botonMatriz[i][j].setBackground(Color.GREEN);
                    }
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio3)) && botonMatriz[i][j].getBackground() == Color.red) {
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                        botonMatriz[i][j].setBackground(Color.GREEN);
                    }
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio4)) && botonMatriz[i][j].getBackground() == Color.red) {
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                        botonMatriz[i][j].setBackground(Color.GREEN);
                    }
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio5)) && botonMatriz[i][j].getBackground() == Color.red) {
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                        botonMatriz[i][j].setBackground(Color.GREEN);
                    }
                    if (botonMatriz[i][j].getText().equals(String.valueOf(premio6)) && botonMatriz[i][j].getBackground() == Color.red) {
                        contAciert++;
                        nAcertado.setText(String.valueOf(contAciert));
                        botonMatriz[i][j].setBackground(Color.GREEN);
                    }
                    comprobar.setEnabled(false);
                    nAcertado.setEditable(false);
                    nWin.setEditable(false);

                }
            }
        }
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (eBoton.equals(botonMatriz[i][j])) {
                    botonMatriz[i][j].setBackground(Color.red);
                    botonMatriz[i][j].setEnabled(false);

                    contador++;
                    if (contador >= maxAp) {
                        for (int k = 0; k < filas; k++) {
                            for (int l = 0; l < columnas; l++) {
                                if (botonMatriz[k][l].getBackground() != Color.red) {
                                    botonMatriz[k][l].setEnabled(false);
                                    botonMatriz[k][l].setBackground(Color.LIGHT_GRAY);
                                    comprobar.setEnabled(true);
                                }
                            }
                        }
                    }

                }
            }

        }
        if (contAciert == 6) {
            JOptionPane.showMessageDialog(null, "ERES MULTIMILLONARIO!!!");
        }
    }
}

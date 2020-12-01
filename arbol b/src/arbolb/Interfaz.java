/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolb;

import java.awt.*;
import javax.swing.*;

    

public class Interfaz extends JFrame {
    
    public int WinWidth = 700;
    public int WinHeight = 600;
    public int LROffset = 3;
    public int DownOffset = 50;
    public int nodeD = 26;
    public double levelOffset = 5.3;
    public Graphics graphics;
    public Graphics2D g;
    private JFrame frameArbol;
    private JButton bInsetar;
    private JButton bBuscar;
    private JButton bEliminar;
    private JButton bVerArbol;
    private JButton bIniciarArbol;
    private JLabel labelPalabra;
    private JLabel labelLlave;
    private JLabel labelBuscar;
    private JLabel labelEliminar;
    private JPanel control;
    private JPanel jPanel2;
    private JPanel verArbol;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JTextField llave;
    private JTextField buscar;
    private JTextField eliminar;
    private JTextField palabra;
    public JLabel Titulo;
    
    Lista datos;
    ArbolB raiz1;
    private int ordenArbol = 1;
    boolean ya = false;
    boolean existe = false;
    ArbolB raizAux = new ArbolB(2);

    public Interfaz() {
        this.setTitle("Arbol B");
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setLocation(0, 0);
        this.setSize(WinWidth, WinHeight);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Titulo = new JLabel("ARBOL B");
        Titulo.setForeground(Color.RED);
        Titulo.setFont(new Font("Monospaced", Font.BOLD, 36));
        Titulo.setBounds((WinWidth / 2) - 100, 20, 400, 50);
        this.getContentPane().add(Titulo);
        
        
        labelPalabra = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        
        control = new JPanel();
        control.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        control.setBounds((this.WinWidth / 2) - ((int) (this.WinWidth * 0.60) / 2)-120, 80, (int) (this.WinWidth * 0.85),
                        (int) (0.80 * this.WinHeight));
        control.setLayout(null);
        this.getContentPane().add(control);
        
        labelPalabra = new JLabel("texto:");
        labelPalabra.setBounds(35, 50, 50, 20);
        control.add(labelPalabra);
        
        labelLlave = new JLabel("llave:");
        labelLlave.setBounds(35, 80, 50, 20);
        control.add(labelLlave);
        
        labelBuscar = new JLabel("llave a buscar:");
        labelBuscar.setBounds(15, 150, 110, 20);
        control.add(labelBuscar);
        
        labelEliminar = new JLabel("llave a eliminar:");
        labelEliminar.setBounds(15, 200, 110, 20);
        control.add(labelEliminar);
       
        palabra = new JTextField();
        palabra.setBounds(100, 50, 190, 20);
        palabra.setVisible(true);
        control.add(palabra);
        
        llave = new JTextField();
        llave.setBounds(100, 80, 190, 20);
        llave.setVisible(true);
        control.add(llave);
        
        buscar = new JTextField();
        buscar.setBounds(130, 150, 190, 20);
        buscar.setVisible(true);
        control.add(buscar);
        
        eliminar = new JTextField();
        eliminar.setBounds(130, 200, 190, 20);
        eliminar.setVisible(true);
        control.add(eliminar);
        
        
        
        bInsetar = new JButton("Insertar");
        bInsetar.setBounds(400, 60, 100, 20);
        control.add(bInsetar);
        bInsetar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInsertarActionPerformed(evt);
            }
        });
		
        bEliminar = new JButton("Elminar");
        bEliminar.setBounds(400, 200, 100, 20);
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        control.add(bEliminar);
        
        
        bBuscar = new JButton("Buscar");
        bBuscar.setBounds(400, 150, 100, 20);
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        control.add(bBuscar);
        
        jPanel2 = new JPanel();
        bIniciarArbol = new JButton("iniciar");
        bIniciarArbol.setBounds((control.getWidth() / 2) - 50, 270, 100, 20);
        bIniciarArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIniciarArbolActionPerformed(evt);
            }
        });
        control.add(bIniciarArbol);
        
        verArbol = new JPanel();
        
        bVerArbol = new JButton("Dibujar");
        bVerArbol.setBounds((control.getWidth() / 2) - 50, 300, 100, 20);
        bVerArbol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVerArbolActionPerformed(evt);
            }
        });
        control.add(bVerArbol);
        
        control.revalidate();
        control.repaint();
        
    }

  
    /*ActionPerformed del botón buscar, el cual busca la clave dentro del árbol
    e informa si se encuentra o no.*/
    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!buscar.getText().equals("")) {
            boolean numero = raizAux.esNumero(buscar.getText());
            if (numero) {
                if (ya) {
                    boolean esta = raiz1.buscar(Integer.parseInt(buscar.getText()));
                    if (esta) {
                        JOptionPane.showMessageDialog(this, "El elemento "
                                + buscar.getText() + " SI se encuentra en el arbol B",
                                "Dato encontrado!!!", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "El elemento "
                                + buscar.getText() + " NO se encuentra en el arbol B",
                                "Dato no encontrado!!!", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
                            "Error!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Ingrese numeros entero diferentes de 0",
                        "Error!!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
                    "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        buscar.setText("");
    }
    
    /*ActionPerformed del botón ver arbol, el cual muestra el framArbol e imprime
    toda la información del arbol. */
    private void bVerArbolActionPerformed(java.awt.event.ActionEvent evt) {
        raiz1.arbol = "";
        if (ya) {
            //Se imprime la Raiz del árbol
            String raiz = "raiz [ ";
            for (int i = 0; i < raiz1.primerNodo.valores.length && raiz1.primerNodo.valores[i] != 0; i++) {
                raiz += raiz1.primerNodo.valores[i] + ", ";
            }
            raiz += " ]\n";
            
            //Se recorre el resto del árbol
            raiz += raiz1.llamarRecorrer();
            
            //Se envía la información del árbol por medio de un TextArea
            jTextArea1.setText(raiz);
        }
        frameArbol.setVisible(true);
    }
    
    

    //ActionPerformed del botón iniciar arbol, el cual inicia un árbol B grado 1.
    private void bIniciarArbolActionPerformed(java.awt.event.ActionEvent evt) {
        raiz1.arbol = "";
        datos = new Lista();
        existe = true;
        raiz1 = new ArbolB(ordenArbol);
        ya = true;
        JOptionPane.showMessageDialog(this, "Se creo un nuevo árbol B de orden "
                + ordenArbol,
                "Actualización", JOptionPane.WARNING_MESSAGE);
    }

    /*ActionPerformed del botón insertar, el cual inserta la clave dentro del árbol
    e informa si ya se encuentra o no.*/
    private void bInsertarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!llave.getText().equals("")&& !palabra.getText().equals("")) {
            boolean numero = raizAux.esNumero(llave.getText());
            if (numero) {
                boolean adentro = false;
                if (existe) {
                    for (int i = 0; i < datos.ingresados.size(); i++) {
                        if (datos.ingresados.get(i) == Integer.parseInt(llave.getText())) {
                            adentro = true;
                        }
                    }
                }
                if (!adentro) {
                    if (!llave.getText().equals("")) {
                        if (!llave.getText().equals("0")) {
                            if (ya) {
                                raiz1.insertar(Integer.parseInt(llave.getText()),palabra.getText());
                                System.out.println(raiz1.recorrer(raiz1));
                                JOptionPane.showMessageDialog(this, "El elemento "
                                        + llave.getText() + " fue ingresado al arbol B exitosamente",
                                        "Novedad", JOptionPane.WARNING_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
                                        "Error!!", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Ingrese datos diferentes de 0",
                                    "Error!!", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
                                "Error!!", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "El elemento ya habia sido ingresado previamente",
                            "Error!!", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese numeros enteros diferentes de 0",
                        "Error!!", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
                    "Error!!", JOptionPane.WARNING_MESSAGE);
        }
        llave.setText("");
        palabra.setText("");

    }
    
    /*ActionPerformed del botón Eliminar, el cual elimina la clave dentro del árbol
    e informa si se encontraba o no.*/
    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        boolean esta = false;
        boolean numero = raizAux.esNumero(eliminar.getText());
        if (!eliminar.getText().equals("")) {
            if (numero) {
                if (ya) {
                    for (int i = 0; i < datos.ingresados.size(); i++) {
                        if (datos.ingresados.get(i) == Integer.parseInt(eliminar.getText())) {
                            esta = true;
                        }
                    }
                    raiz1.eliminar(Integer.parseInt(eliminar.getText()));
                    if (esta) {
                        JOptionPane.showMessageDialog(this, "El elemento " + eliminar.getText()
                                + " fue eliminado exitosamente",
                                "Novedad", JOptionPane.WARNING_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "El elemento " + eliminar.getText()
                                + " no estaba en el arbol",
                                "Novedad", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Aun no ha creado un arbol",
                            "Error!!", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Ingrese numeros enteros diferentes de 0",
                        "Novedad", JOptionPane.WARNING_MESSAGE);

            }
            eliminar.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Ingrese datos en el campo",
                    "Error!!", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        new Interfaz();
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Lizana
 */

public class Procesor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        new MenuProcesador().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MenuProcesador extends JFrame {

    public MenuProcesador() {
    	setTitle("Editor de Texto");
        setBounds(200, 200, 400, 400);
        add(new LaminaProcesador());
        setVisible(true);

    }
}

 class LaminaProcesador extends JPanel {

    static ImageIcon i_negrita;
    static ImageIcon i_cursiva;
    static ImageIcon i_rojo;
    static ImageIcon i_verde;
    static ImageIcon i_azul;
    static ImageIcon i_sub;
    static ImageIcon i_centro;
    static ImageIcon i_derecha;

    static {
        i_negrita = new ImageIcon("icon/negrita.png");
        i_cursiva = new ImageIcon("icon/cursiva.png");
        i_rojo = new ImageIcon("icon/rojo.png");
        i_verde = new ImageIcon("icon/verde.png");
        i_azul = new ImageIcon("icon/azul.png");
        i_sub = new ImageIcon("icon/sub.png");
        i_derecha = new ImageIcon("icon/derecha.png");
        i_centro = new ImageIcon("icon/centro.png");

    }

    public LaminaProcesador() {
        setLayout(new BorderLayout());
        JPanel laminaMenu = new JPanel();
        JMenuBar mibarra = new JMenuBar();

        fuente = new JMenu("Fuentes");
        estilo = new JMenu("Estilo");
        tamano = new JMenu("Tamaño");

        ConfuguraMenu("Arial", "fuente", "Arial", 9, 10, "");
        ConfuguraMenu("Consolas", "fuente", "Cosolas", 9, 10, "");
        ConfuguraMenu("Times New Roman", "fuente", "Times New Roman", 9, 10, "");
        //-------------------------------------------------------
        //ConfuguraMenu("Negrita", "estilo", "", Font.BOLD, 10,"icon/negrita.png");
        //ConfuguraMenu("Cursiva", "estilo", "", Font.ITALIC, 10,"icon/cursiva.png");

        URL r_negrita= LaminaProcesador.class.getResource("icon/negrita.png");
        URL r_cursiva= LaminaProcesador.class.getResource("icon/cursiva.png");
        System.out.print(r_negrita);		
        JMenuItem negrita = new JMenuItem("Negrita", i_negrita);
        JMenuItem cursiva = new JMenuItem("Cursiva", i_cursiva);
        
        negrita.addActionListener(new StyledEditorKit.BoldAction());
        cursiva.addActionListener(new StyledEditorKit.ItalicAction());
        negrita.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        cursiva.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        estilo.add(negrita);
        estilo.add(cursiva);

        //-------------------------------------------------------
        /*ConfuguraMenu("12", "tamaño", "", 9, 12, "");
        ConfuguraMenu("16", "tamaño", "", 9, 16, "");
        ConfuguraMenu("20", "tamaño", "", 9, 20, "");
        ConfuguraMenu("24", "tamaño", "", 9, 24, "");
         */
        ButtonGroup grupo = new ButtonGroup();
        JRadioButtonMenuItem f12 = new JRadioButtonMenuItem("12");
        JRadioButtonMenuItem f16 = new JRadioButtonMenuItem("16");
        JRadioButtonMenuItem f20 = new JRadioButtonMenuItem("20");
        JRadioButtonMenuItem f24 = new JRadioButtonMenuItem("24");

        f12.addActionListener(new StyledEditorKit.FontSizeAction("", 12));
        f16.addActionListener(new StyledEditorKit.FontSizeAction("", 16));
        f20.addActionListener(new StyledEditorKit.FontSizeAction("", 20));
        f24.addActionListener(new StyledEditorKit.FontSizeAction("", 24));
        f24.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));

        grupo.add(f12);
        grupo.add(f16);
        grupo.add(f20);
        grupo.add(f24);

        tamano.add(f12);
        tamano.add(f16);
        tamano.add(f20);
        tamano.add(f24);

        //-------------------------------------------------------
        mibarra.add(fuente);
        mibarra.add(estilo);
        mibarra.add(tamano);
        laminaMenu.add(mibarra);
        laminaMenu.setLayout(new FlowLayout(FlowLayout.LEFT));
        add(laminaMenu, BorderLayout.NORTH);

        area = new JTextPane();
        area.setAutoscrolls(false);
        add(area, BorderLayout.CENTER);

        //-------------------------------------------------------
        pop = new JPopupMenu();
        JMenuItem aux1 = new JMenuItem("Negrita");
        JMenuItem aux2 = new JMenuItem("Cursiva");
        aux1.addActionListener(new StyledEditorKit.BoldAction());
        aux2.addActionListener(new StyledEditorKit.ItalicAction());

        pop.add(aux1);
        pop.add(aux2);
        area.setComponentPopupMenu(pop);

        //-------------------------------------------------------

        /*
        JButton neg = new JButton(new ImageIcon("icon/negrita.png"));
        JButton cur = new JButton(new ImageIcon("icon/cursiva.png"));
        JButton sub = new JButton(new ImageIcon("icon/sub.png"));
        neg.addActionListener(new StyledEditorKit.BoldAction());
        cur.addActionListener(new StyledEditorKit.ItalicAction());
        sub.addActionListener(new StyledEditorKit.UnderlineAction());
        barraHerramientas.add(neg);
        barraHerramientas.add(cur);
        barraHerramientas.add(sub);
        barraHerramientas.addSeparator();
        JButton rojo = new JButton(new ImageIcon("icon/rojo.png"));
        JButton azul = new JButton(new ImageIcon("icon/azul.png"));
        JButton verde = new JButton(new ImageIcon("icon/verde.png"));
        rojo.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.red));
        azul.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.blue));
        verde.addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.green));
        barraHerramientas.add(rojo);
        barraHerramientas.add(azul);
        barraHerramientas.add(verde);
         */
        barraHerramientas = new JToolBar();

        config_bottons(i_negrita).addActionListener(new StyledEditorKit.BoldAction());
        config_bottons(i_cursiva).addActionListener(new StyledEditorKit.ItalicAction());
        config_bottons(i_sub).addActionListener(new StyledEditorKit.UnderlineAction());
        config_bottons(i_rojo).addActionListener(new StyledEditorKit.ForegroundAction("rojo", Color.red));
        config_bottons(i_azul).addActionListener(new StyledEditorKit.ForegroundAction("azul", Color.blue));
        config_bottons(i_verde).addActionListener(new StyledEditorKit.ForegroundAction("verde", Color.green));
        barraHerramientas.addSeparator();
        config_bottons(i_centro).addActionListener(new StyledEditorKit.AlignmentAction("Centrado", 1));
        config_bottons(i_derecha).addActionListener(new StyledEditorKit.AlignmentAction("Derecha", 1));
        barraHerramientas.setOrientation(1);
        add(barraHerramientas, BorderLayout.WEST);
    }

    private JButton config_bottons(ImageIcon icon) {
        JButton botton = new JButton(icon);
        barraHerramientas.add(botton);
        return botton;
    }

    public void ConfuguraMenu(String rotulo, String menu, String tipo_letra, int estilos, int tam, String icon) {
        JMenuItem elem_menu = new JMenuItem(rotulo, new ImageIcon(icon));
        if ("fuente".equals(menu)) {
            fuente.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontFamilyAction("", rotulo));

        } else if ("estilo".equals(menu)) {
            estilo.add(elem_menu);

            if (estilos == Font.BOLD) {
                elem_menu.addActionListener(new StyledEditorKit.BoldAction());
            } else {
                elem_menu.addActionListener(new StyledEditorKit.ItalicAction());
            }

        } else if ("tamaño".equals(menu)) {
            tamano.add(elem_menu);
            elem_menu.addActionListener(new StyledEditorKit.FontSizeAction("", tam));
        }

        //  elem_menu.addActionListener(new Gestiona_Eventos(rotulo, tipo_letra, estilos, tam));
    }

    /*    private class Gestiona_Eventos implements ActionListener {
//
//        String tipo_txt, menu;
//        int estilo_letra, tamano_letra;
//
//        public Gestiona_Eventos(String elemento, String txt2, int estilo2, int tam_letra) {
//            tipo_txt = txt2;
//            estilo_letra = estilo2;
//            tamano_letra = tam_letra;
//            menu = elemento;
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent arg0) {
//            letras = area.getFont();
//            if ("Arial".equals(menu) || "Times New Roman".equals(menu) || "Consolas".equals(menu)) {
//                estilo_letra = letras.getStyle();
//                tamano_letra = letras.getSize();
//            } else if ("Negrita".equals(menu) || "Cursiva".equals(menu)) {
//                tipo_txt = letras.getFontName();
//                tamano_letra = letras.getSize();
//            } else if ("24".equals(menu) || "20".equals(menu) || "16".equals(menu) || "12".equals(menu)) {
//                estilo_letra = letras.getStyle();
//                tipo_txt = letras.getFontName();
//            }
//            area.setFont(new Font(tipo_txt, estilo_letra, tamano_letra));
//            System.out.println("Fuente: "+estilo_letra+" Estilo: "+ tipo_txt+"Tamaño: "+tamano_letra);
//        }
//
//    }
     */
    JTextPane area;
    JMenu fuente;
    JMenu estilo;
    JMenu tamano;
    Font letras;
    JPopupMenu pop;
    JToolBar barraHerramientas;

}

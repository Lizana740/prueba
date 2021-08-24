/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejem;

//import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Lizana
 */
public class LaminaBottons extends JPanel {

    private ButtonGroup grupo;

    public LaminaBottons(String nombre, Enum[] arr) {
        setBorder(new TitledBorder(nombre));
        //setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), nombre));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        grupo = new ButtonGroup();

        for (int i = 0; i < arr.length; i++) {
            JRadioButton aux = new JRadioButton(arr[i].name());
            aux.setActionCommand(arr[i].name());
            add(aux);
            grupo.add(aux);
            aux.setSelected(i == 0);
        }

    }

    public String devolverSelect() {
        return grupo.getSelection().getActionCommand();
    }

}

package eu.kprod.gui.comboBox;

import java.awt.Component;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

class MwComboBoxRenderer extends BasicComboBoxRenderer {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String name;

    public MwComboBoxRenderer(String comboBoxName){
        name = comboBoxName;
    }
    
    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
            if (-1 < index) {
                list.setToolTipText(name+" : "+ ((value == null) ? "" : value.toString() ));
            }
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        setText((value == null) ? "" : value.toString());
        return this;
    }
}
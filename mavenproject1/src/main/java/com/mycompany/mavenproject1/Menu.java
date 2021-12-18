/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.google.cloud.storage.StorageException;
import static com.mycompany.mavenproject1.firebase.leer;
import java.io.IOException;
import static java.lang.Float.parseFloat;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author leonardo
 */
public class Menu extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    TableRowSorter<TableModel> trs;
    //Tabla candidatos
    DefaultTableModel dtmCandidatos = new DefaultTableModel() {
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    public static int columna, fila;

    /**
     * Creates new form Menu
     */
    public Menu() throws InterruptedException, ExecutionException, StorageException, IOException {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(getIconImage());

        String[] titlo = new String[]{"Proyecto", "Empresa", "Fecha Ini", "Fecha Fin", "Detalles"};
        dtm.setColumnIdentifiers(titlo);
        tblCasting.setDefaultRenderer(Object.class, new RenderTable());
        tblCasting.setModel(dtm);
        agregar();
        tblCasting.setRowHeight(30);

        String[] tCandidatos = new String[]{"Nombre", "Primer Apellido", "Segundo Apellido", "Edad", "Peso kg", "Estatura (m)", "Imagen"};
        dtmCandidatos.setColumnIdentifiers(tCandidatos);
        tblCandidatos.setDefaultRenderer(Object.class, new RenderTable());
        tblCandidatos.setModel(dtmCandidatos);
        agregarCandidatos();
        tblCandidatos.setRowHeight(30);
        ocultarElementos();
    }

    public void llenarDetalles() {
        if (lblNomPro.getText().toString() == "Cereales") {
            txtDetalles.setText("Se solicitan dos niños de edad entre 5 a 11 años de altura de 1.20m y una chico de 18 años con peso de 72 kg");
        } else if (lblNomPro.getText().toString() == "Carro") {
            txtDetalles.setText("Se solicita una persona de género masculino de edad entre 22 y 30 años con peso aproximado de 72kg");
        }
    }

    //Agrega datos a la tabla del menu
    void agregar() {
        JButton btnIr = new JButton("Ir");
//        dtm.addRow(new Object[]{"Cereales", "Kellogs", "10/Nov/2021", "30/Nov/2021", btnIr});
        dtm.addRow(new Object[]{"Carro", "Toyota", "10/Nov/2021", "30/Dic/2021", btnIr});
    }
    JButton Abrir = new JButton("Abrir");
    JButton Abrir2 = new JButton("Abrir");

    //Agrega datos a tabla de Candidatos
    void agregarCandidatos() throws InterruptedException, ExecutionException, StorageException, IOException {
        Globales glo = new Globales();
        glo.casting.clear();
        leer();
        conversiones con = new conversiones();
glo.multiplex=0;
        for (int i = 0; i < glo.casting.size(); i++) {
            dtmCandidatos.addRow(new Object[]{glo.casting.get(i).getNombre(), glo.casting.get(i).getPApellido(), glo.casting.get(i).getSApellido(), con.edad(glo.casting.get(i).getFecha()), glo.casting.get(i).getPeso(), con.altura(glo.casting.get(i).getAltura()), Abrir});
        }
    }
  void agregarCandidatosF() throws InterruptedException, ExecutionException, StorageException, IOException {
        Globales glo = new Globales();

        conversiones con = new conversiones();
glo.multiplex=1;
        for (int i = 0; i < glo.filtro.size(); i++) {
            dtmCandidatos.addRow(new Object[]{glo.filtro.get(i).getNombre(), glo.filtro.get(i).getPApellido(), glo.filtro.get(i).getSApellido(), con.edad(glo.filtro.get(i).getFecha()), glo.filtro.get(i).getPeso(), con.altura(glo.filtro.get(i).getAltura()), Abrir2});
        }
    }
    void ocultarElementos() {
        //Botones no visibles
        btnDetalles.setVisible(false);
        btnCandidatos.setVisible(false);
        jSeparator3.setVisible(false);
        jSeparator4.setVisible(false);
        //Paneles no visibles
        pnlCasting.setVisible(true);
        pnlDetalles.setVisible(false);
        pnlCandidatos.setVisible(false);
        rbRanEdad.setVisible(false);
        rbEsEdad.setVisible(false);
        txtEdadFin.setVisible(false);
        txtEdadIni.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        txtEdad.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        rbRangoPeso.setVisible(false);
        rbEsPeso.setVisible(false);
        jLabel16.setVisible(false);
        jLabel18.setVisible(false);
        txtPesoIni.setVisible(false);
        txtPesoFin.setVisible(false);
        jLabel14.setVisible(false);
        txtPeso.setVisible(false);
        jLabel17.setVisible(false);
        rbRanEst.setVisible(false);
        rbEsEst.setVisible(false);
        jLabel21.setVisible(false);
        txtEstatura.setVisible(false);
        jLabel23.setVisible(false);
        jLabel22.setVisible(false);
        txtFinEst.setVisible(false);
        jLabel20.setVisible(false);
        txtIniEst.setVisible(false);
        jLabel19.setVisible(false);
        btnBuscar.setVisible(false);
    }

    void obtener_datos(int a) {
        lblNomPro.setText(tblCasting.getValueAt(a, 0).toString());
        lblEmpresa.setText(tblCasting.getValueAt(a, 1).toString());
        lblFIni.setText(tblCasting.getValueAt(a, 2).toString());
        lblFfin.setText(tblCasting.getValueAt(a, 3).toString());
    }

    public void limpiarTabla(JTable tabla) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }

    void buscartres() {
        Globales glo = new Globales();
        conversiones con = new conversiones();
        glo.filtro.clear();
        if (rbEsEdad.isSelected() && rbEsEst.isSelected() && rbEsPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbEsEst.isSelected() && rbRangoPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbRanEst.isSelected() && rbEsPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbRanEst.isSelected() && rbRangoPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbEsEst.isSelected() && rbEsPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbEsEst.isSelected() && rbRangoPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbRanEst.isSelected() && rbEsPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbRanEst.isSelected() && rbRangoPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
    }

    void buscarPesoEstatura() {
        Globales glo = new Globales();
        conversiones con = new conversiones();
        glo.filtro.clear();
        if (rbRanEst.isSelected() && rbRangoPeso.isSelected()) {

            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEst.isSelected() && rbEsPeso.isSelected()) {
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF)) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEst.isSelected() && rbRangoPeso.isSelected()) {
            double estatura = Double.parseDouble(txtEstatura.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEst.isSelected() && rbEsPeso.isSelected()) {
            double estatura = Double.parseDouble(txtEstatura.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Double.parseDouble(glo.casting.get(i).getAltura()) == estatura) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
    }

    void buscarEdadEstatura() {
        Globales glo = new Globales();
        conversiones con = new conversiones();
        glo.filtro.clear();
        if (rbRanEdad.isSelected() && rbRanEst.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbEsEst.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbRanEst.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && ((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbEsEst.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            double estatura = Double.parseDouble(txtEstatura.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && (Double.parseDouble(glo.casting.get(i).getAltura()) == estatura)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
    }

    void buscarEdadPeso() {
        Globales glo = new Globales();
        conversiones con = new conversiones();
        glo.filtro.clear();
        if (rbRanEdad.isSelected() && rbRangoPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbRanEdad.isSelected() && rbEsPeso.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF)) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbRangoPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && ((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
        if (rbEsEdad.isSelected() && rbEsPeso.isSelected()) {
            int edad = Integer.parseInt(txtEdad.getText());
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad) && (Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
    }

    void buscarPeso() {
        Globales glo = new Globales();
        glo.filtro.clear();
        if (rbEsPeso.isSelected()) {
            float peso = Float.parseFloat(txtPeso.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Float.parseFloat(glo.casting.get(i).getPeso()) == peso)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        } else {
            float pesoini = Float.parseFloat(txtPesoIni.getText());
            float pesoFin = Float.parseFloat(txtPesoFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Float.parseFloat(glo.casting.get(i).getPeso()) > pesoini) && (Float.parseFloat(glo.casting.get(i).getPeso()) < pesoFin))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }

        }
    }

    void buscarEstatura() {
 Globales glo = new Globales();
        glo.filtro.clear();
        if (rbRanEst.isSelected()) {
            double estaturaI = Double.parseDouble(txtIniEst.getText());
            double estaturaF = Double.parseDouble(txtFinEst.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Double.parseDouble(glo.casting.get(i).getAltura()) > estaturaI) && (Double.parseDouble(glo.casting.get(i).getAltura()) < estaturaF))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }else{
double estatura = Double.parseDouble(txtEstatura.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Double.parseDouble(glo.casting.get(i).getAltura()) == estatura)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
}
    }

    void buscarEdad() {
        Globales glo = new Globales();
        conversiones con = new conversiones();
        glo.filtro.clear();
        if (rbRanEdad.isSelected()) {
            int edadI = Integer.parseInt(txtEdadIni.getText());
            int edadF = Integer.parseInt(txtEdadFin.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if (((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) > edadI) && (Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) < edadF))) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        } else {
            int edad = Integer.parseInt(txtEdad.getText());
            for (int i = 0; i < glo.casting.size(); i++) {
                if ((Integer.parseInt(con.edad(glo.casting.get(i).getFecha())) == edad)) {
                    glo.filtro.add(glo.casting.get(i));
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Edad = new javax.swing.ButtonGroup();
        Peso = new javax.swing.ButtonGroup();
        Altura = new javax.swing.ButtonGroup();
        pnlCandidatos = new javax.swing.JPanel();
        lblDetalles1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCandidatos = new javax.swing.JTable();
        rbRanEdad = new javax.swing.JRadioButton();
        rbEsEdad = new javax.swing.JRadioButton();
        txtEdadFin = new javax.swing.JTextField();
        txtEdadIni = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        checkEdad = new javax.swing.JCheckBox();
        checkPeso = new javax.swing.JCheckBox();
        rbRangoPeso = new javax.swing.JRadioButton();
        rbEsPeso = new javax.swing.JRadioButton();
        txtPesoIni = new javax.swing.JTextField();
        txtPesoFin = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rbRanEst = new javax.swing.JRadioButton();
        rbEsEst = new javax.swing.JRadioButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        checkEstatura = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtIniEst = new javax.swing.JTextField();
        txtFinEst = new javax.swing.JTextField();
        txtEstatura = new javax.swing.JTextField();
        lblDetalles2 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        pnlDetalles = new javax.swing.JPanel();
        lblDetalles = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblNomPro = new javax.swing.JLabel();
        lblFIni = new javax.swing.JLabel();
        lblContrato = new javax.swing.JLabel();
        lblFfin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalles = new javax.swing.JTextPane();
        pnlMenu = new javax.swing.JPanel();
        btnCasting = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDetalles = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        btnCandidatos = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        pnlCasting = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblCasting = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCandidatos.setBackground(new java.awt.Color(255, 255, 255));
        pnlCandidatos.setPreferredSize(new java.awt.Dimension(780, 600));
        pnlCandidatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDetalles1.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        lblDetalles1.setForeground(new java.awt.Color(0, 51, 102));
        lblDetalles1.setText("Filtrar por: ");
        pnlCandidatos.add(lblDetalles1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 40));

        tblCandidatos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(18, 33, 97)));
        tblCandidatos.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        tblCandidatos.setForeground(new java.awt.Color(18, 33, 97));
        tblCandidatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCandidatos.setGridColor(new java.awt.Color(18, 33, 97));
        tblCandidatos.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tblCandidatos.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblCandidatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCandidatosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCandidatos);

        pnlCandidatos.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 760, 210));

        rbRanEdad.setBackground(new java.awt.Color(255, 255, 255));
        Edad.add(rbRanEdad);
        rbRanEdad.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbRanEdad.setForeground(new java.awt.Color(0, 51, 102));
        rbRanEdad.setText("Rango");
        rbRanEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRanEdadMouseClicked(evt);
            }
        });
        rbRanEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbRanEdadActionPerformed(evt);
            }
        });
        pnlCandidatos.add(rbRanEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        rbEsEdad.setBackground(new java.awt.Color(255, 255, 255));
        Edad.add(rbEsEdad);
        rbEsEdad.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbEsEdad.setForeground(new java.awt.Color(0, 51, 102));
        rbEsEdad.setText("Especifico");
        rbEsEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEsEdadMouseClicked(evt);
            }
        });
        pnlCandidatos.add(rbEsEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtEdadFin.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtEdadFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadFinKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtEdadFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 90, 30));

        txtEdadIni.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtEdadIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadIniKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtEdadIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 30));

        txtEdad.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdadKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel11.setText("años");
        pnlCandidatos.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 50, -1));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel12.setText("años");
        pnlCandidatos.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 60, 20));

        jLabel13.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel13.setText("De");
        pnlCandidatos.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel14.setText("A");
        pnlCandidatos.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 40, -1));

        checkEdad.setBackground(new java.awt.Color(255, 255, 255));
        checkEdad.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        checkEdad.setForeground(new java.awt.Color(0, 51, 102));
        checkEdad.setText("Edad");
        checkEdad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkEdadMouseClicked(evt);
            }
        });
        pnlCandidatos.add(checkEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        checkPeso.setBackground(new java.awt.Color(255, 255, 255));
        checkPeso.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        checkPeso.setForeground(new java.awt.Color(0, 51, 102));
        checkPeso.setText("Peso");
        checkPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkPesoMouseClicked(evt);
            }
        });
        pnlCandidatos.add(checkPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, -1, -1));

        rbRangoPeso.setBackground(new java.awt.Color(255, 255, 255));
        Peso.add(rbRangoPeso);
        rbRangoPeso.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbRangoPeso.setForeground(new java.awt.Color(0, 51, 102));
        rbRangoPeso.setText("Rango");
        rbRangoPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRangoPesoMouseClicked(evt);
            }
        });
        pnlCandidatos.add(rbRangoPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        rbEsPeso.setBackground(new java.awt.Color(255, 255, 255));
        Peso.add(rbEsPeso);
        rbEsPeso.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbEsPeso.setForeground(new java.awt.Color(0, 51, 102));
        rbEsPeso.setText("Especifico");
        rbEsPeso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEsPesoMouseClicked(evt);
            }
        });
        pnlCandidatos.add(rbEsPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, -1, -1));

        txtPesoIni.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtPesoIni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoIniKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoIniKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtPesoIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 90, -1));

        txtPesoFin.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtPesoFin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoFinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoFinKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtPesoFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 220, 90, 30));

        txtPeso.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPesoKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 90, -1));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel16.setText("De");
        pnlCandidatos.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel17.setText("kg");
        pnlCandidatos.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 20, -1));

        rbRanEst.setBackground(new java.awt.Color(255, 255, 255));
        Altura.add(rbRanEst);
        rbRanEst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbRanEst.setForeground(new java.awt.Color(0, 51, 102));
        rbRanEst.setText("Rango");
        rbRanEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbRanEstMouseClicked(evt);
            }
        });
        pnlCandidatos.add(rbRanEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, -1, -1));

        rbEsEst.setBackground(new java.awt.Color(255, 255, 255));
        Altura.add(rbEsEst);
        rbEsEst.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        rbEsEst.setForeground(new java.awt.Color(0, 51, 102));
        rbEsEst.setText("Especifico");
        rbEsEst.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbEsEstMouseClicked(evt);
            }
        });
        pnlCandidatos.add(rbEsEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, -1, -1));

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel18.setText("A");
        pnlCandidatos.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 40, 20));

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel19.setText("kg");
        pnlCandidatos.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 20, 30));

        checkEstatura.setBackground(new java.awt.Color(255, 255, 255));
        checkEstatura.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        checkEstatura.setForeground(new java.awt.Color(0, 51, 102));
        checkEstatura.setText("Estatura");
        checkEstatura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkEstaturaMouseClicked(evt);
            }
        });
        pnlCandidatos.add(checkEstatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel20.setText("cm");
        pnlCandidatos.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 20, 20));

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel21.setText("De");
        pnlCandidatos.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, -1, -1));

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel23.setText("cm");
        pnlCandidatos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 170, 20, -1));

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 16)); // NOI18N
        jLabel22.setText("A");
        pnlCandidatos.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 40, -1));

        txtIniEst.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtIniEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIniEstKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIniEstKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtIniEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 90, 30));

        txtFinEst.setFont(new java.awt.Font("Yu Gothic Light", 1, 14)); // NOI18N
        txtFinEst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFinEstKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinEstKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtFinEst, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 90, 30));

        txtEstatura.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 14)); // NOI18N
        txtEstatura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEstaturaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEstaturaKeyTyped(evt);
            }
        });
        pnlCandidatos.add(txtEstatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 90, 30));

        lblDetalles2.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        lblDetalles2.setForeground(new java.awt.Color(0, 51, 102));
        lblDetalles2.setText("Candidatos");
        pnlCandidatos.add(lblDetalles2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        btnBuscar.setBackground(new java.awt.Color(18, 33, 97));
        btnBuscar.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 20)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlCandidatos.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 110, 40));

        getContentPane().add(pnlCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        pnlDetalles.setBackground(new java.awt.Color(255, 255, 255));
        pnlDetalles.setPreferredSize(new java.awt.Dimension(780, 600));

        lblDetalles.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        lblDetalles.setForeground(new java.awt.Color(0, 51, 102));
        lblDetalles.setText("Detalles del Proyecto");

        lblEmpresa.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblEmpresa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblEmpresa.setToolTipText("");
        lblEmpresa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel5.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 102));
        jLabel5.setText("Nombre del proyecto:");

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Contrato:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 102));
        jLabel7.setText("Empresa:");

        jLabel8.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 102));
        jLabel8.setText("Fecha de inicio:");

        jLabel9.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 102));
        jLabel9.setText("Fecha de fin:");

        jLabel10.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 102));
        jLabel10.setText("Detalles del proyecto:");

        lblNomPro.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblNomPro.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNomPro.setToolTipText("");
        lblNomPro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblFIni.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblFIni.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFIni.setToolTipText("");
        lblFIni.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblContrato.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblContrato.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblContrato.setToolTipText("");
        lblContrato.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblFfin.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        lblFfin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblFfin.setToolTipText("");
        lblFfin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtDetalles.setEditable(false);
        txtDetalles.setBorder(null);
        txtDetalles.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 20)); // NOI18N
        txtDetalles.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtDetalles);

        javax.swing.GroupLayout pnlDetallesLayout = new javax.swing.GroupLayout(pnlDetalles);
        pnlDetalles.setLayout(pnlDetallesLayout);
        pnlDetallesLayout.setHorizontalGroup(
            pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetallesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlDetallesLayout.createSequentialGroup()
                        .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDetalles)
                            .addComponent(lblContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDetallesLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFIni, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDetallesLayout.createSequentialGroup()
                    .addGap(209, 209, 209)
                    .addComponent(lblFfin, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(261, Short.MAX_VALUE)))
        );
        pnlDetallesLayout.setVerticalGroup(
            pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetallesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblDetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lblNomPro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblFIni, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lblContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDetallesLayout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(lblFfin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(359, Short.MAX_VALUE)))
        );

        getContentPane().add(pnlDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        pnlMenu.setBackground(new java.awt.Color(18, 33, 97));
        pnlMenu.setMinimumSize(new java.awt.Dimension(320, 600));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCasting.setBackground(new java.awt.Color(18, 33, 97));
        btnCasting.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        btnCasting.setForeground(new java.awt.Color(255, 255, 255));
        btnCasting.setText("Casting");
        btnCasting.setBorder(null);
        btnCasting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCastingActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCasting, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 300, 38));
        pnlMenu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 250, 10));

        jLabel2.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\letras.png")); // NOI18N
        pnlMenu.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 450, 290, 70));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\IconoP.png")); // NOI18N
        pnlMenu.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 23, 110, 110));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dinah Arellano");
        pnlMenu.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 134, -1, -1));

        btnDetalles.setBackground(new java.awt.Color(18, 33, 97));
        btnDetalles.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        btnDetalles.setForeground(new java.awt.Color(255, 255, 255));
        btnDetalles.setText("Detalles");
        btnDetalles.setBorder(null);
        btnDetalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetallesActionPerformed(evt);
            }
        });
        pnlMenu.add(btnDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 300, 38));
        pnlMenu.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 250, 10));

        btnCandidatos.setBackground(new java.awt.Color(18, 33, 97));
        btnCandidatos.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 22)); // NOI18N
        btnCandidatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCandidatos.setText("Candidatos");
        btnCandidatos.setBorder(null);
        btnCandidatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCandidatosActionPerformed(evt);
            }
        });
        pnlMenu.add(btnCandidatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 300, 38));
        pnlMenu.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 250, 10));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 600));

        pnlCasting.setBackground(new java.awt.Color(255, 255, 255));
        pnlCasting.setPreferredSize(new java.awt.Dimension(780, 600));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 33, 97));
        jLabel1.setText("Castings");

        tblCasting.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(18, 33, 97)));
        tblCasting.setFont(new java.awt.Font("Yu Gothic Medium", 0, 18)); // NOI18N
        tblCasting.setForeground(new java.awt.Color(18, 33, 97));
        tblCasting.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblCasting.setGridColor(new java.awt.Color(18, 33, 97));
        tblCasting.setSelectionBackground(new java.awt.Color(204, 204, 255));
        tblCasting.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tblCasting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCastingMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblCasting);

        javax.swing.GroupLayout pnlCastingLayout = new javax.swing.GroupLayout(pnlCasting);
        pnlCasting.setLayout(pnlCastingLayout);
        pnlCastingLayout.setHorizontalGroup(
            pnlCastingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCastingLayout.createSequentialGroup()
                .addGap(303, 303, 303)
                .addComponent(jLabel1)
                .addContainerGap(303, Short.MAX_VALUE))
            .addGroup(pnlCastingLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlCastingLayout.setVerticalGroup(
            pnlCastingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCastingLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCasting, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbRanEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRanEdadMouseClicked
        txtEdadFin.setVisible(true);
        txtEdadIni.setVisible(true);
        txtEdad.setVisible(false);
        jLabel11.setVisible(true);
        jLabel12.setVisible(true);
        jLabel13.setVisible(true);
        jLabel14.setVisible(true);
        btnBuscar.setVisible(true);
        txtEdad.setText("");
    }//GEN-LAST:event_rbRanEdadMouseClicked

    private void rbEsEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEsEdadMouseClicked
        txtEdadFin.setVisible(false);
        txtEdadIni.setVisible(false);
        txtEdad.setVisible(true);
        jLabel11.setVisible(true);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        btnBuscar.setVisible(true);


    }//GEN-LAST:event_rbEsEdadMouseClicked

    private void checkEdadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEdadMouseClicked
        if (checkEdad.isSelected()) {
            rbRanEdad.setVisible(true);
            rbEsEdad.setVisible(true);

        } else {
            rbRanEdad.setVisible(false);
            rbEsEdad.setVisible(false);
            txtEdadFin.setVisible(false);
            txtEdadIni.setVisible(false);
            txtEdad.setVisible(false);
            jLabel11.setVisible(false);
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);

        }
    }//GEN-LAST:event_checkEdadMouseClicked

    private void checkPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkPesoMouseClicked
        if (checkPeso.isSelected()) {
            rbRangoPeso.setVisible(true);
            rbEsPeso.setVisible(true);
        } else {
            rbRangoPeso.setVisible(false);
            rbEsPeso.setVisible(false);
            jLabel16.setVisible(false);
            jLabel18.setVisible(false);
            jLabel19.setVisible(false);
            txtPesoIni.setVisible(false);
            txtPesoFin.setVisible(false);
            txtPeso.setVisible(false);
            jLabel17.setVisible(false);
        }

    }//GEN-LAST:event_checkPesoMouseClicked

    private void rbRangoPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRangoPesoMouseClicked
        jLabel16.setVisible(true);
        jLabel18.setVisible(true);
        txtPesoIni.setVisible(true);
        txtPesoFin.setVisible(true);
        jLabel19.setVisible(true);
        txtPeso.setVisible(false);
        jLabel17.setVisible(true);
        btnBuscar.setVisible(true);
        txtPeso.setText("");
    }//GEN-LAST:event_rbRangoPesoMouseClicked

    private void rbEsPesoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEsPesoMouseClicked
        jLabel16.setVisible(false);
        jLabel18.setVisible(false);
        jLabel19.setVisible(false);
        txtPesoIni.setVisible(false);
        txtPesoFin.setVisible(false);
        txtPeso.setVisible(true);
        jLabel17.setVisible(true);

        btnBuscar.setVisible(true);

    }//GEN-LAST:event_rbEsPesoMouseClicked

    private void txtPesoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyReleased
        if (!txtPeso.getText().isEmpty()) {
            int veces = 0;
            char[] caracteres = txtPeso.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtPeso.setText(txtPeso.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtPeso.getText()) > 600) {
                txtPeso.setText("600");
            }
            if (parseFloat(txtPeso.getText()) < 22 && txtPeso.getText().length() >= 2) {
                txtPeso.setText("22");
            }
        }
    }//GEN-LAST:event_txtPesoKeyReleased

    private void rbRanEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbRanEstMouseClicked
        jLabel21.setVisible(true);
        txtEstatura.setVisible(false);
        jLabel23.setVisible(true);
        jLabel22.setVisible(true);
        txtFinEst.setVisible(true);
        jLabel20.setVisible(true);
        txtIniEst.setVisible(true);
        btnBuscar.setVisible(true);
        txtEstatura.setText("");
    }//GEN-LAST:event_rbRanEstMouseClicked

    private void rbEsEstMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbEsEstMouseClicked
        jLabel21.setVisible(false);
        txtEstatura.setVisible(true);
        jLabel23.setVisible(true);
        jLabel22.setVisible(false);
        txtFinEst.setVisible(false);
        jLabel20.setVisible(false);
        txtIniEst.setVisible(false);

        btnBuscar.setVisible(true);

    }//GEN-LAST:event_rbEsEstMouseClicked

    private void checkEstaturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkEstaturaMouseClicked
        if (checkEstatura.isSelected()) {
            rbRanEst.setVisible(true);
            rbEsEst.setVisible(true);
        } else {
            rbRanEst.setVisible(false);
            rbEsEst.setVisible(false);
            jLabel21.setVisible(false);
            txtEstatura.setVisible(false);
            jLabel23.setVisible(false);
            jLabel22.setVisible(false);
            txtFinEst.setVisible(false);
            jLabel20.setVisible(false);
            txtIniEst.setVisible(false);
        }

    }//GEN-LAST:event_checkEstaturaMouseClicked

    private void txtEstaturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstaturaKeyReleased
        if (!txtIniEst.getText().isEmpty()) {
            int veces = 0;
            char[] caracteres = txtIniEst.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtIniEst.setText(txtIniEst.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtIniEst.getText()) > 272) {
                txtIniEst.setText("272");
            }
            if (parseFloat(txtIniEst.getText()) < 72.1 && txtIniEst.getText().length() >= 2) {
                txtIniEst.setText("72.1");
            }
        }
    }//GEN-LAST:event_txtEstaturaKeyReleased

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        limpiarTabla(tblCandidatos);
        if (checkEdad.isSelected() && checkPeso.isSelected() && checkEstatura.isSelected()) {
            buscartres();
        } else if (checkEdad.isSelected() && checkPeso.isSelected()) {
            buscarEdadPeso();

        } else if (checkEdad.isSelected() && checkEstatura.isSelected()) {
            buscarEdadEstatura();
        } else if (checkPeso.isSelected() && checkEstatura.isSelected()) {
            buscarPesoEstatura();
        } else if (checkEdad.isSelected()) {
            buscarEdad();
        } else if (checkPeso.isSelected()) {
            buscarPeso();
        } else if (checkEstatura.isSelected()) {
            buscarEstatura();
        } else {
            try {
                agregarCandidatos();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        try {
                agregarCandidatosF();
            } catch (Exception e) {
                System.out.println(e);
            }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCastingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCastingActionPerformed
        ocultarElementos();

    }//GEN-LAST:event_btnCastingActionPerformed

    private void btnDetallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetallesActionPerformed
        pnlDetalles.setVisible(true);
        pnlCandidatos.setVisible(false);
        pnlCasting.setVisible(false);
    }//GEN-LAST:event_btnDetallesActionPerformed

    private void btnCandidatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCandidatosActionPerformed
        pnlDetalles.setVisible(false);
        pnlCandidatos.setVisible(true);
        pnlCasting.setVisible(false);
    }//GEN-LAST:event_btnCandidatosActionPerformed

    private void tblCastingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCastingMouseClicked
        int column = tblCasting.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tblCasting.getRowHeight();

        if (row < tblCasting.getRowCount() && row >= 0 && column < tblCasting.getColumnCount() && column >= 0) {
            Object value = tblCasting.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                String texto = new String();
                texto = tblCasting.getValueAt(row, 0).toString();
                pnlCasting.setVisible(false);
                pnlDetalles.setVisible(true);
                btnDetalles.setVisible(true);
                btnCandidatos.setVisible(true);

                jSeparator3.setVisible(true);
                jSeparator4.setVisible(true);

                obtener_datos(row);
                llenarDetalles();
                btnDetalles.requestFocus();
            }
        }
    }//GEN-LAST:event_tblCastingMouseClicked

    private void txtEdadIniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadIniKeyTyped
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9'))) {
            evt.consume();
        }
        if (txtEdadIni.getText().length() == 2)
            evt.consume();      // TODO add your handling code here:
    }//GEN-LAST:event_txtEdadIniKeyTyped

    private void txtEdadFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadFinKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9'))) {
            evt.consume();
        }
        if (txtEdadFin.getText().length() == 2)
            evt.consume();
    }//GEN-LAST:event_txtEdadFinKeyTyped

    private void txtPesoIniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoIniKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtPesoIni.getText().length() == 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPesoIniKeyTyped

    private void txtPesoIniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoIniKeyReleased
        if (!txtPesoIni.getText().isEmpty()) {
            int veces = 0;
            char[] caracteres = txtPesoIni.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtPesoIni.setText(txtPesoIni.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtPesoIni.getText()) > 600) {
                txtPesoIni.setText("600");
            }
            if (parseFloat(txtPesoIni.getText()) < 22 && txtPesoIni.getText().length() >= 2) {
                txtPesoIni.setText("22");
            }
        }

    }//GEN-LAST:event_txtPesoIniKeyReleased

    private void txtPesoFinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoFinKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtPesoFin.getText().length() == 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtPesoFinKeyTyped

    private void txtPesoFinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoFinKeyReleased
        if (!txtPesoFin.getText().isEmpty()) {
            int veces = 0;
            double aux = 0;
            char[] caracteres = txtPesoFin.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtPesoFin.setText(txtPesoFin.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtPesoFin.getText()) > 600) {
                txtPesoFin.setText("600");
            }
            if (parseFloat(txtPesoFin.getText()) < parseFloat(txtPesoIni.getText()) && txtPesoFin.getText().length() == 2) {
                txtPesoFin.setText(Float.toString(parseFloat(txtPesoIni.getText()) + 1));
            }
        }
    }//GEN-LAST:event_txtPesoFinKeyReleased

    private void txtIniEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIniEstKeyTyped
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtIniEst.getText().length() == 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtIniEstKeyTyped

    private void txtIniEstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIniEstKeyReleased
        // TODO add your handling code here:
        if (!txtIniEst.getText().isEmpty()) {
            int veces = 0;
            char[] caracteres = txtIniEst.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtIniEst.setText(txtIniEst.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtIniEst.getText()) > 272) {
                txtIniEst.setText("272");
            }
            if (parseFloat(txtIniEst.getText()) < 72.1 && txtIniEst.getText().length() >= 2) {
                txtIniEst.setText("72.1");
            }
        }
    }//GEN-LAST:event_txtIniEstKeyReleased

    private void txtFinEstKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinEstKeyReleased
        // TODO add your handling code here:
        if (!txtFinEst.getText().isEmpty()) {
            int veces = 0;
            char[] caracteres = txtFinEst.getText().toCharArray();
            for (int i = 0; i < caracteres.length; i++) {
                if ('.' == caracteres[i]) {
                    veces++;
                    if (veces > 1) {
                        txtFinEst.setText(txtFinEst.getText().substring(0, i));
                        break;
                    }
                }
            }
            if (parseFloat(txtFinEst.getText()) > 272) {
                txtIniEst.setText("272");
            }
            if (parseFloat(txtFinEst.getText()) < parseFloat(txtIniEst.getText()) && txtFinEst.getText().length() >= 2) {
                txtFinEst.setText(Float.toString(parseFloat(txtIniEst.getText()) + 1));
            }
        }
    }//GEN-LAST:event_txtFinEstKeyReleased

    private void txtFinEstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinEstKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtFinEst.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFinEstKeyTyped

    private void txtEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdadKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9'))) {
            evt.consume();
        }
        if (txtEdad.getText().length() == 2)
            evt.consume();
    }//GEN-LAST:event_txtEdadKeyTyped

    private void txtPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesoKeyTyped
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtPeso.getText().length() == 4) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPesoKeyTyped

    private void txtEstaturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEstaturaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (((validar < '0') || (validar > '9')) && ((validar < '.') || (validar > '.'))) {
            evt.consume();
        }
        if (txtIniEst.getText().length() == 4) {
            evt.consume();
        }

    }//GEN-LAST:event_txtEstaturaKeyTyped

    private void tblCandidatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCandidatosMouseClicked
        // TODO add your handling code here:
        columna = tblCandidatos.getColumnModel().getColumnIndexAtX(evt.getX());
        fila = evt.getY() / tblCandidatos.getRowHeight();

        if ((columna <= tblCandidatos.getColumnCount()) && (columna >= 0) && (fila <= tblCandidatos.getRowCount()) && (fila >= 0)) {
            Object objeto = tblCandidatos.getValueAt(fila, columna);
            if (objeto instanceof JButton) {

                Globales g = new Globales();
                g.index = fila;
                
                prueba p = new prueba();
                p.setVisible(true);

            }
        }
    }//GEN-LAST:event_tblCandidatosMouseClicked

    private void rbRanEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbRanEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbRanEdadActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Menu().setVisible(true);
                } catch (Exception e) {
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Altura;
    private javax.swing.ButtonGroup Edad;
    private javax.swing.ButtonGroup Peso;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCandidatos;
    private javax.swing.JButton btnCasting;
    private javax.swing.JButton btnDetalles;
    private javax.swing.JCheckBox checkEdad;
    private javax.swing.JCheckBox checkEstatura;
    private javax.swing.JCheckBox checkPeso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lblContrato;
    private javax.swing.JLabel lblDetalles;
    private javax.swing.JLabel lblDetalles1;
    private javax.swing.JLabel lblDetalles2;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFIni;
    private javax.swing.JLabel lblFfin;
    private javax.swing.JLabel lblNomPro;
    private javax.swing.JPanel pnlCandidatos;
    private javax.swing.JPanel pnlCasting;
    private javax.swing.JPanel pnlDetalles;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JRadioButton rbEsEdad;
    private javax.swing.JRadioButton rbEsEst;
    private javax.swing.JRadioButton rbEsPeso;
    private javax.swing.JRadioButton rbRanEdad;
    private javax.swing.JRadioButton rbRanEst;
    private javax.swing.JRadioButton rbRangoPeso;
    private javax.swing.JTable tblCandidatos;
    private javax.swing.JTable tblCasting;
    private javax.swing.JTextPane txtDetalles;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtEdadFin;
    private javax.swing.JTextField txtEdadIni;
    private javax.swing.JTextField txtEstatura;
    private javax.swing.JTextField txtFinEst;
    private javax.swing.JTextField txtIniEst;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPesoFin;
    private javax.swing.JTextField txtPesoIni;
    // End of variables declaration//GEN-END:variables
}

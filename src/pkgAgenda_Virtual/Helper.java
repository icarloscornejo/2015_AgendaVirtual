package pkgAgenda_Virtual;

/* Created by (user) */



import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Helper {
    
    public Statement stm;
    public Connection Conexion = null;
    public ResultSet rs;
    
    
    public DefaultTableModel model = new DefaultTableModel(){
    boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
};    
    
    public  DefaultTableModel modelantes = new DefaultTableModel(){
    boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
};    
    
    public  DefaultTableModel modeldespues = new DefaultTableModel(){
    boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
};
  
    public DefaultTableModel modelimagen = new DefaultTableModel(){
        @Override
        public Class getColumnClass(int indice){
            return getValueAt(0, indice).getClass();
        }
        boolean[] canEdit = new boolean [] {
        false, false, false
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
    }
    };
    
    public DefaultComboBoxModel modelfeb = new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"});
    
    public DefaultComboBoxModel model31 = new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
    
    public DefaultComboBoxModel model30 = new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"}); 
    
    public String contra = "virtual123";
    String abc1 = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    public static int Usuario = 0, frmAgregarActividades, frmActividades, frmAgregarContacto, frmVerContacto, cod_nota = -1;
    public static String Usu = "", nom_act;
    
    public void ConectarBD(){
        try{
            
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String DBLocation = "jdbc:sqlserver://localhost:1433;database = Agenda_Virtual;user = sa;password = 123456";
        
        try{            
        Conexion = DriverManager.getConnection(DBLocation);        
            stm = Conexion.createStatement();        
        }
        catch(SQLException ex){
             JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        }
        catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }

}
    
    public void Insertar(String Consulta){
        this.ConectarBD();
        try{
            stm.execute(Consulta);
            JOptionPane.showMessageDialog(null,"Agregado.");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public void Actualizar(String Consulta){
        this.ConectarBD();
        try{
            stm.execute(Consulta);
            JOptionPane.showMessageDialog(null,"Actualizado.");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public void Eliminar(String Consulta){
        this.ConectarBD();
        try{
            if(JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar esto?", "Confirmacion", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            stm.execute(Consulta);
            JOptionPane.showMessageDialog(null,"Eliminado.");
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public void Nota(String Consulta){
        this.ConectarBD();
        try{
            stm.execute(Consulta);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    public ResultSet Buscar(String Consulta){
        this.ConectarBD();
        try{
            rs = stm.executeQuery(Consulta);
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return rs;
    }
    
    public DefaultTableModel BuscarTbl(String Consulta){
        try{
        rs = this.Buscar(Consulta);
        String fecharecibida = "";
        int valor = 2;
        boolean despues = false;
        ResultSetMetaData rsMD = rs.getMetaData();
        int col = rsMD.getColumnCount();
        model.addColumn("Fecha Actividad");
        model.addColumn("Actividad");
        model.addColumn("Tipo Actividad");
        modelantes.addColumn("Fecha Actividad");
        modelantes.addColumn("Actividad");
        modelantes.addColumn("Tipo Actividad");
        modeldespues.addColumn("Fecha Actividad");
        modeldespues.addColumn("Actividad");
        modeldespues.addColumn("Tipo Actividad");
        while(rs.next()){
            String[] fila = new String[col];
            for(int x = 0; x < col;x++){
                if(x == 0){
                    fecharecibida = rs.getString(x+1).substring(0, 10);
                    valor = this.FechaAnterior(fecharecibida);
                    fila[x] = rs.getString(x+1).substring(0, 10);
                }
                if(x == 1){
                        fila[x] = this.desencriptar(rs.getObject(x+1).toString());
                }
                else{
                            fila[x] = rs.getObject(x+1).toString();
                }
            }
            if(valor == 2){
                model.addRow(fila);
            }
            else if(valor == 1){
                this.modelantes.addRow(fila);
            }
            else if(valor == 0){
                this.modeldespues.addRow(fila);
            }
        }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        return model;
    }
    
    public void Cleantbl(JTable tbl1,JTable tbl2,JTable tbl3){
        
        int filas = model.getRowCount()-1;
        for( int x=filas; x>=0; x--){
        model.removeRow(x);
        }   
        tbl1.getColumnModel().removeColumn(tbl1.getColumnModel().getColumn(0));
        model.setColumnCount(0);
        model.setRowCount(0);
        
        int filas2 = modelantes.getRowCount()-1;
        for( int x=filas2; x>=0; x--){
        modelantes.removeRow(x);
        }   
        tbl2.getColumnModel().removeColumn(tbl2.getColumnModel().getColumn(0));
        modelantes.setColumnCount(0);
        modelantes.setRowCount(0);
        
        int filas3 = modeldespues.getRowCount()-1;
        for( int x=filas3; x>=0; x--){
        modeldespues.removeRow(x);
        }   
        tbl3.getColumnModel().removeColumn(tbl3.getColumnModel().getColumn(0));
        modeldespues.setColumnCount(0);
        modeldespues.setRowCount(0);
    }
    
    public void LimpiarTabla(JTable tbl){
        DefaultTableModel modeltbl = (DefaultTableModel) tbl.getModel();
        int filas = modeltbl.getRowCount()-1;
        for( int x=filas; x>=0; x--){
        modeltbl.removeRow(x);
        }   
        tbl.getColumnModel().removeColumn(tbl.getColumnModel().getColumn(0));
        modeltbl.setColumnCount(0);
        modeltbl.setRowCount(0);
        tbl.setModel(modeltbl);
    }
    
    public String getNom_Act(JTable tbl){
        DefaultTableModel modelo=(DefaultTableModel) tbl.getModel();
        int fila = tbl.getSelectedRow();
        String nom = modelo.getValueAt(fila, 2).toString();
        return nom;        
    }
    
    public void DiasdelMes(JComboBox cmb, JComboBox cmb2){
        int mes = cmb2.getSelectedIndex() + 1;
        switch(mes){
            case 1:
                cmb.setModel(model31);
                break;
            case 2:
                cmb.setModel(modelfeb);
                break;
            case 3:
                cmb.setModel(model31);
                break;
            case 4:
                cmb.setModel(model30);
                break;
            case 5:
                cmb.setModel(model31);
                break;
            case 6:
                cmb.setModel(model30);
                break;
            case 7:
                cmb.setModel(model31);
                break;
            case 8:
                cmb.setModel(model31);
                break;
            case 9:
                cmb.setModel(model30);
                break;
            case 10:
                cmb.setModel(model31);
                break;
            case 11:
                cmb.setModel(model30);
                break;
            case 12:
                cmb.setModel(model31);
                break;
        }
    }
    
    public int FechaAnterior(String strFecha){
        SimpleDateFormat Base = new SimpleDateFormat("yyyy-MM-dd");
        Date fecharecibida = null;
        int valor = 5;
        try {
        fecharecibida = Base.parse(strFecha);
        } catch (ParseException ex) {
        JOptionPane.showMessageDialog(null, ex);
        }
        
        Date fechaHoy = new Date();
        if(Base.format(fechaHoy).equals(strFecha)){
            valor = 2;
        }
        else if(fechaHoy.after(fecharecibida) == true) {
             valor = 1;
        }
        else if(fechaHoy.before(fecharecibida) == true){
             valor = 0;
        }
        return valor;
    }
    
    public int SoloLetras(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        int x;
        if(Character.isLetter(c) || Character.isSpaceChar(c) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            x = 1;
        }        
        else{
            x = 0;
        }
        return x;
    }
    
    public int SoloNumeros(java.awt.event.KeyEvent evt){
        char c = evt.getKeyChar();
        int x;
        if(Character.isDigit(c) || evt.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            x = 1;
        }        
        else{
            x = 0;
        }
        return x;
    }
    
    public boolean checkEmail(String email){
        String expresion;
        boolean ce;
            expresion = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
            if(email.matches(expresion))
            {
                ce = true;
            }
            else
            {
                ce = false;
            }
            return ce;
    }
    
    public int getMax(String Consulta){
        int max = 1;
        try{        
            
            rs = this.Buscar(Consulta);
            while(rs.next()){
                max = rs.getInt(1) + 1;
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return max;
    }
 
    public String encriptar(String info_a_encriptar) {
        String info_encriptada = "";
        Boolean cambio = false;
        for (int i = 0; i < info_a_encriptar.length(); i++) {
            for (int j = 0; j < abc1.length(); j++) {
                if (info_a_encriptar.charAt(i) == abc1.charAt(j)) {
                    cambio = true;
                    if ((j == 24) || (j == 25) || (j == 26) || (j == 51) || (j == 52) || (j == 53)) {
                        info_encriptada = info_encriptada + abc1.charAt(j - 24);
                    } else {
                        info_encriptada = info_encriptada + abc1.charAt(j + 3);
                    }
                    j = 53;
                }
            }
            if (!cambio) {
                info_encriptada = info_encriptada + info_a_encriptar.charAt(i);
            }
            cambio = false;
        }
        info_a_encriptar = info_encriptada;
        return info_a_encriptar;
    }

   
    public String desencriptar(String info_a_desencriptar) {
        String info_desencriptada = "";
        Boolean cambio = false;
        for (int i = 0; i < info_a_desencriptar.length(); i++) {
            for (int j = 0; j < abc1.length(); j++) {
                if (info_a_desencriptar.charAt(i) == abc1.charAt(j)) {
                    cambio = true;
                    if ((j == 0) || (j == 1) || (j == 2) || (j == 27) || (j == 28) || (j == 29)) {
                        info_desencriptada = info_desencriptada + abc1.charAt(j + 24);
                    } else {
                        info_desencriptada = info_desencriptada + abc1.charAt(j - 3);
                    }
                    j = 53;
                }
            }
            if (!cambio) {
                info_desencriptada = info_desencriptada + info_a_desencriptar.charAt(i);
            }
            cambio = false;
        }
        info_a_desencriptar = info_desencriptada;
        return info_a_desencriptar;
    }
    
    
}

 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkgAgenda_Virtual;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import static pkgAgenda_Virtual.frmVerContactos.P;

/**
 *
 * @author Carlos
 */
public class frmAgenda extends javax.swing.JFrame {

    /**
     * Creates new form frmAgenda
     */
    public frmAgenda() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        timer.start();
        frmLogin log = new frmLogin();
        log.show();
        log.setAlwaysOnTop(true);
        this.setEnabled(false);
        mnbActs.setVisible(false);
        timertrans.start();
        timermnu.start();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pkgAgenda_Virtual/Images/f2.png")),0,0,this);
            }
        };
        mnbActs = new javax.swing.JMenuBar(){
            public void paintComponent(Graphics g){
                g.drawImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/pkgAgenda_Virtual/Images/Toolbar.png")),0,0,this);
            }
        };
        mnuActividades = new javax.swing.JMenu();
        mnuadmtipacts = new javax.swing.JMenuItem();
        mnucrearactividad = new javax.swing.JMenuItem();
        mnuveracts = new javax.swing.JMenuItem();
        mnuContactos = new javax.swing.JMenu();
        mnuagregarcontacto = new javax.swing.JMenuItem();
        mnuvercontactos = new javax.swing.JMenuItem();
        mnuNotas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        mnuUsuario = new javax.swing.JMenu();
        mnuHora = new javax.swing.JMenu();
        mnuCerrarSesion = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Agenda");
        setName("frmAgenda"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(Escritorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        mnbActs.setBackground(new java.awt.Color(0, 0, 0));
        mnbActs.setBorder(null);
        mnbActs.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        mnbActs.setInheritsPopupMenu(true);
        mnbActs.setPreferredSize(new Dimension(1330, 24));
        mnbActs.setMinimumSize(new Dimension(1330, 24));
        mnbActs.setMaximumSize(new Dimension(1330, 24));

        mnuActividades.setForeground(new java.awt.Color(255, 255, 255));
        mnuActividades.setText("Actividades");
        mnuActividades.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuActividades.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mnuActividadesMouseDragged(evt);
            }
        });

        mnuadmtipacts.setText("Administrar Tipos de Actividades");
        mnuadmtipacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuadmtipactsActionPerformed(evt);
            }
        });
        mnuActividades.add(mnuadmtipacts);

        mnucrearactividad.setText("Crear Actividad");
        mnucrearactividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnucrearactividadActionPerformed(evt);
            }
        });
        mnuActividades.add(mnucrearactividad);

        mnuveracts.setText("Ver Actividades");
        mnuveracts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuveractsActionPerformed(evt);
            }
        });
        mnuActividades.add(mnuveracts);

        mnbActs.add(mnuActividades);

        mnuContactos.setForeground(new java.awt.Color(255, 255, 255));
        mnuContactos.setText("Contactos");
        mnuContactos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuContactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuContactosActionPerformed(evt);
            }
        });

        mnuagregarcontacto.setText("Agregar Contacto");
        mnuagregarcontacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuagregarcontactoActionPerformed(evt);
            }
        });
        mnuContactos.add(mnuagregarcontacto);

        mnuvercontactos.setText("Ver Contactos");
        mnuvercontactos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuvercontactosActionPerformed(evt);
            }
        });
        mnuContactos.add(mnuvercontactos);

        mnbActs.add(mnuContactos);

        mnuNotas.setForeground(new java.awt.Color(255, 255, 255));
        mnuNotas.setText("Notas");
        mnuNotas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem3.setText("Nueva nota");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuNotas.add(jMenuItem3);

        jMenuItem5.setText("Generar Reporte");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        mnuNotas.add(jMenuItem5);

        mnbActs.add(mnuNotas);

        mnuHerramientas.setForeground(new java.awt.Color(255, 255, 255));
        mnuHerramientas.setText("Herramientas");
        mnuHerramientas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem4.setText("Calculadora");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        mnuHerramientas.add(jMenuItem4);

        mnbActs.add(mnuHerramientas);

        mnuUsuario.setForeground(new java.awt.Color(255, 255, 255));
        mnuUsuario.setText("Usuario Actual");
        mnuUsuario.setEnabled(false);
        mnuUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        mnbActs.add(Box.createHorizontalGlue());

        mnbActs.add(mnuUsuario);

        mnuHora.setBackground(new java.awt.Color(255, 255, 255));
        mnuHora.setForeground(new java.awt.Color(255, 255, 255));
        mnuHora.setText("00:00 AM");
        mnuHora.setEnabled(false);
        mnuHora.setFocusable(false);
        mnuHora.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuHora.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                mnuHoraMouseDragged(evt);
            }
        });
        mnbActs.add(mnuHora);

        mnuCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        mnuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgAgenda_Virtual/Images/Exit.png"))); // NOI18N
        mnuCerrarSesion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnuCerrarSesion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        mnuCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jMenuItem2.setText("Cerrar Sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        mnuCerrarSesion.add(jMenuItem2);

        jMenuItem1.setText("Cerrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuCerrarSesion.add(jMenuItem1);

        mnbActs.add(mnuCerrarSesion);

        setJMenuBar(mnbActs);

        getAccessibleContext().setAccessibleName("frmAgenda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ResultSet rs;
    public static int ver = 0;
    Helper H = new Helper();
    JMenu AgrActs, Acts, AgrContacto, VerContacto;
    
    public void PDF() throws SQLException{
        Document documento = new Document();
        FileOutputStream FacturaPdf;
    
        try{
    FacturaPdf = new FileOutputStream("archives/Notas.pdf");
    
    PdfWriter writer = PdfWriter.getInstance(documento, FacturaPdf);
    com.itextpdf.text.Rectangle rct = new com.itextpdf.text.Rectangle(36, 54, 559, 788);
            writer.setBoxSize("art", rct);
            HeaderFooter event = new HeaderFooter();
            writer.setPageEvent(event);
           
        }
        catch (DocumentException | FileNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        try{ 
           Calendar fecha = Calendar.getInstance();
           documento.open();
           com.itextpdf.text.Image imagen = com.itextpdf.text.Image.getInstance("archives\\AgendaVirtual.png");
           imagen.setAbsolutePosition(0f, 0f);
           documento.add(imagen);
           Paragraph AV = new Paragraph("Agenda Virtual", FontFactory.getFont("Segoe UI", 22, Font.NORMAL, BaseColor.BLACK));
           AV.setAlignment(Element.ALIGN_RIGHT);
           documento.add(AV);
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));           
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph("Notas de "+frmLogin.usuario));
           documento.add(new Paragraph("Fecha de Reporte: "+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.YEAR)+"  "+fecha.get(Calendar.HOUR_OF_DAY)+":"+fecha.get(Calendar.MINUTE)));
           documento.add(new Paragraph(" "));           
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));           
           documento.add(new Paragraph(" "));
           PdfPTable tabla = new PdfPTable(2);
           tabla.addCell("Titulo");
           tabla.addCell("Descripcion");
           
           //sdfhfjhsdfsd
           
           rs = H.Buscar("SELECT nom_nota, des_nota FROM Notas WHERE cod_usu = "+H.Usuario+" ORDER BY nom_nota ASC");
           while(rs.next()){
               tabla.addCell(rs.getString(1));
               tabla.addCell(rs.getString(2));
           }
                   
           //askjdhskfjhdf
           documento.add(tabla);
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" ")); 
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));    
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(new Paragraph(" "));
           documento.add(P);
           documento.close();
       }
       catch(DocumentException | IOException ex){
           JOptionPane.showMessageDialog(null, ex.toString());
       }
        
    }
    
    static class HeaderFooter extends PdfPageEventHelper {
        private final String encabezado = "Agenda Virtual";
        PdfTemplate total;
        
    
        @Override
    public void onOpenDocument(PdfWriter writer, Document document) {
        total = writer.getDirectContent().createTemplate(30, 16);
            String Pagina = String.format("Pagina "+writer.getPageNumber());
            P = new Paragraph(Pagina);
            P.setAlignment(Element.ALIGN_RIGHT);
    }
    }
    
    Timer timermnu = new Timer (1, new ActionListener () { 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
       if(H.frmAgregarActividades == 1){
           AgrActs = new javax.swing.JMenu();
           AgrActs.setForeground(new java.awt.Color(255, 255, 255));
           AgrActs.setText("Agregar Actividades");
           AgrActs.setFont(new java.awt.Font("Segoe UI", 0, 14));
           AgrActs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgAgenda_Virtual/Images/AgregarActs.png")));
           AgrActs.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
            H.frmAgregarActividades = 2;

        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    });
          
           mnbActs.remove(mnuUsuario);
           mnbActs.remove(mnuHora);
           mnbActs.remove(mnuCerrarSesion);
          mnbActs.add(AgrActs);
          mnbActs.add(mnuUsuario);
           mnbActs.add(mnuHora);
           mnbActs.add(mnuCerrarSesion);
          mnbActs.repaint();
          H.frmAgregarActividades = 0;
      }
       else if(H.frmAgregarActividades == 2){
           mnbActs.remove(AgrActs);
           mnbActs.repaint();
       }
       
       // Division
       
       
       if(H.frmActividades == 1){
           Acts = new javax.swing.JMenu();
           Acts.setForeground(new java.awt.Color(255, 255, 255));
           Acts.setText("Actividades");
           Acts.setFont(new java.awt.Font("Segoe UI", 0, 14));
           Acts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgAgenda_Virtual/Images/Acts.png")));
           Acts.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
            H.frmActividades = 2;

        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    });
           
           mnbActs.remove(mnuUsuario);
           mnbActs.remove(mnuHora);
           mnbActs.remove(mnuCerrarSesion);
          mnbActs.add(Acts);
          mnbActs.add(mnuUsuario);
           mnbActs.add(mnuHora);
           mnbActs.add(mnuCerrarSesion);
          
          mnbActs.repaint();
          H.frmActividades = 0;
      }
       else if(H.frmActividades == 2){
           mnbActs.remove(Acts);
           mnbActs.repaint();
       }
       
       
       //Division
       
       
       if(H.frmAgregarContacto == 1){
           AgrContacto = new javax.swing.JMenu();
           AgrContacto.setForeground(new java.awt.Color(255, 255, 255));
           AgrContacto.setText("Agregar Contacto");
           AgrContacto.setFont(new java.awt.Font("Segoe UI", 0, 14));
           AgrContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgAgenda_Virtual/Images/AgregarActs.png")));
           AgrContacto.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
            H.frmAgregarContacto = 2;

        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    });
          
           mnbActs.remove(mnuUsuario);
           mnbActs.remove(mnuHora);
           mnbActs.remove(mnuCerrarSesion);
          mnbActs.add(AgrContacto);
          mnbActs.add(mnuUsuario);
           mnbActs.add(mnuHora);
           mnbActs.add(mnuCerrarSesion);
          mnbActs.repaint();
          H.frmAgregarContacto = 0;
      }
       else if(H.frmAgregarContacto == 2){
           mnbActs.remove(AgrContacto);
           mnbActs.repaint();
       }
     
    
    
    //Division
    
    if(H.frmVerContacto == 1){
           VerContacto = new javax.swing.JMenu();
           VerContacto.setForeground(new java.awt.Color(255, 255, 255));
           VerContacto.setText("Ver Contacto");
           VerContacto.setFont(new java.awt.Font("Segoe UI", 0, 14));
           VerContacto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgAgenda_Virtual/Images/AgregarActs.png")));
           VerContacto.addMenuListener(new MenuListener() {

        @Override
        public void menuSelected(MenuEvent e) {
            H.frmVerContacto = 2;

        }

        @Override
        public void menuDeselected(MenuEvent e) {

        }

        @Override
        public void menuCanceled(MenuEvent e) {

        }
    });
          
           mnbActs.remove(mnuUsuario);
           mnbActs.remove(mnuHora);
           mnbActs.remove(mnuCerrarSesion);
          mnbActs.add(VerContacto);
          mnbActs.add(mnuUsuario);
           mnbActs.add(mnuHora);
           mnbActs.add(mnuCerrarSesion);
          mnbActs.repaint();
          H.frmVerContacto = 0;
      }
       else if(H.frmVerContacto == 2){
           mnbActs.remove(VerContacto);
           mnbActs.repaint();
       }
    }
     
});  
    
    Timer timertrans = new Timer (1, new ActionListener () { 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
       if(ver == 1){
          mnuUsuario.setText(H.Usu);
          mnbActs.setVisible(true);
          frmAgenda.this.setEnabled(true);
          frmAgenda.this.setAlwaysOnTop(true);
          ver = 0;
          frmAgenda.this.setAlwaysOnTop(false);
          rs = H.Buscar("SELECT cod_nota FROM Notas WHERE cod_usu = "+H.Usuario+"");
           try {
               while(rs.next()){
                   H.cod_nota = rs.getInt(1);
                   frmNotas nota = new frmNotas();
                    Escritorio.add(nota);
                    nota.show();
               }
               H.cod_nota = -1;
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.toString());
           }
          
          timertrans.stop();
      }
        
     } 
});    
    Timer timer = new Timer (1000, new ActionListener () { 
    @Override
    public void actionPerformed(ActionEvent e) 
    { 
        
      Date fecha = new Date();
      SimpleDateFormat dia = new SimpleDateFormat("E");      
      SimpleDateFormat m = new SimpleDateFormat("M");
      SimpleDateFormat hora = new SimpleDateFormat("dd',' hh:mm a");
      
      String mes = "";
      
      switch(Integer.parseInt(m.format(fecha))){
          case 1:
              mes = "Ene";
              break;
                  case 2:
                      mes = "Feb";
              break;
                      case 3:
                          mes = "Mar";
              break;
                          case 4:
                              mes = "Abr";
              break;
                              case 5:
                                  mes = "May";
              break;
                                  case 6:
                                      mes = "Jun";
              break;
                                      case 7:
                                          mes = "Jul";
              break;
                                          case 8:
                                              mes = "Ago";
              break;
                                              case 9:
                                                  mes = "Sept";
              break;
                                                  case 10:
                                                      mes = "Oct";
              break;
                                                      case 11:
                                                          mes = "Nov";
              break;
                                                          case 12:
                                                              mes = "Dic";
              break;
      }
      
      mnuHora.setText(capitalizarTexto(dia.format(fecha))+" "+mes+" "+hora.format(fecha));
      
     } 
});
    
    public String capitalizarTexto(String textoSinFormato){
        String []palabras = textoSinFormato.split("\\s+");
        StringBuilder textoFormateado = new StringBuilder();
        
        for(String palabra : palabras){
            textoFormateado.append(palabra.substring(0,1).toUpperCase()
        	    	.concat( palabra.substring(1,palabra.length())
        		.toLowerCase()).concat(" "));
        }
        
        return textoFormateado.toString();        
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        timermnu.stop();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        mnuUsuario.setText(null);
        H.Usu = "";
          mnbActs.setVisible(false);
          frmAgenda.this.setEnabled(false);
          frmAgenda.this.setAlwaysOnTop(false);
          ver = 0;
          frmLogin l = new frmLogin();
          l.show();
          l.setAlwaysOnTop(true);
          timertrans.start();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void mnuContactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuContactosActionPerformed
    
    }//GEN-LAST:event_mnuContactosActionPerformed

    private void mnuActividadesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuActividadesMouseDragged

    }//GEN-LAST:event_mnuActividadesMouseDragged

    private void mnuHoraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuHoraMouseDragged
        
    }//GEN-LAST:event_mnuHoraMouseDragged

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        frmNotas nota = new frmNotas();
    Escritorio.add(nota);
    nota.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed
     
    public static int agracts;
    frmAgregarActividades aa;
    private void mnucrearactividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnucrearactividadActionPerformed
         if(agracts == 0){
         aa = new frmAgregarActividades();
         Escritorio.add(aa);
         aa.show();
         agracts = 1;
         }
         else if(agracts == 1){
             aa.toFront();
         }
    }//GEN-LAST:event_mnucrearactividadActionPerformed
    
    public static int acts;
    frmActividades a;
    private void mnuveractsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuveractsActionPerformed
        if(acts == 0){
         a = new frmActividades();
         Escritorio.add(a);
         a.show();
         acts = 1;
         }
         else if(acts == 1){
             a.toFront();
         }
        
    }//GEN-LAST:event_mnuveractsActionPerformed
    
    public static int tipactss;
    frmAdministrarTipo_Actividades tipacts;
    private void mnuadmtipactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuadmtipactsActionPerformed
        if(tipactss == 0){
        tipacts = new frmAdministrarTipo_Actividades();
        Escritorio.add(tipacts);
        tipacts.show();
        tipactss = 1;
        }
        else if(tipactss == 1){
            tipacts.toFront();
        }
    }//GEN-LAST:event_mnuadmtipactsActionPerformed

    public static int agrcontacto;
    frmAgregarContactos ac;
    private void mnuagregarcontactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuagregarcontactoActionPerformed
        if(agrcontacto == 0){
         ac = new frmAgregarContactos();
         Escritorio.add(ac);
         ac.show();
         agrcontacto = 1;
         }
         else if(agrcontacto == 1){
             ac.toFront();
         }
    }//GEN-LAST:event_mnuagregarcontactoActionPerformed

    public static int vercontacto;
    frmVerContactos vc;
    private void mnuvercontactosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuvercontactosActionPerformed
        if(vercontacto == 0){
         vc = new frmVerContactos();
         Escritorio.add(vc);
         vc.show();
         vercontacto = 1;
         }
         else if(vercontacto == 1){
             vc.toFront();
         }
    }//GEN-LAST:event_mnuvercontactosActionPerformed

    public static int calculadora;
    frmCalculadora c;
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        if(calculadora == 0){
         c = new frmCalculadora();
         Escritorio.add(c);
         c.show();
         calculadora = 1;
         }
         else if(calculadora == 1){
             c.toFront();
         }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        try {
            PDF();
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"archives\\Notas.pdf"); 
        } catch (SQLException | IOException ex) {
            Logger.getLogger(frmVerContactos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    
    
    
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
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgenda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuBar mnbActs;
    private javax.swing.JMenu mnuActividades;
    private javax.swing.JMenu mnuCerrarSesion;
    private javax.swing.JMenu mnuContactos;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JMenu mnuHora;
    private javax.swing.JMenu mnuNotas;
    private javax.swing.JMenu mnuUsuario;
    private javax.swing.JMenuItem mnuadmtipacts;
    private javax.swing.JMenuItem mnuagregarcontacto;
    private javax.swing.JMenuItem mnucrearactividad;
    private javax.swing.JMenuItem mnuveracts;
    private javax.swing.JMenuItem mnuvercontactos;
    // End of variables declaration//GEN-END:variables

}

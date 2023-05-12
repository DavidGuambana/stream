package stream;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;

public class JFstream extends javax.swing.JFrame {

    List<Persona> personas = new ArrayList<>();
    String[] a = {"PRIMER NOMBRE", "PRIMER APELLIDO", "SEGUNDO APELLIDO"};
    DefaultTableModel tabla = new DefaultTableModel(null, a);

    public JFstream() {
        initComponents();
        setLocationRelativeTo(null);
        long empieza = System.nanoTime();
        barrido();
        long finaliza = System.nanoTime() - empieza;
        t1.setText("Tiempo estimado de carga: "+finaliza/1e6+ " ms.");
    }
    public void barrido() {
        try {
            File file = new File("src\\stream\\archivo.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String registro = scanner.nextLine();
                String[] datos = registro.split(" ");
                Persona persona = new Persona(datos[0], datos[1], datos[2]);
                personas.add(persona);  //pasamos los objetos en la tabla:
                tabla.addRow(new Object[]{persona.getP_nombre(), persona.getP_apellido(), persona.getS_apellido()});
            }
            JTpersonas.setModel(tabla);
            totales.setText("Totales: " + personas.size() + " de " + personas.size());
        } catch (FileNotFoundException e) {
        }
        
    }

    public void filtro() {
        DefaultTableModel tabla2 = new DefaultTableModel(null, a);
        switch(JCatributos.getSelectedIndex()){
            case 0:
                personas.stream().filter(p -> p.getP_nombre().equals(contenido.getText())).
                forEach(p -> tabla2.addRow(new Object[]{p.getP_nombre(), p.getP_apellido(), p.getS_apellido()}));
                break;
            case 1:
                personas.stream().filter(p -> p.getP_apellido().equals(contenido.getText())).
                forEach(p -> tabla2.addRow(new Object[]{p.getP_nombre(), p.getP_apellido(), p.getS_apellido()}));
                break;
            case 2:
                personas.stream().filter(p -> p.getS_apellido().equals(contenido.getText())).
                forEach(p -> tabla2.addRow(new Object[]{p.getP_nombre(), p.getP_apellido(), p.getS_apellido()}));
                break;
        }
        JTpersonas_filto.setModel(tabla2);
        filtros.setText("Filtros: " + JTpersonas_filto.getRowCount() + " de " + personas.size());
    }
    
    public void ordenamiento(){
        DefaultTableModel tabla2 = new DefaultTableModel(null, a);
        personas.stream().sorted(Comparator.comparing(Persona::getP_nombre)).
                forEach(p -> tabla2.addRow(new Object[]{p.getP_nombre(), p.getP_apellido(), p.getS_apellido()}));
        JTpersonas.setModel(tabla2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jsTabla_ciu4 = new javax.swing.JScrollPane();
        JTpersonas = new javax.swing.JTable();
        JBbuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        contenido = new javax.swing.JTextField();
        JCatributos = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jsTabla_ciu5 = new javax.swing.JScrollPane();
        JTpersonas_filto = new javax.swing.JTable();
        totales = new javax.swing.JLabel();
        filtros = new javax.swing.JLabel();
        t1 = new javax.swing.JLabel();
        t2 = new javax.swing.JLabel();
        JBbuscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 252, 237));

        jsTabla_ciu4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTpersonas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        JTpersonas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JTpersonas.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        JTpersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTpersonas.setFocusable(false);
        JTpersonas.setGridColor(new java.awt.Color(255, 255, 255));
        JTpersonas.setOpaque(false);
        JTpersonas.setRowHeight(30);
        JTpersonas.setSelectionBackground(new java.awt.Color(0, 204, 204));
        JTpersonas.getTableHeader().setResizingAllowed(false);
        JTpersonas.getTableHeader().setReorderingAllowed(false);
        jsTabla_ciu4.setViewportView(JTpersonas);

        JBbuscar.setBackground(new java.awt.Color(255, 204, 0));
        JBbuscar.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        JBbuscar.setText("FILTAR");
        JBbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbuscarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("LISTA DE PERSONAS");

        contenido.setFont(new java.awt.Font("Franklin Gothic Medium Cond", 0, 18)); // NOI18N
        contenido.setForeground(new java.awt.Color(255, 204, 0));

        JCatributos.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 14)); // NOI18N
        JCatributos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "primer nombre", "primer apellido", "segundo apellido" }));

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Light", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("FILTRO DE PERSONAS");

        jsTabla_ciu5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JTpersonas_filto = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        JTpersonas_filto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        JTpersonas_filto.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        JTpersonas_filto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        JTpersonas_filto.setFocusable(false);
        JTpersonas_filto.setGridColor(new java.awt.Color(255, 255, 255));
        JTpersonas_filto.setOpaque(false);
        JTpersonas_filto.setRowHeight(30);
        JTpersonas_filto.setSelectionBackground(new java.awt.Color(0, 204, 204));
        JTpersonas_filto.getTableHeader().setResizingAllowed(false);
        JTpersonas_filto.getTableHeader().setReorderingAllowed(false);
        jsTabla_ciu5.setViewportView(JTpersonas_filto);

        totales.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        totales.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totales.setText("Totales: 0 de 0");

        filtros.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        filtros.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        filtros.setText("Filtrados: 0 de 0");

        t1.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        t1.setText("Tiempo estimado de carga:");

        t2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 14)); // NOI18N
        t2.setText("Tiempo estimado de carga:");

        JBbuscar1.setBackground(new java.awt.Color(255, 204, 0));
        JBbuscar1.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 14)); // NOI18N
        JBbuscar1.setText("ORDENAR");
        JBbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBbuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jsTabla_ciu5, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addComponent(jsTabla_ciu4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JCatributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contenido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JBbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JBbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totales, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(t1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(t2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBbuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(totales, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jsTabla_ciu4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(t1)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(JBbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(JCatributos))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtros, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsTabla_ciu5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(t2)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbuscarActionPerformed
        long empieza = System.nanoTime();
        filtro();
        long finaliza = System.nanoTime() - empieza;
        t2.setText("Tiempo estimado de carga: "+finaliza/1e6+ " ms.");
    }//GEN-LAST:event_JBbuscarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        
    }//GEN-LAST:event_formWindowGainedFocus

    private void JBbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBbuscar1ActionPerformed
        long empieza = System.nanoTime();
        ordenamiento();
        long finaliza = System.nanoTime() - empieza;
        t1.setText("Tiempo estimado de carga: "+finaliza/1e6+ " ms.");
    }//GEN-LAST:event_JBbuscar1ActionPerformed

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
            java.util.logging.Logger.getLogger(JFstream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFstream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFstream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFstream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFstream().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBbuscar;
    private javax.swing.JButton JBbuscar1;
    private javax.swing.JComboBox<String> JCatributos;
    private javax.swing.JTable JTpersonas;
    private javax.swing.JTable JTpersonas_filto;
    private javax.swing.JTextField contenido;
    private javax.swing.JLabel filtros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jsTabla_ciu4;
    private javax.swing.JScrollPane jsTabla_ciu5;
    private javax.swing.JLabel t1;
    private javax.swing.JLabel t2;
    private javax.swing.JLabel totales;
    // End of variables declaration//GEN-END:variables
}

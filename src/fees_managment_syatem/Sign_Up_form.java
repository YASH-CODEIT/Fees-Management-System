package fees_managment_syatem;


import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.sql.Statement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author y
 */
public class Sign_Up_form extends javax.swing.JFrame {

    /**
     * Creates new form Sign_Up_form
     */
    String fname,lname,usname,password,com_password,contNo;
    Date dob;
    int id=0;
    public Sign_Up_form() {
        initComponents();
    }
       public int getId(){
           ResultSet rs=null;
           try{
                 Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_managment?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                String sql="select max(id) from SIGNUP";
                Statement st=con.createStatement();
                rs=st.executeQuery(sql);
                while(rs.next()){
                    id=rs.getInt(1);
                    ++id;
                }
           }
           catch(Exception e){
               e.printStackTrace();
           }
           return id;
       }
        boolean validation(){

            fname=txt_firstName.getText();
            lname=txt_lastName.getText();
            usname=txt_userName.getText();
            password=txt_password.getText();
            com_password=txt_confirmPassword.getText();
            contNo=txt_contactNo.getText();
            dob=txt_dob.getDate();
            if(fname.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter First Name.");
                return false;
            }
            if(lname.equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Last Name.");
                return false;
            }
            if(usname.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter UserName.");
                return false;
            }
            if(password.equals("")){
                JOptionPane.showMessageDialog(this, "Please Enter Password.");
                return false;
            }
            if(com_password.equals("")){
                JOptionPane.showMessageDialog(this,"Please Enter Confirm Password.");
                return false;
            }
           if(contNo.equals("")){
               JOptionPane.showMessageDialog(this,"Please Enter Contact No.");
               return false;
           }
           if(dob == null){
               JOptionPane.showMessageDialog(this,"Pleaase Enter Date Of Birth");
               return false;
           }
           if(password.length()<8){
               txt_password_error.setText("Password should be of 8 charachter");
           }
           if(contNo.length()<10){
               txt_number_error.setText("Number should be of 10 digits ");
           }
           if(!(password.equals(com_password))){
              JOptionPane.showMessageDialog(this, "Password Not Match.");
           }
           
            return true;
        }
        public void checkPassword()
        {
            password=txt_password.getText();
            if(password.length()<8){
                txt_password_error.setText("Password should be of 8 charachter");
            }
            else{
                txt_password_error.setText("");
            }
        }
        public void checkContactNo(){
            contNo=txt_contactNo.getText();
            if(contNo.length()==10){
                txt_number_error.setText("");
            }
            else{
                  txt_number_error.setText("Number should be of 10 digits");
            }
        }
        void insertDetails(){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String mydob=format.format(dob);
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_managment?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                String sql="insert into signUp values(?,?,?,?,?,?,?)";
                PreparedStatement stmt=con.prepareStatement(sql);
                stmt.setInt(1,getId());
                stmt.setString(2, fname);
                stmt.setString(3,lname);
                stmt.setString(4,usname);
                stmt.setString(5, password);
                stmt.setString(6,mydob);
                stmt.setString(7,contNo);
                int i=stmt.executeUpdate();
                if(i>0){
                    JOptionPane.showMessageDialog(this,"Record Succesfully Inserted");
                }
                else{
                    JOptionPane.showMessageDialog(this,"Records Not Inserted");
                }
            }
            catch(Exception e){
               e.printStackTrace();
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

        jLabel3 = new javax.swing.JLabel();
        gendergroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_dob = new com.toedter.calendar.JDateChooser();
        txt_firstName = new javax.swing.JTextField();
        txt_lastName = new javax.swing.JTextField();
        txt_userName = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        txt_confirmPassword = new javax.swing.JPasswordField();
        btn_signUp = new javax.swing.JButton();
        btn_login = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txt_contactNo = new javax.swing.JTextField();
        txt_password_error = new javax.swing.JLabel();
        txt_number_error = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Last Name :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 255, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("       Sign Up");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 255, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("First Name :");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Username :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Last Name :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Confirm Password :");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Password :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Date Of Birth :");

        txt_firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_firstNameActionPerformed(evt);
            }
        });

        txt_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lastNameActionPerformed(evt);
            }
        });

        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_passwordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_passwordKeyTyped(evt);
            }
        });

        btn_signUp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_signUp.setText("SignUp");
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signUpActionPerformed(evt);
            }
        });

        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_login.setText("Login");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Contact No:");

        txt_contactNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_contactNoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_contactNoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_contactNoKeyTyped(evt);
            }
        });

        txt_password_error.setForeground(new java.awt.Color(255, 0, 51));

        txt_number_error.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_number_error.setForeground(new java.awt.Color(255, 0, 0));
        txt_number_error.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel11))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btn_signUp)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt_dob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                        .addComponent(txt_password, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_userName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_lastName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_firstName, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_confirmPassword, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(txt_contactNo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_password_error, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                                    .addComponent(txt_number_error, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(btn_login)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txt_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(txt_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(txt_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_password_error))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(txt_confirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel7))
                                    .addComponent(txt_dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txt_contactNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9))
                            .addComponent(txt_number_error))
                        .addGap(22, 107, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_signUp)
                            .addComponent(btn_login))
                        .addGap(32, 32, 32))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lastNameActionPerformed

    private void txt_firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_firstNameActionPerformed

    private void btn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signUpActionPerformed
        // TODO add your handling code here:
       if(validation()){
           insertDetails();
       }
    }//GEN-LAST:event_btn_signUpActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_passwordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyReleased
checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordKeyReleased

    private void txt_passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyTyped
checkPassword();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_passwordKeyTyped

    private void txt_contactNoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactNoKeyPressed
checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactNoKeyPressed

    private void txt_contactNoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactNoKeyReleased
checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactNoKeyReleased

    private void txt_contactNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_contactNoKeyTyped
checkContactNo();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactNoKeyTyped

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
            java.util.logging.Logger.getLogger(Sign_Up_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sign_Up_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sign_Up_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sign_Up_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sign_Up_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signUp;
    private javax.swing.ButtonGroup gendergroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPasswordField txt_confirmPassword;
    private javax.swing.JTextField txt_contactNo;
    private com.toedter.calendar.JDateChooser txt_dob;
    private javax.swing.JTextField txt_firstName;
    private javax.swing.JTextField txt_lastName;
    private javax.swing.JLabel txt_number_error;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JLabel txt_password_error;
    private javax.swing.JTextField txt_userName;
    // End of variables declaration//GEN-END:variables
}

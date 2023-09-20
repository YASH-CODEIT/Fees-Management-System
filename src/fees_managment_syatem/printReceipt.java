/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_managment_syatem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author yash
 */
public class printReceipt extends javax.swing.JFrame {

    /**
     * Creates new form printReceipt
     */
    public printReceipt() {
        initComponents();
        getRecords();
        Container c=getContentPane();
        c.setBackground(new Color(255,204,204));
    }
public void getRecords(){
    try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_managment?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");  
     PreparedStatement pst=con.prepareStatement("SELECT * FROM fees_details ORDER BY recieptNo DESC LIMIT 1");
     ResultSet rs=pst.executeQuery();
     rs.next();
     lblReceiptNo.setText(rs.getString("recieptNo"));
     lblPaymentMode.setText(rs.getString("paymentMode"));
     String paymentMode=rs.getString("paymentMode");
     if(paymentMode.equalsIgnoreCase("Cash")){
         txtChequeDD.setText("Cheque No : ");
         lblChequeDD.setText("-");
         lblBankName.setText("-");
     }
     if(paymentMode.equalsIgnoreCase("Cheque")){
         txtChequeDD.setText("Cheque No ");
         lblChequeDD.setText(rs.getString("chequeNo"));
         lblBankName.setText(rs.getString("bankName"));
     }
     if(paymentMode.equalsIgnoreCase("dd")){
         txtChequeDD.setText("DD No : ");
         lblChequeDD.setText(rs.getString("ddNo"));
         lblBankName.setText(rs.getString("bankName"));
     }
    if(paymentMode.equalsIgnoreCase("card")){
        txtChequeDD.setText("Cheque No : ");
        lblChequeDD.setText("-");
        lblBankName.setText("bankName");
    }
     lblReceivedFrom.setText(rs.getString("studentName"));
     lblDate.setText(rs.getString("date"));
     lblGSTIN.setText(rs.getString("gstin"));
     lblYear1.setText(rs.getString("year1"));
     lblYear2.setText(rs.getString("year2"));
     lblCourseName.setText(rs.getString("courseName"));
     lblInitialAmount.setText(rs.getString("amount"));
     lblCGST.setText(rs.getString("cgst"));
     lblSGST.setText(rs.getString("sgst"));
     lblTotal.setText(rs.getString("totalAmount"));
     lblTotalInWords.setText(rs.getString("totalInWords"));
    }catch(Exception e){
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

        panelSideBar = new javax.swing.JPanel();
        panelEdit = new javax.swing.JPanel();
        btnEdit = new javax.swing.JLabel();
        panelHome = new javax.swing.JPanel();
        btnHome = new javax.swing.JLabel();
        panelSearchRecords = new javax.swing.JPanel();
        btnSearchRecords = new javax.swing.JLabel();
        panelEditCourse = new javax.swing.JPanel();
        btnEditCourse = new javax.swing.JLabel();
        panelCourseList = new javax.swing.JPanel();
        btnCourseList = new javax.swing.JLabel();
        panelViewAllRecords = new javax.swing.JPanel();
        btnViewAllRecords = new javax.swing.JLabel();
        panelBack = new javax.swing.JPanel();
        btnBack = new javax.swing.JLabel();
        panelLogOut = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JLabel();
        panelPrint = new javax.swing.JPanel();
        btnPrint = new javax.swing.JLabel();
        panelPrintReceipt = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtChequeDD = new javax.swing.JLabel();
        txtBankName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblReceiptNo = new javax.swing.JLabel();
        lblPaymentMode = new javax.swing.JLabel();
        lblChequeDD = new javax.swing.JLabel();
        lblBankName = new javax.swing.JLabel();
        lblReceivedFrom = new javax.swing.JLabel();
        lblYear1 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lblYear2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblGSTIN = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblInitialAmount = new javax.swing.JLabel();
        lblCGST = new javax.swing.JLabel();
        lblSGST = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        lblTotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblTotalInWords = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSideBar.setBackground(new java.awt.Color(255, 102, 102));
        panelSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEdit.setBackground(new java.awt.Color(255, 102, 102));
        panelEdit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEdit.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/edit2.png"))); // NOI18N
        btnEdit.setText("        Edit");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditMouseExited(evt);
            }
        });
        panelEdit.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 260, 50));

        panelSideBar.add(panelEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 580, 320, 50));

        panelHome.setBackground(new java.awt.Color(255, 102, 102));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/home.png"))); // NOI18N
        btnHome.setText("      HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 50));

        panelSideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 320, 50));

        panelSearchRecords.setBackground(new java.awt.Color(255, 102, 102));
        panelSearchRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelSearchRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearchRecords.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSearchRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/search2.png"))); // NOI18N
        btnSearchRecords.setText("      Search Records");
        btnSearchRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchRecordsMouseExited(evt);
            }
        });
        panelSearchRecords.add(btnSearchRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 60));

        panelSideBar.add(panelSearchRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 320, 50));

        panelEditCourse.setBackground(new java.awt.Color(255, 102, 102));
        panelEditCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEditCourse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        panelEditCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditCourse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEditCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/edit2.png"))); // NOI18N
        btnEditCourse.setText("      Edit Course");
        btnEditCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseExited(evt);
            }
        });
        panelEditCourse.add(btnEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, -1));

        panelSideBar.add(panelEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 320, 50));

        panelCourseList.setBackground(new java.awt.Color(255, 102, 102));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/list.png"))); // NOI18N
        btnCourseList.setText("        Course List");
        btnCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCourseListMouseExited(evt);
            }
        });
        panelCourseList.add(btnCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, -1));

        panelSideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 320, 50));

        panelViewAllRecords.setBackground(new java.awt.Color(255, 102, 102));
        panelViewAllRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelViewAllRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewAllRecords.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnViewAllRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/view all record.png"))); // NOI18N
        btnViewAllRecords.setText("        View All Records");
        btnViewAllRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewAllRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewAllRecordsMouseExited(evt);
            }
        });
        panelViewAllRecords.add(btnViewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 50));

        panelSideBar.add(panelViewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 320, 50));

        panelBack.setBackground(new java.awt.Color(255, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/left-arrow.png"))); // NOI18N
        btnBack.setText("        Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 260, -1));

        panelSideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 320, 50));

        panelLogOut.setBackground(new java.awt.Color(255, 102, 102));
        panelLogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelLogOutMouseEntered(evt);
            }
        });
        panelLogOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogOut.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/logout.png"))); // NOI18N
        btnLogOut.setText("        Logout");
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        panelLogOut.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 260, -1));

        panelSideBar.add(panelLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 320, 50));

        panelPrint.setBackground(new java.awt.Color(255, 102, 102));
        panelPrint.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelPrint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/printer-.png"))); // NOI18N
        btnPrint.setText("         Print");
        btnPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPrintMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPrintMouseExited(evt);
            }
        });
        panelPrint.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 50));

        panelSideBar.add(panelPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 320, 50));

        getContentPane().add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 1090));

        panelPrintReceipt.setBackground(new java.awt.Color(255, 255, 255));
        panelPrintReceipt.setPreferredSize(new java.awt.Dimension(1200, 860));
        panelPrintReceipt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 137, 181));
        jLabel1.setText("Pur Road, Pratap Nagar, Bhilwara, Rajasthan 311001");
        panelPrintReceipt.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 137, 181));
        jLabel2.setText("Manikya Lal Verma");
        panelPrintReceipt.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 137, 181));
        jLabel3.setText("Textile & Engineering College ");
        panelPrintReceipt.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/mlv_logo (1).jpg"))); // NOI18N
        panelPrintReceipt.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 100, 90));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Receipt No :            MLV- ");
        panelPrintReceipt.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Payment Mode : ");
        panelPrintReceipt.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        txtChequeDD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtChequeDD.setText("cheque_dd :");
        panelPrintReceipt.add(txtChequeDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        txtBankName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtBankName.setText("Bank Name : ");
        panelPrintReceipt.add(txtBankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Received From : ");
        panelPrintReceipt.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("The following payment int the college office for the year : ");
        panelPrintReceipt.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Date : ");
        panelPrintReceipt.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("GSTIN : ");
        panelPrintReceipt.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        panelPrintReceipt.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 327, 720, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        panelPrintReceipt.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 720, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Sr No");
        panelPrintReceipt.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Heads");
        panelPrintReceipt.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Amounts(Rs)");
        panelPrintReceipt.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, -1, -1));

        lblReceiptNo.setText("jLabel17");
        panelPrintReceipt.add(lblReceiptNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 140, -1));

        lblPaymentMode.setText("jLabel18");
        panelPrintReceipt.add(lblPaymentMode, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 140, -1));

        lblChequeDD.setText("jLabel20");
        panelPrintReceipt.add(lblChequeDD, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, -1));

        lblBankName.setText("jLabel21");
        panelPrintReceipt.add(lblBankName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, -1));

        lblReceivedFrom.setText("jLabel22");
        panelPrintReceipt.add(lblReceivedFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 140, -1));

        lblYear1.setText("jLabel23");
        panelPrintReceipt.add(lblYear1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 280, 50, -1));

        jLabel24.setText("-");
        panelPrintReceipt.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 10, -1));

        lblYear2.setText("jLabel25");
        panelPrintReceipt.add(lblYear2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 60, -1));

        lblDate.setText("jLabel26");
        panelPrintReceipt.add(lblDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 130, 110, -1));

        lblGSTIN.setText("jLabel27");
        panelPrintReceipt.add(lblGSTIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 90, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("1.");
        panelPrintReceipt.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        lblCourseName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCourseName.setText("                      jLabel28");
        panelPrintReceipt.add(lblCourseName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 360, 200, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("CGST 9%");
        panelPrintReceipt.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("SGST 9%");
        panelPrintReceipt.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        lblInitialAmount.setText("jLabel31");
        panelPrintReceipt.add(lblInitialAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 360, -1, -1));

        lblCGST.setText("jLabel32");
        panelPrintReceipt.add(lblCGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, -1, 20));

        lblSGST.setText("jLabel33");
        panelPrintReceipt.add(lblSGST, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, -1));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        panelPrintReceipt.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 450, 190, 10));

        lblTotal.setText("jLabel34");
        panelPrintReceipt.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 460, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Total In Words : ");
        panelPrintReceipt.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 520, -1, -1));

        lblTotalInWords.setText("jLabel35");
        panelPrintReceipt.add(lblTotalInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        panelPrintReceipt.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, 200, 10));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel36.setText("Receiver Signature");
        panelPrintReceipt.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, -1, -1));

        jTextField2.setBackground(new java.awt.Color(0, 137, 181));
        panelPrintReceipt.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 810, 10));

        getContentPane().add(panelPrintReceipt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 810, 590));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 137, 181));
        jLabel17.setText("PRINT RECEIPT");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 110, 20));

        jTextField1.setBackground(new java.awt.Color(0, 137, 181));
        jTextField1.setForeground(new java.awt.Color(0, 137, 181));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, 140, 5));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseEntered

    private void btnEditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelEdit.setBackground(clr);
    }//GEN-LAST:event_btnEditMouseExited

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(255,204,204);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSearchRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRecordsMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelSearchRecords.setBackground(clr);
    }//GEN-LAST:event_btnSearchRecordsMouseEntered

    private void btnSearchRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRecordsMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelSearchRecords.setBackground(clr);
    }//GEN-LAST:event_btnSearchRecordsMouseExited

    private void btnEditCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCourseMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelEditCourse.setBackground(clr);
    }//GEN-LAST:event_btnEditCourseMouseEntered

    private void btnEditCourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCourseMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelEditCourse.setBackground(clr);
    }//GEN-LAST:event_btnEditCourseMouseExited

    private void btnCourseListMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseEntered

    private void btnCourseListMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelCourseList.setBackground(clr);
    }//GEN-LAST:event_btnCourseListMouseExited

    private void btnViewAllRecordsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRecordsMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelViewAllRecords.setBackground(clr);
    }//GEN-LAST:event_btnViewAllRecordsMouseEntered

    private void btnViewAllRecordsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRecordsMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelViewAllRecords.setBackground(clr);
    }//GEN-LAST:event_btnViewAllRecordsMouseExited

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelBack.setBackground(clr);
    }//GEN-LAST:event_btnBackMouseExited

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered

        Color clr=new Color(255,204,204);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited

          Color clr=new Color(255,102,102);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnPrintMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseEntered
        // TODO add your handling code here:
         Color clr=new Color(255,204,204);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseEntered

    private void btnPrintMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseExited
        // TODO add your handling code here:
         Color clr=new Color(255,102,102);
        panelPrint.setBackground(clr);
    }//GEN-LAST:event_btnPrintMouseExited

    private void btnPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintMouseClicked
        // TODO add your handling code here:
        PrinterJob job=PrinterJob.getPrinterJob();
        job.setJobName("Print Data");
        job.setPrintable(new Printable(){
            public int print(Graphics pg,PageFormat pf, int pageNum){
                pf.setOrientation(PageFormat.LANDSCAPE);
                if(pageNum>0){
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2=(Graphics2D)pg;
                g2.translate(pf.getImageableX(),pf.getImageableY());
                g2.scale(0.47, 0.47);
                panelPrintReceipt.print(g2);
                return Printable.PAGE_EXISTS;
            }
        });
         boolean ok = job.printDialog();

    if (ok) {
        try {
            job.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
    }
    }//GEN-LAST:event_btnPrintMouseClicked

    private void panelLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelLogOutMouseEntered
        // TODO add your handling code here:

    }//GEN-LAST:event_panelLogOutMouseEntered

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        // TODO add your handling code here:
        UpdateFeesDetails update=new UpdateFeesDetails();
        update.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditMouseClicked

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
            java.util.logging.Logger.getLogger(printReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(printReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(printReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(printReceipt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new printReceipt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JLabel btnEditCourse;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JLabel btnPrint;
    private javax.swing.JLabel btnSearchRecords;
    private javax.swing.JLabel btnViewAllRecords;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblBankName;
    private javax.swing.JLabel lblCGST;
    private javax.swing.JLabel lblChequeDD;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblGSTIN;
    private javax.swing.JLabel lblInitialAmount;
    private javax.swing.JLabel lblPaymentMode;
    private javax.swing.JLabel lblReceiptNo;
    private javax.swing.JLabel lblReceivedFrom;
    private javax.swing.JLabel lblSGST;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalInWords;
    private javax.swing.JLabel lblYear1;
    private javax.swing.JLabel lblYear2;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEdit;
    private javax.swing.JPanel panelEditCourse;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogOut;
    private javax.swing.JPanel panelPrint;
    private javax.swing.JPanel panelPrintReceipt;
    private javax.swing.JPanel panelSearchRecords;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JPanel panelViewAllRecords;
    private javax.swing.JLabel txtBankName;
    private javax.swing.JLabel txtChequeDD;
    // End of variables declaration//GEN-END:variables
}

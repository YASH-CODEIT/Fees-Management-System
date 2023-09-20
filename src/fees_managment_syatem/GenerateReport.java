/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package fees_managment_syatem;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author yash
 */
public class GenerateReport extends javax.swing.JFrame {

    /**
     * Creates new form GenerateReport
     */
     DefaultTableModel model;
    public GenerateReport() {
        initComponents();
        fillComboBox();
    }
 public void fillComboBox(){
       try{
            Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_managment?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
                PreparedStatement pst=con.prepareStatement("select CNAME from course");
                ResultSet rs=pst.executeQuery();
                while(rs.next()){
                    jComboBox1.addItem(rs.getString("CNAME"));
                }
       }catch(Exception e){
           e.printStackTrace();
       }
   }
 public void setRecordsToTable(){
     String cname=jComboBox1.getSelectedItem().toString();
     SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    String fromDate=dateFormat.format(dateChosserFrom.getDate());
    String toDate=dateFormat.format(dateChosserToDate.getDate());
    Float amountTotal=0.0f;
    try{
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_managment?zeroDateTimeBehavior=CONVERT_TO_NULL","root","");
       PreparedStatement pst=con.prepareStatement("select * from fees_details where date between ? and ? and courseName = ?");
       pst.setString(1,fromDate);
       pst.setString(2,toDate);
       pst.setString(3,cname);
       ResultSet rs=pst.executeQuery();
       while(rs.next()){
          String recieptNo=rs.getString("recieptNo");
          String rollNo=rs.getString("rollNo");
          String studentName=rs.getString("studentName");
          String courseName=rs.getString("courseName");
          float amount=rs.getFloat("totalAmount");
          String remark=rs.getString("remark");
          amountTotal = amountTotal + amount;
          Object[] obj={recieptNo,rollNo,studentName,courseName,amount,remark};
          model=(DefaultTableModel)tblGenerateReport.getModel();
          model.addRow(obj);
       }
       lblDisplaySummaryCourseSelected.setText(cname);
       lblDisplaySummaryTotalAmountCollected.setText(amountTotal.toString());
        lblDisplaySummaryTotalAmountInWords.setText(NumberToWordsConverter.convert(amountTotal.intValue())+" only /-");
    }catch(Exception e){
        e.printStackTrace();
    }
}
  public void clearTable(){
    DefaultTableModel model=(DefaultTableModel)tblGenerateReport.getModel();
    model.setRowCount(1);  
}
  public void exportToExcel(){
      XSSFWorkbook wb=new XSSFWorkbook();
      XSSFSheet ws=wb.createSheet();
         model=(DefaultTableModel)tblGenerateReport.getModel();
         TreeMap<String,Object[]> map=new TreeMap<>();
         map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)});
         for(int i=1;i<model.getRowCount();i++){
             map.put(Integer.toString(i),new Object[]{model.getValueAt(i, 0),model.getValueAt(i,1),model.getValueAt(i,2),model.getValueAt(i,3),model.getValueAt(i,4),model.getValueAt(i,5)});
         }
         Set<String> id=map.keySet();
         XSSFRow fRow;
         int rowId=0;
         for(String key : id){
             fRow=ws.createRow(rowId++);
             Object[] value=map.get(key);
             int cellId=0;
             for(Object object : value){
                 XSSFCell cell=fRow.createCell(cellId++);
                 cell.setCellValue(object.toString());
             }
             
         }
         try(FileOutputStream fos = new FileOutputStream(new File(txtFilePath.getText()))){
             wb.write(fos);
             JOptionPane.showMessageDialog(this,"File Exported Successfully : "+txtFilePath.getText());
         }catch(Exception e){
             e.printStackTrace();
         }
          for(Map.Entry<String,Object[]> entry : map.entrySet()){
             String key=entry.getKey();
             Object[] value=entry.getValue();
                System.out.println(Arrays.toString(value));
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
        panelLogOut = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JLabel();
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
        jPanel1 = new javax.swing.JPanel();
        lblFromDate = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        lblSelectCourse = new javax.swing.JLabel();
        lblToDate = new javax.swing.JLabel();
        lblSelectDate = new javax.swing.JLabel();
        dateChosserFrom = new com.toedter.calendar.JDateChooser();
        dateChosserToDate = new com.toedter.calendar.JDateChooser();
        btnPrint = new javax.swing.JButton();
        btnBrowser = new javax.swing.JButton();
        txtFilePath = new javax.swing.JTextField();
        btnExportToExcel = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGenerateReport = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblSummaryTotalAmountCollected = new javax.swing.JLabel();
        lblTotalAmountsInWords = new javax.swing.JLabel();
        lblSelectCourse3 = new javax.swing.JLabel();
        lblSummaryCourseSelected = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblDisplaySummaryCourseSelected = new javax.swing.JLabel();
        lblDisplaySummaryTotalAmountCollected = new javax.swing.JLabel();
        lblDisplaySummaryTotalAmountInWords = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSideBar.setBackground(new java.awt.Color(255, 102, 102));
        panelSideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogOut.setBackground(new java.awt.Color(255, 102, 102));
        panelLogOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelLogOut.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogOut.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnLogOut.setForeground(new java.awt.Color(255, 255, 255));
        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/exit.png"))); // NOI18N
        btnLogOut.setText("        Logout");
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogOutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogOutMouseExited(evt);
            }
        });
        panelLogOut.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 2, 260, 50));

        panelSideBar.add(panelLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 320, 50));

        panelHome.setBackground(new java.awt.Color(255, 102, 102));
        panelHome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelHome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/home.png"))); // NOI18N
        btnHome.setText("      HOME");
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });
        panelHome.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 50));

        panelSideBar.add(panelHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 320, 50));

        panelSearchRecords.setBackground(new java.awt.Color(255, 102, 102));
        panelSearchRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelSearchRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSearchRecords.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnSearchRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/search2.png"))); // NOI18N
        btnSearchRecords.setText("      Search Records");
        btnSearchRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchRecordsMouseExited(evt);
            }
        });
        panelSearchRecords.add(btnSearchRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 310, 60));

        panelSideBar.add(panelSearchRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 320, 50));

        panelEditCourse.setBackground(new java.awt.Color(255, 102, 102));
        panelEditCourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelEditCourse.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        panelEditCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEditCourse.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnEditCourse.setForeground(new java.awt.Color(255, 255, 255));
        btnEditCourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/edit2.png"))); // NOI18N
        btnEditCourse.setText("      Edit Course");
        btnEditCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditCourseMouseExited(evt);
            }
        });
        panelEditCourse.add(btnEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, -1));

        panelSideBar.add(panelEditCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 320, 50));

        panelCourseList.setBackground(new java.awt.Color(255, 102, 102));
        panelCourseList.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelCourseList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCourseList.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnCourseList.setForeground(new java.awt.Color(255, 255, 255));
        btnCourseList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/list.png"))); // NOI18N
        btnCourseList.setText("        Course List");
        btnCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCourseListMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCourseListMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCourseListMouseExited(evt);
            }
        });
        panelCourseList.add(btnCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 260, -1));

        panelSideBar.add(panelCourseList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 320, 50));

        panelViewAllRecords.setBackground(new java.awt.Color(255, 102, 102));
        panelViewAllRecords.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelViewAllRecords.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnViewAllRecords.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnViewAllRecords.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAllRecords.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/view all record.png"))); // NOI18N
        btnViewAllRecords.setText("        View All Records");
        btnViewAllRecords.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnViewAllRecordsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnViewAllRecordsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnViewAllRecordsMouseExited(evt);
            }
        });
        panelViewAllRecords.add(btnViewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 50));

        panelSideBar.add(panelViewAllRecords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 320, 50));

        panelBack.setBackground(new java.awt.Color(255, 102, 102));
        panelBack.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBack.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_managment_syatem/icon/left-arrow.png"))); // NOI18N
        btnBack.setText("        Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
        });
        panelBack.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 260, -1));

        panelSideBar.add(panelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 320, 50));

        getContentPane().add(panelSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 860));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFromDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblFromDate.setText("From Date :");
        jPanel1.add(lblFromDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 100, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAVA ", "WEB DEVELOPMENT", "SPRINGBOOT", "C", "C++", "PYTHON" }));
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 260, -1));

        lblSelectCourse.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSelectCourse.setText("Select Course :");
        jPanel1.add(lblSelectCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 120, 20));

        lblToDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblToDate.setText("To Date :");
        jPanel1.add(lblToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 80, 20));

        lblSelectDate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblSelectDate.setText("Select Date :");
        jPanel1.add(lblSelectDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));
        jPanel1.add(dateChosserFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 130, -1));
        jPanel1.add(dateChosserToDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, -1));

        btnPrint.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btnPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        btnBrowser.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnBrowser.setText("Browser");
        btnBrowser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserActionPerformed(evt);
            }
        });
        jPanel1.add(btnBrowser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, -1, -1));
        jPanel1.add(txtFilePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 270, -1));

        btnExportToExcel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnExportToExcel.setText("Export To Excel");
        btnExportToExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportToExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btnExportToExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 160, -1));

        btnSubmit.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        tblGenerateReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "ReceiptNo", "StudentName", "PaymentMode", "CourseName", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tblGenerateReport);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 840, 350));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 137, 181)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSummaryTotalAmountCollected.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSummaryTotalAmountCollected.setText("Total Amount Collected :");
        jPanel2.add(lblSummaryTotalAmountCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 20));

        lblTotalAmountsInWords.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblTotalAmountsInWords.setText("Total Amounts In Words :");
        jPanel2.add(lblTotalAmountsInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 160, 20));

        lblSelectCourse3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSelectCourse3.setForeground(new java.awt.Color(0, 137, 181));
        lblSelectCourse3.setText("Summary");
        jPanel2.add(lblSelectCourse3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, 20));

        lblSummaryCourseSelected.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblSummaryCourseSelected.setText("Course Selected :");
        jPanel2.add(lblSummaryCourseSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 20));

        jTextField1.setBackground(new java.awt.Color(0, 137, 181));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 70, 5));
        jPanel2.add(lblDisplaySummaryCourseSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 150, 20));
        jPanel2.add(lblDisplaySummaryTotalAmountCollected, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 100, 20));

        lblDisplaySummaryTotalAmountInWords.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblDisplaySummaryTotalAmountInWords.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel2.add(lblDisplaySummaryTotalAmountInWords, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 260, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 290, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 900, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogOutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseEntered
        // TODO add your handling code here:
        Color clr=new Color(255,204,204);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseEntered

    private void btnLogOutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelLogOut.setBackground(clr);
    }//GEN-LAST:event_btnLogOutMouseExited

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        HomePage home=new HomePage();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        Color clr=new Color(255,204,204);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        // TODO add your handling code here:
        Color clr=new Color(255,102,102);
        panelHome.setBackground(clr);
    }//GEN-LAST:event_btnHomeMouseExited

    private void btnSearchRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchRecordsMouseClicked
SearchRecords records=new SearchRecords();
records.setVisible(true);
this.dispose();
    }//GEN-LAST:event_btnSearchRecordsMouseClicked

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

    private void btnEditCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditCourseMouseClicked
         EditCourse edit=new EditCourse();
         edit.setVisible(true);
         this.dispose();
    }//GEN-LAST:event_btnEditCourseMouseClicked

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

    private void btnCourseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseListMouseClicked

    }//GEN-LAST:event_btnCourseListMouseClicked

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

    private void btnBrowserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserActionPerformed
       JFileChooser fileChooser =new JFileChooser();
       fileChooser.showOpenDialog(this);
       SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
       String date=dateFormat.format(new Date());
       try{
         File f=fileChooser.getSelectedFile();
         String path=f.getAbsolutePath();
         path=path+"_"+date+".xlsx";
         txtFilePath.setText(path);
       }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_btnBrowserActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
   clearTable();
        setRecordsToTable();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String dateFrom=dateFormat.format(dateChosserFrom.getDate());
        String dateTo=dateFormat.format(dateChosserToDate.getDate());
        MessageFormat header=new MessageFormat("Report From "+dateFrom+" To "+dateTo);
        MessageFormat fotter=new MessageFormat("page{0,number,integer}");
        try{
            tblGenerateReport.print(JTable.PrintMode.FIT_WIDTH,header,fotter);
        }catch(Exception e){
            e.getMessage();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnExportToExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportToExcelActionPerformed
        exportToExcel();
    }//GEN-LAST:event_btnExportToExcelActionPerformed

    private void btnViewAllRecordsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnViewAllRecordsMouseClicked
       ViewAllRecords view=new ViewAllRecords();
       view.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnViewAllRecordsMouseClicked

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
       HomePage home=new HomePage();
       home.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btnBackMouseClicked

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOutMouseClicked

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
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnBrowser;
    private javax.swing.JLabel btnCourseList;
    private javax.swing.JLabel btnEditCourse;
    private javax.swing.JButton btnExportToExcel;
    private javax.swing.JLabel btnHome;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel btnSearchRecords;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel btnViewAllRecords;
    private com.toedter.calendar.JDateChooser dateChosserFrom;
    private com.toedter.calendar.JDateChooser dateChosserToDate;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblDisplaySummaryCourseSelected;
    private javax.swing.JLabel lblDisplaySummaryTotalAmountCollected;
    private javax.swing.JLabel lblDisplaySummaryTotalAmountInWords;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblSelectCourse;
    private javax.swing.JLabel lblSelectCourse3;
    private javax.swing.JLabel lblSelectDate;
    private javax.swing.JLabel lblSummaryCourseSelected;
    private javax.swing.JLabel lblSummaryTotalAmountCollected;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JLabel lblTotalAmountsInWords;
    private javax.swing.JPanel panelBack;
    private javax.swing.JPanel panelCourseList;
    private javax.swing.JPanel panelEditCourse;
    private javax.swing.JPanel panelHome;
    private javax.swing.JPanel panelLogOut;
    private javax.swing.JPanel panelSearchRecords;
    private javax.swing.JPanel panelSideBar;
    private javax.swing.JPanel panelViewAllRecords;
    private javax.swing.JTable tblGenerateReport;
    private javax.swing.JTextField txtFilePath;
    // End of variables declaration//GEN-END:variables
}

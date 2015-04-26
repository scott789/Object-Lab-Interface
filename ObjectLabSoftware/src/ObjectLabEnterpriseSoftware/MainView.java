package ObjectLabEnterpriseSoftware;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class MainView extends javax.swing.JFrame
{
    private static final String NAME_OF_PAGE = "Home";

    NewStudentView newStudentSys;
    PendingJobsView pendingSys;
    StudentSubmissionView studentSys;
    boolean show;
    String PASS = "ForwardMotion";

    public MainView()
    {
        initComponents();
        this.setResizable(false);
        setPrintersVisible(false);
        pendingSys = new PendingJobsView();
        studentSys = new StudentSubmissionView();
        newStudentSys = new NewStudentView();

        //Allows only integers for student ID
        studentIdString.addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                char c = e.getKeyChar();
                if (!((c >= '0') && (c <= '9')
                        || (c == KeyEvent.VK_BACK_SPACE)
                        || (c == KeyEvent.VK_DELETE)))
                {
                    getToolkit().beep();
                    e.consume();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        newStudentButton = new javax.swing.JButton();
        errorIdLabel = new javax.swing.JLabel();
        studentIdString = new javax.swing.JTextField();
        studentButton = new javax.swing.JButton();
        enterBuild = new javax.swing.JButton();
        AdminButton = new javax.swing.JButton();
        openProjectsButton = new javax.swing.JButton();
        settingsButton = new javax.swing.JButton();
        ReportsButton = new javax.swing.JButton();
        newStudent = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        helpButton = new javax.swing.JMenu();
        userGuideButton = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Art 101-001\nArt 201-002\nArt 401-004\nArt 501-005\nArt 601-006\nArt 701-007\nArt 801-009");
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(UtilController.getPageName(NAME_OF_PAGE));
        setMinimumSize(new java.awt.Dimension(545, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        newStudentButton.setText("New Student");
        newStudentButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                newStudentButtonActionPerformed(evt);
            }
        });
        getContentPane().add(newStudentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 110, 30));

        errorIdLabel.setBackground(new java.awt.Color(0, 0, 0));
        errorIdLabel.setForeground(new java.awt.Color(255, 0, 0));
        getContentPane().add(errorIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 130, 20));

        studentIdString.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                studentIdStringActionPerformed(evt);
            }
        });
        getContentPane().add(studentIdString, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 130, 30));

        studentButton.setText("Student");
        studentButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                studentButtonActionPerformed(evt);
            }
        });
        getContentPane().add(studentButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 110, 30));

        enterBuild.setText("Enter Build");
        enterBuild.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                enterBuildActionPerformed(evt);
            }
        });
        getContentPane().add(enterBuild, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 130, 30));

        AdminButton.setText("Administrator");
        AdminButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                AdminButtonActionPerformed(evt);
            }
        });
        getContentPane().add(AdminButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 130, 30));

        openProjectsButton.setText("Projects");
        openProjectsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                openProjectsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(openProjectsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 130, 30));

        settingsButton.setText("Settings");
        settingsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                settingsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(settingsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, 130, 30));

        ReportsButton.setText("Reports");
        ReportsButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                ReportsButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ReportsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 130, 30));

        newStudent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/render_bg.png"))); // NOI18N
        getContentPane().add(newStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 350));

        helpButton.setText("Help");

        userGuideButton.setText("User Guide");
        userGuideButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                userGuideButtonActionPerformed(evt);
            }
        });
        helpButton.add(userGuideButton);

        MenuBar.add(helpButton);

        setJMenuBar(MenuBar);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void enterBuildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBuildActionPerformed
        // TODO add your handling code here:
        PrinterBuildView Build = new PrinterBuildView();
        Build.startMakeBuildProcess();
        dispose();
    }//GEN-LAST:event_enterBuildActionPerformed

    private void openProjectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openProjectsButtonActionPerformed
        // TODO add your handling code here:
        pendingSys.PendingJobsStart();
        dispose();
    }//GEN-LAST:event_openProjectsButtonActionPerformed

    private void AdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminButtonActionPerformed
        PasswordDialogView dialogue = new PasswordDialogView();
        dialogue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        dialogue.setAlwaysOnTop(true);
        dialogue.setVisible(true);
        dialogue.setLocationRelativeTo(this);
        dialogue.setResizable(false);
        /* 
         Currently bypasses what is typed into dialogue for ease of testing
         password.equals(PASS) 
         */
        if (true)
        {
            //studentSubmissionButton.setVisible(false);
            setPrintersVisible(true);
        } else
        {
            JOptionPane.showMessageDialog(new java.awt.Frame(), "Incorrect password! Access Denied!");
        }
    }//GEN-LAST:event_AdminButtonActionPerformed

    private void ReportsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsButtonActionPerformed
        // TODO add your handling code here:
        ReportsView reports = new ReportsView();
        reports.ReportsPage();
        dispose();
    }//GEN-LAST:event_ReportsButtonActionPerformed

    private void studentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentButtonActionPerformed
        // TODO add your handling code here:
        setPrintersVisible(false);
        int id;

        String idString = studentIdString.getText();//DB team this is to store String

        if (idString.length() != 7)
        {
            errorIdLabel.setText("USER ID must be 7 digits");
        } else
        {
            id = Integer.parseInt(idString);
            if (UtilController.userIDExist(id))
            {
                errorIdLabel.setText("");
                dispose();
                studentSys.studentSubmissionStart(id);
            } else
            {
                errorIdLabel.setText("USER ID does not exist");
            }
        }

    }//GEN-LAST:event_studentButtonActionPerformed

    private void studentIdStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdStringActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_studentIdStringActionPerformed

    private void newStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStudentButtonActionPerformed
        // TODO add your handling code here:
        newStudentSys.NewStudentViewStart();
        dispose();

    }//GEN-LAST:event_newStudentButtonActionPerformed

    private void userGuideButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userGuideButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userGuideButtonActionPerformed

    private void settingsButtonActionPerformed(java.awt.event.ActionEvent evt)
    {
        AdminSettingsView ad = new AdminSettingsView();
        ad.setVisible(true);
        dispose();
    }

    public void setPrintersVisible(boolean isVisible)
    {
        settingsButton.setVisible(isVisible);
        openProjectsButton.setVisible(isVisible);
        enterBuild.setVisible(isVisible);
        ReportsButton.setVisible(isVisible);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Windows".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminButton;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton ReportsButton;
    private javax.swing.JButton enterBuild;
    private javax.swing.JLabel errorIdLabel;
    private javax.swing.JMenu helpButton;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel newStudent;
    private javax.swing.JButton newStudentButton;
    private javax.swing.JButton openProjectsButton;
    private javax.swing.JButton settingsButton;
    private javax.swing.JButton studentButton;
    private javax.swing.JTextField studentIdString;
    private javax.swing.JMenuItem userGuideButton;
    // End of variables declaration//GEN-END:variables
}
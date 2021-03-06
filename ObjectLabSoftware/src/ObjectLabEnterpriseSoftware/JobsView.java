package ObjectLabEnterpriseSoftware;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JLabel;

public class JobsView extends javax.swing.JFrame
{

    private static final String NAME_OF_PAGE = "Student Submission - Admin";

    private static final int PROJECT_NAME_COLUMN_NUMBER = 0;
    private static final int FIRST_NAME_COLUMN_NUMBER = 1;
    private static final int LAST_NAME_COLUMN_NUMBER = 2;
    private static final int PRINTER_COLUMN_NUMBER = 3;
    private static final int DATE_PROJECT_STARTED_COLUMN_NUMBER = 4;
    private ArrayList<String> printers;
    private String selectedPrinter;
    private String[] completedHeaders = new String[]{"File Name","First Name","Last Name","Submission Date","Class","Section","Volume"};
    // --nav bar views ~Alex
    private BuildView buildView;
    private JobsView jobsView;
    private ReportsView reportsView;	
    private AdminSettingsView adminSettingsView;
    //
    private static final MainView home = new MainView();

    private DefaultTableModel allFileTableModel;

    private void updateView(String status, DefaultTableModel pendingJobsView, ArrayList<ArrayList<Object>> view)
    {

        pendingJobsView.setColumnIdentifiers(UtilController.getStatusJobsHeaders(status));
        /* Clears up the rows in the view's model. */
        for (int rows = pendingJobsView.getRowCount() - 1; rows >= 0; rows--)
        {
            pendingJobsView.removeRow(rows);
        }
        	int rowSelector = 0;
        /* Inserts data found in (ArrayList -> listOfRows) by row into the UI model to display */
        for (ArrayList<Object> row : view)
        {
            if(UtilController.findAndVerifyFile((String)(row.toArray()[0]))){
                pendingJobsView.addRow(row.toArray());
               // add(new Checkbox(Integer.toString(rowSelector), selectedGroup, false));
                rowSelector++;
              
            } 
        }

        
        //if the status is pending, show the approve and reject buttons
        if (!status.equals("pending"))
        {
            approveButton.setVisible(false);
            rejectButton.setVisible(false);
        } else if(status.equals("pending"))
        {
            approveButton.setVisible(true);
            rejectButton.setVisible(true);
        }
        //If status is completed, let the user see printer selection and export button
        if (!status.equals("completed"))
        {
            exportButton.setVisible(false);
            deviceLabel.setVisible(false);
            printerBox.setVisible(false);
        } else if(status.equals("completed"))
        {
            exportButton.setVisible(true);
            deviceLabel.setVisible(true);
            printerBox.setVisible(true);
        }
    }

    public JobsView()
    {
        
        printers = UtilController.getListOfAllDevices();
        /* Creates are PendingJobs UI window componet and grabs its data model for our uses */
        initComponents();
        // --nav bar views ~Alex

        initNavBar();
        //
        
        
        allFileTableModel = (DefaultTableModel) PendingTable.getModel();

        addWindowListener(
                new WindowAdapter()
                {
                    @Override
                    public void windowClosing(WindowEvent we)
                    {
                        /* If they close the program then close out the window properly */
                        dispose();
                        //home.resetAdminMode();
                    }
                }
        );
    }

    public void PendingJobsStart()
    {
        /* Updates table */
        updateView((String) jobStatus.getSelectedItem(), allFileTableModel, UtilController.updatePendingTableData((String) jobStatus.getSelectedItem()));
        setVisible(true);
    }

    /**
     * Takes the table model, selected row, and the column you are interested in
     * and returns the row number that the user selected.
     */
    public static int getSelectedRowNum(DefaultTableModel dm, int selectedRow, int column)
    {
        if (selectedRow < 0)
        {
            return -1;
        }

        for (int i = 0; i < dm.getRowCount(); i++)
        {
            if (dm.getValueAt(i, column).equals(dm.getValueAt(selectedRow, column)))
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

    	
    	getContentPane().setPreferredSize(new Dimension(775,700));
    	setResizable(false);
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        PendingTable = new javax.swing.JTable();
        backToMainMenu = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jobStatus = new javax.swing.JComboBox();
        reviewFile = new javax.swing.JLabel();
        approveButton = new javax.swing.JLabel();
        rejectButton = new javax.swing.JLabel();
        exportButton = new javax.swing.JButton();
        deviceLabel = new javax.swing.JLabel();
        printerBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
      

        
 ;	
        

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Jobs Manager");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 750, 10));

        PendingTable.setAutoCreateRowSorter(true);
        PendingTable.setModel(new javax.swing.table.DefaultTableModel()
            {
                boolean[] canEdit = new boolean []
                {
                    false, false, false, false, false, false, true
                };

                public boolean isCellEditable(int rowIndex, int columnIndex)
                {
                    return canEdit [columnIndex];
                }
            });
            jScrollPane4.setViewportView(PendingTable);

            getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 750, 410));

            backToMainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/back_arrow_button.png"))); // NOI18N
            backToMainMenu.setToolTipText("Back");
            backToMainMenu.setBorderPainted(false);
            backToMainMenu.setContentAreaFilled(false);
            backToMainMenu.setFocusPainted(false);
            backToMainMenu.setVisible(false);
            backToMainMenu.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                	System.out.println("found old backbutton");
                    backToMainMenuActionPerformed(evt);
                }
            });
            
            
            
            
            
            
            
            getContentPane().add(backToMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 60, 40));

            jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            jLabel3.setText("Job status:");
            getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 60, 20));

            jobStatus.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            jobStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] {"All Jobs", "Pending", "Rejected", "Approved", "Completed"}));
            jobStatus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jobStatusActionPerformed(evt);
                }
            });
            getContentPane().add(jobStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, 20));

            reviewFile.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            reviewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/view_file_icon.png"))); // NOI18N
            reviewFile.setText("Review File");
            reviewFile.setToolTipText("Review file");
            reviewFile.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    openFileInDefaultProgram(evt);
                }
            });
            getContentPane().add(reviewFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 130, 60));

            approveButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            approveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/accept_icon.png"))); // NOI18N
            approveButton.setText("Approve");
            approveButton.setToolTipText("Accept job");
            approveButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    approveButtonMouseClicked(evt);
                }
            });
            getContentPane().add(approveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 510, 110, 60));

            rejectButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            rejectButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/reject_icon.png"))); // NOI18N
            rejectButton.setText("Reject");
            rejectButton.setToolTipText("Reject job");
            rejectButton.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    rejectButtonMouseClicked(evt);
                }
            });
            getContentPane().add(rejectButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 510, 100, 60));

            exportButton.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            exportButton.setText("Export File Tracking Report");
            exportButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    exportButtonActionPerformed(evt);
                }
            });
            getContentPane().add(exportButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, -1, -1));

            deviceLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
            deviceLabel.setText("Device:");
            getContentPane().add(deviceLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 60, 40, 20));

            printerBox.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
            printerBox.setModel(new javax.swing.DefaultComboBoxModel(UtilController.arrayListToStringArray(UtilController.getListOfCurrentDevices())));
            getContentPane().add(printerBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 90, 20));

            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ObjectLabEnterpriseSoftware/images/white_bg.jpg"))); // NOI18N
            getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, -6, 790, 590));


            
            
            
            
            
            
            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void initNavBar()
    {

    	jMenuBar1.setPreferredSize(new Dimension(200, 75));
        setJMenuBar(jMenuBar1);
        
        navBtn_jobsMgr = new JButton("Jobs Manager");
        navBtn_jobsMgr.setIcon(new ImageIcon(JobsView.class.getResource("/ObjectLabEnterpriseSoftware/images/view_file_icon.png")));
        navBtn_jobsMgr.setPreferredSize(new Dimension(100,75));
        navBtn_jobsMgr.setAlignmentX(jScrollPane2.CENTER_ALIGNMENT);
        
        jMenuBar1.add(Box.createRigidArea(new Dimension(100,0)));
        jMenuBar1.add(navBtn_jobsMgr);
        
        navBtn_build = new JButton("Enter Build");
        navBtn_build.setIcon(new ImageIcon(JobsView.class.getResource("/ObjectLabEnterpriseSoftware/images/hammer_icon.png")));
        
        navBtn_build.setPreferredSize(new Dimension(100,100));
        navBtn_build.setAlignmentX(jScrollPane2.CENTER_ALIGNMENT);
        jMenuBar1.add(navBtn_build);
        
        navBtn_reports = new JButton("Reports");
        navBtn_reports.setIcon(new ImageIcon(JobsView.class.getResource("/ObjectLabEnterpriseSoftware/images/reports_icon.png")));
        navBtn_reports.setPreferredSize(new Dimension(100,100));
        navBtn_reports.setAlignmentX(jScrollPane2.CENTER_ALIGNMENT);
        jMenuBar1.add(navBtn_reports);
        
        navBtn_settings = new JButton("Settings");
        navBtn_settings.setIcon(new ImageIcon(JobsView.class.getResource("/ObjectLabEnterpriseSoftware/images/cog_icon.png")));
        navBtn_settings.setPreferredSize(new Dimension(100,100));
        navBtn_settings.setAlignmentX(jScrollPane2.CENTER_ALIGNMENT);
        jMenuBar1.add(navBtn_settings);
        
        navBtn_rejected = new JButton("Rejected File Manager");
        navBtn_rejected.setIcon(new ImageIcon(JobsView.class.getResource("/ObjectLabEnterpriseSoftware/images/reject_files_icon.ico")));
        navBtn_rejected.setPreferredSize(new Dimension(100, 100));
        navBtn_rejected.setAlignmentX(0.5f);
        jMenuBar1.add(navBtn_rejected);

        
        navBtn_jobsMgr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtn_jobsMgrActionPerformed(evt);
            }
        });
        
        navBtn_build.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtn_buildActionPerformed(evt);
            }
        });
        
        navBtn_reports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                navBtn_reportsActionPerformed(evt);
            }
        });
        
        navBtn_settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	navBtn_settingsActionPerformed(evt);
            }
        }); 

    }
    
    
    private void navBtn_jobsMgrActionPerformed(java.awt.event.ActionEvent evt)
    {
    	newJobsMgr njm = new newJobsMgr();
        njm.setVisible(true);
    	dispose();

    }
    
    private void navBtn_buildActionPerformed(java.awt.event.ActionEvent evt)
    {
    	buildView = new BuildView();
        buildView.startMakeBuildProcess();
    	dispose();
    	
    }
    
    private void navBtn_reportsActionPerformed(java.awt.event.ActionEvent evt)
    {
    	reportsView = new ReportsView();
        reportsView.ReportsPage();
    	dispose();
    	
    }
    
    private void navBtn_settingsActionPerformed(java.awt.event.ActionEvent evt)
    {
    	adminSettingsView = new AdminSettingsView();
    	adminSettingsView.AdminSettingsViewStart();
    	dispose();
    	
    }
    
    
    
    /////// Nav Bar ~Alex /////
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This is probably something that should be in a general Utils class for
     * the front end or the various "views". I'm leaving this here for now
     * because I don't want to change or add anything else that could affect
     * other groups. -Nick
     */
    private static double getDouble(String msg, double min, double max)
    {
        String tmp;
        do
        {

            tmp = JOptionPane.showInputDialog(null, msg);

            if (tmp != null)
            {
                Scanner inputChecker = new Scanner(tmp);
                double volume;

                if (inputChecker.hasNextDouble())
                {
                    volume = inputChecker.nextDouble();
                    if (volume >= min && volume <= max)
                    {
                        return volume;
                    }
                } else
                {
                    if (inputChecker.hasNext())
                    {
                        inputChecker.next();
                    }
                }
            } else
            {
                return -1;
            }

        } while (true);
    }

    

    
    
    
    
    private void backToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backToMainMenuActionPerformed
        dispose();
        home.resetAdminMode();
    }//GEN-LAST:event_backToMainMenuActionPerformed

    private void jobStatusActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jobStatusActionPerformed
    {//GEN-HEADEREND:event_jobStatusActionPerformed
        updateView((String) jobStatus.getSelectedItem(), allFileTableModel, UtilController.updatePendingTableData((String) jobStatus.getSelectedItem()));
    }//GEN-LAST:event_jobStatusActionPerformed

    private void openFileInDefaultProgram(java.awt.event.MouseEvent evt)//GEN-FIRST:event_openFileInDefaultProgram
    {//GEN-HEADEREND:event_openFileInDefaultProgram
        int userSelectedRow = PendingTable.getSelectedRow();

        if (userSelectedRow > -1)
        {
            int rowDataLocation = getSelectedRowNum(allFileTableModel, userSelectedRow, 0);

            /* Hand off the data in the selected row found in our tablemodel to this method so we can 
             open the correct file with the information found in the row that was clicked on. -Nick 
             */
            File fileLocation = UtilController.getFilePath(
                    (String) allFileTableModel.getValueAt(rowDataLocation, FIRST_NAME_COLUMN_NUMBER),
                    (String) allFileTableModel.getValueAt(rowDataLocation, LAST_NAME_COLUMN_NUMBER),
                    (String) allFileTableModel.getValueAt(rowDataLocation, PROJECT_NAME_COLUMN_NUMBER),
                    (String) allFileTableModel.getValueAt(rowDataLocation, DATE_PROJECT_STARTED_COLUMN_NUMBER)
            );
            //TODO: display popup/error if this is false
            UtilController.checkFileExists(fileLocation.getPath());
            try
            {
                Desktop.getDesktop().open(fileLocation);
            } catch (IOException ex)
            {
                Logger.getLogger(JobsView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a file to review!");
        }
    }//GEN-LAST:event_openFileInDefaultProgram

    private void approveButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_approveButtonMouseClicked
    {//GEN-HEADEREND:event_approveButtonMouseClicked
        int userSelectedRow = PendingTable.getSelectedRow();
        double maxVolume = 10000.0; /* Will need to have this in a cfg file.... */

        if (userSelectedRow > -1)
        {
            int rowDataLocation = getSelectedRowNum(allFileTableModel, userSelectedRow, 0);
            double volume = getDouble("Enter volume (in cubic inches): ", 0.0, maxVolume);

            if (volume >= 0.001) // fix for input 0 < x < 1
            {
                /* Hand off the data in the selected row found in our tablemodel to this method so we can 
                 approve the correct file to be printed... -Nick 
                 */
                UtilController.approveStudentSubmission(
                        (String) allFileTableModel.getValueAt(rowDataLocation, PROJECT_NAME_COLUMN_NUMBER),
                        volume
                );
                updateView((String) jobStatus.getSelectedItem(), allFileTableModel, UtilController.updatePendingTableData((String) jobStatus.getSelectedItem()));
            }
        } else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a submission file to approve!");
        }
    }//GEN-LAST:event_approveButtonMouseClicked

    private void rejectButtonMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_rejectButtonMouseClicked
    {//GEN-HEADEREND:event_rejectButtonMouseClicked
        int userSelectedRow = PendingTable.getSelectedRow();
        String desc;

        if (userSelectedRow >= 0)
        {
            desc = JOptionPane.showInputDialog(new java.awt.Frame(), "Enter in reject description: ");

            if (desc != null)
            {

                /* Hand off the data in the selected row found in our tablemodel to this method so we can 
                 * reject the correct file -Nick 
                 */
                boolean success = UtilController.rejectStudentSubmission(
                        (String) allFileTableModel.getValueAt(userSelectedRow, PROJECT_NAME_COLUMN_NUMBER),
                        desc
                );

                if (success) // always rejects, commenting out email utlity for now ~Alex
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Rejected succesfully!");
                    updateView((String) jobStatus.getSelectedItem(), allFileTableModel, UtilController.updatePendingTableData((String) jobStatus.getSelectedItem()));
                } else
                {
                    JOptionPane.showMessageDialog(new JFrame(), "Rejection of student submission successful!");
                }
            }
        } else
        {
            JOptionPane.showMessageDialog(new JFrame(), "Please select a submission file to reject!");
        }
    }//GEN-LAST:event_rejectButtonMouseClicked

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed

        selectedPrinter = printerBox.getSelectedItem().toString();
        UtilController controller = new UtilController();
        
        controller.exportReportToFile(allFileTableModel, completedHeaders, selectedPrinter, 'f');
    }//GEN-LAST:event_exportButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable PendingTable;
    private javax.swing.JLabel approveButton;
    private javax.swing.JButton backToMainMenu;
    private javax.swing.JLabel deviceLabel;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox jobStatus;
    private javax.swing.JComboBox printerBox;
    private javax.swing.JLabel rejectButton;
    private javax.swing.JLabel reviewFile;
    private CheckboxGroup selectedGroup;
    // --nav bar vars ~Alex
    private JButton navBtn_jobsMgr;
    private JButton navBtn_build;
    private JButton navBtn_reports;
    private JButton navBtn_settings;
    private JButton navBtn_rejected;
    //
    // End of variables declaration//GEN-END:variables
}

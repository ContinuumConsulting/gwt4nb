/*
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at http://www.netbeans.org/cddl.html
 * or http://www.netbeans.org/cddl.txt.
 *
 * When distributing Covered Code, include this CDDL Header Notice in each file
 * and include the License file at http://www.netbeans.org/cddl.txt.
 * If applicable, add the following below the CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 */
package org.netbeans.modules.gwt4nb;

import java.io.File;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.netbeans.api.project.Project;
import org.netbeans.modules.gwt4nb.settings.GWTSettings;
import org.openide.util.NbBundle;
import org.netbeans.modules.web.api.webmodule.WebModule;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.Lookup;
import org.openide.util.Utilities;

/**
 * @author Tomas.Zezula@Sun.COM
 * @author Tomasz.Slota@Sun.COM
 */
public class GWTConfigPanelVisual extends javax.swing.JPanel {
    private GWTConfigPanel controller;
    private ChangeNotifier changeNotifier = new ChangeNotifier();
    private Project project=null;
    
    /** Creates new form GWTConfigPanelVisual */
    public GWTConfigPanelVisual(GWTConfigPanel controller,Project project) {
        this.controller = controller;
        this.project = project;
        initComponents();
        upgradeProgressBar.setVisible(false);
        upgradeLbl.setVisible(false);
        gwtFolder.getDocument().addDocumentListener(changeNotifier);
        gwtModule.getDocument().addDocumentListener(changeNotifier);
        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGWTFolder = new javax.swing.JLabel();
        gwtFolder = new javax.swing.JTextField();
        btnGWTBrowse = new javax.swing.JButton();
        lblGWTModule = new javax.swing.JLabel();
        gwtModule = new javax.swing.JTextField();
        upgradeProgressBar = new javax.swing.JProgressBar();
        upgradeLbl = new javax.swing.JLabel();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/netbeans/modules/gwt4nb/Bundle"); // NOI18N
        lblGWTFolder.setText(bundle.getString("GWTConfigPanelVisual.lblGWTFolder.text")); // NOI18N

        btnGWTBrowse.setText(bundle.getString("GWTConfigPanelVisual.btnGWTBrowse.text")); // NOI18N
        btnGWTBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGWTBrowsebrowse(evt);
            }
        });

        lblGWTModule.setText(bundle.getString("GWTConfigPanelVisual.lblGWTModule.text")); // NOI18N

        gwtModule.setText(org.openide.util.NbBundle.getMessage(GWTConfigPanelVisual.class, "GWTConfigPanelVisual.gwtModule.text")); // NOI18N

        upgradeProgressBar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        upgradeLbl.setFont(new java.awt.Font("Tahoma", 2, 10));
        upgradeLbl.setText(org.openide.util.NbBundle.getMessage(GWTConfigPanelVisual.class, "GWTConfigPanelVisual.upgradeLbl.text")); // NOI18N

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(lblGWTFolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .add(lblGWTModule))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(layout.createSequentialGroup()
                                .add(gwtFolder, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED))
                            .add(layout.createSequentialGroup()
                                .add(gwtModule)
                                .add(9, 9, 9)))
                        .add(btnGWTBrowse))
                    .add(upgradeLbl)
                    .add(upgradeProgressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(btnGWTBrowse)
                    .add(lblGWTFolder)
                    .add(gwtFolder, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblGWTModule)
                    .add(gwtModule, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(32, 32, 32)
                .add(upgradeLbl)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(upgradeProgressBar, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
        
    private void btnGWTBrowsebrowse(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGWTBrowsebrowse
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle(NbBundle.getMessage(GWTConfigPanelVisual.class,"LBL_SelectGWTLocation")); //NOI18N
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String path = gwtFolder.getText();
        if (path.length() > 0) {
            File f = new File(path);
            if (f.exists())
                chooser.setSelectedFile(f);
        }
        if (JFileChooser.APPROVE_OPTION == chooser.showOpenDialog(this)) {
            File projectDir = chooser.getSelectedFile();
            gwtFolder.setText(projectDir.getAbsolutePath());
        }
        //if gwt.properties exists(existing project), upgrade
        if (project != null && project.getProjectDirectory().getFileObject(GWTProjectInfo.PRJ_DIR).getFileObject("gwt", "properties")!=null) {
            // if current gwtFolder is different from the default gwtFolder and is a valid GWT installation root, enable upgrade
            String gwtLocation = GWTProjectInfo.readGWTProperty(project, "gwt.install.dir");
            File prevGwtFolder;
            if (gwtLocation != null && !gwtLocation.equals("")) {
                prevGwtFolder = new File(gwtLocation);
            } else {
                GWTSettings gwtSettings = GWTSettings.getDefault();
                prevGwtFolder = gwtSettings.getGWTLocation();
            }

            File gwtRoot = new File(gwtFolder.getText());
            assert gwtRoot.exists() && gwtRoot.isDirectory();
            File[] files = gwtRoot.listFiles();
            Pattern pattern = Pattern.compile(GWTFrameworkProvider.GWT_DEV, Pattern.CASE_INSENSITIVE);
            FileObject devjar = null;
            for (File file : files) {
                if (pattern.matcher(file.getName()).matches()) {
                    devjar = FileUtil.toFileObject(FileUtil.normalizeFile(file));
                }
            }
            if (!prevGwtFolder.getAbsolutePath().equals(gwtFolder.getText()) && devjar != null) {
                MyWorker myWorker = new MyWorker(this);
                myWorker.start();
            }
        }

}//GEN-LAST:event_btnGWTBrowsebrowse
    
    public void enableComponents(boolean enabled){
        lblGWTModule.setVisible(enabled);
        gwtModule.setVisible(enabled);
    }
    
    public void setGWTFolder(File folder){
        gwtFolder.setText(String.valueOf(folder));
        
    }
    
    public File getGWTFolder(){
        return new File(gwtFolder.getText());
    }
    
    public void setProject(Project p){
        project = p;
        
    }
    
    public Project getProject(){
        return project;
    }
   
    
    public void setGWTModule(String path){
        gwtModule.setText(path);
    }
    
    public String getGWTModule(){
        return gwtModule.getText();
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGWTBrowse;
    private javax.swing.JTextField gwtFolder;
    private javax.swing.JTextField gwtModule;
    private javax.swing.JLabel lblGWTFolder;
    private javax.swing.JLabel lblGWTModule;
    private javax.swing.JLabel upgradeLbl;
    private javax.swing.JProgressBar upgradeProgressBar;
    // End of variables declaration//GEN-END:variables
    
    private class ChangeNotifier implements DocumentListener{
        public void insertUpdate(DocumentEvent arg0) {
            controller.fireChangeEvent();
        }
        
        public void removeUpdate(DocumentEvent arg0) {
            controller.fireChangeEvent();
        }
        
        public void changedUpdate(DocumentEvent arg0) {
            controller.fireChangeEvent();
        }
    }
    
    private class MyWorker extends SwingWorker {

        JPanel jpanel;

        MyWorker(JPanel panel) {
            jpanel = panel;
        }

        public Object construct() {
            upgradeProgressBar.setVisible(true);
            upgradeLbl.setVisible(true);
            upgradeProgressBar.setValue(5);
            Lookup lkp = Utilities.actionsGlobalContext();
            Project p = lkp.lookup(Project.class);
            WebModule webModule = WebModule.getWebModule(p.getProjectDirectory());
            GWTFrameworkProvider.upgradeGWTVersion(webModule, getGWTFolder(), upgradeProgressBar);
            upgradeProgressBar.setValue(100);
            upgradeLbl.setVisible(false);
            JOptionPane.showMessageDialog(jpanel,"Please select the required libraries through the library manager panel" , "GWT Upgrade Successful", JOptionPane.INFORMATION_MESSAGE);
            upgradeProgressBar.setVisible(false);
            upgradeLbl.setVisible(false);
            return null;
        }

        public void start() {
            super.start();
        }

        public void finished() {
        }
    }
}

abstract class SwingWorker {
   private Object value;  // see getValue(), setValue()
   private Thread thread;

   /**
    * Class to maintain reference to current worker thread
    * under separate synchronization control.
    */
   private static class ThreadVar {
       private Thread thread;
       ThreadVar(Thread t) { thread = t; }
       synchronized Thread get() { return thread; }
       synchronized void clear() { thread = null; }
   }

   private ThreadVar threadVar;

   /**
    * Get the value produced by the worker thread, or null if it
    * hasn't been constructed yet.
    */
   protected synchronized Object getValue() {
       return value;
   }

   /**
    * Set the value produced by worker thread
    */
   private synchronized void setValue(Object x) {
       value = x;
   }

   /**
    * Compute the value to be returned by the <code>get</code> method.
    */
   public abstract Object construct();

   /**
    * Called on the event dispatching thread (not on the worker thread)
    * after the <code>construct</code> method has returned.
    */
   public void finished() {
   }

   /**
    * A new method that interrupts the worker thread.  Call this method
    * to force the worker to stop what it's doing.
    */
   public void interrupt() {
       Thread t = threadVar.get();
       if (t != null) {
           t.interrupt();
       }
       threadVar.clear();
   }

   /**
    * Return the value created by the <code>construct</code> method.      
    * Returns null if either the constructing thread or the current
    * thread was interrupted before a value was produced.
    *
    * @return the value created by the <code>construct</code> method
    */
   public Object get() {
       while (true) {             Thread t = threadVar.get();
           if (t == null) {
               return getValue();
           }
           try {
               t.join();
           }
           catch (InterruptedException e) {
               Thread.currentThread().interrupt(); // propagate
               return null;
           }
       }
   }


   /**
    * Start a thread that will call the <code>construct</code> method
    * and then exit.
    */
   public SwingWorker() {
       final Runnable doFinished = new Runnable() {
          public void run() { finished(); }
       };

       Runnable doConstruct = new Runnable() {
           public void run() {
               try {
                   setValue(construct());
               }
               finally {
                   threadVar.clear();
               }

               SwingUtilities.invokeLater(doFinished);
           }
       };

       Thread t = new Thread(doConstruct);
       threadVar = new ThreadVar(t);
   }

   /**
    * Start the worker thread.
    */
   public void start() {
       Thread t = threadVar.get();
       if (t != null) {
           t.start();
       }
   }
}
package pkg1;

/**
 *
 * @author sagiz
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class Main extends javax.swing.JFrame {

    private final ArrayList<ProductBoundary> products = new ArrayList<>(10);
    private final Gson gson = new Gson();
    private ProductBoundary currentProduct;
    private Process rsocketProcess;

    public Main() {
        initComponents();
        ((DefaultListModel) productsListBox.getModel()).addElement("New");
        productsListBox.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        transmitionComboBox = new javax.swing.JComboBox<>();
        sendButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jarPathTextField = new javax.swing.JTextField();
        routeTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        killButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orderIdTextField = new javax.swing.JTextField();
        userEmailTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productsListBox = new javax.swing.JList<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        productIdTextField = new javax.swing.JTextField();
        productQuantitySpinner = new javax.swing.JSpinner();
        saveProductButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        userBoundaryEmailTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        rawJsonTextArea = new javax.swing.JTextArea();
        debugCheckbox = new javax.swing.JCheckBox();
        selectFileButton = new javax.swing.JButton();
        sendDataCheckbox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RSocket Communicator");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 25)); // NOI18N
        jLabel1.setText("Enter order's details here:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel3.setText("Select transmission type:");

        transmitionComboBox.setBackground(new java.awt.Color(204, 204, 204));
        transmitionComboBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        transmitionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "request-response", "fire-and-forget", "stream", "channel" }));
        transmitionComboBox.setName("transmisionType"); // NOI18N

        sendButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        sendButton.setText("Send");
        sendButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendButton.setName("sendButton"); // NOI18N
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(204, 204, 204));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTextArea2.setRows(5);
        jTextArea2.setTabSize(4);
        jTextArea2.setName("dataTextArea"); // NOI18N
        jScrollPane2.setViewportView(jTextArea2);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel5.setText("Path to RSocket JAR");

        jarPathTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jarPathTextField.setText("rsc-0.9.1.jar");

        routeTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        routeTextField.setText("something");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("Route:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("URL:");

        urlTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        urlTextField.setText("tcp://localhost:7000");

        killButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        killButton.setText("Kill");
        killButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        killButton.setEnabled(false);
        killButton.setName("sendButton"); // NOI18N
        killButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                killButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 23)); // NOI18N
        jTabbedPane1.setInheritsPopupMenu(true);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel2.setText("Order ID:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel4.setText("User email:");

        orderIdTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        orderIdTextField.setText("secret id");

        userEmailTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        userEmailTextField.setText("realemail@example.org");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel8.setText("Products:");

        productsListBox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        productsListBox.setModel(new DefaultListModel());
        productsListBox.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        productsListBox.setToolTipText("");
        productsListBox.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productsListBoxValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(productsListBox);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel9.setText("Product ID:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel10.setText("Quantity:");

        productIdTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        productIdTextField.setText("secret id");

        productQuantitySpinner.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        productQuantitySpinner.setModel(new javax.swing.SpinnerNumberModel(1, null, null, 1));

        saveProductButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        saveProductButton.setText("Save");
        saveProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveProductButton.setName("sendButton"); // NOI18N
        saveProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProductButtonActionPerformed(evt);
            }
        });

        deleteProductButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        deleteProductButton.setText("Delete");
        deleteProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProductButton.setName("sendButton"); // NOI18N
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(productIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deleteProductButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(saveProductButton)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productQuantitySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveProductButton)
                    .addComponent(deleteProductButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(orderIdTextField)
                                    .addComponent(userEmailTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))))
                        .addGap(239, 239, 239))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(orderIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(userEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Order", jPanel2);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel11.setText("User email:");

        userBoundaryEmailTextField.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        userBoundaryEmailTextField.setText("realemail@example.org");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(userBoundaryEmailTextField)
                .addGap(239, 239, 239))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(userBoundaryEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("User", jPanel4);

        rawJsonTextArea.setColumns(20);
        rawJsonTextArea.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rawJsonTextArea.setRows(5);
        jScrollPane3.setViewportView(rawJsonTextArea);

        jTabbedPane1.addTab("Raw JSON", jScrollPane3);

        debugCheckbox.setBackground(new java.awt.Color(153, 153, 153));
        debugCheckbox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        debugCheckbox.setSelected(true);
        debugCheckbox.setText("Debug");

        selectFileButton.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        selectFileButton.setText("...");
        selectFileButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        selectFileButton.setName("sendButton"); // NOI18N
        selectFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectFileButtonActionPerformed(evt);
            }
        });

        sendDataCheckbox.setBackground(new java.awt.Color(153, 153, 153));
        sendDataCheckbox.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        sendDataCheckbox.setSelected(true);
        sendDataCheckbox.setText("Send data");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sendDataCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(selectFileButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(killButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(transmitionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(debugCheckbox)
                                .addGap(241, 241, 241))
                            .addComponent(routeTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jarPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addComponent(urlTextField))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sendDataCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(transmitionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(debugCheckbox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(routeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jarPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectFileButton))
                        .addGap(42, 42, 42)
                        .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton)
                    .addComponent(killButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String getData() {
        String data;
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0:
                data = gson.toJson(new OrderBoundary(orderIdTextField.getText(),
                        userEmailTextField.getText(), products.toArray(new ProductBoundary[0])));
                break;
            case 1:
                data = gson.toJson(new UserBoundary(userBoundaryEmailTextField.getText()));
                break;
            case 2:
                Object temp;
                try {
                    temp = gson.fromJson(rawJsonTextArea.getText(), Object.class);
                } catch (JsonSyntaxException e) {
                    temp = null;
                }
                // If the object is null or a non-object, it means the deserialization wasn't successful.
                if (temp == null || temp instanceof String
                        || temp instanceof List) {
                    throw new RuntimeException("Invalid JSON string!");
                }
                // Reserialize the object to JSON to get a shrinked version of it.
                data = gson.toJson(temp);
                break;
            default:
                throw new RuntimeException("Unknow tab was selected!");
        }
        return data;
    }

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
//        String jarPath = "D:\\Desktop\\Studies\\Cloud computing\\rsc-0.9.1.jar";

        if (rsocketProcess != null && rsocketProcess.isAlive()) {
            String data = getData();

            try {
                rsocketProcess.getOutputStream().write(data.getBytes());
                rsocketProcess.getOutputStream().write("\n".getBytes());
                rsocketProcess.getOutputStream().flush();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            return;
        }

        String transmision = getTransmisionType();
        final String data;
        final boolean sendData;
        if (transmision.equalsIgnoreCase("channel")) {
            data = "-";
            sendButton.setText("Send to channel");
            sendDataCheckbox.setEnabled(false);
            sendData = true;
        } else {
            data = getData().replace("\"", "\\\"");
            sendButton.setEnabled(false);
            sendData = sendDataCheckbox.isSelected();
        }
        jTextArea2.setText("");
        new Thread(() -> {
            try {
                List<String> commands = new ArrayList<>();
                commands.add("java");
                commands.add("-jar");
                commands.add(jarPathTextField.getText());
                if (debugCheckbox.isSelected()) {
                    commands.add("--debug");
                }
                commands.add("--" + transmision);
                if (sendData) {
                    commands.add("--data");
                    commands.add(data);
                    jTextArea2.setText("Sending data: " + data);
                    jTextArea2.append("\n\n");
                }
                commands.add("--route");
                commands.add(routeTextField.getText());
                commands.add(urlTextField.getText());
                rsocketProcess = Runtime.getRuntime().exec(commands.toArray(new String[0]));
                killButton.setEnabled(true);
                try (BufferedReader input = new BufferedReader(new InputStreamReader(rsocketProcess.getInputStream()))) {
                    String line;
                    while (rsocketProcess.isAlive()) {
                        if ((line = input.readLine()) != null) {
                            jTextArea2.append(line + "\n");
                        }
                    }
                }
                jTextArea2.append("-----------------------------\n");
                jTextArea2.append("ERRORS\n");
                jTextArea2.append("-----------------------------\n");
                try (BufferedReader input = new BufferedReader(new InputStreamReader(rsocketProcess.getErrorStream()))) {
                    String line;
                    while ((line = input.readLine()) != null) {
                        jTextArea2.append(line + "\n");
                    }
                }
                rsocketProcess.waitFor();
                jTextArea2.append("\nConnection closed successfully :-)");
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                sendButton.setEnabled(true);
                killButton.setEnabled(false);
                sendDataCheckbox.setEnabled(true);
                sendButton.setText("Send");
            }
        }).start();
    }//GEN-LAST:event_sendButtonActionPerformed

    private String getTransmisionType() throws RuntimeException {
        /*
        0. request-response
        1. fire-and-forget
        2. stream
        3. channel
         */
        String transmision;
        switch (transmitionComboBox.getSelectedIndex()) {
            case 0:
                transmision = "route";
                break;
            case 1:
                transmision = "fnf";
                break;
            case 2:
                transmision = "stream";
                break;
            case 3:
                transmision = "channel";
                break;
            default:
                throw new RuntimeException("Unknown transmision type: " + transmitionComboBox.getSelectedItem());
        }
        return transmision;
    }

    private void saveProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProductButtonActionPerformed
        currentProduct.setProductId(productIdTextField.getText());
        currentProduct.setQuantity((int) productQuantitySpinner.getValue());
        if (productsListBox.getSelectedIndex() == 0) {
            for (ProductBoundary product : products) {
                if (product.getProductId().equals(currentProduct.getProductId())) {
                    JOptionPane.showMessageDialog(this, "Product with id "
                            + currentProduct.getProductId() + " already exists!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
            products.add(currentProduct);
            ((DefaultListModel) productsListBox.getModel()).addElement(currentProduct.getProductId());
            productsListBox.setSelectedIndex(products.size());
        } else {
            ((DefaultListModel) productsListBox.getModel()).set(productsListBox.getSelectedIndex(), currentProduct.getProductId());
        }
    }//GEN-LAST:event_saveProductButtonActionPerformed

    private void deleteProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductButtonActionPerformed
        products.remove(productsListBox.getSelectedIndex() - 1);
        ((DefaultListModel) productsListBox.getModel()).removeElementAt(productsListBox.getSelectedIndex());
        productsListBox.setSelectedIndex(0);
    }//GEN-LAST:event_deleteProductButtonActionPerformed

    private void productsListBoxValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productsListBoxValueChanged
        if (productsListBox.getSelectedIndex() <= 0) {
            currentProduct = new ProductBoundary();
            deleteProductButton.setEnabled(false);
        } else {
            currentProduct = this.products.get(productsListBox.getSelectedIndex() - 1);
            deleteProductButton.setEnabled(true);
        }
        productIdTextField.setText(currentProduct.getProductId());
        productQuantitySpinner.setValue(currentProduct.getQuantity());
    }//GEN-LAST:event_productsListBoxValueChanged

    private void killButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_killButtonActionPerformed
        if (rsocketProcess != null && rsocketProcess.isAlive()) {
            rsocketProcess.destroy();
        }
    }//GEN-LAST:event_killButtonActionPerformed

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        switch (jTabbedPane1.getSelectedIndex()) {
            case 0:
                jLabel1.setText("Enter order's details here:");
                break;
            case 1:
                jLabel1.setText("Enter user's details here:");
                break;
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void selectFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectFileButtonActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().toLowerCase().endsWith(".jar") || f.isDirectory();
            }

            //Set description for the type of file that should be display
            @Override
            public String getDescription() {
                return "*.jar files";
            }
        });
        int exitStatus = chooser.showOpenDialog(this);
        if (exitStatus == JFileChooser.APPROVE_OPTION) {
            jarPathTextField.setText(chooser.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_selectFileButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox debugCheckbox;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jarPathTextField;
    private javax.swing.JButton killButton;
    private javax.swing.JTextField orderIdTextField;
    private javax.swing.JTextField productIdTextField;
    private javax.swing.JSpinner productQuantitySpinner;
    private javax.swing.JList<String> productsListBox;
    private javax.swing.JTextArea rawJsonTextArea;
    private javax.swing.JTextField routeTextField;
    private javax.swing.JButton saveProductButton;
    private javax.swing.JButton selectFileButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JCheckBox sendDataCheckbox;
    private javax.swing.JComboBox<String> transmitionComboBox;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JTextField userBoundaryEmailTextField;
    private javax.swing.JTextField userEmailTextField;
    // End of variables declaration//GEN-END:variables
}

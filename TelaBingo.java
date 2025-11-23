import java.awt.*;

public class TelaBingo extends javax.swing.JFrame {
    
    private Cartela cartela;
    /**
     * Creates new form NewJFrame
     */
    public TelaBingo(Bingo logicaBingo) {
        
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        inicializarCartela();
        
        addWindowListener(new java.awt.event.WindowAdapter() {

        public void windowClosing(java.awt.event.WindowEvent windowEvent) {

        logicaBingo.finalizar();

        }});
    }
    
    private void inicializarCartela() {
        cartela = new Cartela();
        int[][] numeros = cartela.getNumeros();
        
        // Colunas: B=0, I=1, N=2, G=3, O=4
        // Linhas: 1-5 (índices 0-4)
        
        // Coluna B (índice 0)
        B1.setText(String.valueOf(numeros[0][0]));
        B2.setText(String.valueOf(numeros[1][0]));
        B3.setText(String.valueOf(numeros[2][0]));
        B4.setText(String.valueOf(numeros[3][0]));
        B5.setText(String.valueOf(numeros[4][0]));
        
        // Coluna I (índice 1)
        I1.setText(String.valueOf(numeros[0][1]));
        I2.setText(String.valueOf(numeros[1][1]));
        I3.setText(String.valueOf(numeros[2][1]));
        I4.setText(String.valueOf(numeros[3][1]));
        I5.setText(String.valueOf(numeros[4][1]));
        
        // Coluna N (índice 2)
        N1.setText(String.valueOf(numeros[0][2]));
        N2.setText(String.valueOf(numeros[1][2]));
        // N3 é o espaço livre (PAPACAPIM)
        N4.setText(String.valueOf(numeros[3][2]));
        N5.setText(String.valueOf(numeros[4][2]));
        
        // Coluna G (índice 3)
        G1.setText(String.valueOf(numeros[0][3]));
        G2.setText(String.valueOf(numeros[1][3]));
        G3.setText(String.valueOf(numeros[2][3]));
        G4.setText(String.valueOf(numeros[3][3]));
        G5.setText(String.valueOf(numeros[4][3]));
        
        // Coluna O (índice 4)
        O1.setText(String.valueOf(numeros[0][4]));
        O2.setText(String.valueOf(numeros[1][4]));
        O3.setText(String.valueOf(numeros[2][4]));
        O4.setText(String.valueOf(numeros[3][4]));
        O5.setText(String.valueOf(numeros[4][4]));
    }
    
    private void initComponents() {

        I1 = new javax.swing.JButton();
        N1 = new javax.swing.JButton();
        G1 = new javax.swing.JButton();
        B1 = new javax.swing.JButton();
        I2 = new javax.swing.JButton();
        N2 = new javax.swing.JButton();
        G2 = new javax.swing.JButton();
        B2 = new javax.swing.JButton();
        I3 = new javax.swing.JButton();
        papacapim = new javax.swing.JButton();
        G3 = new javax.swing.JButton();
        B3 = new javax.swing.JButton();
        I4 = new javax.swing.JButton();
        N4 = new javax.swing.JButton();
        G4 = new javax.swing.JButton();
        B4 = new javax.swing.JButton();
        I5 = new javax.swing.JButton();
        N5 = new javax.swing.JButton();
        G5 = new javax.swing.JButton();
        B5 = new javax.swing.JButton();
        O3 = new javax.swing.JButton();
        O4 = new javax.swing.JButton();
        O1 = new javax.swing.JButton();
        O2 = new javax.swing.JButton();
        O5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        I1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        I1.setText("I1");
        I1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1ActionPerformed(evt);
            }
        });

        N1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        N1.setText("N1");
        N1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N1ActionPerformed(evt);
            }
        });

        G1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        G1.setText("G1");
        G1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G1ActionPerformed(evt);
            }
        });

        B1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        B1.setText("B1");
        B1.setOpaque(true);
        B1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B1ActionPerformed(evt);
            }
        });

        I2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        I2.setText("I2");
        I2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I2ActionPerformed(evt);
            }
        });

        N2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        N2.setText("N2");
        N2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N2ActionPerformed(evt);
            }
        });

        G2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        G2.setText("G2");
        G2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G2ActionPerformed(evt);
            }
        });

        B2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        B2.setText("B2");
        B2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B2ActionPerformed(evt);
            }
        });

        I3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        I3.setText("I3");
        I3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I3ActionPerformed(evt);
            }
        });

        papacapim.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        papacapim.setText("FREE");
        papacapim.setEnabled(false);

        G3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        G3.setText("G3");
        G3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G3ActionPerformed(evt);
            }
        });

        B3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        B3.setText("B3");
        B3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B3ActionPerformed(evt);
            }
        });

        I4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        I4.setText("I4");
        I4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I4ActionPerformed(evt);
            }
        });

        N4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        N4.setText("N4");
        N4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N4ActionPerformed(evt);
            }
        });

        G4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        G4.setText("G4");
        G4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G4ActionPerformed(evt);
            }
        });

        B4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        B4.setText("B4");
        B4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B4ActionPerformed(evt);
            }
        });

        I5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        I5.setText("I5");
        I5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I5ActionPerformed(evt);
            }
        });

        N5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        N5.setText("N5");
        N5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N5ActionPerformed(evt);
            }
        });

        G5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        G5.setText("G5");
        G5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                G5ActionPerformed(evt);
            }
        });

        B5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        B5.setText("B5");
        B5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B5ActionPerformed(evt);
            }
        });

        O3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        O3.setText("O3");
        O3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O3ActionPerformed(evt);
            }
        });

        O4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        O4.setText("O4");
        O4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O4ActionPerformed(evt);
            }
        });

        O1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        O1.setText("O1");
        O1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O1ActionPerformed(evt);
            }
        });

        O2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        O2.setText("O2");
        O2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O2ActionPerformed(evt);
            }
        });

        O5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        O5.setText("O5");
        O5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("B");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("I");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("N");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("G");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("O");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(N5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(N4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(papacapim, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(O5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(O4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(O3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(138, 138, 138))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {B1, B2, B3, B4, B5, G1, G2, G3, G4, G5, I1, I2, I3, I4, I5, N1, N2, N4, N5, O1, O2, O3, O4, O5, papacapim});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(O1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(O2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(O3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(O4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(O5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(I3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(G3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(B3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(papacapim, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(I5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(N5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(G5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {B1, B2, B3, B4, B5, G1, G2, G3, G4, G5, I1, I2, I3, I4, I5, N1, N2, N4, N5, O1, O2, O3, O4, O5, papacapim});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B1ActionPerformed
        if (B1.getBackground().equals(Color.BLUE)) {
            B1.setBackground(null);
        } else {
            B1.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_B1ActionPerformed

    private void B2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B2ActionPerformed
        if (B2.getBackground().equals(Color.BLUE)) {
            B2.setBackground(null);
        } else {
            B2.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_B2ActionPerformed

    private void B3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B3ActionPerformed
        if (B3.getBackground().equals(Color.BLUE)) {
            B3.setBackground(null);
        } else {
            B3.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_B3ActionPerformed

    private void B4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B4ActionPerformed
        if (B4.getBackground().equals(Color.BLUE)) {
            B4.setBackground(null);
        } else {
            B4.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_B4ActionPerformed

    private void B5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B5ActionPerformed
        if (B5.getBackground().equals(Color.BLUE)) {
            B5.setBackground(null);
        } else {
            B5.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_B5ActionPerformed

    private void I1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I1ActionPerformed
        if (I1.getBackground().equals(Color.BLUE)) {
            I1.setBackground(null);
        } else {
            I1.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_I1ActionPerformed

    private void I2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I2ActionPerformed
        if (I2.getBackground().equals(Color.BLUE)) {
            I2.setBackground(null);
        } else {
            I2.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_I2ActionPerformed

    private void I3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I3ActionPerformed
        if (I3.getBackground().equals(Color.BLUE)) {
            I3.setBackground(null);
        } else {
            I3.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_I3ActionPerformed

    private void I4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I4ActionPerformed
        if (I4.getBackground().equals(Color.BLUE)) {
            I4.setBackground(null);
        } else {
            I4.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_I4ActionPerformed

    private void I5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I5ActionPerformed
        if (I5.getBackground().equals(Color.BLUE)) {
            I5.setBackground(null);
        } else {
            I5.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_I5ActionPerformed

    private void N1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N1ActionPerformed
        if (N1.getBackground().equals(Color.BLUE)) {
            N1.setBackground(null);
        } else {
            N1.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_N1ActionPerformed

    private void N2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N2ActionPerformed
        if (N2.getBackground().equals(Color.BLUE)) {
            N2.setBackground(null);
        } else {
            N2.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_N2ActionPerformed

    private void N4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N4ActionPerformed
        if (N4.getBackground().equals(Color.BLUE)) {
            N4.setBackground(null);
        } else {
            N4.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_N4ActionPerformed

    private void N5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N5ActionPerformed
        if (N5.getBackground().equals(Color.BLUE)) {
            N5.setBackground(null);
        } else {
            N5.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_N5ActionPerformed

    private void G1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G1ActionPerformed
        if (G1.getBackground().equals(Color.BLUE)) {
            G1.setBackground(null);
        } else {
            G1.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_G1ActionPerformed

    private void G2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G2ActionPerformed
        if (G2.getBackground().equals(Color.BLUE)) {
            G2.setBackground(null);
        } else {
            G2.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_G2ActionPerformed

    private void G3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G3ActionPerformed
        if (G3.getBackground().equals(Color.BLUE)) {
            G3.setBackground(null);
        } else {
            G3.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_G3ActionPerformed

    private void G4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G4ActionPerformed
        if (G4.getBackground().equals(Color.BLUE)) {
            G4.setBackground(null);
        } else {
            G4.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_G4ActionPerformed

    private void G5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_G5ActionPerformed
        if (G5.getBackground().equals(Color.BLUE)) {
            G5.setBackground(null);
        } else {
            G5.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_G5ActionPerformed

    private void O1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O1ActionPerformed
        if (O1.getBackground().equals(Color.BLUE)) {
            O1.setBackground(null);
        } else {
            O1.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_O1ActionPerformed

    private void O2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O2ActionPerformed
        if (O2.getBackground().equals(Color.BLUE)) {
            O2.setBackground(null);
        } else {
            O2.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_O2ActionPerformed

    private void O3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O3ActionPerformed
        if (O3.getBackground().equals(Color.BLUE)) {
            O3.setBackground(null);
        } else {
            O3.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_O3ActionPerformed

    private void O4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O4ActionPerformed
        if (O4.getBackground().equals(Color.BLUE)) {
            O4.setBackground(null);
        } else {
            O4.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_O4ActionPerformed

    private void O5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O5ActionPerformed
        if (O5.getBackground().equals(Color.BLUE)) {
            O5.setBackground(null);
        } else {
            O5.setBackground(Color.BLUE);
        }
    }//GEN-LAST:event_O5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B1;
    private javax.swing.JButton B2;
    private javax.swing.JButton B3;
    private javax.swing.JButton B4;
    private javax.swing.JButton B5;
    private javax.swing.JButton G1;
    private javax.swing.JButton G2;
    private javax.swing.JButton G3;
    private javax.swing.JButton G4;
    private javax.swing.JButton G5;
    private javax.swing.JButton I1;
    private javax.swing.JButton I2;
    private javax.swing.JButton I3;
    private javax.swing.JButton I4;
    private javax.swing.JButton I5;
    private javax.swing.JButton N1;
    private javax.swing.JButton N2;
    private javax.swing.JButton N4;
    private javax.swing.JButton N5;
    private javax.swing.JButton O1;
    private javax.swing.JButton O2;
    private javax.swing.JButton O3;
    private javax.swing.JButton O4;
    private javax.swing.JButton O5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton papacapim;
    // End of variables declaration//GEN-END:variables
}
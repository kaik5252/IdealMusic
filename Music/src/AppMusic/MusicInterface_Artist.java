package AppMusic;

import Control.Config;
import Control.ConfigMusic;
import Control.PopUp;
import Model.Album;
import Model.Music;
import Model.Users;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public final class MusicInterface_Artist extends JFrame {
    
    private Users users = new Users("users");
    private Album albums = new Album("album");
    private Music music = new Music("music");
    private int[] musicPlays;
    private int uid;
    private ConfigMusic cm;
    boolean muted = false;
    int som = 0;
    boolean play = false;
    
    public MusicInterface_Artist(int uid) {
        initComponents();
        setIconImage(java.awt.Toolkit.getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));
        
        tableMusic.getTableHeader().setPreferredSize(new Dimension(100, 26));
        DefaultTableCellRenderer tableHeader = (DefaultTableCellRenderer) tableMusic.getTableHeader().getDefaultRenderer();
        tableHeader.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        for (int colInit = 0; colInit < tableMusic.getColumnModel().getColumnCount(); colInit++) {
            tableMusic.getColumnModel().getColumn(colInit).setCellRenderer(tableCell);
        }
        
        tableAlbum.getTableHeader().setPreferredSize(new Dimension(100, 26));
        tableHeader = (DefaultTableCellRenderer) tableAlbum.getTableHeader().getDefaultRenderer();
        tableHeader.setHorizontalAlignment(SwingConstants.CENTER);
        tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        for (int colInit = 0; colInit < tableAlbum.getColumnModel().getColumnCount(); colInit++) {
            tableAlbum.getColumnModel().getColumn(colInit).setCellRenderer(tableCell);
        }
        
        tableMusicAlbum.getTableHeader().setPreferredSize(new Dimension(100, 26));
        tableHeader = (DefaultTableCellRenderer) tableMusicAlbum.getTableHeader().getDefaultRenderer();
        tableHeader.setHorizontalAlignment(SwingConstants.CENTER);
        tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        for (int colInit = 0; colInit < tableMusicAlbum.getColumnModel().getColumnCount(); colInit++) {
            tableMusicAlbum.getColumnModel().getColumn(colInit).setCellRenderer(tableCell);
        }
        
        this.uid = uid;
        labelMenuArtist.setText(String.valueOf(users.readUser(uid, new String[]{"ulogin"}).get(0)[0]));
        tableAlbum();
        tableMusic();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        panelAlbum = new javax.swing.JPanel();
        scrollAlbum = new javax.swing.JScrollPane();
        tableAlbum = new javax.swing.JTable();
        panelMusic = new javax.swing.JPanel();
        scrollMusic = new javax.swing.JScrollPane();
        tableMusic = new javax.swing.JTable();
        panelMusicAlbum = new javax.swing.JPanel();
        scrollMusicAlbum = new javax.swing.JScrollPane();
        tableMusicAlbum = new javax.swing.JTable();
        panelPlayer = new javax.swing.JPanel();
        labelPlayerMusic = new javax.swing.JLabel();
        panelPlayerController = new javax.swing.JPanel();
        labelPlayerTime = new javax.swing.JLabel();
        sliderPlayerMusic = new javax.swing.JSlider();
        btnPlayerVolume = new javax.swing.JButton();
        btnPlayerControl = new javax.swing.JButton();
        btnPlayerBack = new javax.swing.JButton();
        btnPlayerNext = new javax.swing.JButton();
        panelPlayerVolume = new javax.swing.JPanel();
        sliderPlayerVolume = new javax.swing.JSlider();
        txtPlayerMusicId = new javax.swing.JTextField();
        panelMenu = new javax.swing.JPanel();
        labelMenuArtist = new javax.swing.JLabel();
        btnMenuAlbum = new javax.swing.JButton();
        btnMenuMusic = new javax.swing.JButton();
        panelMenuLogo = new javax.swing.JPanel();
        labelMenuLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ideal Music");
        setMinimumSize(new java.awt.Dimension(1280, 640));
        setName("frame"); // NOI18N

        panelMain.setLayout(new java.awt.CardLayout());

        panelAlbum.setBackground(new java.awt.Color(173, 216, 230));
        panelAlbum.setAlignmentY(0.0F);
        panelAlbum.setMinimumSize(new java.awt.Dimension(980, 489));

        tableAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tableAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Nome Albúm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableAlbum.setAlignmentX(0.0F);
        tableAlbum.setAlignmentY(0.0F);
        tableAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableAlbum.setRowHeight(24);
        tableAlbum.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableAlbum.getTableHeader().setResizingAllowed(false);
        tableAlbum.getTableHeader().setReorderingAllowed(false);
        tableAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableAlbumMouseClicked(evt);
            }
        });
        scrollAlbum.setViewportView(tableAlbum);
        if (tableAlbum.getColumnModel().getColumnCount() > 0) {
            tableAlbum.getColumnModel().getColumn(0).setMinWidth(0);
            tableAlbum.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableAlbum.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout panelAlbumLayout = new javax.swing.GroupLayout(panelAlbum);
        panelAlbum.setLayout(panelAlbumLayout);
        panelAlbumLayout.setHorizontalGroup(
            panelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAlbumLayout.setVerticalGroup(
            panelAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelAlbum, "panelAlbum");

        panelMusic.setBackground(new java.awt.Color(173, 216, 230));
        panelMusic.setAlignmentY(0.0F);
        panelMusic.setMinimumSize(new java.awt.Dimension(980, 489));
        panelMusic.setPreferredSize(new java.awt.Dimension(980, 489));

        tableMusic.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tableMusic.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Name Música"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMusic.setAlignmentX(0.0F);
        tableMusic.setAlignmentY(0.0F);
        tableMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableMusic.setRowHeight(24);
        tableMusic.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableMusic.getTableHeader().setResizingAllowed(false);
        tableMusic.getTableHeader().setReorderingAllowed(false);
        tableMusic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMusicMouseClicked(evt);
            }
        });
        scrollMusic.setViewportView(tableMusic);
        if (tableMusic.getColumnModel().getColumnCount() > 0) {
            tableMusic.getColumnModel().getColumn(0).setMinWidth(0);
            tableMusic.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableMusic.getColumnModel().getColumn(0).setMaxWidth(0);
            tableMusic.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout panelMusicLayout = new javax.swing.GroupLayout(panelMusic);
        panelMusic.setLayout(panelMusicLayout);
        panelMusicLayout.setHorizontalGroup(
            panelMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMusicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMusicLayout.setVerticalGroup(
            panelMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMusicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelMusic, "panelMusic");

        panelMusicAlbum.setBackground(new java.awt.Color(173, 216, 230));
        panelMusicAlbum.setAlignmentY(0.0F);
        panelMusicAlbum.setMinimumSize(new java.awt.Dimension(980, 489));

        tableMusicAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tableMusicAlbum.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Músicas do Albúm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableMusicAlbum.setAlignmentX(0.0F);
        tableMusicAlbum.setAlignmentY(0.0F);
        tableMusicAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableMusicAlbum.setRowHeight(24);
        tableMusicAlbum.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMusicAlbum.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableMusicAlbum.getTableHeader().setResizingAllowed(false);
        tableMusicAlbum.getTableHeader().setReorderingAllowed(false);
        tableMusicAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMusicAlbumMouseClicked(evt);
            }
        });
        scrollMusicAlbum.setViewportView(tableMusicAlbum);
        if (tableMusicAlbum.getColumnModel().getColumnCount() > 0) {
            tableMusicAlbum.getColumnModel().getColumn(0).setMinWidth(0);
            tableMusicAlbum.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableMusicAlbum.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout panelMusicAlbumLayout = new javax.swing.GroupLayout(panelMusicAlbum);
        panelMusicAlbum.setLayout(panelMusicAlbumLayout);
        panelMusicAlbumLayout.setHorizontalGroup(
            panelMusicAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMusicAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMusicAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 1002, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelMusicAlbumLayout.setVerticalGroup(
            panelMusicAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMusicAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollMusicAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(panelMusicAlbum, "panelMusicAlbum");

        panelPlayer.setBackground(new java.awt.Color(179, 7, 83));
        panelPlayer.setMaximumSize(new java.awt.Dimension(32767, 250));
        panelPlayer.setMinimumSize(new java.awt.Dimension(900, 150));
        panelPlayer.setPreferredSize(new java.awt.Dimension(991, 150));

        labelPlayerMusic.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelPlayerMusic.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayerMusic.setText("Nome da música");

        panelPlayerController.setBackground(new java.awt.Color(179, 7, 83));

        labelPlayerTime.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelPlayerTime.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayerTime.setText("00:00");

        sliderPlayerMusic.setBackground(new java.awt.Color(179, 7, 83));
        sliderPlayerMusic.setForeground(new java.awt.Color(255, 255, 255));
        sliderPlayerMusic.setValue(0);
        sliderPlayerMusic.setAlignmentX(0.0F);
        sliderPlayerMusic.setAlignmentY(0.0F);
        sliderPlayerMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderPlayerMusic.setFocusable(false);
        sliderPlayerMusic.setMaximumSize(new java.awt.Dimension(32767, 18));
        sliderPlayerMusic.setMinimumSize(new java.awt.Dimension(400, 18));
        sliderPlayerMusic.setPreferredSize(new java.awt.Dimension(400, 18));

        btnPlayerVolume.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/som.png"))); // NOI18N
        btnPlayerVolume.setAlignmentY(0.0F);
        btnPlayerVolume.setBorder(null);
        btnPlayerVolume.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerVolume.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPlayerVolume.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerVolumeActionPerformed(evt);
            }
        });

        btnPlayerControl.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/play.png"))); // NOI18N
        btnPlayerControl.setAlignmentY(0.0F);
        btnPlayerControl.setBorder(null);
        btnPlayerControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerControl.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPlayerControl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayerControlActionPerformed(evt);
            }
        });

        btnPlayerBack.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/back.png"))); // NOI18N
        btnPlayerBack.setAlignmentY(0.0F);
        btnPlayerBack.setBorder(null);
        btnPlayerBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerBack.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnPlayerNext.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/next.png"))); // NOI18N
        btnPlayerNext.setAlignmentY(0.0F);
        btnPlayerNext.setBorder(null);
        btnPlayerNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerNext.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout panelPlayerControllerLayout = new javax.swing.GroupLayout(panelPlayerController);
        panelPlayerController.setLayout(panelPlayerControllerLayout);
        panelPlayerControllerLayout.setHorizontalGroup(
            panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                        .addComponent(labelPlayerTime)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderPlayerMusic, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                    .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPlayerBack)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlayerControl)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlayerNext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPlayerVolume)))
                .addContainerGap())
        );
        panelPlayerControllerLayout.setVerticalGroup(
            panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(sliderPlayerMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlayerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlayerControl)
                    .addComponent(btnPlayerVolume)
                    .addComponent(btnPlayerNext)
                    .addComponent(btnPlayerBack))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelPlayerVolume.setBackground(new java.awt.Color(179, 7, 83));

        sliderPlayerVolume.setBackground(new java.awt.Color(179, 7, 83));
        sliderPlayerVolume.setForeground(new java.awt.Color(179, 7, 83));
        sliderPlayerVolume.setMaximum(0);
        sliderPlayerVolume.setMinimum(-40);
        sliderPlayerVolume.setOrientation(javax.swing.JSlider.VERTICAL);
        sliderPlayerVolume.setAlignmentX(0.0F);
        sliderPlayerVolume.setAlignmentY(0.0F);
        sliderPlayerVolume.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderPlayerVolume.setMinimumSize(new java.awt.Dimension(20, 130));
        sliderPlayerVolume.setPreferredSize(new java.awt.Dimension(20, 130));
        sliderPlayerVolume.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderPlayerVolumeStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panelPlayerVolumeLayout = new javax.swing.GroupLayout(panelPlayerVolume);
        panelPlayerVolume.setLayout(panelPlayerVolumeLayout);
        panelPlayerVolumeLayout.setHorizontalGroup(
            panelPlayerVolumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPlayerVolumeLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(sliderPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelPlayerVolumeLayout.setVerticalGroup(
            panelPlayerVolumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sliderPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, 120, Short.MAX_VALUE)
        );

        txtPlayerMusicId.setEditable(false);
        txtPlayerMusicId.setBackground(new java.awt.Color(179, 7, 83));
        txtPlayerMusicId.setAlignmentX(0.0F);
        txtPlayerMusicId.setAlignmentY(0.0F);
        txtPlayerMusicId.setBorder(null);
        txtPlayerMusicId.setCaretColor(new java.awt.Color(179, 7, 83));
        txtPlayerMusicId.setDisabledTextColor(new java.awt.Color(179, 7, 83));
        txtPlayerMusicId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtPlayerMusicId.setMaximumSize(new java.awt.Dimension(1, 5));
        txtPlayerMusicId.setMinimumSize(new java.awt.Dimension(1, 5));
        txtPlayerMusicId.setPreferredSize(new java.awt.Dimension(1, 5));
        txtPlayerMusicId.setSelectedTextColor(new java.awt.Color(179, 7, 83));
        txtPlayerMusicId.setSelectionColor(new java.awt.Color(179, 7, 83));

        javax.swing.GroupLayout panelPlayerLayout = new javax.swing.GroupLayout(panelPlayer);
        panelPlayer.setLayout(panelPlayerLayout);
        panelPlayerLayout.setHorizontalGroup(
            panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerLayout.createSequentialGroup()
                .addGroup(panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlayerLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(labelPlayerMusic))
                    .addGroup(panelPlayerLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(txtPlayerMusicId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addComponent(panelPlayerController, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPlayerLayout.setVerticalGroup(
            panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerLayout.createSequentialGroup()
                .addGroup(panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlayerLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelPlayerController, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPlayerLayout.createSequentialGroup()
                                .addComponent(labelPlayerMusic)
                                .addGap(18, 18, 18)
                                .addComponent(txtPlayerMusicId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPlayerLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(panelPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        panelMenu.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setAlignmentX(0.0F);
        panelMenu.setAlignmentY(0.0F);
        panelMenu.setMinimumSize(new java.awt.Dimension(300, 640));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 640));

        labelMenuArtist.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        labelMenuArtist.setForeground(new java.awt.Color(173, 216, 230));
        labelMenuArtist.setText("Nome Artista");

        btnMenuAlbum.setBackground(new java.awt.Color(0, 0, 0));
        btnMenuAlbum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/textAlbuns.png"))); // NOI18N
        btnMenuAlbum.setAlignmentY(0.0F);
        btnMenuAlbum.setBorder(null);
        btnMenuAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuAlbum.setFocusable(false);
        btnMenuAlbum.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMenuAlbum.setMaximumSize(new java.awt.Dimension(300, 100));
        btnMenuAlbum.setMinimumSize(new java.awt.Dimension(300, 100));
        btnMenuAlbum.setPreferredSize(new java.awt.Dimension(300, 100));
        btnMenuAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuAlbumActionPerformed(evt);
            }
        });

        btnMenuMusic.setBackground(new java.awt.Color(0, 0, 0));
        btnMenuMusic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/textMusica.png"))); // NOI18N
        btnMenuMusic.setAlignmentY(0.0F);
        btnMenuMusic.setBorder(null);
        btnMenuMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuMusic.setFocusable(false);
        btnMenuMusic.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMenuMusic.setMaximumSize(new java.awt.Dimension(300, 100));
        btnMenuMusic.setMinimumSize(new java.awt.Dimension(300, 100));
        btnMenuMusic.setPreferredSize(new java.awt.Dimension(300, 100));
        btnMenuMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuMusicActionPerformed(evt);
            }
        });

        panelMenuLogo.setBackground(new java.awt.Color(179, 7, 83));

        labelMenuLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo_grande.png"))); // NOI18N
        labelMenuLogo.setAlignmentY(0.0F);
        labelMenuLogo.setMaximumSize(new java.awt.Dimension(300, 240));
        labelMenuLogo.setMinimumSize(new java.awt.Dimension(300, 180));
        labelMenuLogo.setPreferredSize(new java.awt.Dimension(300, 180));

        javax.swing.GroupLayout panelMenuLogoLayout = new javax.swing.GroupLayout(panelMenuLogo);
        panelMenuLogo.setLayout(panelMenuLogoLayout);
        panelMenuLogoLayout.setHorizontalGroup(
            panelMenuLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(panelMenuLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLogoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelMenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelMenuLogoLayout.setVerticalGroup(
            panelMenuLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(panelMenuLogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelMenuLogoLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(labelMenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelMenuLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelMenuArtist)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(panelMenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMenuAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMenuMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelMenuArtist)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 1014, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(panelPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuMusicActionPerformed
        Config.openCard(panelMain, "panelMusic");
        tableAlbum();
    }//GEN-LAST:event_btnMenuMusicActionPerformed

    private void btnMenuAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuAlbumActionPerformed
        Config.openCard(panelMain, "panelAlbum");
        tableMusic();
    }//GEN-LAST:event_btnMenuAlbumActionPerformed

    private void btnPlayerVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerVolumeActionPerformed
        muted = !muted;
        if (muted) {
            cm.volume(-80);
            btnPlayerVolume.setIcon(new ImageIcon(getClass().getResource("/resources/icons/mute.png")));
            sliderPlayerVolume.setVisible(false);
            som = sliderPlayerVolume.getValue();
            
        } else {
            cm.volume(som);
            btnPlayerVolume.setIcon(new ImageIcon(getClass().getResource("/resources/icons/som.png")));
            sliderPlayerVolume.setVisible(true);
            som = 0;
        }
    }//GEN-LAST:event_btnPlayerVolumeActionPerformed

    private void tableAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableAlbumMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tableAlbum.getSelectedRow();
            int selectedId = Integer.parseInt(tableAlbum.getValueAt(row, 0).toString());
            
            DefaultTableModel model = (DefaultTableModel) tableMusicAlbum.getModel();
            model.setRowCount(0);
            
            ArrayList<Object[]> arrayData = music.readMusicForAlbum(selectedId, new String[]{"mid", "mname"});
            for (int i = 0; i < arrayData.size(); i++) {
                model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
            }
            Config.openCard(panelMain, "panelMusicAlbum");
        }
    }//GEN-LAST:event_tableAlbumMouseClicked

    private void tableMusicAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMusicAlbumMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tableMusicAlbum.getSelectedRow();
            int selectedId = Integer.parseInt(tableMusicAlbum.getValueAt(row, 0).toString());
            labelPlayerMusic.setText(tableMusicAlbum.getValueAt(row, 1).toString());
            playMusic(selectedId);
        }
    }//GEN-LAST:event_tableMusicAlbumMouseClicked

    private void sliderPlayerVolumeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderPlayerVolumeStateChanged
        if (sliderPlayerVolume.getValue() == -40) {
            cm.volume(-80);
            btnPlayerVolume.setIcon(new ImageIcon(getClass().getResource("/resources/icons/mute.png")));
        } else {
            cm.volume(sliderPlayerVolume.getValue());
            btnPlayerVolume.setIcon(new ImageIcon(getClass().getResource("/resources/icons/som.png")));
        }
    }//GEN-LAST:event_sliderPlayerVolumeStateChanged

    private void btnPlayerControlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerControlActionPerformed
        if (!play) {
            cm.notStop();
            btnPlayerControl.setIcon(new ImageIcon(getClass().getResource("/resources/icons/pouse.png")));
            play = true;
            
        } else {
            cm.stop();
            btnPlayerControl.setIcon(new ImageIcon(getClass().getResource("/resources/icons/play.png")));
            play = false;
        }
    }//GEN-LAST:event_btnPlayerControlActionPerformed

    private void tableMusicMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMusicMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tableMusic.getSelectedRow();
            int selectedId = Integer.parseInt(tableMusic.getValueAt(row, 0).toString());
            String selectedName = tableMusic.getValueAt(row, 1).toString();
            
            if (cm != null) {
                cm.finalStop();
            }
            
            cm = new ConfigMusic(selectedId);
            cm.start();
            btnPlayerControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/pouse.png")));
            labelPlayerMusic.setText(selectedName);
            labelPlayerTime.setText(Double.toString((cm.getDurationLenghtMusic() / 1000000) / 60)
                    .replace(".", ":").substring(0, Double.toString((cm.getDurationLenghtMusic() / 1000000) / 60).lastIndexOf(".") + 3));
            txtPlayerMusicId.setText(Integer.toString(selectedId));
            
            sliderPlayerMusic.setMinimum(0);
            sliderPlayerMusic.setValue(0);
            sliderPlayerMusic.setMaximum((int) cm.getDurationLenghtMusic());
            
            ChangeListener changeListener = (ChangeEvent e) -> {
                cm.setDurationMusic(sliderPlayerMusic.getValue());
            };
            sliderPlayerMusic.addChangeListener(changeListener);
            play = true;
        }
    }//GEN-LAST:event_tableMusicMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenuAlbum;
    private javax.swing.JButton btnMenuMusic;
    private javax.swing.JButton btnPlayerBack;
    private javax.swing.JButton btnPlayerControl;
    private javax.swing.JButton btnPlayerNext;
    private javax.swing.JButton btnPlayerVolume;
    private javax.swing.JLabel labelMenuArtist;
    private javax.swing.JLabel labelMenuLogo;
    private javax.swing.JLabel labelPlayerMusic;
    private javax.swing.JLabel labelPlayerTime;
    private javax.swing.JPanel panelAlbum;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuLogo;
    private javax.swing.JPanel panelMusic;
    private javax.swing.JPanel panelMusicAlbum;
    private javax.swing.JPanel panelPlayer;
    private javax.swing.JPanel panelPlayerController;
    private javax.swing.JPanel panelPlayerVolume;
    private javax.swing.JScrollPane scrollAlbum;
    private javax.swing.JScrollPane scrollMusic;
    private javax.swing.JScrollPane scrollMusicAlbum;
    private javax.swing.JSlider sliderPlayerMusic;
    private javax.swing.JSlider sliderPlayerVolume;
    private javax.swing.JTable tableAlbum;
    private javax.swing.JTable tableMusic;
    private javax.swing.JTable tableMusicAlbum;
    private javax.swing.JTextField txtPlayerMusicId;
    // End of variables declaration//GEN-END:variables

    /*public void loopingMusic() {
        ChangeListener changeListener = (ChangeEvent e) -> {
            configMusic.setDurationMusic(sliderPlayerMusic.getValue());
        };

        while (play) {
            if (!sliderPlayerMusic.getValueIsAdjusting()) {
                sliderPlayerMusic.removeChangeListener(changeListener);
                sliderPlayerMusic.setValue(configMusic.getDurationMusic());
                sliderPlayerMusic.addChangeListener(changeListener);
            }
        }
    }*/
    public void playMusic(int mid) {
//        if (cm != null) {
//            cm.finalStop();
//        }
//
//        cm = new ConfigMusic(selectedId);
//        cm.start();
//        btnPlayerControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/pouse.png")));
//        labelPlayerMusic.setText(selectedName);
//        labelPlayerTime.setText(Double.toString((cm.getDurationLenghtMusic() / 1000000) / 60)
//                .replace(".", ":").substring(0, Double.toString((cm.getDurationLenghtMusic() / 1000000) / 60).lastIndexOf(".") + 3));
//        txtPlayerMusicId.setText(Integer.toString(selectedId));
//
//        sliderPlayerMusic.setMinimum(0);
//        sliderPlayerMusic.setValue(0);
//        sliderPlayerMusic.setMaximum((int) cm.getDurationLenghtMusic());
//
//        ChangeListener changeListener = (ChangeEvent e) -> {
//            cm.setDurationMusic(sliderPlayerMusic.getValue());
//        };
//        sliderPlayerMusic.addChangeListener(changeListener);
//        play = true;
        PopUp.showNotefy("Inativo!!");
    }
    
    public void tableMusic() {
        DefaultTableModel model = (DefaultTableModel) tableMusic.getModel();
        model.setRowCount(0);
        
        ArrayList<Object[]> arrayData = music.readMusic(new Object[]{this.uid}, new String[]{"mid", "mname"});
        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
        }
    }
    
    public void tableAlbum() {
        DefaultTableModel model = (DefaultTableModel) tableAlbum.getModel();
        model.setRowCount(0);
        
        ArrayList<Object[]> arrayData = albums.readAlbum(uid, new String[]{"alid", "alname"});
        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
        }
    }
}

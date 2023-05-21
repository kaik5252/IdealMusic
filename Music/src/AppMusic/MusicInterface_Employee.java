package AppMusic;

import Control.Config;
import Control.ConfigMusic;
import Control.PopUp;
import Model.Album;
import Model.Category;
import Model.Database;
import Model.Music;
import Model.Users;
import static java.awt.Toolkit.getDefaultToolkit;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;

public class MusicInterface_Employee extends JFrame {

    private Users users = new Users("users");
    private Album album = new Album("album");
    private Category category = new Category("category");
    private Music music = new Music("music");
    private ConfigMusic cm;
    boolean muted = false;
    int som = 0;

    public MusicInterface_Employee() {
        initComponents();
        setIconImage(getDefaultToolkit().getImage("src/resources/icons/logo_icon.png"));

        tableSelectedList.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 0));
        DefaultTableCellRenderer tableHeader = (DefaultTableCellRenderer) tableSelectedList.getTableHeader().getDefaultRenderer();
        tableHeader.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer tableCell = new DefaultTableCellRenderer();
        tableCell.setHorizontalAlignment(SwingConstants.CENTER);
        for (int colInit = 0; colInit < tableSelectedList.getColumnModel().getColumnCount(); colInit++) {
            tableSelectedList.getColumnModel().getColumn(colInit).setCellRenderer(tableCell);
        }

        panelMusic();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        frameUtiliti = new javax.swing.JFrame();
        panelUtilitiMain = new javax.swing.JPanel();
        panelCreateEmployee = new javax.swing.JPanel();
        labelCreateEmployee1 = new javax.swing.JLabel();
        labelCreateEmployee2 = new javax.swing.JLabel();
        labelCreateEmployee3 = new javax.swing.JLabel();
        labelCreateEmployee4 = new javax.swing.JLabel();
        btnCreateEmployeeCancel = new javax.swing.JButton();
        btnCreateEmployeeEnter = new javax.swing.JButton();
        txtCreateEmployeePassword = new javax.swing.JPasswordField();
        txtCreateEmployeeName = new javax.swing.JTextField();
        labelCreateEmployee5 = new javax.swing.JLabel();
        txtCreateEmployeeLogin = new javax.swing.JTextField();
        labelCreateEmployeeLogo = new javax.swing.JLabel();
        txtCreateEmployeeTel = new javax.swing.JFormattedTextField();
        panelCreateArtist = new javax.swing.JPanel();
        labelCreateArtist1 = new javax.swing.JLabel();
        labelCreateArtistLogo = new javax.swing.JLabel();
        txtCreateArtistName = new javax.swing.JTextField();
        labelCreateArtist2 = new javax.swing.JLabel();
        labelCreateArtist3 = new javax.swing.JLabel();
        labelCreateArtist4 = new javax.swing.JLabel();
        txtCreateArtistLogin = new javax.swing.JTextField();
        labelCreateArtist5 = new javax.swing.JLabel();
        txtCreateArtistPassword = new javax.swing.JPasswordField();
        btnCreateArtistCancel = new javax.swing.JButton();
        btnCreateArtistEnter = new javax.swing.JButton();
        txtCreateArtistTel = new javax.swing.JFormattedTextField();
        panelCreateAlbum = new javax.swing.JPanel();
        labelCreateAlbum1 = new javax.swing.JLabel();
        labelCreateAlbum2 = new javax.swing.JLabel();
        txtCreateAlbumName = new javax.swing.JTextField();
        btnCreateAlbumCancel = new javax.swing.JButton();
        btnCreateAlbumEnter = new javax.swing.JButton();
        boxCreateAlbumArtist = new javax.swing.JComboBox<>();
        labelCreateAlbum3 = new javax.swing.JLabel();
        labelCreateAlbumLogo = new javax.swing.JLabel();
        panelCreateCategory = new javax.swing.JPanel();
        labelCreateCategory1 = new javax.swing.JLabel();
        labelCreateCategory2 = new javax.swing.JLabel();
        labelCreateCategory3 = new javax.swing.JLabel();
        txtCreateCategoryName = new javax.swing.JTextField();
        btnCreateCategoryCancel = new javax.swing.JButton();
        btnCreateCategoryEnter = new javax.swing.JButton();
        labelCreateCategoryLogo = new javax.swing.JLabel();
        checkboxGroupUpdate = new javax.swing.ButtonGroup();
        panelMain = new javax.swing.JPanel();
        panelCreateMusic = new javax.swing.JPanel();
        txtCreateMusicName = new javax.swing.JTextField();
        txtCreateMusicSound = new javax.swing.JTextField();
        labelCreateMusic1 = new javax.swing.JLabel();
        labelCreateMusic2 = new javax.swing.JLabel();
        btnCreateMusicCategory = new javax.swing.JButton();
        labelCreateMusic3 = new javax.swing.JLabel();
        labelCreateMusic4 = new javax.swing.JLabel();
        btnCreateMusicEnter = new javax.swing.JButton();
        btnCreateMusicClear = new javax.swing.JButton();
        btnCreateMusicSelect = new javax.swing.JButton();
        boxCreateMusicAlbum = new javax.swing.JComboBox<>();
        labelCreateMusic5 = new javax.swing.JLabel();
        boxCreateMusicCategory = new javax.swing.JComboBox<>();
        labelCreateMusic6 = new javax.swing.JLabel();
        btnCreateMusicAlbum = new javax.swing.JButton();
        labelCreateMusic7 = new javax.swing.JLabel();
        txtCreateMusicDuration = new javax.swing.JFormattedTextField();
        panelEmployee = new javax.swing.JPanel();
        labelEmployee1 = new javax.swing.JLabel();
        btnEmployeeCreateCategory = new javax.swing.JButton();
        btnEmployeeCreateArtist = new javax.swing.JButton();
        btnEmployeeCreateAlbum = new javax.swing.JButton();
        btnEmployeeCreateEmployee = new javax.swing.JButton();
        labelEmployee2 = new javax.swing.JLabel();
        btnEmployeeEditEmployee = new javax.swing.JButton();
        btnEmployeeEditArtist = new javax.swing.JButton();
        btnEmployeeEditAlbum = new javax.swing.JButton();
        btnEmployeeEditMusic = new javax.swing.JButton();
        btnEmployeeCreateMusic = new javax.swing.JButton();
        btnEmployeeEditCategory = new javax.swing.JButton();
        panelUpdates = new javax.swing.JPanel();
        panelSelectUpdates = new javax.swing.JPanel();
        checkboxSelectMusic = new javax.swing.JCheckBox();
        checkboxSelectArtist = new javax.swing.JCheckBox();
        checkboxSelectCategory = new javax.swing.JCheckBox();
        btnSelectUpdateCancel = new javax.swing.JButton();
        labelSelectUpdate1 = new javax.swing.JLabel();
        labelSelectUpdate2 = new javax.swing.JLabel();
        checkboxSelectAlbum = new javax.swing.JCheckBox();
        checkboxSelectEmployee = new javax.swing.JCheckBox();
        scrollSelectedList = new javax.swing.JScrollPane();
        tableSelectedList = new javax.swing.JTable();
        panelViewUpdates = new javax.swing.JPanel();
        panelViewUpdatesMusic = new javax.swing.JPanel();
        txtViewMusicSound = new javax.swing.JTextField();
        boxViewMusicCategory = new javax.swing.JComboBox<>();
        txtViewMusicName = new javax.swing.JTextField();
        btnViewMusicEdit = new javax.swing.JButton();
        btnViewMusicDelete = new javax.swing.JButton();
        labelViewMusic1 = new javax.swing.JLabel();
        labelViewMusic2 = new javax.swing.JLabel();
        labelViewMusic4 = new javax.swing.JLabel();
        labelViewMusic5 = new javax.swing.JLabel();
        labelViewMusic6 = new javax.swing.JLabel();
        btnViewMusicSelect = new javax.swing.JButton();
        btnViewMusicRefresh = new javax.swing.JButton();
        labelViewMusic7 = new javax.swing.JLabel();
        boxViewMusicAlbum = new javax.swing.JComboBox<>();
        txtViewMusicId = new javax.swing.JTextField();
        txtCreateMusicDuration1 = new javax.swing.JFormattedTextField();
        labelViewMusic8 = new javax.swing.JLabel();
        txtViewMusicYear = new javax.swing.JTextField();
        labelViewMusic9 = new javax.swing.JLabel();
        panelViewUpdatesCategory = new javax.swing.JPanel();
        labelViewCategory1 = new javax.swing.JLabel();
        txtViewCategoryName = new javax.swing.JTextField();
        labelViewCategory2 = new javax.swing.JLabel();
        btnViewCategoryRefresh = new javax.swing.JButton();
        btnViewCategoryEdit = new javax.swing.JButton();
        btnViewCategoryDelete = new javax.swing.JButton();
        txtViewCategoryId = new javax.swing.JTextField();
        labelViewCategory3 = new javax.swing.JLabel();
        panelViewUpdatesAlbum = new javax.swing.JPanel();
        labelViewAlbum1 = new javax.swing.JLabel();
        txtViewAlbumName = new javax.swing.JTextField();
        labelViewAlbumName = new javax.swing.JLabel();
        btnViewAlbumRefresh = new javax.swing.JButton();
        btnViewAlbumEdit = new javax.swing.JButton();
        btnViewAlbumDelete = new javax.swing.JButton();
        txtViewAlbumId = new javax.swing.JTextField();
        labelViewAlbum2 = new javax.swing.JLabel();
        boxViewAlbumArtist = new javax.swing.JComboBox<>();
        labelViewAlbum3 = new javax.swing.JLabel();
        panelViewUpdatesArtist = new javax.swing.JPanel();
        txtViewArtistName = new javax.swing.JTextField();
        labelViewArtist1 = new javax.swing.JLabel();
        labelViewArtist2 = new javax.swing.JLabel();
        labelViewArtist3 = new javax.swing.JLabel();
        btnViewArtistRefresh = new javax.swing.JButton();
        labelViewArtist4 = new javax.swing.JLabel();
        labelViewArtist5 = new javax.swing.JLabel();
        txtViewArtistLogin = new javax.swing.JTextField();
        labelViewArtist6 = new javax.swing.JLabel();
        txtViewArtistTel = new javax.swing.JFormattedTextField();
        btnViewArtistDelete = new javax.swing.JButton();
        btnViewArtistEdit = new javax.swing.JButton();
        txtViewArtistId = new javax.swing.JTextField();
        txtViewArtistPassword = new javax.swing.JPasswordField();
        panelViewUpdatesEmployee = new javax.swing.JPanel();
        txtViewEmployeeName = new javax.swing.JTextField();
        labelViewEmployee1 = new javax.swing.JLabel();
        labelViewEmployee2 = new javax.swing.JLabel();
        labelViewEmployee3 = new javax.swing.JLabel();
        btnViewEmployeeRefresh = new javax.swing.JButton();
        labelViewEmployee4 = new javax.swing.JLabel();
        labelViewEmployee5 = new javax.swing.JLabel();
        txtViewEmployeeLogin = new javax.swing.JTextField();
        labelViewEmployee6 = new javax.swing.JLabel();
        txtViewEmployeeTel = new javax.swing.JFormattedTextField();
        btnViewEmployeeDelete = new javax.swing.JButton();
        btnViewEmployeeEdit = new javax.swing.JButton();
        txtViewEmployeeId = new javax.swing.JTextField();
        txtViewEmployeePassword = new javax.swing.JPasswordField();
        panelPlayer = new javax.swing.JPanel();
        labelPLayerMusic = new javax.swing.JLabel();
        panelPlayerController = new javax.swing.JPanel();
        labelPlayerTimeDuraction = new javax.swing.JLabel();
        labelPlayerTime = new javax.swing.JLabel();
        sliderPlayerMusic = new javax.swing.JSlider();
        btnPlayerVolume = new javax.swing.JButton();
        btnPlayerNext = new javax.swing.JButton();
        btnPlayerControl = new javax.swing.JButton();
        btnPlayerBack = new javax.swing.JButton();
        panelPlayerVolume = new javax.swing.JPanel();
        sliderPlayerVolume = new javax.swing.JSlider();
        panelMenu = new javax.swing.JPanel();
        btnMenuMusic = new javax.swing.JButton();
        btnMenuEmployee = new javax.swing.JButton();
        panelMenuLogo = new javax.swing.JPanel();
        labelMenuLogo = new javax.swing.JLabel();

        frameUtiliti.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        frameUtiliti.setMinimumSize(new java.awt.Dimension(500, 338));
        frameUtiliti.setResizable(false);

        panelUtilitiMain.setMaximumSize(new java.awt.Dimension(500, 300));
        panelUtilitiMain.setLayout(new java.awt.CardLayout());

        panelCreateEmployee.setBackground(new java.awt.Color(179, 7, 83));
        panelCreateEmployee.setAlignmentX(0.0F);
        panelCreateEmployee.setAlignmentY(0.0F);
        panelCreateEmployee.setMaximumSize(new java.awt.Dimension(500, 300));
        panelCreateEmployee.setMinimumSize(new java.awt.Dimension(500, 300));
        panelCreateEmployee.setPreferredSize(new java.awt.Dimension(500, 300));

        labelCreateEmployee1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelCreateEmployee1.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateEmployee1.setText("Cadastrar Funcionário:");
        labelCreateEmployee1.setAlignmentY(0.0F);

        labelCreateEmployee2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateEmployee2.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateEmployee2.setText("Nome:");
        labelCreateEmployee2.setAlignmentY(0.0F);

        labelCreateEmployee3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateEmployee3.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateEmployee3.setText("Telefone:");
        labelCreateEmployee3.setAlignmentY(0.0F);

        labelCreateEmployee4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateEmployee4.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateEmployee4.setText("Senha:");
        labelCreateEmployee4.setAlignmentY(0.0F);

        btnCreateEmployeeCancel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateEmployeeCancel.setText("Cancelar");
        btnCreateEmployeeCancel.setAlignmentY(0.0F);
        btnCreateEmployeeCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateEmployeeCancel.setFocusable(false);
        btnCreateEmployeeCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateEmployeeCancel.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeCancel.setMinimumSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeCancelActionPerformed(evt);
            }
        });

        btnCreateEmployeeEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateEmployeeEnter.setText("Salvar");
        btnCreateEmployeeEnter.setAlignmentY(0.0F);
        btnCreateEmployeeEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateEmployeeEnter.setFocusable(false);
        btnCreateEmployeeEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateEmployeeEnter.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeEnter.setMinimumSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeEnter.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCreateEmployeeEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateEmployeeEnterActionPerformed(evt);
            }
        });

        txtCreateEmployeePassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateEmployeePassword.setAlignmentX(0.0F);
        txtCreateEmployeePassword.setAlignmentY(0.0F);
        txtCreateEmployeePassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateEmployeePassword.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeePassword.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeePassword.setPreferredSize(new java.awt.Dimension(260, 30));

        txtCreateEmployeeName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateEmployeeName.setAlignmentX(0.0F);
        txtCreateEmployeeName.setAlignmentY(0.0F);
        txtCreateEmployeeName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateEmployeeName.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeName.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeName.setPreferredSize(new java.awt.Dimension(260, 30));

        labelCreateEmployee5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateEmployee5.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateEmployee5.setText("Login:");
        labelCreateEmployee5.setAlignmentY(0.0F);

        txtCreateEmployeeLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateEmployeeLogin.setAlignmentX(0.0F);
        txtCreateEmployeeLogin.setAlignmentY(0.0F);
        txtCreateEmployeeLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateEmployeeLogin.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeLogin.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeLogin.setPreferredSize(new java.awt.Dimension(260, 30));

        labelCreateEmployeeLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        try {
            txtCreateEmployeeTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCreateEmployeeTel.setAlignmentX(0.0F);
        txtCreateEmployeeTel.setAlignmentY(0.0F);
        txtCreateEmployeeTel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateEmployeeTel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateEmployeeTel.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeTel.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateEmployeeTel.setPreferredSize(new java.awt.Dimension(260, 30));

        javax.swing.GroupLayout panelCreateEmployeeLayout = new javax.swing.GroupLayout(panelCreateEmployee);
        panelCreateEmployee.setLayout(panelCreateEmployeeLayout);
        panelCreateEmployeeLayout.setHorizontalGroup(
            panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                        .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelCreateEmployee3)
                                    .addComponent(labelCreateEmployee4)
                                    .addComponent(labelCreateEmployee5)
                                    .addComponent(labelCreateEmployee2)))
                            .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelCreateEmployeeLogo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCreateEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCreateEmployeePassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                                .addComponent(btnCreateEmployeeCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateEmployeeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCreateEmployeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCreateEmployeeTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCreateEmployee1)))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        panelCreateEmployeeLayout.setVerticalGroup(
            panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreateEmployee1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateEmployee2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateEmployee3)
                    .addComponent(txtCreateEmployeeTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateEmployeeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateEmployee5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateEmployee4))
                .addGap(18, 18, 18)
                .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateEmployeeCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreateEmployeeEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelCreateEmployeeLogo))
                .addGap(36, 36, 36))
        );

        panelUtilitiMain.add(panelCreateEmployee, "panelCreateEmployee");

        panelCreateArtist.setBackground(new java.awt.Color(179, 7, 83));
        panelCreateArtist.setAlignmentX(0.0F);
        panelCreateArtist.setAlignmentY(0.0F);
        panelCreateArtist.setMaximumSize(new java.awt.Dimension(500, 300));
        panelCreateArtist.setMinimumSize(new java.awt.Dimension(500, 300));
        panelCreateArtist.setPreferredSize(new java.awt.Dimension(500, 300));

        labelCreateArtist1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelCreateArtist1.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateArtist1.setText("Cadastro de artista:");
        labelCreateArtist1.setAlignmentY(0.0F);

        labelCreateArtistLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        txtCreateArtistName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateArtistName.setAlignmentX(0.0F);
        txtCreateArtistName.setAlignmentY(0.0F);
        txtCreateArtistName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateArtistName.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistName.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistName.setPreferredSize(new java.awt.Dimension(260, 30));

        labelCreateArtist2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateArtist2.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateArtist2.setText("Nome:");
        labelCreateArtist2.setAlignmentY(0.0F);

        labelCreateArtist3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateArtist3.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateArtist3.setText("Telefone:");
        labelCreateArtist3.setAlignmentY(0.0F);

        labelCreateArtist4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateArtist4.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateArtist4.setText("Login:");
        labelCreateArtist4.setAlignmentY(0.0F);

        txtCreateArtistLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateArtistLogin.setAlignmentX(0.0F);
        txtCreateArtistLogin.setAlignmentY(0.0F);
        txtCreateArtistLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateArtistLogin.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistLogin.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistLogin.setPreferredSize(new java.awt.Dimension(260, 30));

        labelCreateArtist5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateArtist5.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateArtist5.setText("Senha:");
        labelCreateArtist5.setAlignmentY(0.0F);

        txtCreateArtistPassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateArtistPassword.setAlignmentX(0.0F);
        txtCreateArtistPassword.setAlignmentY(0.0F);
        txtCreateArtistPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateArtistPassword.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistPassword.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistPassword.setPreferredSize(new java.awt.Dimension(260, 30));

        btnCreateArtistCancel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateArtistCancel.setText("Cancelar");
        btnCreateArtistCancel.setAlignmentY(0.0F);
        btnCreateArtistCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateArtistCancel.setFocusable(false);
        btnCreateArtistCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateArtistCancel.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateArtistCancel.setMinimumSize(new java.awt.Dimension(100, 30));
        btnCreateArtistCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCreateArtistCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateArtistCancelActionPerformed(evt);
            }
        });

        btnCreateArtistEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateArtistEnter.setText("Salvar");
        btnCreateArtistEnter.setAlignmentY(0.0F);
        btnCreateArtistEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateArtistEnter.setFocusable(false);
        btnCreateArtistEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateArtistEnter.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateArtistEnter.setMinimumSize(new java.awt.Dimension(100, 30));
        btnCreateArtistEnter.setPreferredSize(new java.awt.Dimension(100, 30));
        btnCreateArtistEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateArtistEnterActionPerformed(evt);
            }
        });

        try {
            txtCreateArtistTel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCreateArtistTel.setAlignmentX(0.0F);
        txtCreateArtistTel.setAlignmentY(0.0F);
        txtCreateArtistTel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateArtistTel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateArtistTel.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistTel.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateArtistTel.setPreferredSize(new java.awt.Dimension(260, 30));

        javax.swing.GroupLayout panelCreateArtistLayout = new javax.swing.GroupLayout(panelCreateArtist);
        panelCreateArtist.setLayout(panelCreateArtistLayout);
        panelCreateArtistLayout.setHorizontalGroup(
            panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateArtistLayout.createSequentialGroup()
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateArtistLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(labelCreateArtist1))
                    .addGroup(panelCreateArtistLayout.createSequentialGroup()
                        .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCreateArtistLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelCreateArtist3)
                                    .addComponent(labelCreateArtist5)
                                    .addComponent(labelCreateArtist4)
                                    .addComponent(labelCreateArtist2)))
                            .addGroup(panelCreateArtistLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelCreateArtistLogo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCreateArtistName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtCreateArtistPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelCreateArtistLayout.createSequentialGroup()
                                .addComponent(btnCreateArtistCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateArtistEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCreateArtistTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCreateArtistLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        panelCreateArtistLayout.setVerticalGroup(
            panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateArtistLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelCreateArtist1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateArtistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateArtist2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateArtist3)
                    .addComponent(txtCreateArtistTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateArtistLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateArtist4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateArtistPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateArtist5))
                .addGap(18, 18, 18)
                .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCreateArtistCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreateArtistEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelCreateArtistLogo))
                .addGap(36, 36, 36))
        );

        panelUtilitiMain.add(panelCreateArtist, "panelCreateArtist");

        panelCreateAlbum.setBackground(new java.awt.Color(179, 7, 83));
        panelCreateAlbum.setAlignmentX(0.0F);
        panelCreateAlbum.setAlignmentY(0.0F);
        panelCreateAlbum.setMaximumSize(new java.awt.Dimension(500, 300));
        panelCreateAlbum.setMinimumSize(new java.awt.Dimension(500, 300));
        panelCreateAlbum.setPreferredSize(new java.awt.Dimension(500, 300));

        labelCreateAlbum1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelCreateAlbum1.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateAlbum1.setText("Cadastrar Albúm:");

        labelCreateAlbum2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateAlbum2.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateAlbum2.setText("Nome:");

        txtCreateAlbumName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateAlbumName.setAlignmentX(0.0F);
        txtCreateAlbumName.setAlignmentY(0.0F);
        txtCreateAlbumName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCreateAlbumName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateAlbumName.setMaximumSize(new java.awt.Dimension(260, 30));
        txtCreateAlbumName.setMinimumSize(new java.awt.Dimension(260, 30));
        txtCreateAlbumName.setPreferredSize(new java.awt.Dimension(260, 30));

        btnCreateAlbumCancel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateAlbumCancel.setText("Cancelar");
        btnCreateAlbumCancel.setAlignmentY(0.0F);
        btnCreateAlbumCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateAlbumCancel.setFocusable(false);
        btnCreateAlbumCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateAlbumCancel.setMaximumSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumCancel.setMinimumSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumCancel.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAlbumCancelActionPerformed(evt);
            }
        });

        btnCreateAlbumEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateAlbumEnter.setText("Cadastrar");
        btnCreateAlbumEnter.setAlignmentY(0.0F);
        btnCreateAlbumEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateAlbumEnter.setFocusable(false);
        btnCreateAlbumEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateAlbumEnter.setMaximumSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumEnter.setMinimumSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumEnter.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCreateAlbumEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateAlbumEnterActionPerformed(evt);
            }
        });

        boxCreateAlbumArtist.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxCreateAlbumArtist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxCreateAlbumArtist.setAlignmentX(0.0F);
        boxCreateAlbumArtist.setAlignmentY(0.0F);
        boxCreateAlbumArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxCreateAlbumArtist.setMaximumSize(new java.awt.Dimension(260, 30));
        boxCreateAlbumArtist.setMinimumSize(new java.awt.Dimension(260, 30));
        boxCreateAlbumArtist.setPreferredSize(new java.awt.Dimension(260, 30));

        labelCreateAlbum3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateAlbum3.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateAlbum3.setText("Artsita:");

        labelCreateAlbumLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout panelCreateAlbumLayout = new javax.swing.GroupLayout(panelCreateAlbum);
        panelCreateAlbum.setLayout(panelCreateAlbumLayout);
        panelCreateAlbumLayout.setHorizontalGroup(
            panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCreateAlbumLogo))
                    .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(labelCreateAlbum1))
                    .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelCreateAlbum3)
                            .addComponent(labelCreateAlbum2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                                .addComponent(btnCreateAlbumCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCreateAlbumEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCreateAlbumName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxCreateAlbumArtist, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        panelCreateAlbumLayout.setVerticalGroup(
            panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateAlbumLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelCreateAlbum1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateAlbum2)
                    .addComponent(txtCreateAlbumName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateAlbum3)
                    .addComponent(boxCreateAlbumArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCreateAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateAlbumCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateAlbumEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelCreateAlbumLogo)
                .addContainerGap())
        );

        panelUtilitiMain.add(panelCreateAlbum, "panelCreateAlbum");

        panelCreateCategory.setBackground(new java.awt.Color(179, 7, 83));
        panelCreateCategory.setMaximumSize(new java.awt.Dimension(500, 300));
        panelCreateCategory.setMinimumSize(new java.awt.Dimension(500, 300));

        labelCreateCategory1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelCreateCategory1.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateCategory1.setText("Cadastrar Categoria Musical:");

        labelCreateCategory2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelCreateCategory2.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateCategory2.setText("<html>Para cadastrar uma nova categoria musical,<br>basta apenas o nome da categoria</html>");

        labelCreateCategory3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateCategory3.setForeground(new java.awt.Color(255, 255, 255));
        labelCreateCategory3.setText("Nome:");

        txtCreateCategoryName.setAlignmentX(0.0F);
        txtCreateCategoryName.setAlignmentY(0.0F);
        txtCreateCategoryName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCreateCategoryName.setMaximumSize(new java.awt.Dimension(200, 30));
        txtCreateCategoryName.setMinimumSize(new java.awt.Dimension(200, 30));
        txtCreateCategoryName.setPreferredSize(new java.awt.Dimension(200, 30));

        btnCreateCategoryCancel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateCategoryCancel.setText("Cancelar");
        btnCreateCategoryCancel.setAlignmentY(0.0F);
        btnCreateCategoryCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateCategoryCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateCategoryCancel.setMaximumSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryCancel.setMinimumSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryCancel.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategoryCancelActionPerformed(evt);
            }
        });

        btnCreateCategoryEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateCategoryEnter.setText("Cadastrar");
        btnCreateCategoryEnter.setAlignmentY(0.0F);
        btnCreateCategoryEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateCategoryEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateCategoryEnter.setMaximumSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryEnter.setMinimumSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryEnter.setPreferredSize(new java.awt.Dimension(90, 30));
        btnCreateCategoryEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCategoryEnterActionPerformed(evt);
            }
        });

        labelCreateCategoryLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/logo.png"))); // NOI18N

        javax.swing.GroupLayout panelCreateCategoryLayout = new javax.swing.GroupLayout(panelCreateCategory);
        panelCreateCategory.setLayout(panelCreateCategoryLayout);
        panelCreateCategoryLayout.setHorizontalGroup(
            panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                .addGroup(panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelCreateCategoryLogo))
                    .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(labelCreateCategory3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                                .addComponent(btnCreateCategoryCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCreateCategoryEnter, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtCreateCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelCreateCategory1)
                            .addComponent(labelCreateCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        panelCreateCategoryLayout.setVerticalGroup(
            panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateCategoryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelCreateCategory1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCreateCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateCategory3)
                    .addComponent(txtCreateCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateCategoryCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateCategoryEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(labelCreateCategoryLogo)
                .addContainerGap())
        );

        panelUtilitiMain.add(panelCreateCategory, "panelCreateCategory");

        javax.swing.GroupLayout frameUtilitiLayout = new javax.swing.GroupLayout(frameUtiliti.getContentPane());
        frameUtiliti.getContentPane().setLayout(frameUtilitiLayout);
        frameUtilitiLayout.setHorizontalGroup(
            frameUtilitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
            .addGroup(frameUtilitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frameUtilitiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelUtilitiMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        frameUtilitiLayout.setVerticalGroup(
            frameUtilitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 318, Short.MAX_VALUE)
            .addGroup(frameUtilitiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(frameUtilitiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelUtilitiMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ideal Music");
        setMinimumSize(new java.awt.Dimension(1280, 640));
        setName("frame"); // NOI18N

        panelMain.setPreferredSize(new java.awt.Dimension(980, 490));
        panelMain.setLayout(new java.awt.CardLayout());

        panelCreateMusic.setBackground(new java.awt.Color(173, 216, 230));
        panelCreateMusic.setAlignmentX(0.0F);
        panelCreateMusic.setAlignmentY(0.0F);
        panelCreateMusic.setMinimumSize(new java.awt.Dimension(980, 489));
        panelCreateMusic.setPreferredSize(new java.awt.Dimension(980, 489));

        txtCreateMusicName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCreateMusicName.setAlignmentX(0.0F);
        txtCreateMusicName.setAlignmentY(0.0F);
        txtCreateMusicName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCreateMusicName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateMusicName.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCreateMusicName.setMinimumSize(new java.awt.Dimension(250, 30));
        txtCreateMusicName.setPreferredSize(new java.awt.Dimension(250, 30));

        txtCreateMusicSound.setEditable(false);
        txtCreateMusicSound.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCreateMusicSound.setAlignmentX(0.0F);
        txtCreateMusicSound.setAlignmentY(0.0F);
        txtCreateMusicSound.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtCreateMusicSound.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateMusicSound.setMaximumSize(new java.awt.Dimension(300, 30));
        txtCreateMusicSound.setMinimumSize(new java.awt.Dimension(250, 30));
        txtCreateMusicSound.setPreferredSize(new java.awt.Dimension(250, 30));

        labelCreateMusic1.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateMusic1.setText("Arquivo:");

        labelCreateMusic2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateMusic2.setText("Nome:");

        btnCreateMusicCategory.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateMusicCategory.setText("Cadastrar Categoria Musical");
        btnCreateMusicCategory.setAlignmentY(0.0F);
        btnCreateMusicCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateMusicCategory.setFocusable(false);
        btnCreateMusicCategory.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateMusicCategory.setMaximumSize(new java.awt.Dimension(150, 30));
        btnCreateMusicCategory.setMinimumSize(new java.awt.Dimension(130, 30));
        btnCreateMusicCategory.setPreferredSize(new java.awt.Dimension(130, 30));
        btnCreateMusicCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMusicCategoryActionPerformed(evt);
            }
        });

        labelCreateMusic3.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelCreateMusic3.setText("Cadastrar Música:");

        labelCreateMusic4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelCreateMusic4.setText("<html>Para pegar o arquivo da música clique no botão `Selecionar` e<br>selecione o arquivo .wav que deseja. Ao terminar de preencher todos<br>os campos clique em `Cadastrar`.</html>");

        btnCreateMusicEnter.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateMusicEnter.setText("Cadastrar");
        btnCreateMusicEnter.setAlignmentY(0.0F);
        btnCreateMusicEnter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateMusicEnter.setFocusable(false);
        btnCreateMusicEnter.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateMusicEnter.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateMusicEnter.setMinimumSize(new java.awt.Dimension(80, 30));
        btnCreateMusicEnter.setPreferredSize(new java.awt.Dimension(80, 30));
        btnCreateMusicEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMusicEnterActionPerformed(evt);
            }
        });

        btnCreateMusicClear.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateMusicClear.setText("Limpar");
        btnCreateMusicClear.setAlignmentY(0.0F);
        btnCreateMusicClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateMusicClear.setFocusable(false);
        btnCreateMusicClear.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateMusicClear.setMaximumSize(new java.awt.Dimension(100, 30));
        btnCreateMusicClear.setMinimumSize(new java.awt.Dimension(80, 30));
        btnCreateMusicClear.setPreferredSize(new java.awt.Dimension(80, 30));
        btnCreateMusicClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMusicClearActionPerformed(evt);
            }
        });

        btnCreateMusicSelect.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateMusicSelect.setText("Selecionar");
        btnCreateMusicSelect.setAlignmentY(0.0F);
        btnCreateMusicSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateMusicSelect.setFocusable(false);
        btnCreateMusicSelect.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateMusicSelect.setMaximumSize(new java.awt.Dimension(100, 26));
        btnCreateMusicSelect.setMinimumSize(new java.awt.Dimension(80, 26));
        btnCreateMusicSelect.setPreferredSize(new java.awt.Dimension(80, 26));
        btnCreateMusicSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMusicSelectActionPerformed(evt);
            }
        });

        boxCreateMusicAlbum.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxCreateMusicAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxCreateMusicAlbum.setAlignmentX(0.0F);
        boxCreateMusicAlbum.setAlignmentY(0.0F);
        boxCreateMusicAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxCreateMusicAlbum.setMaximumSize(new java.awt.Dimension(300, 30));
        boxCreateMusicAlbum.setMinimumSize(new java.awt.Dimension(250, 30));
        boxCreateMusicAlbum.setPreferredSize(new java.awt.Dimension(250, 30));

        labelCreateMusic5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateMusic5.setText("Albúm:");

        boxCreateMusicCategory.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxCreateMusicCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxCreateMusicCategory.setAlignmentX(0.0F);
        boxCreateMusicCategory.setAlignmentY(0.0F);
        boxCreateMusicCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boxCreateMusicCategory.setMaximumSize(new java.awt.Dimension(300, 30));
        boxCreateMusicCategory.setMinimumSize(new java.awt.Dimension(250, 30));
        boxCreateMusicCategory.setPreferredSize(new java.awt.Dimension(250, 30));

        labelCreateMusic6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateMusic6.setText("Categoria:");

        btnCreateMusicAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnCreateMusicAlbum.setText("Cadastrar Albúm");
        btnCreateMusicAlbum.setAlignmentY(0.0F);
        btnCreateMusicAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateMusicAlbum.setFocusable(false);
        btnCreateMusicAlbum.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCreateMusicAlbum.setMaximumSize(new java.awt.Dimension(150, 30));
        btnCreateMusicAlbum.setMinimumSize(new java.awt.Dimension(130, 30));
        btnCreateMusicAlbum.setPreferredSize(new java.awt.Dimension(130, 30));
        btnCreateMusicAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateMusicAlbumActionPerformed(evt);
            }
        });

        labelCreateMusic7.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelCreateMusic7.setText("Duração:");

        try {
            txtCreateMusicDuration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCreateMusicDuration.setAlignmentX(0.0F);
        txtCreateMusicDuration.setAlignmentY(0.0F);
        txtCreateMusicDuration.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateMusicDuration.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateMusicDuration.setMaximumSize(new java.awt.Dimension(250, 30));
        txtCreateMusicDuration.setMinimumSize(new java.awt.Dimension(250, 30));
        txtCreateMusicDuration.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout panelCreateMusicLayout = new javax.swing.GroupLayout(panelCreateMusic);
        panelCreateMusic.setLayout(panelCreateMusicLayout);
        panelCreateMusicLayout.setHorizontalGroup(
            panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateMusicLayout.createSequentialGroup()
                .addContainerGap(291, Short.MAX_VALUE)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreateMusicLayout.createSequentialGroup()
                        .addComponent(btnCreateMusicAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreateMusicCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCreateMusicLayout.createSequentialGroup()
                        .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCreateMusic3)
                                .addComponent(labelCreateMusic4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelCreateMusicLayout.createSequentialGroup()
                                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelCreateMusicLayout.createSequentialGroup()
                                        .addComponent(labelCreateMusic2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCreateMusicName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelCreateMusicLayout.createSequentialGroup()
                                        .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(labelCreateMusic1)
                                            .addComponent(labelCreateMusic5)
                                            .addComponent(labelCreateMusic6)
                                            .addComponent(labelCreateMusic7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(panelCreateMusicLayout.createSequentialGroup()
                                                .addComponent(btnCreateMusicClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnCreateMusicEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtCreateMusicSound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boxCreateMusicCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCreateMusicDuration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(boxCreateMusicAlbum, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCreateMusicSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(271, Short.MAX_VALUE))))
        );
        panelCreateMusicLayout.setVerticalGroup(
            panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCreateMusicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateMusicCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateMusicAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(labelCreateMusic3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelCreateMusic4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateMusicName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateMusic2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCreateMusicSound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateMusic1)
                    .addComponent(btnCreateMusicSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateMusic7)
                    .addComponent(txtCreateMusicDuration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxCreateMusicAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCreateMusic5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCreateMusic6)
                    .addComponent(boxCreateMusicCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCreateMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreateMusicClear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateMusicEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        panelMain.add(panelCreateMusic, "panelCreateMusic");

        panelEmployee.setBackground(new java.awt.Color(173, 216, 230));
        panelEmployee.setAlignmentX(0.0F);
        panelEmployee.setAlignmentY(0.0F);
        panelEmployee.setMinimumSize(new java.awt.Dimension(980, 489));
        panelEmployee.setPreferredSize(new java.awt.Dimension(980, 489));

        labelEmployee1.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        labelEmployee1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmployee1.setText("Painel de edição");
        labelEmployee1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEmployeeCreateCategory.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeCreateCategory.setText("Cadastrar Categoria Musical");
        btnEmployeeCreateCategory.setAlignmentY(0.0F);
        btnEmployeeCreateCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeCreateCategory.setFocusable(false);
        btnEmployeeCreateCategory.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeCreateCategory.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateCategory.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateCategory.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCreateCategoryActionPerformed(evt);
            }
        });

        btnEmployeeCreateArtist.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeCreateArtist.setText("Cadastrar Artista");
        btnEmployeeCreateArtist.setAlignmentY(0.0F);
        btnEmployeeCreateArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeCreateArtist.setFocusable(false);
        btnEmployeeCreateArtist.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeCreateArtist.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateArtist.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateArtist.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCreateArtistActionPerformed(evt);
            }
        });

        btnEmployeeCreateAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeCreateAlbum.setText("Cadastrar Albúm");
        btnEmployeeCreateAlbum.setAlignmentY(0.0F);
        btnEmployeeCreateAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeCreateAlbum.setFocusable(false);
        btnEmployeeCreateAlbum.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeCreateAlbum.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateAlbum.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateAlbum.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCreateAlbumActionPerformed(evt);
            }
        });

        btnEmployeeCreateEmployee.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeCreateEmployee.setText("Cadastrar Funcionário");
        btnEmployeeCreateEmployee.setAlignmentY(0.0F);
        btnEmployeeCreateEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeCreateEmployee.setFocusable(false);
        btnEmployeeCreateEmployee.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeCreateEmployee.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateEmployee.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateEmployee.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCreateEmployeeActionPerformed(evt);
            }
        });

        labelEmployee2.setFont(new java.awt.Font("Cambria", 0, 30)); // NOI18N
        labelEmployee2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmployee2.setText("Painel de Cadastro:");
        labelEmployee2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEmployeeEditEmployee.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeEditEmployee.setText("Editar Funcionário");
        btnEmployeeEditEmployee.setAlignmentY(0.0F);
        btnEmployeeEditEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeEditEmployee.setFocusable(false);
        btnEmployeeEditEmployee.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeEditEmployee.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditEmployee.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditEmployee.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeEditEmployeeActionPerformed(evt);
            }
        });

        btnEmployeeEditArtist.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeEditArtist.setText("Editar Artista");
        btnEmployeeEditArtist.setAlignmentY(0.0F);
        btnEmployeeEditArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeEditArtist.setFocusable(false);
        btnEmployeeEditArtist.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeEditArtist.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditArtist.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditArtist.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeEditArtistActionPerformed(evt);
            }
        });

        btnEmployeeEditAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeEditAlbum.setText("Editar Albúm");
        btnEmployeeEditAlbum.setAlignmentY(0.0F);
        btnEmployeeEditAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeEditAlbum.setFocusable(false);
        btnEmployeeEditAlbum.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeEditAlbum.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditAlbum.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditAlbum.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeEditAlbumActionPerformed(evt);
            }
        });

        btnEmployeeEditMusic.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeEditMusic.setText("Editar Música");
        btnEmployeeEditMusic.setAlignmentY(0.0F);
        btnEmployeeEditMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeEditMusic.setFocusable(false);
        btnEmployeeEditMusic.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeEditMusic.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditMusic.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditMusic.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeEditMusicActionPerformed(evt);
            }
        });

        btnEmployeeCreateMusic.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeCreateMusic.setText("Cadastrar Música");
        btnEmployeeCreateMusic.setAlignmentY(0.0F);
        btnEmployeeCreateMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeCreateMusic.setFocusable(false);
        btnEmployeeCreateMusic.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeCreateMusic.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateMusic.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateMusic.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeCreateMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeCreateMusicActionPerformed(evt);
            }
        });

        btnEmployeeEditCategory.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnEmployeeEditCategory.setText("Editar Categoria Musical");
        btnEmployeeEditCategory.setAlignmentY(0.0F);
        btnEmployeeEditCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeEditCategory.setFocusable(false);
        btnEmployeeEditCategory.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnEmployeeEditCategory.setMaximumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditCategory.setMinimumSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditCategory.setPreferredSize(new java.awt.Dimension(300, 34));
        btnEmployeeEditCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeEditCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelEmployeeLayout = new javax.swing.GroupLayout(panelEmployee);
        panelEmployee.setLayout(panelEmployeeLayout);
        panelEmployeeLayout.setHorizontalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEmployeeCreateEmployee, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmployeeCreateAlbum, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEmployeeCreateCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelEmployee2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEmployeeCreateMusic, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnEmployeeCreateArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmployeeEditArtist, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployeeEditEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployeeEditAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployeeEditMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEmployee1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEmployeeEditCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        panelEmployeeLayout.setVerticalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEmployeeLayout.createSequentialGroup()
                        .addComponent(labelEmployee2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeCreateEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeCreateArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeCreateAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeCreateMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeCreateCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEmployeeLayout.createSequentialGroup()
                        .addComponent(labelEmployee1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeEditEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeEditArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeEditAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeEditMusic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEmployeeEditCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        panelMain.add(panelEmployee, "panelEmployee");

        panelUpdates.setAlignmentX(0.0F);
        panelUpdates.setAlignmentY(0.0F);

        panelSelectUpdates.setBackground(new java.awt.Color(173, 216, 230));
        panelSelectUpdates.setAlignmentX(0.0F);
        panelSelectUpdates.setAlignmentY(0.0F);

        checkboxSelectMusic.setBackground(new java.awt.Color(173, 216, 230));
        checkboxGroupUpdate.add(checkboxSelectMusic);
        checkboxSelectMusic.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        checkboxSelectMusic.setText("Música");
        checkboxSelectMusic.setAlignmentY(0.0F);
        checkboxSelectMusic.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkboxSelectMusic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSelectMusicActionPerformed(evt);
            }
        });

        checkboxSelectArtist.setBackground(new java.awt.Color(173, 216, 230));
        checkboxGroupUpdate.add(checkboxSelectArtist);
        checkboxSelectArtist.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        checkboxSelectArtist.setText("Artista");
        checkboxSelectArtist.setAlignmentY(0.0F);
        checkboxSelectArtist.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkboxSelectArtist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSelectArtistActionPerformed(evt);
            }
        });

        checkboxSelectCategory.setBackground(new java.awt.Color(173, 216, 230));
        checkboxGroupUpdate.add(checkboxSelectCategory);
        checkboxSelectCategory.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        checkboxSelectCategory.setText("Categoria Musical");
        checkboxSelectCategory.setAlignmentY(0.0F);
        checkboxSelectCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkboxSelectCategory.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxSelectCategoryStateChanged(evt);
            }
        });
        checkboxSelectCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSelectCategoryActionPerformed(evt);
            }
        });

        btnSelectUpdateCancel.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnSelectUpdateCancel.setText("Voltar");
        btnSelectUpdateCancel.setAlignmentY(0.0F);
        btnSelectUpdateCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelectUpdateCancel.setFocusable(false);
        btnSelectUpdateCancel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnSelectUpdateCancel.setMaximumSize(new java.awt.Dimension(100, 30));
        btnSelectUpdateCancel.setMinimumSize(new java.awt.Dimension(100, 30));
        btnSelectUpdateCancel.setPreferredSize(new java.awt.Dimension(100, 30));
        btnSelectUpdateCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectUpdateCancelActionPerformed(evt);
            }
        });

        labelSelectUpdate1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelSelectUpdate1.setText("Editar dados:");
        labelSelectUpdate1.setAlignmentY(0.0F);

        labelSelectUpdate2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelSelectUpdate2.setText("<html>Selecione o tipo do dados e logo depois<br/>selecione-o na lista abeixo e clique em editar.</html>");
        labelSelectUpdate2.setAlignmentY(0.0F);

        checkboxSelectAlbum.setBackground(new java.awt.Color(173, 216, 230));
        checkboxGroupUpdate.add(checkboxSelectAlbum);
        checkboxSelectAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        checkboxSelectAlbum.setText("Albúm");
        checkboxSelectAlbum.setAlignmentY(0.0F);
        checkboxSelectAlbum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkboxSelectAlbum.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxSelectAlbumStateChanged(evt);
            }
        });
        checkboxSelectAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSelectAlbumActionPerformed(evt);
            }
        });

        checkboxSelectEmployee.setBackground(new java.awt.Color(173, 216, 230));
        checkboxGroupUpdate.add(checkboxSelectEmployee);
        checkboxSelectEmployee.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        checkboxSelectEmployee.setText("Funcionário");
        checkboxSelectEmployee.setAlignmentY(0.0F);
        checkboxSelectEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkboxSelectEmployee.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                checkboxSelectEmployeeStateChanged(evt);
            }
        });
        checkboxSelectEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxSelectEmployeeActionPerformed(evt);
            }
        });

        tableSelectedList.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        tableSelectedList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "id", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableSelectedList.setAlignmentX(0.0F);
        tableSelectedList.setAlignmentY(0.0F);
        tableSelectedList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableSelectedList.setRowHeight(24);
        tableSelectedList.getTableHeader().setResizingAllowed(false);
        tableSelectedList.getTableHeader().setReorderingAllowed(false);
        tableSelectedList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSelectedListMouseClicked(evt);
            }
        });
        scrollSelectedList.setViewportView(tableSelectedList);
        if (tableSelectedList.getColumnModel().getColumnCount() > 0) {
            tableSelectedList.getColumnModel().getColumn(0).setMinWidth(0);
            tableSelectedList.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableSelectedList.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout panelSelectUpdatesLayout = new javax.swing.GroupLayout(panelSelectUpdates);
        panelSelectUpdates.setLayout(panelSelectUpdatesLayout);
        panelSelectUpdatesLayout.setHorizontalGroup(
            panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSelectUpdatesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollSelectedList)
                    .addGroup(panelSelectUpdatesLayout.createSequentialGroup()
                        .addComponent(btnSelectUpdateCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSelectUpdatesLayout.createSequentialGroup()
                        .addGroup(panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelSelectUpdatesLayout.createSequentialGroup()
                                .addComponent(checkboxSelectCategory)
                                .addGap(18, 18, 18)
                                .addComponent(checkboxSelectMusic)
                                .addGap(18, 18, 18)
                                .addComponent(checkboxSelectAlbum))
                            .addGroup(panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelSelectUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labelSelectUpdate1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkboxSelectEmployee)
                        .addGap(18, 18, 18)
                        .addComponent(checkboxSelectArtist)))
                .addContainerGap())
        );
        panelSelectUpdatesLayout.setVerticalGroup(
            panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSelectUpdatesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelSelectUpdate1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelSelectUpdate2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelSelectUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkboxSelectCategory)
                    .addComponent(checkboxSelectMusic)
                    .addComponent(checkboxSelectArtist)
                    .addComponent(checkboxSelectAlbum)
                    .addComponent(checkboxSelectEmployee))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollSelectedList, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelectUpdateCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelViewUpdates.setLayout(new java.awt.CardLayout());

        panelViewUpdatesMusic.setBackground(new java.awt.Color(173, 216, 230));
        panelViewUpdatesMusic.setAlignmentX(0.0F);
        panelViewUpdatesMusic.setAlignmentY(0.0F);
        panelViewUpdatesMusic.setPreferredSize(new java.awt.Dimension(480, 490));

        txtViewMusicSound.setEditable(false);
        txtViewMusicSound.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewMusicSound.setAlignmentX(0.0F);
        txtViewMusicSound.setAlignmentY(0.0F);
        txtViewMusicSound.setMaximumSize(new java.awt.Dimension(230, 30));
        txtViewMusicSound.setMinimumSize(new java.awt.Dimension(230, 30));
        txtViewMusicSound.setPreferredSize(new java.awt.Dimension(230, 30));

        boxViewMusicCategory.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxViewMusicCategory.setMaximumRowCount(2);
        boxViewMusicCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxViewMusicCategory.setAlignmentX(0.0F);
        boxViewMusicCategory.setAlignmentY(0.0F);
        boxViewMusicCategory.setMaximumSize(new java.awt.Dimension(230, 30));
        boxViewMusicCategory.setMinimumSize(new java.awt.Dimension(230, 30));
        boxViewMusicCategory.setPreferredSize(new java.awt.Dimension(230, 30));

        txtViewMusicName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewMusicName.setAlignmentX(0.0F);
        txtViewMusicName.setAlignmentY(0.0F);
        txtViewMusicName.setMaximumSize(new java.awt.Dimension(230, 30));
        txtViewMusicName.setMinimumSize(new java.awt.Dimension(230, 30));
        txtViewMusicName.setPreferredSize(new java.awt.Dimension(230, 30));

        btnViewMusicEdit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewMusicEdit.setText("Editar");
        btnViewMusicEdit.setAlignmentY(0.0F);
        btnViewMusicEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMusicEdit.setFocusable(false);
        btnViewMusicEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewMusicEdit.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewMusicEdit.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewMusicEdit.setPreferredSize(new java.awt.Dimension(90, 30));

        btnViewMusicDelete.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewMusicDelete.setText("Deletar");
        btnViewMusicDelete.setAlignmentY(0.0F);
        btnViewMusicDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMusicDelete.setFocusable(false);
        btnViewMusicDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewMusicDelete.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewMusicDelete.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewMusicDelete.setPreferredSize(new java.awt.Dimension(90, 30));

        labelViewMusic1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelViewMusic1.setText("Alterar Música:");
        labelViewMusic1.setAlignmentY(0.0F);

        labelViewMusic2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic2.setText("Nome:");
        labelViewMusic2.setAlignmentY(0.0F);

        labelViewMusic4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic4.setText("Música:");
        labelViewMusic4.setAlignmentY(0.0F);

        labelViewMusic5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic5.setText("Categoria:");
        labelViewMusic5.setAlignmentY(0.0F);

        labelViewMusic6.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelViewMusic6.setText("Selecione um item no painel ao lado.");
        labelViewMusic6.setAlignmentY(0.0F);

        btnViewMusicSelect.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewMusicSelect.setText("Selecionar");
        btnViewMusicSelect.setAlignmentY(0.0F);
        btnViewMusicSelect.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMusicSelect.setFocusable(false);
        btnViewMusicSelect.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewMusicSelect.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewMusicSelect.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewMusicSelect.setPreferredSize(new java.awt.Dimension(75, 25));

        btnViewMusicRefresh.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewMusicRefresh.setText("Recarregar");
        btnViewMusicRefresh.setAlignmentY(0.0F);
        btnViewMusicRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewMusicRefresh.setFocusable(false);
        btnViewMusicRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewMusicRefresh.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewMusicRefresh.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewMusicRefresh.setPreferredSize(new java.awt.Dimension(75, 25));

        labelViewMusic7.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic7.setText("Albúm:");
        labelViewMusic7.setAlignmentY(0.0F);

        boxViewMusicAlbum.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxViewMusicAlbum.setMaximumRowCount(2);
        boxViewMusicAlbum.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxViewMusicAlbum.setAlignmentX(0.0F);
        boxViewMusicAlbum.setAlignmentY(0.0F);
        boxViewMusicAlbum.setMaximumSize(new java.awt.Dimension(230, 30));
        boxViewMusicAlbum.setMinimumSize(new java.awt.Dimension(230, 30));
        boxViewMusicAlbum.setPreferredSize(new java.awt.Dimension(230, 30));

        txtViewMusicId.setEditable(false);
        txtViewMusicId.setBackground(new java.awt.Color(173, 216, 230));
        txtViewMusicId.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewMusicId.setForeground(new java.awt.Color(173, 216, 230));
        txtViewMusicId.setAlignmentX(0.0F);
        txtViewMusicId.setAlignmentY(0.0F);
        txtViewMusicId.setBorder(null);
        txtViewMusicId.setCaretColor(new java.awt.Color(173, 216, 230));
        txtViewMusicId.setDisabledTextColor(new java.awt.Color(173, 216, 230));
        txtViewMusicId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewMusicId.setMaximumSize(new java.awt.Dimension(3, 20));
        txtViewMusicId.setSelectionColor(new java.awt.Color(255, 255, 255));

        try {
            txtCreateMusicDuration1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCreateMusicDuration1.setAlignmentX(0.0F);
        txtCreateMusicDuration1.setAlignmentY(0.0F);
        txtCreateMusicDuration1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtCreateMusicDuration1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtCreateMusicDuration1.setMaximumSize(new java.awt.Dimension(230, 30));
        txtCreateMusicDuration1.setMinimumSize(new java.awt.Dimension(230, 30));
        txtCreateMusicDuration1.setPreferredSize(new java.awt.Dimension(230, 30));

        labelViewMusic8.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic8.setText("Duração:");

        txtViewMusicYear.setEditable(false);
        txtViewMusicYear.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewMusicYear.setAlignmentX(0.0F);
        txtViewMusicYear.setAlignmentY(0.0F);
        txtViewMusicYear.setMaximumSize(new java.awt.Dimension(230, 30));
        txtViewMusicYear.setMinimumSize(new java.awt.Dimension(230, 30));
        txtViewMusicYear.setPreferredSize(new java.awt.Dimension(230, 30));

        labelViewMusic9.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewMusic9.setText("Ano:");
        labelViewMusic9.setAlignmentY(0.0F);

        javax.swing.GroupLayout panelViewUpdatesMusicLayout = new javax.swing.GroupLayout(panelViewUpdatesMusic);
        panelViewUpdatesMusic.setLayout(panelViewUpdatesMusicLayout);
        panelViewUpdatesMusicLayout.setHorizontalGroup(
            panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesMusicLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(labelViewMusic2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtViewMusicName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesMusicLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesMusicLayout.createSequentialGroup()
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelViewMusic6)
                            .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                                .addComponent(labelViewMusic1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnViewMusicRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesMusicLayout.createSequentialGroup()
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                                .addComponent(labelViewMusic7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxViewMusicAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelViewMusic4)
                                    .addComponent(labelViewMusic5)
                                    .addComponent(labelViewMusic8)
                                    .addComponent(labelViewMusic9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtViewMusicYear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCreateMusicDuration1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewMusicSound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesMusicLayout.createSequentialGroup()
                                        .addComponent(btnViewMusicDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnViewMusicEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(boxViewMusicCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnViewMusicSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(txtViewMusicId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelViewUpdatesMusicLayout.setVerticalGroup(
            panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewMusic1)
                    .addComponent(btnViewMusicRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewMusic6)
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewMusicName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewMusic2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewMusicSound, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewMusic4)
                    .addComponent(btnViewMusicSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewMusic8)
                    .addComponent(txtCreateMusicDuration1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtViewMusicId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(panelViewUpdatesMusicLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewMusicYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelViewMusic9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelViewMusic7)
                            .addComponent(boxViewMusicAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxViewMusicCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelViewMusic5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesMusicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewMusicDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewMusicEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(49, Short.MAX_VALUE))))
        );

        panelViewUpdates.add(panelViewUpdatesMusic, "panelViewUpdatesMusic");

        panelViewUpdatesCategory.setBackground(new java.awt.Color(173, 216, 230));
        panelViewUpdatesCategory.setAlignmentX(0.0F);
        panelViewUpdatesCategory.setAlignmentY(0.0F);

        labelViewCategory1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelViewCategory1.setText("Alterar Categoria:");
        labelViewCategory1.setAlignmentY(0.0F);

        txtViewCategoryName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewCategoryName.setAlignmentX(0.0F);
        txtViewCategoryName.setAlignmentY(0.0F);
        txtViewCategoryName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewCategoryName.setMaximumSize(new java.awt.Dimension(232, 30));
        txtViewCategoryName.setMinimumSize(new java.awt.Dimension(232, 30));
        txtViewCategoryName.setPreferredSize(new java.awt.Dimension(232, 30));

        labelViewCategory2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewCategory2.setText("Nome:");
        labelViewCategory2.setAlignmentY(0.0F);

        btnViewCategoryRefresh.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewCategoryRefresh.setText("Recarregar");
        btnViewCategoryRefresh.setAlignmentY(0.0F);
        btnViewCategoryRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCategoryRefresh.setFocusable(false);
        btnViewCategoryRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewCategoryRefresh.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewCategoryRefresh.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewCategoryRefresh.setPreferredSize(new java.awt.Dimension(75, 25));

        btnViewCategoryEdit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewCategoryEdit.setText("Editar");
        btnViewCategoryEdit.setAlignmentY(0.0F);
        btnViewCategoryEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCategoryEdit.setFocusable(false);
        btnViewCategoryEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewCategoryEdit.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewCategoryEdit.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewCategoryEdit.setPreferredSize(new java.awt.Dimension(90, 30));
        btnViewCategoryEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCategoryEditActionPerformed(evt);
            }
        });

        btnViewCategoryDelete.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewCategoryDelete.setText("Deletar");
        btnViewCategoryDelete.setAlignmentY(0.0F);
        btnViewCategoryDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewCategoryDelete.setFocusable(false);
        btnViewCategoryDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewCategoryDelete.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewCategoryDelete.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewCategoryDelete.setPreferredSize(new java.awt.Dimension(90, 30));

        txtViewCategoryId.setEditable(false);
        txtViewCategoryId.setBackground(new java.awt.Color(173, 216, 230));
        txtViewCategoryId.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewCategoryId.setForeground(new java.awt.Color(173, 216, 230));
        txtViewCategoryId.setAlignmentX(0.0F);
        txtViewCategoryId.setAlignmentY(0.0F);
        txtViewCategoryId.setBorder(null);
        txtViewCategoryId.setCaretColor(new java.awt.Color(173, 216, 230));
        txtViewCategoryId.setDisabledTextColor(new java.awt.Color(173, 216, 230));
        txtViewCategoryId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewCategoryId.setMaximumSize(new java.awt.Dimension(3, 20));
        txtViewCategoryId.setSelectionColor(new java.awt.Color(255, 255, 255));

        labelViewCategory3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelViewCategory3.setText("Selecione um item no painel ao lado.");
        labelViewCategory3.setAlignmentY(0.0F);

        javax.swing.GroupLayout panelViewUpdatesCategoryLayout = new javax.swing.GroupLayout(panelViewUpdatesCategory);
        panelViewUpdatesCategory.setLayout(panelViewUpdatesCategoryLayout);
        panelViewUpdatesCategoryLayout.setHorizontalGroup(
            panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesCategoryLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewUpdatesCategoryLayout.createSequentialGroup()
                        .addComponent(labelViewCategory2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtViewCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnViewCategoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtViewCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelViewUpdatesCategoryLayout.createSequentialGroup()
                        .addComponent(labelViewCategory1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewCategoryRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelViewCategory3)
                    .addComponent(btnViewCategoryDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );
        panelViewUpdatesCategoryLayout.setVerticalGroup(
            panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesCategoryLayout.createSequentialGroup()
                .addContainerGap(150, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewCategory1)
                    .addComponent(btnViewCategoryRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewCategory3)
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewCategory2))
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewCategoryEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewCategoryDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
                .addComponent(txtViewCategoryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelViewUpdates.add(panelViewUpdatesCategory, "panelViewUpdatesCategory");

        panelViewUpdatesAlbum.setBackground(new java.awt.Color(173, 216, 230));

        labelViewAlbum1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelViewAlbum1.setText("Alterar Albúm:");
        labelViewAlbum1.setAlignmentY(0.0F);

        txtViewAlbumName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewAlbumName.setAlignmentX(0.0F);
        txtViewAlbumName.setAlignmentY(0.0F);
        txtViewAlbumName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewAlbumName.setMaximumSize(new java.awt.Dimension(232, 30));
        txtViewAlbumName.setMinimumSize(new java.awt.Dimension(232, 30));
        txtViewAlbumName.setPreferredSize(new java.awt.Dimension(232, 30));

        labelViewAlbumName.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewAlbumName.setText("Nome:");
        labelViewAlbumName.setAlignmentY(0.0F);

        btnViewAlbumRefresh.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewAlbumRefresh.setText("Recarregar");
        btnViewAlbumRefresh.setAlignmentY(0.0F);
        btnViewAlbumRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAlbumRefresh.setFocusable(false);
        btnViewAlbumRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewAlbumRefresh.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewAlbumRefresh.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewAlbumRefresh.setPreferredSize(new java.awt.Dimension(75, 25));

        btnViewAlbumEdit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewAlbumEdit.setText("Editar");
        btnViewAlbumEdit.setAlignmentY(0.0F);
        btnViewAlbumEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAlbumEdit.setFocusable(false);
        btnViewAlbumEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewAlbumEdit.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewAlbumEdit.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewAlbumEdit.setPreferredSize(new java.awt.Dimension(90, 30));
        btnViewAlbumEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAlbumEditActionPerformed(evt);
            }
        });

        btnViewAlbumDelete.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewAlbumDelete.setText("Deletar");
        btnViewAlbumDelete.setAlignmentY(0.0F);
        btnViewAlbumDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAlbumDelete.setFocusable(false);
        btnViewAlbumDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewAlbumDelete.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewAlbumDelete.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewAlbumDelete.setPreferredSize(new java.awt.Dimension(90, 30));

        txtViewAlbumId.setEditable(false);
        txtViewAlbumId.setBackground(new java.awt.Color(173, 216, 230));
        txtViewAlbumId.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewAlbumId.setForeground(new java.awt.Color(173, 216, 230));
        txtViewAlbumId.setAlignmentX(0.0F);
        txtViewAlbumId.setAlignmentY(0.0F);
        txtViewAlbumId.setBorder(null);
        txtViewAlbumId.setCaretColor(new java.awt.Color(173, 216, 230));
        txtViewAlbumId.setDisabledTextColor(new java.awt.Color(173, 216, 230));
        txtViewAlbumId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewAlbumId.setMaximumSize(new java.awt.Dimension(3, 20));
        txtViewAlbumId.setSelectionColor(new java.awt.Color(255, 255, 255));

        labelViewAlbum2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelViewAlbum2.setText("Selecione um item no painel ao lado.");
        labelViewAlbum2.setAlignmentY(0.0F);

        boxViewAlbumArtist.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        boxViewAlbumArtist.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None" }));
        boxViewAlbumArtist.setAlignmentX(0.0F);
        boxViewAlbumArtist.setAlignmentY(0.0F);
        boxViewAlbumArtist.setMaximumSize(new java.awt.Dimension(196, 30));
        boxViewAlbumArtist.setMinimumSize(new java.awt.Dimension(196, 30));
        boxViewAlbumArtist.setPreferredSize(new java.awt.Dimension(196, 30));

        labelViewAlbum3.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewAlbum3.setText("Artista:");
        labelViewAlbum3.setAlignmentY(0.0F);

        javax.swing.GroupLayout panelViewUpdatesAlbumLayout = new javax.swing.GroupLayout(panelViewUpdatesAlbum);
        panelViewUpdatesAlbum.setLayout(panelViewUpdatesAlbumLayout);
        panelViewUpdatesAlbumLayout.setHorizontalGroup(
            panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesAlbumLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewUpdatesAlbumLayout.createSequentialGroup()
                        .addComponent(labelViewAlbum1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnViewAlbumRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelViewAlbum2)
                    .addComponent(btnViewAlbumDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnViewAlbumEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelViewUpdatesAlbumLayout.createSequentialGroup()
                            .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelViewAlbumName)
                                .addComponent(labelViewAlbum3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(boxViewAlbumArtist, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtViewAlbumName, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(panelViewUpdatesAlbumLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(txtViewAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelViewUpdatesAlbumLayout.setVerticalGroup(
            panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesAlbumLayout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewAlbum1)
                    .addComponent(btnViewAlbumRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewAlbum2)
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewAlbumName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewAlbumName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxViewAlbumArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewAlbum3))
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewAlbumEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewAlbumDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(txtViewAlbumId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        panelViewUpdates.add(panelViewUpdatesAlbum, "panelViewUpdatesAlbum");

        panelViewUpdatesArtist.setBackground(new java.awt.Color(173, 216, 230));

        txtViewArtistName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewArtistName.setAlignmentX(0.0F);
        txtViewArtistName.setAlignmentY(0.0F);
        txtViewArtistName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewArtistName.setMaximumSize(new java.awt.Dimension(200, 30));
        txtViewArtistName.setMinimumSize(new java.awt.Dimension(200, 30));
        txtViewArtistName.setPreferredSize(new java.awt.Dimension(200, 30));

        labelViewArtist1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelViewArtist1.setText("Editar Artsita:");
        labelViewArtist1.setAlignmentY(0.0F);

        labelViewArtist2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewArtist2.setText("Nome:");
        labelViewArtist2.setAlignmentY(0.0F);

        labelViewArtist3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelViewArtist3.setText("Selecione um item no painel ao lado.");
        labelViewArtist3.setAlignmentY(0.0F);

        btnViewArtistRefresh.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewArtistRefresh.setText("Recarregar");
        btnViewArtistRefresh.setAlignmentY(0.0F);
        btnViewArtistRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewArtistRefresh.setFocusable(false);
        btnViewArtistRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewArtistRefresh.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewArtistRefresh.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewArtistRefresh.setPreferredSize(new java.awt.Dimension(75, 25));

        labelViewArtist4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewArtist4.setText("Telefone:");
        labelViewArtist4.setAlignmentY(0.0F);

        labelViewArtist5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewArtist5.setText("Login:");
        labelViewArtist5.setAlignmentY(0.0F);

        txtViewArtistLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewArtistLogin.setAlignmentX(0.0F);
        txtViewArtistLogin.setAlignmentY(0.0F);
        txtViewArtistLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewArtistLogin.setMaximumSize(new java.awt.Dimension(200, 30));
        txtViewArtistLogin.setMinimumSize(new java.awt.Dimension(200, 30));
        txtViewArtistLogin.setPreferredSize(new java.awt.Dimension(200, 30));

        labelViewArtist6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewArtist6.setText("Senha:");
        labelViewArtist6.setAlignmentY(0.0F);

        txtViewArtistTel.setAlignmentX(0.0F);
        txtViewArtistTel.setAlignmentY(0.0F);
        txtViewArtistTel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewArtistTel.setMaximumSize(new java.awt.Dimension(200, 30));
        txtViewArtistTel.setMinimumSize(new java.awt.Dimension(200, 30));
        txtViewArtistTel.setPreferredSize(new java.awt.Dimension(200, 30));

        btnViewArtistDelete.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewArtistDelete.setText("Deletar");
        btnViewArtistDelete.setAlignmentY(0.0F);
        btnViewArtistDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewArtistDelete.setFocusable(false);
        btnViewArtistDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewArtistDelete.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewArtistDelete.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewArtistDelete.setPreferredSize(new java.awt.Dimension(90, 30));
        btnViewArtistDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewArtistDeleteActionPerformed(evt);
            }
        });

        btnViewArtistEdit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewArtistEdit.setText("Editar");
        btnViewArtistEdit.setAlignmentY(0.0F);
        btnViewArtistEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewArtistEdit.setFocusable(false);
        btnViewArtistEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewArtistEdit.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewArtistEdit.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewArtistEdit.setPreferredSize(new java.awt.Dimension(90, 30));
        btnViewArtistEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewArtistEditActionPerformed(evt);
            }
        });

        txtViewArtistId.setEditable(false);
        txtViewArtistId.setBackground(new java.awt.Color(173, 216, 230));
        txtViewArtistId.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewArtistId.setForeground(new java.awt.Color(173, 216, 230));
        txtViewArtistId.setAlignmentX(0.0F);
        txtViewArtistId.setAlignmentY(0.0F);
        txtViewArtistId.setBorder(null);
        txtViewArtistId.setCaretColor(new java.awt.Color(173, 216, 230));
        txtViewArtistId.setDisabledTextColor(new java.awt.Color(173, 216, 230));
        txtViewArtistId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewArtistId.setMaximumSize(new java.awt.Dimension(3, 20));
        txtViewArtistId.setSelectionColor(new java.awt.Color(255, 255, 255));

        txtViewArtistPassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewArtistPassword.setAlignmentX(0.0F);
        txtViewArtistPassword.setAlignmentY(0.0F);
        txtViewArtistPassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewArtistPassword.setMaximumSize(new java.awt.Dimension(200, 30));
        txtViewArtistPassword.setMinimumSize(new java.awt.Dimension(200, 30));
        txtViewArtistPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout panelViewUpdatesArtistLayout = new javax.swing.GroupLayout(panelViewUpdatesArtist);
        panelViewUpdatesArtist.setLayout(panelViewUpdatesArtistLayout);
        panelViewUpdatesArtistLayout.setHorizontalGroup(
            panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesArtistLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelViewUpdatesArtistLayout.createSequentialGroup()
                        .addComponent(txtViewArtistId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(454, 454, 454))
                    .addGroup(panelViewUpdatesArtistLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesArtistLayout.createSequentialGroup()
                                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelViewArtist6)
                                    .addComponent(labelViewArtist5)
                                    .addComponent(labelViewArtist2)
                                    .addComponent(labelViewArtist4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtViewArtistName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewArtistTel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewArtistLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewArtistPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelViewArtist3)
                                    .addGroup(panelViewUpdatesArtistLayout.createSequentialGroup()
                                        .addComponent(labelViewArtist1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnViewArtistRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelViewUpdatesArtistLayout.createSequentialGroup()
                                    .addGap(11, 11, 11)
                                    .addComponent(btnViewArtistDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(59, 59, 59)
                                    .addComponent(btnViewArtistEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelViewUpdatesArtistLayout.setVerticalGroup(
            panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesArtistLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewArtist1)
                    .addComponent(btnViewArtistRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewArtist3)
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelViewUpdatesArtistLayout.createSequentialGroup()
                        .addComponent(txtViewArtistName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewArtistTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelViewArtist4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewArtistLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelViewArtist5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtViewArtistPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelViewArtist6)))
                    .addComponent(labelViewArtist2))
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesArtistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewArtistDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewArtistEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(txtViewArtistId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        panelViewUpdates.add(panelViewUpdatesArtist, "panelViewUpdatesArtist");

        panelViewUpdatesEmployee.setBackground(new java.awt.Color(173, 216, 230));

        txtViewEmployeeName.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewEmployeeName.setAlignmentX(0.0F);
        txtViewEmployeeName.setAlignmentY(0.0F);
        txtViewEmployeeName.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewEmployeeName.setMaximumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeName.setMinimumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeName.setPreferredSize(new java.awt.Dimension(250, 30));

        labelViewEmployee1.setFont(new java.awt.Font("Cambria", 0, 26)); // NOI18N
        labelViewEmployee1.setText("Editar Funcionário:");
        labelViewEmployee1.setAlignmentY(0.0F);

        labelViewEmployee2.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewEmployee2.setText("Nome:");
        labelViewEmployee2.setAlignmentY(0.0F);

        labelViewEmployee3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelViewEmployee3.setText("Selecione um item no painel ao lado.");
        labelViewEmployee3.setAlignmentY(0.0F);

        btnViewEmployeeRefresh.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewEmployeeRefresh.setText("Recarregar");
        btnViewEmployeeRefresh.setAlignmentY(0.0F);
        btnViewEmployeeRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewEmployeeRefresh.setFocusable(false);
        btnViewEmployeeRefresh.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewEmployeeRefresh.setMaximumSize(new java.awt.Dimension(75, 25));
        btnViewEmployeeRefresh.setMinimumSize(new java.awt.Dimension(75, 25));
        btnViewEmployeeRefresh.setPreferredSize(new java.awt.Dimension(75, 25));

        labelViewEmployee4.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewEmployee4.setText("Telefone:");
        labelViewEmployee4.setAlignmentY(0.0F);

        labelViewEmployee5.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewEmployee5.setText("Login:");
        labelViewEmployee5.setAlignmentY(0.0F);

        txtViewEmployeeLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewEmployeeLogin.setAlignmentX(0.0F);
        txtViewEmployeeLogin.setAlignmentY(0.0F);
        txtViewEmployeeLogin.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewEmployeeLogin.setMaximumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeLogin.setMinimumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeLogin.setPreferredSize(new java.awt.Dimension(250, 30));

        labelViewEmployee6.setFont(new java.awt.Font("Cambria", 0, 16)); // NOI18N
        labelViewEmployee6.setText("Senha:");
        labelViewEmployee6.setAlignmentY(0.0F);

        txtViewEmployeeTel.setAlignmentX(0.0F);
        txtViewEmployeeTel.setAlignmentY(0.0F);
        txtViewEmployeeTel.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewEmployeeTel.setMaximumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeTel.setMinimumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeeTel.setPreferredSize(new java.awt.Dimension(250, 30));

        btnViewEmployeeDelete.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewEmployeeDelete.setText("Deletar");
        btnViewEmployeeDelete.setAlignmentY(0.0F);
        btnViewEmployeeDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewEmployeeDelete.setFocusable(false);
        btnViewEmployeeDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewEmployeeDelete.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewEmployeeDelete.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewEmployeeDelete.setPreferredSize(new java.awt.Dimension(90, 30));

        btnViewEmployeeEdit.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnViewEmployeeEdit.setText("Editar");
        btnViewEmployeeEdit.setAlignmentY(0.0F);
        btnViewEmployeeEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewEmployeeEdit.setFocusable(false);
        btnViewEmployeeEdit.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnViewEmployeeEdit.setMaximumSize(new java.awt.Dimension(90, 30));
        btnViewEmployeeEdit.setMinimumSize(new java.awt.Dimension(90, 30));
        btnViewEmployeeEdit.setPreferredSize(new java.awt.Dimension(90, 30));
        btnViewEmployeeEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewEmployeeEditActionPerformed(evt);
            }
        });

        txtViewEmployeeId.setEditable(false);
        txtViewEmployeeId.setBackground(new java.awt.Color(173, 216, 230));
        txtViewEmployeeId.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewEmployeeId.setForeground(new java.awt.Color(173, 216, 230));
        txtViewEmployeeId.setAlignmentX(0.0F);
        txtViewEmployeeId.setAlignmentY(0.0F);
        txtViewEmployeeId.setBorder(null);
        txtViewEmployeeId.setCaretColor(new java.awt.Color(173, 216, 230));
        txtViewEmployeeId.setDisabledTextColor(new java.awt.Color(173, 216, 230));
        txtViewEmployeeId.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewEmployeeId.setMaximumSize(new java.awt.Dimension(3, 20));
        txtViewEmployeeId.setSelectionColor(new java.awt.Color(255, 255, 255));

        txtViewEmployeePassword.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtViewEmployeePassword.setAlignmentX(0.0F);
        txtViewEmployeePassword.setAlignmentY(0.0F);
        txtViewEmployeePassword.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txtViewEmployeePassword.setMaximumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeePassword.setMinimumSize(new java.awt.Dimension(250, 30));
        txtViewEmployeePassword.setPreferredSize(new java.awt.Dimension(250, 30));

        javax.swing.GroupLayout panelViewUpdatesEmployeeLayout = new javax.swing.GroupLayout(panelViewUpdatesEmployee);
        panelViewUpdatesEmployee.setLayout(panelViewUpdatesEmployeeLayout);
        panelViewUpdatesEmployeeLayout.setHorizontalGroup(
            panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelViewUpdatesEmployeeLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                        .addComponent(txtViewEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(454, 454, 454))
                    .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                        .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelViewEmployee3)
                                .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                                    .addComponent(labelViewEmployee1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnViewEmployeeRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelViewEmployee4)
                                    .addComponent(labelViewEmployee6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelViewEmployee5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelViewEmployee2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                                        .addComponent(btnViewEmployeeDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnViewEmployeeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtViewEmployeeName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewEmployeeLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewEmployeeTel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtViewEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelViewUpdatesEmployeeLayout.setVerticalGroup(
            panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelViewUpdatesEmployeeLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelViewEmployee1)
                    .addComponent(btnViewEmployeeRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelViewEmployee3)
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewEmployeeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewEmployee2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewEmployeeTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewEmployee4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewEmployeeLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewEmployee5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtViewEmployeePassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelViewEmployee6))
                .addGap(18, 18, 18)
                .addGroup(panelViewUpdatesEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewEmployeeDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewEmployeeEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(txtViewEmployeeId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        panelViewUpdates.add(panelViewUpdatesEmployee, "panelViewUpdatesEmployee");

        javax.swing.GroupLayout panelUpdatesLayout = new javax.swing.GroupLayout(panelUpdates);
        panelUpdates.setLayout(panelUpdatesLayout);
        panelUpdatesLayout.setHorizontalGroup(
            panelUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUpdatesLayout.createSequentialGroup()
                .addComponent(panelSelectUpdates, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelViewUpdates, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE))
        );
        panelUpdatesLayout.setVerticalGroup(
            panelUpdatesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSelectUpdates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelViewUpdates, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelMain.add(panelUpdates, "panelUpdates");

        panelPlayer.setBackground(new java.awt.Color(179, 7, 83));
        panelPlayer.setAlignmentX(0.0F);
        panelPlayer.setAlignmentY(0.0F);
        panelPlayer.setMaximumSize(new java.awt.Dimension(32767, 250));
        panelPlayer.setMinimumSize(new java.awt.Dimension(980, 150));
        panelPlayer.setPreferredSize(new java.awt.Dimension(980, 150));

        labelPLayerMusic.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        labelPLayerMusic.setForeground(new java.awt.Color(255, 255, 255));
        labelPLayerMusic.setText("Nome da música");

        panelPlayerController.setBackground(new java.awt.Color(179, 7, 83));
        panelPlayerController.setAlignmentX(0.0F);
        panelPlayerController.setAlignmentY(0.0F);
        panelPlayerController.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        labelPlayerTimeDuraction.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelPlayerTimeDuraction.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayerTimeDuraction.setText("00:00");

        labelPlayerTime.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        labelPlayerTime.setForeground(new java.awt.Color(255, 255, 255));
        labelPlayerTime.setText("00:00");

        sliderPlayerMusic.setBackground(new java.awt.Color(179, 7, 83));
        sliderPlayerMusic.setForeground(new java.awt.Color(179, 7, 83));
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

        btnPlayerNext.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/next.png"))); // NOI18N
        btnPlayerNext.setAlignmentY(0.0F);
        btnPlayerNext.setBorder(null);
        btnPlayerNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerNext.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnPlayerControl.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerControl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/play.png"))); // NOI18N
        btnPlayerControl.setAlignmentY(0.0F);
        btnPlayerControl.setBorder(null);
        btnPlayerControl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerControl.setMargin(new java.awt.Insets(0, 0, 0, 0));

        btnPlayerBack.setBackground(new java.awt.Color(179, 7, 83));
        btnPlayerBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/back.png"))); // NOI18N
        btnPlayerBack.setAlignmentY(0.0F);
        btnPlayerBack.setBorder(null);
        btnPlayerBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlayerBack.setMargin(new java.awt.Insets(0, 0, 0, 0));

        javax.swing.GroupLayout panelPlayerControllerLayout = new javax.swing.GroupLayout(panelPlayerController);
        panelPlayerController.setLayout(panelPlayerControllerLayout);
        panelPlayerControllerLayout.setHorizontalGroup(
            panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPlayerControllerLayout.createSequentialGroup()
                        .addComponent(labelPlayerTimeDuraction)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderPlayerMusic, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(labelPlayerTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(labelPlayerTimeDuraction, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPlayerTime, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPlayerControllerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPlayerControl)
                    .addComponent(btnPlayerNext)
                    .addComponent(btnPlayerBack)
                    .addComponent(btnPlayerVolume))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelPlayerVolume.setBackground(new java.awt.Color(179, 7, 83));

        sliderPlayerVolume.setBackground(new java.awt.Color(179, 7, 83));
        sliderPlayerVolume.setForeground(new java.awt.Color(179, 7, 83));
        sliderPlayerVolume.setMaximum(0);
        sliderPlayerVolume.setMinimum(-80);
        sliderPlayerVolume.setOrientation(javax.swing.JSlider.VERTICAL);
        sliderPlayerVolume.setAlignmentX(0.0F);
        sliderPlayerVolume.setAlignmentY(0.0F);
        sliderPlayerVolume.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sliderPlayerVolume.setMinimumSize(new java.awt.Dimension(20, 130));
        sliderPlayerVolume.setPreferredSize(new java.awt.Dimension(20, 130));

        javax.swing.GroupLayout panelPlayerVolumeLayout = new javax.swing.GroupLayout(panelPlayerVolume);
        panelPlayerVolume.setLayout(panelPlayerVolumeLayout);
        panelPlayerVolumeLayout.setHorizontalGroup(
            panelPlayerVolumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerVolumeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sliderPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPlayerVolumeLayout.setVerticalGroup(
            panelPlayerVolumeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerVolumeLayout.createSequentialGroup()
                .addComponent(sliderPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelPlayerLayout = new javax.swing.GroupLayout(panelPlayer);
        panelPlayer.setLayout(panelPlayerLayout);
        panelPlayerLayout.setHorizontalGroup(
            panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelPLayerMusic)
                .addGap(18, 18, 18)
                .addComponent(panelPlayerController, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(panelPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPlayerLayout.setVerticalGroup(
            panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPlayerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelPlayerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPlayerController, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPLayerMusic))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelPlayerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPlayerVolume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMenu.setBackground(new java.awt.Color(0, 0, 0));
        panelMenu.setAlignmentX(0.0F);
        panelMenu.setAlignmentY(0.0F);
        panelMenu.setMinimumSize(new java.awt.Dimension(300, 640));
        panelMenu.setPreferredSize(new java.awt.Dimension(300, 640));

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

        btnMenuEmployee.setBackground(new java.awt.Color(0, 0, 0));
        btnMenuEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/textFuncionario.png"))); // NOI18N
        btnMenuEmployee.setAlignmentY(0.0F);
        btnMenuEmployee.setBorder(null);
        btnMenuEmployee.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenuEmployee.setFocusable(false);
        btnMenuEmployee.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnMenuEmployee.setMaximumSize(new java.awt.Dimension(300, 100));
        btnMenuEmployee.setMinimumSize(new java.awt.Dimension(300, 100));
        btnMenuEmployee.setPreferredSize(new java.awt.Dimension(300, 100));
        btnMenuEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuEmployeeActionPerformed(evt);
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
                    .addComponent(btnMenuMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMenuEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(panelMenuLogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMenuMusic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnMenuEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelPlayer, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                    .addComponent(panelMain, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE))
                .addGap(0, 0, 0))
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

    private void btnMenuEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuEmployeeActionPerformed
        Config.openCard(panelMain, "panelEmployee");
    }//GEN-LAST:event_btnMenuEmployeeActionPerformed

    private void btnMenuMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuMusicActionPerformed
        Config.openCard(panelMain, "panelCreateMusic");
        panelMusic();
    }//GEN-LAST:event_btnMenuMusicActionPerformed

    private void btnEmployeeCreateEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCreateEmployeeActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar Funcionário:", panelUtilitiMain, "panelCreateEmployee");
    }//GEN-LAST:event_btnEmployeeCreateEmployeeActionPerformed

    private void btnPlayerVolumeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayerVolumeActionPerformed
        muted = !muted;
        if (muted) {
            btnPlayerVolume.setIcon(new ImageIcon(getClass().getResource("/resources/icons/mute.png")));
            sliderPlayerVolume.setVisible(false);
            som = sliderPlayerVolume.getValue();
            cm.volume(-80);

        } else {
            btnPlayerVolume.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons/som.png")));
            sliderPlayerVolume.setVisible(true);
            cm.volume(som);
            som = 0;
        }
    }//GEN-LAST:event_btnPlayerVolumeActionPerformed

    private void checkboxSelectMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSelectMusicActionPerformed
        Config.openCard(panelViewUpdates, "panelViewUpdatesMusic");
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

        ArrayList<Object[]> arrayData = music.readMusic(null, null, new String[]{"mid", "mname"});
        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
        }
    }//GEN-LAST:event_checkboxSelectMusicActionPerformed

    private void btnEmployeeCreateAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCreateAlbumActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar Albúm:", panelUtilitiMain, "panelCreateAlbum");
        boxCreateAlbumArtist.removeAllItems();
        boxCreateAlbumArtist.addItem("None");

        ArrayList<Object[]> arrayData = users.readUser("WHERE utype = ?", new Object[]{"artist"}, new String[]{"ulogin"});
        for (int i = 0; i < arrayData.size(); i++) {
            boxCreateAlbumArtist.addItem((String) arrayData.get(i)[0]);
        }
    }//GEN-LAST:event_btnEmployeeCreateAlbumActionPerformed

    private void btnEmployeeCreateArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCreateArtistActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar Artista:", panelUtilitiMain, "panelCreateArtist");
    }//GEN-LAST:event_btnEmployeeCreateArtistActionPerformed

    private void btnCreateEmployeeCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeCancelActionPerformed
        Config.closeFrame(frameUtiliti, this);
    }//GEN-LAST:event_btnCreateEmployeeCancelActionPerformed

    private void btnCreateEmployeeEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateEmployeeEnterActionPerformed
        String textCreateLogin = txtCreateEmployeeLogin.getText().trim();
        String textCreatePassword = new String(txtCreateEmployeePassword.getPassword()).trim();

        if (!"".equals(textCreateLogin) && !"".equals(textCreatePassword)) {
            if (users.createUser(new Object[]{textCreateLogin, textCreatePassword, "employee"})) {
                PopUp.showNotefy("Funcionário cadastrado com sucesso!!!");
            } else {
                PopUp.showAlert("Erro ao cadastrar o funcionário.");
            }
            Config.clearTextFields(txtCreateEmployeeLogin, txtCreateEmployeePassword);

        } else {
            PopUp.showAlert("Você esqueceu de preencher algum campo!!\nPreencha-os e tente novamente.", "Oooops!!");
        }
    }//GEN-LAST:event_btnCreateEmployeeEnterActionPerformed

    private void btnCreateAlbumEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAlbumEnterActionPerformed
        String textCreateName = txtCreateAlbumName.getText().trim();

        if (!textCreateName.equals("") && boxCreateAlbumArtist.getSelectedIndex() > 0) {
            if (album.createAlbum(boxCreateAlbumArtist.getSelectedItem().toString(), textCreateName)) {
                PopUp.showNotefy("Album cadastrado com sucesso!!!");
            } else {
                PopUp.showAlert("Erro ao cadastrar o album.");
            }
            Config.clearTextFields(txtCreateAlbumName);
            boxCreateAlbumArtist.setSelectedIndex(0);

        } else {
            PopUp.showAlert("Você esqueceu de preencher algum campo!!\nPreencha-os e tente novamente.", "Oooops!!");
        }
    }//GEN-LAST:event_btnCreateAlbumEnterActionPerformed

    private void btnCreateAlbumCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateAlbumCancelActionPerformed
        Config.closeFrame(frameUtiliti, this);
    }//GEN-LAST:event_btnCreateAlbumCancelActionPerformed

    private void btnEmployeeCreateCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCreateCategoryActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar Categoria Musical:", panelUtilitiMain, "panelCreateCategory");
    }//GEN-LAST:event_btnEmployeeCreateCategoryActionPerformed

    private void checkboxSelectCategoryStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxSelectCategoryStateChanged

    }//GEN-LAST:event_checkboxSelectCategoryStateChanged

    private void checkboxSelectCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSelectCategoryActionPerformed
        Config.openCard(panelViewUpdates, "panelViewUpdatesCategory");
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

        ArrayList<Object[]> arrayData = category.readCategory(null, null, new String[]{"cname"});

        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(arrayData.get(i));
        }
    }//GEN-LAST:event_checkboxSelectCategoryActionPerformed

    private void checkboxSelectArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSelectArtistActionPerformed
        Config.openCard(panelViewUpdates, "panelViewUpdatesArtist");
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

        ArrayList<Object[]> arrayData = users.readUser("WHERE utype = ?", new Object[]{"artist"}, new String[]{"uid", "ulogin"});
        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
        }
    }//GEN-LAST:event_checkboxSelectArtistActionPerformed

    private void btnEmployeeEditEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeEditEmployeeActionPerformed
        Config.openCard(panelMain, "panelUpdates");
        checkboxSelectEmployee.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

        ArrayList<Object[]> arrayData = users.readUser("WHERE utype = ?", new Object[]{"employee"}, new String[]{"uid", "ulogin"});
        for (int i = 0; i < arrayData.size(); i++) {
            model.addRow(new Object[]{arrayData.get(i)[0], arrayData.get(i)[1]});
        }
    }//GEN-LAST:event_btnEmployeeEditEmployeeActionPerformed

    private void btnEmployeeEditArtistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeEditArtistActionPerformed
        Config.openCard(panelMain, "panelUpdates");
        checkboxSelectArtist.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<Object[]> arrayData = readAll("users", "uid", "uname", "utype");
//
//        for (int i = 0; i < dados.size(); i++) {
//            String[] elementos = dados.get(i).split(";");
//
//            if (elementos[2].trim().equals("artist")) {
//                Object[] newLine = {
//                    elementos[0].trim(),
//                    elementos[1].trim()
//                };
//
//                model.addRow(newLine);
//            }
//        }
    }//GEN-LAST:event_btnEmployeeEditArtistActionPerformed

    private void btnEmployeeEditAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeEditAlbumActionPerformed
        Config.openCard(panelMain, "panelUpdates");
        checkboxSelectAlbum.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<String> dados = new Database().readAll("album", "alid", "alname");
//
//        for (int i = 0; i < dados.size(); i++) {
//            Object[] newLine = {
//                dados.get(i).substring(0, dados.get(i).lastIndexOf(";")),
//                dados.get(i).substring(dados.get(i).lastIndexOf(";") + 1)
//            };
//
//            model.addRow(newLine);
//        }
    }//GEN-LAST:event_btnEmployeeEditAlbumActionPerformed

    private void btnEmployeeEditMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeEditMusicActionPerformed
        Config.openCard(panelMain, "panelUpdates");
        checkboxSelectMusic.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<String> dados = new Database().readAll("music", "mid", "mname");
//
//        for (int i = 0; i < dados.size(); i++) {
//            Object[] newLine = {
//                dados.get(i).substring(0, dados.get(i).lastIndexOf(";")),
//                dados.get(i).substring(dados.get(i).lastIndexOf(";") + 1)
//            };
//
//            model.addRow(newLine);
//        }
    }//GEN-LAST:event_btnEmployeeEditMusicActionPerformed

    private void btnEmployeeCreateMusicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeCreateMusicActionPerformed
        Config.openCard(panelMain, "panelCreateMusic");
    }//GEN-LAST:event_btnEmployeeCreateMusicActionPerformed

    private void btnEmployeeEditCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeEditCategoryActionPerformed
        Config.openCard(panelMain, "panelUpdates");
        checkboxSelectCategory.setSelected(true);
        DefaultTableModel model = (DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<String> dados = new Database().readAll("category", "cid", "cname");
//
//        for (int i = 0; i < dados.size(); i++) {
//            Object[] newLine = {
//                dados.get(i).substring(0, dados.get(i).lastIndexOf(";")),
//                dados.get(i).substring(dados.get(i).lastIndexOf(";") + 1)
//            };
//
//            model.addRow(newLine);
//        }
    }//GEN-LAST:event_btnEmployeeEditCategoryActionPerformed

    private void btnSelectUpdateCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectUpdateCancelActionPerformed
        Config.openCard(panelMain, "panelEmployee");
    }//GEN-LAST:event_btnSelectUpdateCancelActionPerformed

    private void checkboxSelectAlbumStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxSelectAlbumStateChanged

    }//GEN-LAST:event_checkboxSelectAlbumStateChanged

    private void checkboxSelectAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSelectAlbumActionPerformed
        Config.openCard(panelViewUpdates, "panelViewUpdatesAlbum");
        DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<String> dados = new Database().readAll("album", "alid", "alname");
//
//        for (int i = 0; i < dados.size(); i++) {
//            Object[] newLine = {
//                dados.get(i).substring(0, dados.get(i).lastIndexOf(";")),
//                dados.get(i).substring(dados.get(i).lastIndexOf(";") + 1)
//            };
//
//            model.addRow(newLine);
//        }
    }//GEN-LAST:event_checkboxSelectAlbumActionPerformed

    private void checkboxSelectEmployeeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_checkboxSelectEmployeeStateChanged

    }//GEN-LAST:event_checkboxSelectEmployeeStateChanged

    private void checkboxSelectEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxSelectEmployeeActionPerformed
        Config.openCard(panelViewUpdates, "panelViewUpdatesEmployee");
        DefaultTableModel model = (javax.swing.table.DefaultTableModel) tableSelectedList.getModel();
        model.setRowCount(0);

//        ArrayList<String> dados = new Database().readAll("users", "uid", "uname", "utype");
//
//        for (int i = 0; i < dados.size(); i++) {
//            String[] elementos = dados.get(i).split(";");
//
//            if (elementos[2].trim().equals("employee")) {
//                Object[] newLine = {
//                    elementos[0].trim(),
//                    elementos[1].trim()
//                };
//
//                model.addRow(newLine);
//            }
//        }
    }//GEN-LAST:event_checkboxSelectEmployeeActionPerformed

    private void btnCreateCategoryEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategoryEnterActionPerformed
        String textCreateName = txtCreateCategoryName.getText().trim();

        if (!textCreateName.equals("")) {
            if (category.createCategory(textCreateName)) {
                PopUp.showNotefy("Categoria musical cadastrada com sucesso!!");
            } else {
                PopUp.showAlert("Erro ao cadastrar uma nova categoria musical.");
            }
            Config.clearTextFields(txtCreateCategoryName);

        } else {
            PopUp.showAlert("Você esqueceu de preencher algum campo!!\nPreencha-os e tente novamente.", "Oooops!!");
        }
    }//GEN-LAST:event_btnCreateCategoryEnterActionPerformed

    private void btnCreateArtistCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateArtistCancelActionPerformed
        Config.closeFrame(frameUtiliti, this);
    }//GEN-LAST:event_btnCreateArtistCancelActionPerformed

    private void btnCreateArtistEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateArtistEnterActionPerformed
        String textCreateLogin = txtCreateArtistLogin.getText().trim();
        String textCreatePassword = new String(txtCreateArtistPassword.getPassword()).trim();

        if (!textCreateLogin.equals("") && !textCreatePassword.equals("")) {
            if (users.createUser(new Object[]{textCreateLogin, textCreatePassword, "artist"})) {
                PopUp.showNotefy("Artista Cadastrado com sucesso!!");
            } else {
                PopUp.showAlert("Erro ao cadastrar o artista.");
            }
            Config.clearTextFields(txtCreateArtistLogin, txtCreateArtistPassword);

        } else {
            PopUp.showAlert("Você esqueceu de preencher algum campo!!\nPreencha-os e tente novamente.", "Oooops!!");
        }
    }//GEN-LAST:event_btnCreateArtistEnterActionPerformed

    private void btnCreateCategoryCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCategoryCancelActionPerformed
        Config.closeFrame(frameUtiliti, this);
    }//GEN-LAST:event_btnCreateCategoryCancelActionPerformed

    private void btnViewCategoryEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewCategoryEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewCategoryEditActionPerformed

    private void btnViewAlbumEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAlbumEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewAlbumEditActionPerformed

    private void btnViewArtistEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewArtistEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewArtistEditActionPerformed

    private void btnViewArtistDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewArtistDeleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewArtistDeleteActionPerformed

    private void btnViewEmployeeEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewEmployeeEditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnViewEmployeeEditActionPerformed

    private void btnCreateMusicClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMusicClearActionPerformed
        Config.clearTextFields(txtCreateMusicName, txtCreateMusicSound);
        boxCreateMusicAlbum.setSelectedItem("None");
        boxCreateMusicCategory.setSelectedItem("None");
    }//GEN-LAST:event_btnCreateMusicClearActionPerformed

    private void btnCreateMusicSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMusicSelectActionPerformed
        txtCreateMusicSound.setText(Config.fileChooser("Selecione uma Música:", "Música", "wav"));
    }//GEN-LAST:event_btnCreateMusicSelectActionPerformed

    private void btnCreateMusicEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMusicEnterActionPerformed
//        if (Config.verifyTextFields(txtCreateMusicName, txtCreateMusicSound, txtCreateMusicDuration) && boxCreateMusicAlbum.getSelectedIndex() > 0 && boxCreateMusicAlbum.getSelectedIndex() > 0) {
//
//            new Music(
//                    0,
//                    txtCreateMusicName.getText().trim(),
//                    txtCreateMusicSound.getText().trim(),
//                    txtCreateMusicDuration.getText().trim(),
//                    String.valueOf(Calendar.getInstance().get(Calendar.YEAR)),
//                    boxCreateMusicCategory.getSelectedItem().toString().trim(),
//                    boxCreateMusicAlbum.getSelectedItem().toString().trim()
//            ).createMusic();
//
//        }

        PopUp.showNotefy("Inativo!");
    }//GEN-LAST:event_btnCreateMusicEnterActionPerformed

    private void btnCreateMusicAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMusicAlbumActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar Albúm:", panelUtilitiMain, "panelCreateAlbum");
        boxCreateAlbumArtist.removeAllItems();
        boxCreateAlbumArtist.addItem("None");

        ArrayList<Object[]> arrayData = users.readUser("WHERE utype = ?", new Object[]{"artist"}, new String[]{"ulogin"});
        for (int i = 0; i < arrayData.size(); i++) {
            boxCreateAlbumArtist.addItem((String) arrayData.get(i)[0]);
        }
    }//GEN-LAST:event_btnCreateMusicAlbumActionPerformed

    private void btnCreateMusicCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateMusicCategoryActionPerformed
        Config.openFrame(frameUtiliti, "Cadastrar categoria Musical:", panelUtilitiMain, "panelCreateCategory");
    }//GEN-LAST:event_btnCreateMusicCategoryActionPerformed

    private void tableSelectedListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSelectedListMouseClicked
        if (evt.getClickCount() == 2) {
//            int row = tableSelectedList.getSelectedRow();
//            int selectedId = Integer.parseInt(tableSelectedList.getValueAt(row, 0).toString());
//
//            if (checkboxSelectArtist.isSelected()) {
//                ArrayList<String> dados = new Database().readAllForWhere("users", "uid", selectedId, "uid", "uname", "utel", "ulogin", "upassword", "utype");
//
//                for (int i = 0; i < dados.size(); i++) {
//                    String[] elementos = dados.get(i).split(";");
//
//                    if (elementos[5].trim().equals("employee")) {
//                        txtViewArtistId.setText(elementos[0]);
//                        txtViewArtistName.setText(elementos[1]);
//                        txtViewArtistTel.setText(elementos[2]);
//                        txtViewArtistLogin.setText(elementos[3]);
//                        txtViewArtistPassword.setText(elementos[4]);
//                    }
//                }
//
//            } else if (checkboxSelectEmployee.isSelected()) {
//                ArrayList<String> dados = new Database().readAllForWhere("users", "uid", selectedId, "uid", "uname", "utel", "ulogin", "upassword", "utype");
//
//                for (int i = 0; i < dados.size(); i++) {
//                    String[] elementos = dados.get(i).split(";");
//
//                    if (elementos[5].trim().equals("artist")) {
//                        txtViewEmployeeId.setText(elementos[0]);
//                        txtViewEmployeeName.setText(elementos[1]);
//                        txtViewEmployeeTel.setText(elementos[2]);
//                        txtViewEmployeeLogin.setText(elementos[3]);
//                        txtViewEmployeePassword.setText(elementos[4]);
//                    }
//                }
//
//            } else if (checkboxSelectCategory.isSelected()) {
//                ArrayList<String> dados = new Database().readAllForWhere("category", "cid", selectedId, "cid", "cnmae");
//
//                for (int i = 0; i < dados.size(); i++) {
//                    String[] elementos = dados.get(i).split(";");
//
//                    txtViewCategoryId.setText(elementos[0]);
//                    txtViewCategoryName.setText(elementos[1]);
//                }
//
//            } else if (checkboxSelectMusic.isSelected()) {
//                ArrayList<Object[]> dados = new Database().readAllMusic(selectedId);
//
//                for (int i = 0; i < dados.size(); i++) {
//                    Object[] abacate = dados.get(i);
//                    txtViewMusicId.setText((String) abacate[0]);
//                    txtViewCategoryName.setText((String) abacate[1]);
//                }
//
//            } else if (checkboxSelectAlbum.isSelected()) {
//
//            }
            PopUp.showNotefy("Inativo!!");
        }
    }//GEN-LAST:event_tableSelectedListMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> boxCreateAlbumArtist;
    private javax.swing.JComboBox<String> boxCreateMusicAlbum;
    private javax.swing.JComboBox<String> boxCreateMusicCategory;
    private javax.swing.JComboBox<String> boxViewAlbumArtist;
    private javax.swing.JComboBox<String> boxViewMusicAlbum;
    private javax.swing.JComboBox<String> boxViewMusicCategory;
    private javax.swing.JButton btnCreateAlbumCancel;
    private javax.swing.JButton btnCreateAlbumEnter;
    private javax.swing.JButton btnCreateArtistCancel;
    private javax.swing.JButton btnCreateArtistEnter;
    private javax.swing.JButton btnCreateCategoryCancel;
    private javax.swing.JButton btnCreateCategoryEnter;
    private javax.swing.JButton btnCreateEmployeeCancel;
    private javax.swing.JButton btnCreateEmployeeEnter;
    private javax.swing.JButton btnCreateMusicAlbum;
    private javax.swing.JButton btnCreateMusicCategory;
    private javax.swing.JButton btnCreateMusicClear;
    private javax.swing.JButton btnCreateMusicEnter;
    private javax.swing.JButton btnCreateMusicSelect;
    private javax.swing.JButton btnEmployeeCreateAlbum;
    private javax.swing.JButton btnEmployeeCreateArtist;
    private javax.swing.JButton btnEmployeeCreateCategory;
    private javax.swing.JButton btnEmployeeCreateEmployee;
    private javax.swing.JButton btnEmployeeCreateMusic;
    private javax.swing.JButton btnEmployeeEditAlbum;
    private javax.swing.JButton btnEmployeeEditArtist;
    private javax.swing.JButton btnEmployeeEditCategory;
    private javax.swing.JButton btnEmployeeEditEmployee;
    private javax.swing.JButton btnEmployeeEditMusic;
    private javax.swing.JButton btnMenuEmployee;
    private javax.swing.JButton btnMenuMusic;
    private javax.swing.JButton btnPlayerBack;
    private javax.swing.JButton btnPlayerControl;
    private javax.swing.JButton btnPlayerNext;
    private javax.swing.JButton btnPlayerVolume;
    private javax.swing.JButton btnSelectUpdateCancel;
    private javax.swing.JButton btnViewAlbumDelete;
    private javax.swing.JButton btnViewAlbumEdit;
    private javax.swing.JButton btnViewAlbumRefresh;
    private javax.swing.JButton btnViewArtistDelete;
    private javax.swing.JButton btnViewArtistEdit;
    private javax.swing.JButton btnViewArtistRefresh;
    private javax.swing.JButton btnViewCategoryDelete;
    private javax.swing.JButton btnViewCategoryEdit;
    private javax.swing.JButton btnViewCategoryRefresh;
    private javax.swing.JButton btnViewEmployeeDelete;
    private javax.swing.JButton btnViewEmployeeEdit;
    private javax.swing.JButton btnViewEmployeeRefresh;
    private javax.swing.JButton btnViewMusicDelete;
    private javax.swing.JButton btnViewMusicEdit;
    private javax.swing.JButton btnViewMusicRefresh;
    private javax.swing.JButton btnViewMusicSelect;
    private javax.swing.ButtonGroup checkboxGroupUpdate;
    private javax.swing.JCheckBox checkboxSelectAlbum;
    private javax.swing.JCheckBox checkboxSelectArtist;
    private javax.swing.JCheckBox checkboxSelectCategory;
    private javax.swing.JCheckBox checkboxSelectEmployee;
    private javax.swing.JCheckBox checkboxSelectMusic;
    private javax.swing.JFrame frameUtiliti;
    private javax.swing.JLabel labelCreateAlbum1;
    private javax.swing.JLabel labelCreateAlbum2;
    private javax.swing.JLabel labelCreateAlbum3;
    private javax.swing.JLabel labelCreateAlbumLogo;
    private javax.swing.JLabel labelCreateArtist1;
    private javax.swing.JLabel labelCreateArtist2;
    private javax.swing.JLabel labelCreateArtist3;
    private javax.swing.JLabel labelCreateArtist4;
    private javax.swing.JLabel labelCreateArtist5;
    private javax.swing.JLabel labelCreateArtistLogo;
    private javax.swing.JLabel labelCreateCategory1;
    private javax.swing.JLabel labelCreateCategory2;
    private javax.swing.JLabel labelCreateCategory3;
    private javax.swing.JLabel labelCreateCategoryLogo;
    private javax.swing.JLabel labelCreateEmployee1;
    private javax.swing.JLabel labelCreateEmployee2;
    private javax.swing.JLabel labelCreateEmployee3;
    private javax.swing.JLabel labelCreateEmployee4;
    private javax.swing.JLabel labelCreateEmployee5;
    private javax.swing.JLabel labelCreateEmployeeLogo;
    private javax.swing.JLabel labelCreateMusic1;
    private javax.swing.JLabel labelCreateMusic2;
    private javax.swing.JLabel labelCreateMusic3;
    private javax.swing.JLabel labelCreateMusic4;
    private javax.swing.JLabel labelCreateMusic5;
    private javax.swing.JLabel labelCreateMusic6;
    private javax.swing.JLabel labelCreateMusic7;
    private javax.swing.JLabel labelEmployee1;
    private javax.swing.JLabel labelEmployee2;
    private javax.swing.JLabel labelMenuLogo;
    private javax.swing.JLabel labelPLayerMusic;
    private javax.swing.JLabel labelPlayerTime;
    private javax.swing.JLabel labelPlayerTimeDuraction;
    private javax.swing.JLabel labelSelectUpdate1;
    private javax.swing.JLabel labelSelectUpdate2;
    private javax.swing.JLabel labelViewAlbum1;
    private javax.swing.JLabel labelViewAlbum2;
    private javax.swing.JLabel labelViewAlbum3;
    private javax.swing.JLabel labelViewAlbumName;
    private javax.swing.JLabel labelViewArtist1;
    private javax.swing.JLabel labelViewArtist2;
    private javax.swing.JLabel labelViewArtist3;
    private javax.swing.JLabel labelViewArtist4;
    private javax.swing.JLabel labelViewArtist5;
    private javax.swing.JLabel labelViewArtist6;
    private javax.swing.JLabel labelViewCategory1;
    private javax.swing.JLabel labelViewCategory2;
    private javax.swing.JLabel labelViewCategory3;
    private javax.swing.JLabel labelViewEmployee1;
    private javax.swing.JLabel labelViewEmployee2;
    private javax.swing.JLabel labelViewEmployee3;
    private javax.swing.JLabel labelViewEmployee4;
    private javax.swing.JLabel labelViewEmployee5;
    private javax.swing.JLabel labelViewEmployee6;
    private javax.swing.JLabel labelViewMusic1;
    private javax.swing.JLabel labelViewMusic2;
    private javax.swing.JLabel labelViewMusic4;
    private javax.swing.JLabel labelViewMusic5;
    private javax.swing.JLabel labelViewMusic6;
    private javax.swing.JLabel labelViewMusic7;
    private javax.swing.JLabel labelViewMusic8;
    private javax.swing.JLabel labelViewMusic9;
    private javax.swing.JPanel panelCreateAlbum;
    private javax.swing.JPanel panelCreateArtist;
    private javax.swing.JPanel panelCreateCategory;
    private javax.swing.JPanel panelCreateEmployee;
    private javax.swing.JPanel panelCreateMusic;
    private javax.swing.JPanel panelEmployee;
    private javax.swing.JPanel panelMain;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuLogo;
    private javax.swing.JPanel panelPlayer;
    private javax.swing.JPanel panelPlayerController;
    private javax.swing.JPanel panelPlayerVolume;
    private javax.swing.JPanel panelSelectUpdates;
    private javax.swing.JPanel panelUpdates;
    private javax.swing.JPanel panelUtilitiMain;
    private javax.swing.JPanel panelViewUpdates;
    private javax.swing.JPanel panelViewUpdatesAlbum;
    private javax.swing.JPanel panelViewUpdatesArtist;
    private javax.swing.JPanel panelViewUpdatesCategory;
    private javax.swing.JPanel panelViewUpdatesEmployee;
    private javax.swing.JPanel panelViewUpdatesMusic;
    private javax.swing.JScrollPane scrollSelectedList;
    private javax.swing.JSlider sliderPlayerMusic;
    private javax.swing.JSlider sliderPlayerVolume;
    private javax.swing.JTable tableSelectedList;
    private javax.swing.JTextField txtCreateAlbumName;
    private javax.swing.JTextField txtCreateArtistLogin;
    private javax.swing.JTextField txtCreateArtistName;
    private javax.swing.JPasswordField txtCreateArtistPassword;
    private javax.swing.JFormattedTextField txtCreateArtistTel;
    private javax.swing.JTextField txtCreateCategoryName;
    private javax.swing.JTextField txtCreateEmployeeLogin;
    private javax.swing.JTextField txtCreateEmployeeName;
    private javax.swing.JPasswordField txtCreateEmployeePassword;
    private javax.swing.JFormattedTextField txtCreateEmployeeTel;
    private javax.swing.JFormattedTextField txtCreateMusicDuration;
    private javax.swing.JFormattedTextField txtCreateMusicDuration1;
    private javax.swing.JTextField txtCreateMusicName;
    private javax.swing.JTextField txtCreateMusicSound;
    private javax.swing.JTextField txtViewAlbumId;
    private javax.swing.JTextField txtViewAlbumName;
    private javax.swing.JTextField txtViewArtistId;
    private javax.swing.JTextField txtViewArtistLogin;
    private javax.swing.JTextField txtViewArtistName;
    private javax.swing.JPasswordField txtViewArtistPassword;
    private javax.swing.JFormattedTextField txtViewArtistTel;
    private javax.swing.JTextField txtViewCategoryId;
    private javax.swing.JTextField txtViewCategoryName;
    private javax.swing.JTextField txtViewEmployeeId;
    private javax.swing.JTextField txtViewEmployeeLogin;
    private javax.swing.JTextField txtViewEmployeeName;
    private javax.swing.JPasswordField txtViewEmployeePassword;
    private javax.swing.JFormattedTextField txtViewEmployeeTel;
    private javax.swing.JTextField txtViewMusicId;
    private javax.swing.JTextField txtViewMusicName;
    private javax.swing.JTextField txtViewMusicSound;
    private javax.swing.JTextField txtViewMusicYear;
    // End of variables declaration//GEN-END:variables

    public void panelMusic() {
        boxCreateMusicAlbum.removeAllItems();
        boxCreateMusicAlbum.addItem("None");
        ArrayList<Object[]> arrayData = album.readAlbum(null, null, new String[]{"alname"});
        for (int i = 0; i < arrayData.size(); i++) {
            boxCreateMusicAlbum.addItem((String) arrayData.get(i)[0]);
        }

        boxCreateMusicCategory.removeAllItems();
        boxCreateMusicCategory.addItem("None");
        arrayData = category.readCategory(null, null, new String[]{"cname"});
        for (int i = 0; i < arrayData.size(); i++) {
            boxCreateMusicCategory.addItem((String) arrayData.get(i)[0]);
        }

        Config.openCard(panelMain, "panelCreateMusic");
    }
}

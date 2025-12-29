package com.mycompany.data_mahasiswa;
        
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Data_Mahasiswa extends javax.swing.JFrame {

    DefaultTableModel model;
    private int currentId = -1;  // Menyimpan ID yang sedang diedit

    public Data_Mahasiswa() {
        initComponents();
        initTable();
        loadData();
    }
    
    // ================= KONEKSI DATABASE =================
    private Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/datamahasiswa?useSSL=false&allowPublicKeyRetrieval=true",
                "root",// usename
                "" // password mysql
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + e.getMessage());
        }
        return conn;
    }

    // ================= LOAD DATA =================
    private void loadData() {
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM data_mahasiswa";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getString("jurusan"),
                    rs.getString("alamat"),
                    rs.getString("no_telpon"),
                    rs.getString("fakultas"),
                    rs.getString("universitas"),
                    rs.getString("bidang_perminatan")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("NIM");
        model.addColumn("Jurusan");
        model.addColumn("Alamat");
        model.addColumn("No HP");
        model.addColumn("Fakultas");
        model.addColumn("Universitas");
        model.addColumn("Bidang Perminatan");
        tableMahasiswa.setModel(model);
    }

    private void clearForm() {
        txtNama.setText("");
        txtNim.setText("");
        cmbJurusan.setSelectedIndex(0);
        txtAlamat.setText("");
        txtNoHp.setText("");
        txtFakultas.setText("");
        txtUniversitas.setText("");
        txtBidangPerminatan.setText("");
        tableMahasiswa.clearSelection();
        currentId = -1;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cmbJurusan = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNoHp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtFakultas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtUniversitas = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtBidangPerminatan = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data Mahasiswa");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Data Mahasiswa"));

        jLabel1.setText("Nama");
        jLabel2.setText("NIM");
        jLabel3.setText("Jurusan");
        jLabel4.setText("Alamat");
        jLabel5.setText("No Handphone");
        jLabel6.setText("Fakultas");
        jLabel7.setText("Universitas");
        jLabel8.setText("Bidang Perminatan");

        cmbJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(
            new String[] { "Teknik Informatika", "Sistem Informasi", "Bisnis", "Manajemen", "Lainnya" }
        ));

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(evt -> btnTambahActionPerformed(evt));

        btnEdit.setText("Edit");
        btnEdit.addActionListener(evt -> btnEditActionPerformed(evt));

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(evt -> btnHapusActionPerformed(evt));

        btnClear.setText("Clear");
        btnClear.addActionListener(evt -> clearForm());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNama)
                    .addComponent(txtNim)
                    .addComponent(cmbJurusan)
                    .addComponent(txtAlamat)
                    .addComponent(txtNoHp)
                    .addComponent(txtFakultas)
                    .addComponent(txtUniversitas)
                    .addComponent(txtBidangPerminatan, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnClear))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNama)
                    .addComponent(btnTambah))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNim)
                    .addComponent(btnEdit))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbJurusan))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAlamat)
                    .addComponent(btnHapus))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNoHp)
                    .addComponent(btnClear))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFakultas))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtUniversitas))
                .addGap(10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBidangPerminatan))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tableMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tableMahasiswa.getSelectedRow();
                currentId = Integer.parseInt(model.getValueAt(row, 0).toString());
                txtNama.setText(model.getValueAt(row, 1).toString());
                txtNim.setText(model.getValueAt(row, 2).toString());
                cmbJurusan.setSelectedItem(model.getValueAt(row, 3).toString());
                txtAlamat.setText(model.getValueAt(row, 4).toString());
                txtNoHp.setText(model.getValueAt(row, 5).toString());
                txtFakultas.setText(model.getValueAt(row, 6).toString());
                txtUniversitas.setText(model.getValueAt(row, 7).toString());
                txtBidangPerminatan.setText(model.getValueAt(row, 8).toString());
            }
        });

        jScrollPane1.setViewportView(tableMahasiswa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>

    // ================= CRUD =================
    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {
        // Validasi semua field required
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtNim.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "NIM hanya boleh berisi angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cmbJurusan.getSelectedIndex() == -1 || cmbJurusan.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jurusan wajib dipilih!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNoHp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Handphone wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtNoHp.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "No Handphone hanya boleh berisi angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtFakultas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fakultas wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtUniversitas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Universitas wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtBidangPerminatan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bidang Perminatan wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO data_mahasiswa VALUES (?,?,?,?,?,?,?,?,?)";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, null);
            ps.setString(2, txtNama.getText());
            ps.setString(3, txtNim.getText());
            ps.setString(4, cmbJurusan.getSelectedItem().toString());
            ps.setString(5, txtAlamat.getText());
            ps.setString(6, txtNoHp.getText());
            ps.setString(7, txtFakultas.getText());
            ps.setString(8, txtUniversitas.getText());
            ps.setString(9, txtBidangPerminatan.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            loadData();
            clearForm();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {
        // Validasi semua field required
        if (txtNama.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nama wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNim.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "NIM wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (cmbJurusan.getSelectedIndex() == -1 || cmbJurusan.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Jurusan wajib dipilih!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtAlamat.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Alamat wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtNoHp.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No Handphone wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!txtNoHp.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "No Handphone hanya boleh berisi angka!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtFakultas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fakultas wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtUniversitas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Universitas wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (txtBidangPerminatan.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bidang Perminatan wajib diisi!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (currentId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE data_mahasiswa SET nama=?, nim=?, jurusan=?, alamat=?, no_telpon=?, fakultas=?, universitas=?, bidang_perminatan=? WHERE id=?";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txtNama.getText());
            ps.setString(2, txtNim.getText());
            ps.setString(3, cmbJurusan.getSelectedItem().toString());
            ps.setString(4, txtAlamat.getText());
            ps.setString(5, txtNoHp.getText());
            ps.setString(6, txtFakultas.getText());
            ps.setString(7, txtUniversitas.getText());
            ps.setString(8, txtBidangPerminatan.getText());
            ps.setInt(9, currentId);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
                loadData();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal mengupdate data!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            }
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {
        // Validasi ID untuk identifikasi data
        if (currentId == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data dari tabel terlebih dahulu!", "Validasi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String sql = "DELETE FROM data_mahasiswa WHERE id=?";
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, currentId);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            loadData();
            clearForm();
            ps.close();
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Data_Mahasiswa().setVisible(true));
    }

    // Variables declaration
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cmbJurusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableMahasiswa;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtBidangPerminatan;
    private javax.swing.JTextField txtFakultas;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtUniversitas;
}
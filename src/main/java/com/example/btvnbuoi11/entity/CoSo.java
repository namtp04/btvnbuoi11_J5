package com.example.btvnbuoi11.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "co_so")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CoSo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "tai_khoan_ngan_hang_id",referencedColumnName = "id")
    private TaiKhoanNganHang taiKhoanNganHang;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten_co_so")
    private String tenCoSo;

    @Column(name = "ho_ten_nguoi_dai_dien")
    private String hoTenNguoiDaiDien;

    @Column(name = "ma_so_thue")
    private String maSoThue;

    @Column(name = "so_dien_thoai")
    private String soDienThoai;

    @Column(name = "email")
    private String email;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "ten_tinh")
    private String tenTinh;

    @Column(name = "ten_thanh_pho")
    private String tenThanhPho;

    @Column(name = "ten_quan_huyen")
    private String tenQuanHuyen;

    @Column(name = "trang_thai")
    private Integer trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "ngay_chinh_sua")
    @Temporal(TemporalType.DATE)
    private Date ngayChinhSua;
}

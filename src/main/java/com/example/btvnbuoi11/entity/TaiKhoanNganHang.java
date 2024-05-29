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
@Table(name = "tai_khoan_ngan_hang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaiKhoanNganHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ho_ten_chu_tai_khoan")
    private String hoTenChuTaiKhoan;

    @Column(name = "so_tai_khoan")
    private String soTaiKhoan;

    @Column(name = "ten_ngan_hang")
    private String tenNganHang;

    @Column(name = "ten_chi_nhanh")
    private String tenChiNhanh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "ghi_chu")
    private String ghiChu;

    @Column(name = "trang_thai")
    private String trangThai;

    @Column(name = "ngay_tao")
    @Temporal(TemporalType.DATE)
    private Date ngayTao;

    @Column(name = "ngay_sua")
    @Temporal(TemporalType.DATE)
    private Date ngaySua;
}

package com.example.btvnbuoi11.repository;

import com.example.btvnbuoi11.entity.TaiKhoanNganHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanNganHangRepository extends JpaRepository<TaiKhoanNganHang,Integer> {
    TaiKhoanNganHang findTaiKhoanNganHangById(Integer id);
}

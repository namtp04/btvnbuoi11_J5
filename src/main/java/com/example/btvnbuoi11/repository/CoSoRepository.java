package com.example.btvnbuoi11.repository;

import com.example.btvnbuoi11.entity.CoSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoSoRepository extends JpaRepository<CoSo,Integer> {
    CoSo findCoSoById(Integer id);
}

package com.karyawan.karyawan.repositories;

import com.karyawan.karyawan.models.Tetap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TetapRepository extends JpaRepository<Tetap,Long> {
}

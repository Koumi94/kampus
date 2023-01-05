package com.e.campus.repository;

import com.e.campus.model.Ogrenci;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OgrenciRepository extends JpaRepository< Ogrenci, String> {


}

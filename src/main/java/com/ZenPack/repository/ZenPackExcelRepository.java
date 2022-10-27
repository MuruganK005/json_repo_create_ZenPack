package com.ZenPack.repository;

import com.ZenPack.model.ZenPack;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZenPackExcelRepository extends JpaRepository<ZenPack,Long> {
}

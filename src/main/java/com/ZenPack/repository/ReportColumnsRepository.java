package com.ZenPack.repository;

import com.ZenPack.model.ReportColumns;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportColumnsRepository extends JpaRepository<ReportColumns,Long> {

}

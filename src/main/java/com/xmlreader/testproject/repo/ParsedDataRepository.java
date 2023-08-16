package com.xmlreader.testproject.repo;

import com.xmlreader.testproject.entity.ParsedDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParsedDataRepository extends JpaRepository<ParsedDataEntity, Long> {

}


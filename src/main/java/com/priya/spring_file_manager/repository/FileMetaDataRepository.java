package com.priya.spring_file_manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.priya.spring_file_manager.model.FileMetaData;

@Repository
public interface FileMetaDataRepository extends JpaRepository<FileMetaData, Integer>{
	FileMetaData findByUniqueId(String uniqueId);
}

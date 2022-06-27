package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Attachment;
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer>{

	

	Optional<Attachment> findById(String fileId);

}

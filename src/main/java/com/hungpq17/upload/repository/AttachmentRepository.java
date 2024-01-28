package com.hungpq17.upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hungpq17.upload.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}

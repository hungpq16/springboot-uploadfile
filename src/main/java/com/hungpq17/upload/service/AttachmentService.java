package com.hungpq17.upload.service;

import org.springframework.web.multipart.MultipartFile;

import com.hungpq17.upload.entity.Attachment;

public interface AttachmentService {

    Attachment saveAttachment(MultipartFile file) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

}

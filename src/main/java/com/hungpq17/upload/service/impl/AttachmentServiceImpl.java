package com.hungpq17.upload.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hungpq17.upload.entity.Attachment;
import com.hungpq17.upload.repository.AttachmentRepository;
import com.hungpq17.upload.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid path sequnce " + fileName);
            }

            // set content file
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save File: " + fileName);
        }
    }

    @Override
    public Attachment getAttachment(String fileId) throws Exception {
        return attachmentRepository.findById(fileId)
                .orElseThrow(() -> new Exception("File not found with Id: " + fileId));
    }

}

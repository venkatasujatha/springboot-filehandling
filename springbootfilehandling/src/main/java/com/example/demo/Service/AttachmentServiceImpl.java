package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Model.ResponseData;
import com.example.demo.Repository.AttachmentRepository;
import com.example.demo.entity.Attachment;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	@Autowired
	private AttachmentRepository attachmentRepository;

	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
		String filename = StringUtils.cleanPath(file.getOriginalFilename());
		try
		{
		if(filename.contains(".."))
		{
			throw new Exception("filename contains invalid sequence"+filename);
		}
		
		Attachment attachment=new Attachment(0,filename,
				file.getContentType(),
				file.getBytes());
		return attachmentRepository.save(attachment);
	}
		catch (Exception e) {
			
			throw new Exception("could not load the file"+filename);
		}
		
	}

	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		
		return attachmentRepository.findById(fileId).orElseThrow(()->new Exception("file not found with id"+fileId));
	}
}



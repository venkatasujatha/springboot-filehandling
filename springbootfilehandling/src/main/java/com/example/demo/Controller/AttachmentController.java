package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.Model.ResponseData;
import com.example.demo.Service.AttachmentService;
import com.example.demo.entity.Attachment;
import com.example.demo.helper.FileUploadHelper;

@RestController
public class AttachmentController {
	
	@Autowired
	private AttachmentService attachmentService;
	
	
	public AttachmentController(AttachmentService attachmentService)
	{
		this.attachmentService=attachmentService;
	}
	
	@Autowired
	FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws Exception
	{
		/*
		 * Attachment attachment=null; String downloadURL=null;
		 * attachment=attachmentService.saveAttachment(file); downloadURL =
		 * ServletUriComponentsBuilder.fromCurrentContextPath() .path("/download/")
		 * .path(attachment.getFilename()) .toUriString();
		 * 
		 * return new
		 * ResponseData(attachment.getFilename(),downloadURL,file.getContentType(),file.
		 * getSize());
		 */
		
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		System.out.println(file.getSize());
		System.out.println(file.getBytes());
		
		//validation
		try {
			
		
		if(file.isEmpty())
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("request must contain file");
		}
		if(!file.getContentType().equals("image/jpeg"))
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("only JPEG content type is allowed");
		}
		
		//FILE UPLOAD CODE
		boolean f = fileUploadHelper.uploadFile(file);
		if(f)
		{
			// FOR STATIC PATH
			//return ResponseEntity.ok("file successfully uploaded");
			
			//FOR DYNAMIC PATH
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/images/").path(file.getOriginalFilename()).toUriString());
		}
		
	}
		catch (Exception e) {
			// TODO: handle exception
		}
	
	
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong !try again");
	}
	
	@GetMapping("/download/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception
	{
		Attachment attachment=null;
		attachment=attachmentService.getAttachment(fileId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(attachment.getFiletype()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\""+attachment.getFilename()+"\"")
				.body(new ByteArrayResource(attachment.getData()));
	}
}

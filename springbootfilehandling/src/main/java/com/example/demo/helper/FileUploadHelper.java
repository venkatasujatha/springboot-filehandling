package com.example.demo.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.aspectj.apache.bcel.util.ClassPath;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	//STATIC PATH DIR
	//public final String UPLOAD_DIR="/home/tectoro/Core java/cloud-gateway/springbootfilehandling/src/main/resources/static/images";
	
	//DYNAMIC PATH DIR
	public final String UPLOAD_DIR=new ClassPathResource("static/images").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException
	{
		
	}
	public boolean uploadFile(MultipartFile multipartFile)
	{
		boolean f=false;
		try {
			//read
			
			InputStream stream = multipartFile.getInputStream();
			byte[] bs = new byte[stream.available()];
			stream.read(bs);
			
			//write
			/*
			 * FileOutputStream fileOutputStream=new
			 * FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
			 * System.out.println(fileOutputStream); fileOutputStream.write(bs);
			 * fileOutputStream.flush(); fileOutputStream.close(); f=true;
			 */
			//or
			
			//write
			
			Files.copy(multipartFile.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			f=true;
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return f;
		
	}

}

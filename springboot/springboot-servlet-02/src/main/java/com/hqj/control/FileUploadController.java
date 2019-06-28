package com.hqj.control;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 * 
 * @author huangqj
 * @see （1）定义文件：指定文件上传大小，src/main/resources/application.properties
 */
@RestController // 该类下的方法的返回值格式是json格式
public class FileUploadController {

	/**
	 * 上传文件
	 * 
	 * @param filename
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping("/fileUploadController")
	public Map<String, Object> fileUpload(MultipartFile filename) throws IllegalStateException, IOException {
		System.out.println(filename.getOriginalFilename());
		// 保存文件
		filename.transferTo(new File("f:/" + filename.getOriginalFilename()));
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "上传成功");
		return map;
	}
}

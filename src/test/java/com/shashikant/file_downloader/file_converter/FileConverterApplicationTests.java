package com.shashikant.file_downloader.file_converter;

import com.shashikant.file_downloader.file_converter.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FileConverterApplicationTests {

	@Autowired
	private UserRepo userRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCategoryRepo(){
		System.out.println("Test Started");
		userRepo.findAll().forEach(ur-> System.out.println(ur.getName()));

	}

}

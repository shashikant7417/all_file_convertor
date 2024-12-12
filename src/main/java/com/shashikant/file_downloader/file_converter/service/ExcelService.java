package com.shashikant.file_downloader.file_converter.service;

import com.shashikant.file_downloader.file_converter.helper.Helper;
import com.shashikant.file_downloader.file_converter.models.User;
import com.shashikant.file_downloader.file_converter.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {

    @Autowired
    private UserRepo userRepo;


    public ByteArrayInputStream getActualData() throws IOException {
         List<User> userList = userRepo.findAll();

         ByteArrayInputStream byteArrayInputStream = Helper.dataToExcel(userList);
         return byteArrayInputStream;
    }

}

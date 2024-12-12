package com.shashikant.file_downloader.file_converter.repo;

import com.shashikant.file_downloader.file_converter.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}

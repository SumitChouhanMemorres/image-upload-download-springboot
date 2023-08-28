package com.springbootproject.imageuploaddownload;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProjectImageRepository extends JpaRepository<ProductImage, Long> {
    Optional<ProductImage> findByName(String fileName);
}

package com.springbootproject.imageuploaddownload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ProductImageService {
    @Autowired
    private ProjectImageRepository imageRepo;

    public void uploadImage(MultipartFile file) throws IOException{
        ProductImage pImage = new ProductImage();
        pImage.setName(file.getOriginalFilename());
        pImage.setType(file.getContentType());
        pImage.setImageData(ImageUtil.compressImage(file.getBytes()));
        imageRepo.save(pImage);
    }

    public byte[] downloadImage(String fileName){
        Optional<ProductImage> imageData = imageRepo.findByName(fileName);
        return ImageUtil.decompressImage(imageData.get().getImageData());
    }

}

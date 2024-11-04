package com.Ecommerce.ByCart.Service.Image;

import com.Ecommerce.ByCart.DTO.ImageDTO;
import com.Ecommerce.ByCart.Model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDTO> saveImage(List<MultipartFile> file, Long productId);
    void updateImage(MultipartFile file,Long imageId);

}

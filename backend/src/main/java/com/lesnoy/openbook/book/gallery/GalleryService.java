package com.lesnoy.openbook.book.gallery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GalleryService {

    private final GalleyRepository galleryRepository;

    @Transactional
    public void saveGallery(int bookId, List<String> imageList) {
        for (String image : imageList) {
            galleryRepository.save(new GalleryImage(bookId, image));
        }
    }
}

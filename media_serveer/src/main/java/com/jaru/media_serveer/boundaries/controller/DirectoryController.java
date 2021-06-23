package com.jaru.media_serveer.boundaries.controller;

import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/media/admin")
public class DirectoryController {

    @PostMapping("/directory")
    public ResponseEntity createDir(@RequestBody @Valid RequestDirectoryDto requestDirectoryDto) {
        return null;
    };

}

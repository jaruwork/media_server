package com.jaru.media_serveer.boundaries.controller;

import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;
import com.jaru.media_serveer.boundaries.Dto.ResponseDirectoryDto;
import com.jaru.media_serveer.core.usecase.directory.CheckDirSpaceUsecase;
import com.jaru.media_serveer.core.usecase.directory.CreateDirUsecase;
import com.jaru.media_serveer.core.usecase.directory.CreateDirUsecaseImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/media/admin")
public class DirectoryController {

    private final CreateDirUsecase createDirUsecase;
    private final CheckDirSpaceUsecase checkDirSpaceUsecase;

    @PostMapping("/directory")
    public ResponseEntity createDir(@RequestBody @Valid RequestDirectoryDto requestDirectoryDto) {
        createDirUsecase.execute(requestDirectoryDto);

        return ResponseEntity.noContent().build();
    };

    @PostMapping("/checkSpace")
    public ResponseDirectoryDto checkSpace(@RequestBody @Valid RequestDirectoryDto requestDirectoryDto) {

        return checkDirSpaceUsecase.execute(requestDirectoryDto);
    }
}

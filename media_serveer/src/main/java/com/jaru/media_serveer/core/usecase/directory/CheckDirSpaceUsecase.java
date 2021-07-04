package com.jaru.media_serveer.core.usecase.directory;

import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;
import com.jaru.media_serveer.boundaries.Dto.ResponseDirectoryDto;

public interface CheckDirSpaceUsecase {

    public ResponseDirectoryDto execute(RequestDirectoryDto requestDirectoryDto);
}

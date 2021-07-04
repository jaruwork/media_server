package com.jaru.media_serveer.core.usecase.directory;

import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;

public interface CreateDirUsecase {

    public boolean execute(RequestDirectoryDto requestDirectoryDto);
}

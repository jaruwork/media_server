package com.jaru.media_serveer.core.usecase.directory;

import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;
import com.jaru.media_serveer.boundaries.Dto.ResponseDirectoryDto;
import com.jaru.media_serveer.core.exception.MediaServerException;
import com.jaru.media_serveer.infra.UploadFileProperties;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class CheckDirSpaceUsecaseImpl implements CheckDirSpaceUsecase{
    private static final Logger logger = LoggerFactory.getLogger(UploadFileProperties.class);
    private final UploadFileProperties uploadFileProperties;

    @Override
    public ResponseDirectoryDto execute(RequestDirectoryDto requestDirectoryDto) {

        try{
            if(uploadFileProperties.checkLoadDir(requestDirectoryDto))
                return uploadFileProperties.checkUploadDirSpace(requestDirectoryDto);
            else
                throw new MediaServerException("Internal server error");
        }catch (IOException ioex) {
            logger.error(ioex.getLocalizedMessage());
            throw new MediaServerException(ioex.getMessage(), ioex);
        }
    }
}

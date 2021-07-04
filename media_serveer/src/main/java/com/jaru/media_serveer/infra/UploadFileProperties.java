package com.jaru.media_serveer.infra;

import com.jaru.media_serveer.Util.FileUtils;
import com.jaru.media_serveer.boundaries.Dto.RequestDirectoryDto;
import com.jaru.media_serveer.boundaries.Dto.ResponseDirectoryDto;
import com.jaru.media_serveer.core.exception.NotDirectoryException;
import com.jaru.media_serveer.core.exception.NotExistDirectoryException;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.io.File;
import java.io.IOException;

@Getter
@Configuration
public class UploadFileProperties {
    private static final Logger logger = LoggerFactory.getLogger(UploadFileProperties.class);

    @Value("${file.upload-dir}")
    private String uploadDir;

    public boolean checkLoadDir(RequestDirectoryDto requestDirectoryDto) throws IOException {
        File uploadDirectory = new File(uploadDir + requestDirectoryDto.getDirectoryName());
        if(!uploadDirectory.exists()){
            throw new NotExistDirectoryException(HttpStatus.INTERNAL_SERVER_ERROR, "Not Exist directory " + uploadDirectory.getPath());
        }
        if(!uploadDirectory.isDirectory()) {
            throw new NotDirectoryException(HttpStatus.INTERNAL_SERVER_ERROR, "Not directory '" + uploadDirectory.getPath());
        }
        if (uploadDirectory.isHidden()) {
            throw new NotDirectoryException(HttpStatus.INTERNAL_SERVER_ERROR, "This directory is hidden dir '" + uploadDirectory.getPath() + "'");
        }
        if(!uploadDirectory.canWrite()) {
            logger.error("Current path can not write " +
                    "Check Path: " + uploadDirectory.getPath());
            return false;
        }
        if(!uploadDirectory.canRead()) {
            logger.error("Current path can not read " +
                    "Check Path: " + uploadDirectory.getPath());
            return false;
        }

        return true;
    }

    public ResponseDirectoryDto checkUploadDirSpace(RequestDirectoryDto requestDirectoryDto) throws IOException{
        File directory = new File(uploadDir + requestDirectoryDto.getDirectoryName());
        String totalSpace = FileUtils.readableFileSizeUnit(directory.getTotalSpace());
        String usedSPace = FileUtils.readableFileSizeUnit(directory.getTotalSpace() - directory.getUsableSpace());

        return new ResponseDirectoryDto(uploadDir+requestDirectoryDto.getDirectoryName(), totalSpace, usedSPace);
    }
}

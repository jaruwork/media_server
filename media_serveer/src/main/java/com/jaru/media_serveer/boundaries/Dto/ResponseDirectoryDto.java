package com.jaru.media_serveer.boundaries.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDirectoryDto {
    private String directoryPath;
    private String totalSpace;
    private String usedSpace;
}

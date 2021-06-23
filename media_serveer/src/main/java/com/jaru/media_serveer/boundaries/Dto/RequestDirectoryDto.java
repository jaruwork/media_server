package com.jaru.media_serveer.boundaries.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class RequestDirectoryDto {
    @NotBlank
    @Pattern(regexp = "^/$|^(/[\\w-]+)+$", message = "Please check request param.")
    private String directoryName;
}

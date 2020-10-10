package com.pangoapi.dto.advertisementRequest;

import lombok.Getter;

@Getter
public class CreateDtoAdvertisementRequest {

    private String title;
    private String userEmail;
    private String detailDescription;
    private String advertisementType;
    private String imagePath;
    private String siteUrl;
    private String rowPosition;
    private String columnPosition;
    private String startedDate;
    private String finishedDate;
}

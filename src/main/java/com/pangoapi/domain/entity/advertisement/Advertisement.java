package com.pangoapi.domain.entity.advertisement;

import com.pangoapi.dto.advertisement.CreateDtoAdvertisement;
import com.pangoapi.domain.entity.user.User;
import com.pangoapi.dto.advertisement.UpdateDtoAdvertisement;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Entity
public class Advertisement {

    @Id @GeneratedValue
    @Column(name = "ADVERTISEMENT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADVERTISEMENT_TYPE_ID")
    private AdvertisementType advertisementType;

    private String title;
    private String detailDescription;
    private String imagePath;
    private String siteUrl;
    private Long rowPosition;
    private Long columnPosition;
    private Boolean isActivated;

    public void changeTitle(String title) {
        this.title = title;
    }

    public void changeDetailDescription(String detailDescription) {
        this.detailDescription = detailDescription;
    }

    public void changeImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void changeStieUrl(String siteUrl) { this.siteUrl = siteUrl; }

    public void changeRowPosition(Long rowPosition) { this.rowPosition = rowPosition; }

    public void changeColumnPosition(Long columnPosition) { this.columnPosition = columnPosition; }

    public void changeIsActivatedToActivated() { this.isActivated = true; }

    public void changeIsActivatedToDeactivated() { this.isActivated = false; }

    /**
     * @name changeAdvertisement
     * @description
     * 사용자가 업데이트 요청할 수 있는 필드/메소드 입니다.
     * ReviewStatus, Reviewer 필드는 관리자가 업데이트 요청할 수 있는 필드입니다. 즉, 관리자와 관련 필드입니다.
     * */
    public void changeAdvertisement(UpdateDtoAdvertisement updateDtoAdvertisement) {
        if(updateDtoAdvertisement.getTitle() != null) changeTitle(updateDtoAdvertisement.getTitle());
        if(updateDtoAdvertisement.getDetailDescription() != null) changeDetailDescription(updateDtoAdvertisement.getDetailDescription());
        if(updateDtoAdvertisement.getImagePath() != null) changeImagePath(updateDtoAdvertisement.getImagePath());
        if(updateDtoAdvertisement.getSiteUrl() != null) changeStieUrl(updateDtoAdvertisement.getSiteUrl());
        if(updateDtoAdvertisement.getRowPosition() != null) changeRowPosition(updateDtoAdvertisement.getRowPosition());
        if(updateDtoAdvertisement.getColumnPosition() != null) changeColumnPosition(updateDtoAdvertisement.getColumnPosition());
    }

    public static Advertisement createAdvertisement(CreateDtoAdvertisement createDtoAdvertisement, User user, AdvertisementType advertisementType) {
        return Advertisement.builder()
                .id(null)
                .user(user)
                .advertisementType(advertisementType)
                .title(createDtoAdvertisement.getTitle())
                .detailDescription(createDtoAdvertisement.getDetailDescription())
                .imagePath(createDtoAdvertisement.getImagePath())
                .siteUrl(createDtoAdvertisement.getSiteUrl())
                .rowPosition(createDtoAdvertisement.getRowPosition())
                .columnPosition(createDtoAdvertisement.getColumnPosition())
                .isActivated(false)
                .build();
    }
}

package com.Liveasy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Embeddable
@Data
public class Facility {
    @Column(name = "loading_point")
    private String loadingPoint;

    @Column(name = "unloading_point")
    private String unloadingPoint;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "loading_date")
    private LocalDate loadingDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @Column(name = "unloading_date")
    private LocalDate unloadingDate;
}

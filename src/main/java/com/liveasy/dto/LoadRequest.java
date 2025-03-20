package com.Liveasy.dto;

import com.Liveasy.model.Facility;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LoadRequest {
    private Facility facility;

    private String productType;

    private String truckType;

    @Positive
    private Integer noOfTrucks;

    @Positive
    private Double weight;

    private String comment;

    @NotNull
    private String shipperId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}

package com.Liveasy.dto;

import com.Liveasy.model.Facility;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class LoadResponse {
    private UUID loadId;
    private Facility facility;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private UUID shipperId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}

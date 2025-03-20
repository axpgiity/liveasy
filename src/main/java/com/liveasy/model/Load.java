package com.Liveasy.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "loads")
public class Load {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "load_id")
    private UUID loadId;

    @Embedded
    private Facility facility;

    @Column(name = "product_type")
    private String productType;

    @Column(name="truck_type")
    private String truckType;

    @Column(name = "no_of_trucks")
    private int noOfTrucks;
    private double weight;
    private String comment;

    @Column(name = "shipper_id")
    private UUID shipperId;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
}

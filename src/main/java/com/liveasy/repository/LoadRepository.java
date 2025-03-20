// LoadRepository.java
package com.Liveasy.repository;

import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.Liveasy.model.Load;
import java.util.List;
import java.util.UUID;

public interface LoadRepository extends JpaRepository<Load, UUID> {

    @Query("SELECT l FROM Load l WHERE " +
            "(COALESCE(:shipperId, null) IS NULL OR l.shipperId = :shipperId) AND " +
            "(COALESCE(:truckType, '') = '' OR l.truckType = :truckType) AND " +
            "(COALESCE(:productType, '') = '' OR l.productType = :productType) AND " +
            "(COALESCE(:loadingPoint, '') = '' OR l.facility.loadingPoint = :loadingPoint) AND " +
            "(COALESCE(:unloadingPoint, '') = '' OR l.facility.unloadingPoint = :unloadingPoint)")
    List<Load> findByFilters(

            @Param("shipperId") UUID shipperId,
            @Param("truckType") String truckType,
            @Param("productType") String productType,
            @Param("loadingPoint") String loadingPoint,
            @Param("unloadingPoint") String unloadingPoint
    );
}
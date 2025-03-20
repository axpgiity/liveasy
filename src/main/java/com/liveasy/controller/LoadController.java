// LoadController.java
package com.Liveasy.controller;

import com.Liveasy.dto.LoadResponse;
import com.Liveasy.dto.LoadRequest;
import com.Liveasy.dto.LoadResponse;
import com.Liveasy.service.LoadService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/loads")
@RequiredArgsConstructor
public class LoadController {

    private final LoadService loadService;

    // 1. Create Load
    @PostMapping
    public ResponseEntity<LoadResponse> createLoad(@RequestBody LoadRequest loadRequest) {
        LoadResponse response = loadService.createLoad(loadRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 2. Get Loads with Filters
    @GetMapping
    public ResponseEntity<List<LoadResponse>> getLoads(
            @RequestParam(required = false) UUID shipperId,
            @RequestParam(required = false) String truckType,
            @RequestParam(required = false) String productType,
            @RequestParam(required = false) String loadingPoint,
            @RequestParam(required = false) String unloadingPoint) {

        List<LoadResponse> loads = loadService.getFilteredLoads(
                shipperId, truckType, productType, loadingPoint, unloadingPoint
        );
        return ResponseEntity.ok(loads);
    }

    // 3. Get Load by ID
    @GetMapping("/{loadId}")
    public ResponseEntity<LoadResponse> getLoadById(@PathVariable UUID loadId) {
        LoadResponse load = loadService.getLoadById(loadId);
        return ResponseEntity.ok(load);
    }

    // 4. Update Load
    @PutMapping("/{loadId}")
    public ResponseEntity<LoadResponse> updateLoad(
            @PathVariable UUID loadId,
            @RequestBody LoadRequest loadRequest) {

        LoadResponse updatedLoad = loadService.updateLoad(loadId, loadRequest);
        return ResponseEntity.ok(updatedLoad);
    }

    // 5. Delete Load
    @DeleteMapping("/{loadId}")
    public ResponseEntity<Void> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.noContent().build();
    }
}
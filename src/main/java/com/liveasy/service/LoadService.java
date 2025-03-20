// LoadService.java
package com.Liveasy.service;

import com.Liveasy.dto.LoadRequest;
import com.Liveasy.dto.LoadResponse;
import com.Liveasy.model.Facility;
import com.Liveasy.model.Load;
import com.Liveasy.repository.LoadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoadService {

    private final LoadRepository loadRepository;

    public LoadResponse createLoad(LoadRequest request) {
        String shipperIdInput = request.getShipperId();
        UUID shipperId;

        // Handle both "shipper:<UUID>" and raw UUID formats
        if (shipperIdInput.contains(":")) {
            shipperId = UUID.fromString(shipperIdInput.split(":")[1]);
        } else {
            shipperId = UUID.fromString(shipperIdInput); // Directly parse UUID
        }

        Load load = convertToEntity(request);
        //load.setLoadId(UUID.randomUUID());
        load.setShipperId(shipperId);

        Load savedLoad = loadRepository.save(load);
        return convertToResponse(savedLoad);
    }

    public List<LoadResponse> getFilteredLoads(
            UUID shipperId,
            String truckType,
            String productType,
            String loadingPoint,
            String unloadingPoint
    ) {
        // This is the method implementation
        return loadRepository.findByFilters(
                        shipperId,
                        truckType,
                        productType,
                        loadingPoint,
                        unloadingPoint
                )
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

    public LoadResponse getLoadById(UUID loadId) {
        Load load = loadRepository.findById(loadId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Load not found"));
        return convertToResponse(load);
    }

    public LoadResponse updateLoad(UUID loadId, LoadRequest request) {
        Load existingLoad = loadRepository.findById(loadId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Load not found"));

        updateEntityFromRequest(request, existingLoad);
        Load updatedLoad = loadRepository.save(existingLoad);
        return convertToResponse(updatedLoad);
    }

    public void deleteLoad(UUID loadId) {
        loadRepository.deleteById(loadId);
    }

    private Load convertToEntity(LoadRequest request) {
        Load load = new Load();

        // Map other fields (EXCLUDING shipperId)
        load.setFacility(request.getFacility());
        load.setProductType(request.getProductType());
        load.setTruckType(request.getTruckType());
        load.setNoOfTrucks(request.getNoOfTrucks());
        load.setWeight(request.getWeight());
        load.setComment(request.getComment());
        load.setDate(request.getDate());
        return load;
    }

    private LoadResponse convertToResponse(Load load) {
        LoadResponse response = new LoadResponse();
        // Map fields from entity to response
        response.setLoadId(load.getLoadId());
        response.setFacility(load.getFacility());
        response.setProductType(load.getProductType());
        response.setTruckType(load.getTruckType());
        response.setNoOfTrucks(load.getNoOfTrucks());
        response.setWeight(load.getWeight());
        response.setComment(load.getComment());
        response.setShipperId(load.getShipperId());
        response.setDate(load.getDate());
        return response;
    }

    private void updateEntityFromRequest(LoadRequest request, Load existingLoad) {

        if(request.getFacility() != null) existingLoad.setFacility(request.getFacility());
        if(request.getProductType() != null) existingLoad.setProductType(request.getProductType());
        if(request.getTruckType() != null) existingLoad.setTruckType(request.getTruckType());

        if(request.getNoOfTrucks() != null) {
            existingLoad.setNoOfTrucks(request.getNoOfTrucks());
        }
        if(request.getWeight() != null) {
            existingLoad.setWeight(request.getWeight());
        }
        if(request.getComment() != null) existingLoad.setComment(request.getComment());
        if(request.getDate() != null) existingLoad.setDate(request.getDate());
    }
}
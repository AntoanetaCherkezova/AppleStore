package com.example.applemarketplace.model.view;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
public class LatestModelDeviceView {

    private String id;
    private String model;
    private List<String> photosUrls;
    private String operatingSystem;
    private LocalDate dateOfPurchase;
    private BigDecimal price;
}

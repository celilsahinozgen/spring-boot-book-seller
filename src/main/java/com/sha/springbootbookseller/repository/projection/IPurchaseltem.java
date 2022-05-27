package com.sha.springbootbookseller.repository.projection;

import java.time.LocalDateTime;

public interface IPurchaseltem {


    String getTitle();
    Double getPrice();
    LocalDateTime getPurchaseTime();

}

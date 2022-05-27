package com.sha.springbootbookseller.service;


import com.sha.springbootbookseller.model.PurchaseHistory;
import com.sha.springbootbookseller.repository.projection.IPurchaseltem;

import java.util.List;

public interface IPurchaseHistoryService {
    PurchaseHistory savePurchaseHistory(PurchaseHistory purchaseHistory);

    List<IPurchaseltem> findPurchasedItemOfUser(Long userId);
}

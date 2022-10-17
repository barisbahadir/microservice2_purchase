package com.sha.springbootmicroservice2purchase.controller;

import com.sha.springbootmicroservice2purchase.model.Purchase;
import com.sha.springbootmicroservice2purchase.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @PostMapping //api/purchase
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.savePurchase(purchase), HttpStatus.CREATED);
    }

    @GetMapping("{userId}") //api/purchase/userId
    public ResponseEntity<?> getAllPurchasesByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(purchaseService.findAllPurchesesOfUser(userId));
    }

}

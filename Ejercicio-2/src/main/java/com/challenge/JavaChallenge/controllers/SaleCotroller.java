package com.challenge.JavaChallenge.controllers;

import com.challenge.JavaChallenge.models.sale.SaleRequest;
import com.challenge.JavaChallenge.models.sale.SimulateResponse;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SaleCotroller {

    @RequestMapping(value = "sale/simulate", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody SaleRequest saleRequest) throws Exception{

        try {
            SimulateResponse simulateResponse = new SimulateResponse(saleRequest.getCard(), saleRequest.getAmount());
            return ResponseEntity.ok(simulateResponse);
        }catch (Exception e){
            JSONObject response = new JSONObject();
            response.put("error", e.getMessage());
            return new ResponseEntity<String>(response.toString(), HttpStatus.BAD_REQUEST);
        }
    }

}

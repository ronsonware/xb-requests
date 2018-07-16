package br.com.test.xbrain.xbrequests.controller;

import br.com.test.xbrain.xbrequests.dto.DeliveryDTO;
import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.exception.BadRequest400;
import br.com.test.xbrain.xbrequests.exception.InternalServerError500;
import br.com.test.xbrain.xbrequests.service.IDeliveryService;
import br.com.test.xbrain.xbrequests.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregas")
@CrossOrigin
public class DeliveryController {

    @Autowired
    IDeliveryService service;

    @RequestMapping(value="", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<List<DeliveryDTO>> getAll() {
        List<DeliveryDTO> delivery = service.getAllDeliveries();
        return new ResponseEntity<>(delivery, HttpStatus.OK);
    }

}
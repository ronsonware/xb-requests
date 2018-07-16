package br.com.test.xbrain.xbrequests.controller;

import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.exception.BadRequest400;
import br.com.test.xbrain.xbrequests.exception.InternalServerError500;
import br.com.test.xbrain.xbrequests.service.IRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin
public class RequestController {

    @Autowired
    IRequestService service;

    @RequestMapping(value="", method=RequestMethod.GET, produces="application/json" )
    public ResponseEntity<List<RequestDTO>> getAll() {
        List<RequestDTO> request = service.getAllRequests();
        return new ResponseEntity<>(request, HttpStatus.OK);
    }


    @RequestMapping(value="", method=RequestMethod.POST, produces="application/json" )
    public ResponseEntity<RequestDTO> create(@RequestBody RequestDTO request) {
        try {
            service.createRequest(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (BadRequest400 p) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (InternalServerError500 u) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
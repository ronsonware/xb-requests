package br.com.test.xbrain.xbrequests.controller;

import br.com.test.xbrain.xbrequests.XbRequestsApplicationTests;
import br.com.test.xbrain.xbrequests.dto.RequestDTO;
import br.com.test.xbrain.xbrequests.entity.Product;
import br.com.test.xbrain.xbrequests.service.RequestService;
import br.com.test.xbrain.xbrequests.util.TestUtil;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

public class DeliveryControllerTests extends XbRequestsApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    private DeliveryController deliveryController;

    @Autowired
    private RequestService requestService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(deliveryController).build();
    }


    @Test
    public void testGETGetAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/entregas"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}

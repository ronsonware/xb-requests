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

public class RequestControllerTests extends XbRequestsApplicationTests {


    private MockMvc mockMvc;

    @Autowired
    private RequestController requestController;

    @Autowired
    private RequestService requestService;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(requestController).build();
    }


    @Test
    public void testGETGetAll() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/pedidos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testPOSTCreate() throws Exception {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(20));

        RequestDTO requestDTO = new RequestDTO(2, "Av. Paraná, 217", 20.0, products);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/api/pedidos")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .param("clientCode", "2")
                .content(TestUtil.convertObjectToJsonBytes(requestDTO))
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

}

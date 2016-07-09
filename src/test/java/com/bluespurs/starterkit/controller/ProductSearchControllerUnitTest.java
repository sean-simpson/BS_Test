package com.bluespurs.starterkit.controller;

import com.bluespurs.starterkit.UnitTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Category(UnitTest.class)
public class ProductSearchControllerUnitTest extends UnitTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        super.setUp();
        mockMvc = MockMvcBuilders.standaloneSetup(new ProductSearchController()).build();
    }

    /**
     * Test the product search.
     *
     * @see ProductSearchController#performSearch(String)
     */
    @Test
    public void testProductSearch() throws Exception {
        mockMvc.perform(get("/product/search?name=ipod"))
            .andExpect(status().isOk());
    }
}

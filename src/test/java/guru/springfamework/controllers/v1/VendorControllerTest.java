package guru.springfamework.controllers.v1;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.services.VendorService;

public class VendorControllerTest {
	
	private static final String VENDOR = "Vendor";

	@Mock
	VendorService vendorService;
	
	@InjectMocks
	VendorController vendorController;
	
    MockMvc mockMvc;
    
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
	    mockMvc = MockMvcBuilders.standaloneSetup(vendorController).setControllerAdvice(new RestResponseEntityExceptionHandler()).build();
	}

	@Test
	public void testGetAllVendors() throws Exception {
		List<VendorDTO> vds = Arrays.asList(new VendorDTO(), new VendorDTO());
		
		when(vendorService.getAllVendors()).thenReturn(vds);
		
        mockMvc.perform(get("/api/v1/vendors/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.vendors", hasSize(2)));
	}

	@Test
	public void testGetVendor() throws Exception {
		VendorDTO vd = new VendorDTO();
		vd.setName(VENDOR);
		vd.setId(1L);
		when(vendorService.getVendorByName(VENDOR)).thenReturn(vd);
        mockMvc.perform(get("/api/v1/vendors/"+VENDOR)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", equalTo(VENDOR)));
	}

}

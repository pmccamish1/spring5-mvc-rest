package guru.springfamework.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;

public class VendorServiceImplTest {

	private static final String VENDOR_NAME = "VendorName";

	VendorService vendorService;
	
	@Mock
	VendorRepository vendorRepository;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		vendorService = new VendorServiceImpl(VendorMapper.INSTANCE,vendorRepository);
	}

	@Test
	public void testGetAllVendors() {
		List<Vendor> vList = Arrays.asList(new Vendor(), new Vendor(), new Vendor());
		
		//when(vendorService.getAllVendors()).thenReturn(vList);
		when(vendorRepository.findAll()).thenReturn(vList);
		List<VendorDTO> vs = vendorService.getAllVendors();
		
		assertEquals(vs.size(), 3);
	}

	@Test
	public void testGetVendorByName() {

		Vendor value = new Vendor();
		value.setName(VENDOR_NAME);
		when(vendorRepository.findByName(VENDOR_NAME)).thenReturn(value);
		VendorDTO v = vendorService.getVendorByName(VENDOR_NAME);
		assertEquals(v.getName(),VENDOR_NAME);
	}

}

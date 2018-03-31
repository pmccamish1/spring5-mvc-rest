package guru.springfamework.api.v1.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.sym.Name;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.domain.Vendor;

public class VendorMapperTest {


	private static final String NAME = "VendorName";

	VendorMapper vendorMapper = VendorMapper.INSTANCE;
    public static final long ID = 1L;
    
	@Test
	public void testVendorToVendorDTO() {
		
		Vendor v = new Vendor();
		v.setId(ID);
		v.setName(NAME);
		
		VendorDTO vd = vendorMapper.vendorToVendorDTO(v);
		
		assertEquals(vd.getName(),NAME);
		assertEquals(vd.getId(),v.getId());
	}

}

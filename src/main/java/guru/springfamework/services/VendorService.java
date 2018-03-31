package guru.springfamework.services;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import guru.springfamework.api.v1.model.VendorDTO;

public interface VendorService {
	List<VendorDTO> getAllVendors();
	VendorDTO getVendorByName(@PathVariable String name);
}

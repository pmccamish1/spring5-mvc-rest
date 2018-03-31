package guru.springfamework.controllers.v1;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.api.v1.model.VendorListDTO;
import guru.springfamework.services.VendorService;

@RestController
@RequestMapping("/api/v1/vendors")
public class VendorController {
	private final VendorService vendorService;
	
	
	public VendorController(VendorService vendorService) {
		super();
		this.vendorService = vendorService;
	}


	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public VendorListDTO getAllVendors() {	
		return new VendorListDTO(vendorService.getAllVendors());		
	}
	
	@GetMapping("{name}")
	@ResponseStatus(HttpStatus.OK)
	public VendorDTO getVendor(@PathVariable String name) {		
		return vendorService.getVendorByName(name);
	}
}

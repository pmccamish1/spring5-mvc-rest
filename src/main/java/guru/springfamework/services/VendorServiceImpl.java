package guru.springfamework.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springfamework.api.v1.mapper.VendorMapper;
import guru.springfamework.api.v1.model.VendorDTO;
import guru.springfamework.repositories.VendorRepository;

@Service
public class VendorServiceImpl implements VendorService {
	
	private final VendorMapper vendorMapper;
	private final VendorRepository vendorRepository;
	

	public VendorServiceImpl(VendorMapper vendorMapper, VendorRepository vendorRepository) {
		super();
		this.vendorMapper = vendorMapper;
		this.vendorRepository = vendorRepository;
	}

	@Override
	public List<VendorDTO> getAllVendors() {
		return vendorRepository.findAll().stream().map(vendorMapper::vendorToVendorDTO).collect(Collectors.toList());
	}

	@Override
	public VendorDTO getVendorByName(String name) {
		return vendorMapper.vendorToVendorDTO(vendorRepository.findByName(name));
	}

}

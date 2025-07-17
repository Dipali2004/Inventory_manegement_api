package com.rt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.SupplierDTO;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Supplier;
import com.rt.mapper.SupplierMapper;
import com.rt.repository.SupplierRepo;
import com.rt.serviceInterfase.SupplierInterfase;

@Service
public class SupplierImp implements SupplierInterfase {
	@Autowired
	private SupplierRepo supplierRepo;

	@Autowired
	private SupplierMapper supplierMapper;

	@Override
	public SupplierRespDTO add(SupplierDTO supplierDTO) {
		Supplier supplier = supplierMapper.toEntity(supplierDTO);

		Supplier data = supplierRepo.save(supplier);
		SupplierRespDTO dto = supplierMapper.toDto(data);

		return dto;
	}
	@Override
	public List<SupplierRespDTO> getAll() {
		List<Supplier> supplier = supplierRepo.findAll();
		List<SupplierRespDTO> dto = new ArrayList<>();
		
		for(Supplier data:supplier) {
			SupplierRespDTO todto= 	supplierMapper.toDto(data);
			dto.add(todto);
		}
		
		return dto;
	}


	@Override
	public SupplierRespDTO GetAll(int id) {
		Optional<Supplier> supplier = supplierRepo.findById(id);
		if(supplier.isPresent()) {
			Supplier data = supplier.get();
			SupplierRespDTO info = supplierMapper.toDto(data);
			return info;
		}
		return null;
	}
	@Override
	public SupplierRespDTO updateForm(SupplierDTO supplierDTO) {
	Supplier  update = supplierMapper.toEntity(supplierDTO);
	Supplier supplier = supplierRepo.save(update);
	SupplierRespDTO data = supplierMapper.toDto(supplier);
			
		return data;
	}


}

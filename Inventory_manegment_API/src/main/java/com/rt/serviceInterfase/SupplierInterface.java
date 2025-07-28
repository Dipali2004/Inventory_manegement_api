package com.rt.serviceInterfase;

import java.util.List;

import com.rt.DTO.SupplierDTO;
import com.rt.DTO.SupplierRespDTO;

public interface SupplierInterface {

	SupplierRespDTO add(SupplierDTO supplierDTO);

	Object GetAll(int id);

	List<SupplierRespDTO> getAll();

	SupplierRespDTO updateForm(SupplierDTO supplierDTO);

}

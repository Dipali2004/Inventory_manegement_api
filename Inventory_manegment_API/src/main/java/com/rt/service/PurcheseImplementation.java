package com.rt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.PurchaseDTO;
import com.rt.DTO.PurchaseRespDto;
import com.rt.DTO.SupplierRespDTO;
import com.rt.entity.Product;
import com.rt.entity.Purchase;
import com.rt.entity.Supplier;
import com.rt.mapper.ProductMapper;
import com.rt.mapper.PurchaseMapper;
import com.rt.mapper.SupplierMapper;
import com.rt.repository.ProductRepo;
import com.rt.repository.PurcheseRepo;
import com.rt.repository.SupplierRepo;
import com.rt.serviceInterfase.PurcheseInterface;

@Service
public class PurcheseImplementation implements PurcheseInterface {
	@Autowired
	private PurcheseRepo purcheseRepo;

	@Autowired
	private PurchaseMapper purchaseMapper;

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private SupplierRepo supplierRepo;
	@Autowired
	private SupplierMapper supplierMapper;
	@Autowired
	private ProductMapper productMapper;

	@Override
	public PurchaseRespDto add_stock(PurchaseDTO purchaseDTO) {

		Supplier supplier = supplierRepo.findById(purchaseDTO.getSupplierId())
				.orElseThrow(() -> new RuntimeException("Supplier not found with ID: "));
		Product product = productRepo.findById(purchaseDTO.getProductId())
				.orElseThrow(() -> new RuntimeException("Product not found"));

		Purchase purchase = purchaseMapper.toEntity(purchaseDTO, product, supplier);

		Purchase data = purcheseRepo.save(purchase);

		PurchaseRespDto dto = purchaseMapper.toDto(data);
		System.out.println(dto);
		return dto;
	}

	@Override
	public List<SupplierRespDTO> supplier() {
		List<Supplier> suppliers = supplierRepo.findAll();
		List<SupplierRespDTO> dtoList = new ArrayList<>();

		for (Supplier supplier : suppliers) {
			SupplierRespDTO dto = supplierMapper.toDto(supplier);
			dtoList.add(dto);
		}

		return dtoList;

	}

	@Override
	public List<ProductRespDto> product() {
		List<Product> product = productRepo.findAll();
		List<ProductRespDto> dto = new ArrayList<>();
		for (Product products : product) {
			ProductRespDto dtoList = productMapper.toDto(products);
			dto.add(dtoList);

		}

		return dto;
	}

	public List<PurchaseRespDto> getData() {
		List<Purchase> product = purcheseRepo.findAll();
		List<PurchaseRespDto> dto = new ArrayList<>();
		for (Purchase products : product) {
			PurchaseRespDto dtoList = purchaseMapper.toDto(products);
			dto.add(dtoList);
		}
		return dto;
	}

	@Override
	public Object getDataID(int id) {
		Optional<Purchase> purhase =purcheseRepo.findById(id);
		if(purhase.isPresent()) {
			Purchase data = purhase.get();
			PurchaseRespDto info = purchaseMapper.toDto(data);
			return info;
		}
		return null;
		
	}

	@Override
	public void update(PurchaseDTO purchaseDTO) {
		System.out.println("purchase details :"+purchaseDTO.getPurchaseId()+" product id :"+purchaseDTO.getProductId());
		  Purchase existing = purcheseRepo.findById(purchaseDTO.getPurchaseId())
		            .orElseThrow(() -> new RuntimeException("purcahse data find"));

		        
		        existing.setQuantityPurchased(purchaseDTO.getQuantityPurchased());
		        existing.setPurchaseDate(purchaseDTO.getPurchaseDate());


		        Product product = productRepo.findById(purchaseDTO.getProductId())
		            .orElseThrow(() -> new RuntimeException("Product not found"));
		        System.out.println("Product ID from DTO: " + purchaseDTO.getProductId());

		        existing.setProduct(product);

		      
		        Supplier supplier = supplierRepo.findById(purchaseDTO.getSupplierId())
		            .orElseThrow(() -> new RuntimeException("Supplier not found"));
		        existing.setSupplier(supplier);

		       
		        Purchase updated = purcheseRepo.save(existing);

		       
		        return  ;  
		
	}
}

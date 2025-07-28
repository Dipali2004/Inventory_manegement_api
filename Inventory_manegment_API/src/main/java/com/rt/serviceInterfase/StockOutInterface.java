package com.rt.serviceInterfase;

import java.util.List;

import com.rt.DTO.ProductRespDto;
import com.rt.DTO.StockOutDTO;
import com.rt.DTO.StockOutRepDTO;

public interface StockOutInterface {

	String add(StockOutDTO stockOutDTO);

	List<StockOutRepDTO> getAll();

	StockOutRepDTO update(int id);

	List<ProductRespDto> product();

	StockOutRepDTO updateStock(StockOutDTO stockOutDTO);

}

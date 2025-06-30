package com.rt.serviceInterfase;

import java.util.List;



import com.rt.DTO.GetAllManegerDTO;
import com.rt.DTO.ManegerDTO;

public interface ManegerInterface {

	ManegerDTO addManger(ManegerDTO manegerDTO);

	List<GetAllManegerDTO> getAll();

	GetAllManegerDTO update(int id);

	GetAllManegerDTO update(GetAllManegerDTO getAllManegerDTO);

	



}

package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.IouDAO;
import com.project.model.Iou;

@Service(value="iouService")
public class IouService {
	@Autowired
	private IouDAO iou;
	
	@Transactional
	public List<Iou> getAllIou(){
		return iou.getIou();
	}
}

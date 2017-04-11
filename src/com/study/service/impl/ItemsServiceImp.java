package com.study.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.study.exception.CustomException;
import com.study.mapper.ItemCustomerMapper;
import com.study.po.ItemsCustom;
import com.study.po.ItemsqueryVo;
import com.study.service.ItemsService;

public class ItemsServiceImp implements ItemsService{

	//这个是自动注入 使用注解
	@Autowired
	private ItemCustomerMapper itemCustomerMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsqueryVo vo) throws Exception {
		
		List<ItemsCustom> result = itemCustomerMapper.findItemsList(vo);
		
		return result;
	}

	@Override
	public ItemsCustom findItmeByid(Integer id) throws Exception {
		ItemsCustom item = itemCustomerMapper.findItmeByid(id);
		if(item==null){
			throw new CustomException("找不到您需要找到的商品！");
		}
		return item; 
	}

	@Override
	public void updateItem(int id,ItemsCustom items) throws Exception {
		
		//一定需要items存在id
		items.setId(id);
		
		itemCustomerMapper.updateItem(items);
	}

}

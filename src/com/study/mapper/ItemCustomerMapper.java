package com.study.mapper;

import java.util.List;

import com.study.po.ItemsCustom;
import com.study.po.ItemsqueryVo;

public interface ItemCustomerMapper {
	
	//商品列表查询
	public List<ItemsCustom> findItemsList(ItemsqueryVo vo) throws Exception;
	
	//根据商品id查询对应的商品
	public ItemsCustom findItmeByid(Integer id) throws Exception;
	
	//更新item
	public void updateItem(ItemsCustom item) throws Exception;

}

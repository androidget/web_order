package com.study.service;

import java.util.List;

import com.study.po.ItemsCustom;
import com.study.po.ItemsqueryVo;

public interface ItemsService {

	// 商品列表查询
	public List<ItemsCustom> findItemsList(ItemsqueryVo vo) throws Exception;

	//根据对应的id查询对应的商品
	public ItemsCustom findItmeByid(Integer id) throws Exception;
	
	//更新数据
	public void updateItem(int id,ItemsCustom items) throws Exception;

}

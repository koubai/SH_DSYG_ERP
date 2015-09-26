package com.cn.dsyg.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.cn.common.util.Constants;
import com.cn.common.util.PropertiesConfig;
import com.cn.dsyg.dao.Dict01Dao;
import com.cn.dsyg.dao.SalesItemDao;
import com.cn.dsyg.dto.Dict01Dto;
import com.cn.dsyg.dto.SalesItemDto;
import com.cn.dsyg.service.SalesItemService;

/**
 * @name SalesItemServiceImpl.java
 * @author Frank
 * @time 2015-6-17下午9:49:18
 * @version 1.0
 */
public class SalesItemServiceImpl implements SalesItemService {
	
	private SalesItemDao salesItemDao;
	private Dict01Dao dict01Dao;

	@Override
	public List<SalesItemDto> querySalesItemBySalesno(String salesno) {
		List<SalesItemDto> list = salesItemDao.querySalesItemBySalesno(salesno);
		if(list != null && list.size() > 0) {
			for(SalesItemDto item : list) {
				BigDecimal rate = new BigDecimal(1);
				//税率
				List<Dict01Dto> listRate = dict01Dao.queryDict01ByFieldcode(Constants.DICT_RATE, PropertiesConfig.getPropertiesValueByKey(Constants.SYSTEM_LANGUAGE));
				if(listRate != null && listRate.size() > 0) {
					rate = rate.add(new BigDecimal(listRate.get(0).getCode()));
				}
				if(item.getUnitprice() != null) {
					//计算税后价格，保留4位有效数字
					item.setTaxunitprice(item.getUnitprice().multiply(rate).setScale(4, BigDecimal.ROUND_HALF_UP));
				}
			}
		}
		return list;
	}

	@Override
	public SalesItemDto querySalesItemByID(String id) {
		return salesItemDao.querySalesItemByID(id);
	}

	@Override
	public void deleteSalesItemBySalesno(String salesno, String updateuid) {
		salesItemDao.deleteSalesItemBySalesno(salesno, updateuid);
	}

	@Override
	public void insertSalesItem(SalesItemDto salesItem) {
		salesItemDao.insertSalesItem(salesItem);
	}

	@Override
	public void updateSalesItem(SalesItemDto salesItem) {
		salesItemDao.updateSalesItem(salesItem);
	}
	
	@Override
	public List<SalesItemDto> querySalesItemByProductid(String productid,
			String customerid, int start, int end) {
		return salesItemDao.querySalesItemByProductid(productid, customerid, start, end);
	}

	public SalesItemDao getSalesItemDao() {
		return salesItemDao;
	}

	public void setSalesItemDao(SalesItemDao salesItemDao) {
		this.salesItemDao = salesItemDao;
	}

	public Dict01Dao getDict01Dao() {
		return dict01Dao;
	}

	public void setDict01Dao(Dict01Dao dict01Dao) {
		this.dict01Dao = dict01Dao;
	}
}

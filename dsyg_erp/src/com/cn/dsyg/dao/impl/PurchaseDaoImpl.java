package com.cn.dsyg.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.common.dao.BaseDao;
import com.cn.dsyg.dao.PurchaseDao;
import com.cn.dsyg.dto.PurchaseDto;

/**
 * @name PurchaseDaoImpl.java
 * @author Frank
 * @time 2015-5-9下午10:22:05
 * @version 1.0
 */
public class PurchaseDaoImpl extends BaseDao implements PurchaseDao {
	
	@Override
	public PurchaseDto queryPurchaseByNo(String purchaseno) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("purchaseno", purchaseno);
		@SuppressWarnings("unchecked")
		List<PurchaseDto> list = getSqlMapClientTemplate().queryForList("queryPurchaseByNo", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public int queryPurchaseCountByPage(String purchasedateLow,
			String purchasedateHigh) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("purchasedateLow", purchasedateLow);
		paramMap.put("purchasedateHigh", purchasedateHigh);
		return (Integer) getSqlMapClientTemplate().queryForObject("queryPurchaseCountByPage", paramMap);
	}

	@Override
	public List<PurchaseDto> queryPurchaseByPage(String purchasedateLow,
			String purchasedateHigh, int start, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("purchasedateLow", purchasedateLow);
		paramMap.put("purchasedateHigh", purchasedateHigh);
		paramMap.put("start", start);
		paramMap.put("end", end);
		@SuppressWarnings("unchecked")
		List<PurchaseDto> list = getSqlMapClientTemplate().queryForList("queryPurchaseByPage", paramMap);
		return list;
	}

	@Override
	public PurchaseDto queryPurchaseByID(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		@SuppressWarnings("unchecked")
		List<PurchaseDto> list = getSqlMapClientTemplate().queryForList("queryPurchaseByID", paramMap);
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void deletePurchase(String id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		getSqlMapClientTemplate().delete("deletePurchase", paramMap);
	}

	@Override
	public void insertPurchase(PurchaseDto purchase) {
		getSqlMapClientTemplate().insert("insertPurchase", purchase);
	}

	@Override
	public void updatePurchase(PurchaseDto purchase) {
		getSqlMapClientTemplate().update("updatePurchase", purchase);
	}
}
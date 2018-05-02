package io.renren.modules.sys.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.common.utils.DataPoint;
import io.renren.common.utils.RegressionLine;
import io.renren.common.utils.SortMapByValue;
import io.renren.modules.sys.dao.SysVegetableDao;
import io.renren.modules.sys.entity.SysVegetableEntity;
import io.renren.modules.sys.service.SysVegetableService;

/**
 * 蔬菜 
 * 
 * @author ryanyang
 * 
 * @date 2018年4月24日
 */
@Service("sysVegetableService")
public class SysVegetableServiceImpl extends ServiceImpl<SysVegetableDao, SysVegetableEntity> implements SysVegetableService{
	@Autowired
	SysVegetableDao sysVegetableDao;
	
	
	@Override
	public List<SysVegetableEntity> queryByType(String type) {
		return baseMapper.queryByType(type);
	}

	@Override
	public List<SysVegetableEntity> queryByNameTime(String name, String beginTime, String endTime) {
		
		return baseMapper.queryByNameTime(name, beginTime, endTime);
	}

	@Override
	public List<SysVegetableEntity> queryByCondition(Map<String, Object> map) {
		
		return baseMapper.selectByMap(map);
	}

	@Override
	public List<SysVegetableEntity> queryByCondition(String name, String beginTime, String endTime, String area) {
		
		return baseMapper.queryByCondition(name, beginTime, endTime, area);
	}

	@Override
	public List<String> getItem(String area) {
		
		return baseMapper.getItem(area);
	}

	@Override
	public List<String> getAreas() {
		return baseMapper.getAreas();
	}

	@Override
	public List<SysVegetableEntity> getTendency(Integer days, String name, String area) {
		
		return baseMapper.getTendency(days, name, area);
	}

	@Override
	public Map<String, Double> getVegetableTotalTendency(Integer days,String area) {
		List<String> itemList = this.getItem(area);
		
		Map<String, Double> map = new HashMap<String, Double>( );
		for (String item : itemList) {
			List<SysVegetableEntity> veList = this.getTendency(days, item, area);
			double sum = 0.0;
			for (SysVegetableEntity sysVegetableEntity : veList) {
				sum += (sysVegetableEntity.gethPrice()+sysVegetableEntity.getlPrice())/2;
			}
			map.put(item, sum/veList.size());
		}
		
		
		return SortMapByValue.sortByValue(map,true);
	}

	@Override
	public Map<String, Double> getVegetableTopFiveHPriecTendency(Integer days, String area) {
		Map<String, Double> tmMap = this.getVegetableTotalPriceTendency(days, area, "hprice");
		
		return tmMap;
	}

	@Override
	public Map<String, Double> getVegetableTopFiveLPriecTendency(Integer days, String area) {
		Map<String, Double> tmMap = this.getVegetableTotalPriceTendency(days, area, "lprice");
		return tmMap;
	}

	@Override
	public List<SysVegetableEntity> getPriceTendency(Integer days, String name, String area) {
		
		return baseMapper.getPriceTendency(days, name, area);
	}

	@Override
	public Map<String, Double> getVegetableTotalPriceTendency(Integer days, String area,String priceType) {
        List<String> itemList = this.getItem(area);
        RegressionLine line = new RegressionLine();
		Map<String, Double> map = new HashMap<String, Double>( );
		for (String item : itemList) {
			List<SysVegetableEntity> veList = this.getTendency(days, item, area);
			line = new RegressionLine();
			for(int i = 1 ; i <= veList.size(); i++) {
				if(priceType == "hprice") {
			        line.addDataPoint(new DataPoint(i, veList.get(i-1).gethPrice()));
				}else if(priceType == "lprice"){
					line.addDataPoint(new DataPoint(i, veList.get(i-1).getlPrice()));
				}else {
					line.addDataPoint(new DataPoint(i, veList.get(i-1).getAvePrice()));
				}
			}
			map.put(item, line.getA1());
		}
		
		
		return SortMapByValue.sortByValue(map,true);
	}

	

}

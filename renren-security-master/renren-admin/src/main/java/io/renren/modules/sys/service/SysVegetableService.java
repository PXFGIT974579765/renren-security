package io.renren.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import io.renren.modules.sys.entity.SysVegetableEntity;

/**
 * 蔬菜
 * 
 * @author ryanyang
 * 
 * @date 2018年4月23日
 */
public interface SysVegetableService extends IService<SysVegetableEntity>{
	/**
	 * 根据种类获取蔬菜
	 */
	List<SysVegetableEntity> queryByType(String type);
	
	/**
	 * 根据蔬菜名字、查询起始时间查询
	 * @param name
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<SysVegetableEntity> queryByNameTime(String name, String beginTime, String endTime);
	
	List<SysVegetableEntity> queryByCondition(Map<String,Object> map);
	
	List<SysVegetableEntity> queryByCondition(String name, String beginTime, String endTime, String area);

   
    
    /**
	 * 获取蔬菜种类数目
	 * @return
	 */
	List<String> getItem(String area);
	
	/**
	 * 获取蔬菜信息来源区域数目
	 * @return
	 */
	List<String> getAreas();
	
	/**
	 * 获取某蔬菜往前多少天数据
	 * @param days 往前多少天
	 * @param name 蔬菜种类
	 * @param area 蔬菜信息来源区域
	 * @return
	 */
	List<SysVegetableEntity> getTendency(Integer days,String name, String area);
	
	/**
	 * 获取蔬菜的近期趋势
	 * @param days
	 * @param area
	 * @return
	 */
	Map<String,Double> getVegetableTotalTendency(Integer days,String area);
	
	/**
	 * 获取蔬菜的近期的价格趋势（包含历史最高最低价格）
	 * @param days
	 * @param area
	 * @param priceType 价格类型    最高价：hprice 最低价：lprice 均价：aveprice
	 * @return
	 */
	Map<String,Double> getVegetableTotalPriceTendency(Integer days,String area,String priceType); 
	
	/**
	 * 获取蔬菜近期最高价上涨趋势最高的五种蔬菜
	 * @param days
	 * @param area
	 * @return
	 */
	Map<String,Double> getVegetableTopFiveHPriecTendency(Integer days,String area); 
	
	/**
	 * 获取蔬菜近期最低价下降趋势最高的五种蔬菜
	 * @param days
	 * @param area
	 * @return
	 */
	Map<String,Double> getVegetableTopFiveLPriecTendency(Integer days,String area);
	
	/**
	 * 获取某蔬菜往前多少天的价格数据（包含历史的最高最低价格）
	 * @param days 往前多少天
	 * @param name 蔬菜种类
	 * @param area 蔬菜信息来源区域
	 * @return
	 */
	List<SysVegetableEntity> getPriceTendency(Integer days,String name, String area);
}

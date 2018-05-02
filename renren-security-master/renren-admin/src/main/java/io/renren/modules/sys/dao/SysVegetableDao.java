package io.renren.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import io.renren.modules.sys.entity.SysVegetableEntity;


/**
 * 蔬菜实体
 * 
 * @author ryanyang
 * 
 * @date 2018年4月23日
 */
public interface SysVegetableDao extends BaseMapper<SysVegetableEntity>{

	
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
	List<SysVegetableEntity> queryByNameTime(@Param("name") String name,@Param("beginTime") String beginTime,@Param("endTime") String endTime);
	
	/**
	 * 根据条件查询
	 * @param name
	 * @param beginTime
	 * @param endTime
	 * @param area
	 * @return
	 */
	List<SysVegetableEntity> queryByCondition(@Param("name") String name,@Param("beginTime") String beginTime,@Param("endTime")  String endTime,@Param("area")  String area);
	
	/**
	 * 获取蔬菜种类数目
	 * @return
	 */
	List<String> getItem(@Param("area") String area);
	
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
	List<SysVegetableEntity> getTendency(@Param("days") Integer days,@Param("name") String name,@Param("area") String area);
	
	
	
	/**
	 * 获取某蔬菜往前多少天的价格数据（包含历史的最高最低价格）
	 * @param days 往前多少天
	 * @param name 蔬菜种类
	 * @param area 蔬菜信息来源区域
	 * @return
	 */
	List<SysVegetableEntity> getPriceTendency(@Param("days") Integer days,@Param("name") String name,@Param("area") String area);
}

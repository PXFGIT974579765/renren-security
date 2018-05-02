package io.renren.modules.sys.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import io.renren.modules.sys.entity.SysVegetablePreEntity;

/**
 * 蔬菜实体
 * 
 * @author ryanyang
 * 
 * @date 2018年4月23日
 */
public interface SysVegetablePreDao extends BaseMapper<SysVegetablePreEntity>{

	
	/**
	 * 根据种类获取蔬菜
	 */
	List<SysVegetablePreEntity> queryByType(String type);
}

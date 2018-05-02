package io.renren.modules.sys.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import io.renren.modules.sys.entity.SysVegetablePreEntity;

/**
 * 蔬菜
 * 
 * @author ryanyang
 * 
 * @date 2018年4月23日
 */
public interface SysVegetablePreService extends IService<SysVegetablePreEntity>{
	/**
	 * 根据种类获取蔬菜
	 */
	List<SysVegetablePreEntity> queryByType(String type);
}

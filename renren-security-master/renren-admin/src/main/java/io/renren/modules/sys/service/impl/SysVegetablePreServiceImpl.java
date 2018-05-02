package io.renren.modules.sys.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.renren.modules.sys.dao.SysVegetableDao;
import io.renren.modules.sys.dao.SysVegetablePreDao;
import io.renren.modules.sys.entity.SysVegetableEntity;
import io.renren.modules.sys.entity.SysVegetablePreEntity;
import io.renren.modules.sys.service.SysVegetablePreService;
import io.renren.modules.sys.service.SysVegetableService;

/**
 * 蔬菜 
 * 
 * @author ryanyang
 * 
 * @date 2018年4月24日
 */
@Service("sysVegetablePreService")
public class SysVegetablePreServiceImpl extends ServiceImpl<SysVegetablePreDao, SysVegetablePreEntity> implements SysVegetablePreService{

	
	
	@Override
	public List<SysVegetablePreEntity> queryByType(String type) {
		// TODO Auto-generated method stub
		return baseMapper.queryByType(type);
	}

}

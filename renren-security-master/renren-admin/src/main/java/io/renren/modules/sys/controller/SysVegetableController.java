package io.renren.modules.sys.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.renren.common.annotation.SysLog;
import io.renren.common.utils.R;
import io.renren.modules.sys.entity.SysVegetableEntity;
import io.renren.modules.sys.entity.SysVegetablePreEntity;
import io.renren.modules.sys.service.SysVegetablePreService;
import io.renren.modules.sys.service.SysVegetableService;

/**
 * 蔬菜信息控制器
 * 
 * @author ryanyang
 * @date 2018年4月24日
 * 
 */
@RestController
@RequestMapping("/sys/vegetable")
public class SysVegetableController extends AbstractController {
	@Autowired
	private SysVegetableService sysVegetableService;
	@Autowired
	private SysVegetablePreService sysVegetablePreService;

	/**
	 * 所有蔬菜列表
	 */
	@SysLog("按种类查询蔬菜")
	@RequestMapping("/list")
	public List<SysVegetableEntity> list(@RequestParam String type) {
		System.out.println("type ::  " + type);
		List<SysVegetableEntity> veList = sysVegetableService.queryByType(type);

		return veList;
	}

	/**
	 * 按种类查询蔬菜趋势
	 */
	@SysLog("按种类查询蔬菜趋势")
	@RequestMapping("/tendency")
	public List<SysVegetableEntity> tendency(@RequestParam String name, Integer days, String area) {

		List<SysVegetableEntity> veList = sysVegetableService.getTendency(days, name, area);

		return veList;
	}

	/**
	 * 按种类查询蔬菜价格趋势（包含历史最高最低价格）
	 */
	@SysLog("按种类查询蔬菜价格趋势（包含历史最高最低价格）")
	@RequestMapping("/pricetendency")
	public List<SysVegetableEntity> pricetendency(@RequestParam String name, Integer days, String area) {

		List<SysVegetableEntity> veList = sysVegetableService.getPriceTendency(days, name, area);

		return veList;
	}

	/**
	 * 所有蔬菜列表
	 */
	@SysLog("按种类、起始时间查询蔬菜")
	@RequestMapping("/listbytime")
	public List<SysVegetableEntity> velist(@RequestParam String name, String beginTime, String endTime) {
		System.out.println("name ::  " + name);
		if (endTime == null || endTime == "") {
			endTime = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		}
		if (beginTime == null || beginTime == "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1); // 得到前一个月
			beginTime = format.format(c.getTime());
		}
		List<SysVegetableEntity> veList = sysVegetableService.queryByNameTime(name, beginTime, endTime);

		return veList;
	}

	/**
	 * 所有蔬菜列表
	 */
	@SysLog("按条件查询蔬菜")
	@RequestMapping("/listbycondition")
	public List<SysVegetableEntity> listByContion(@RequestParam String name, String area, String beginTime,
			String endTime) {
		System.out.println("name ::  " + name);
		if (endTime == null || endTime == "") {
			endTime = new SimpleDateFormat("yyyy-mm-dd").format(new Date());
		}
		if (beginTime == null || beginTime == "") {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			c.add(Calendar.MONTH, -1); // 得到前一个月
			beginTime = format.format(c.getTime());
		}

		List<SysVegetableEntity> veList = sysVegetableService.queryByCondition(name, beginTime, endTime, area);

		return veList;
	}

	/**
	 * 所有蔬菜列表
	 */
	@SysLog("获取蔬菜种类列表")
	@RequestMapping("/itemlist")
	public List<String> itemList(String area) {
		List<String> items = sysVegetableService.getItem(area);
		return items;
	}

	/**
	 * 所有蔬菜数据来源
	 */
	@SysLog("获取蔬菜数据来源地列表")
	@RequestMapping("/arealist")
	public List<String> areaList() {
		List<String> items = sysVegetableService.getAreas();
		return items;
	}

	/**
	 * 所有蔬菜均价趋势排名
	 */
	@SysLog("获取所有蔬菜均价趋势排名")
	@RequestMapping("/tendencylist")
	public List<SysVegetableEntity> tendencylist(Integer days, String area) {
		Map<String, Double> items = sysVegetableService.getVegetableTotalTendency(days, area);
		List<SysVegetableEntity> ves = new LinkedList<>();
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			SysVegetableEntity ve = null;
			System.out.println("key=" + key + " value=" + value);
			if (sysVegetableService.getTendency(days, entry.getKey(), area).size() != 0) {
				ve = sysVegetableService.getTendency(days, entry.getKey(), area).get(0);
				ve.setTendency(entry.getValue());
				ves.add(ve);
			}

		}
		return ves;
	}

	/**
	 * 所有蔬菜平均价格趋势排名（采用线性拟合）
	 */
	@SysLog("获取所有蔬菜平均价格趋势排名（采用线性拟合）")
	@RequestMapping("/tendencyavepricelist")
	public List<SysVegetableEntity> tendencyavepricelist(Integer days, String area) {
		Map<String, Double> items = sysVegetableService.getVegetableTotalPriceTendency(days, area, "aveprice");
		List<SysVegetableEntity> ves = new LinkedList<>();
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			SysVegetableEntity ve = null;
			System.out.println("key=" + key + " value=" + value);
			if (sysVegetableService.getTendency(days, entry.getKey(), area).size() != 0) {
				ve = sysVegetableService.getTendency(days, entry.getKey(), area).get(0);
				ve.setTendency(entry.getValue());
				ves.add(ve);
			}

		}
		return ves;
	}

	/**
	 * 所有蔬菜最高价格趋势排名（采用线性拟合）
	 */
	@SysLog("获取所有蔬菜最高价格趋势排名（采用线性拟合）")
	@RequestMapping("/tendencyhpricelist")
	public List<List<SysVegetableEntity>> tendencyhpricelist(Integer days, String area) {
		Map<String, Double> items = sysVegetableService.getVegetableTopFiveHPriecTendency(days, area);

		List<List<SysVegetableEntity>> ves = new LinkedList<>();
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			List<SysVegetableEntity> ve = null;
			System.out.println("key=" + key + " value=" + value);
			if (sysVegetableService.getTendency(days, entry.getKey(), area).size() != 0) {
				 ve= sysVegetableService.getTendency(days, entry.getKey(), area);
				ve.get(0).setTendency(entry.getValue());
				
				ves.add(ve);
			}

		}
		return ves;
	}

	/**
	 * 所有蔬菜最低价格趋势排名（采用线性拟合）
	 */
	@SysLog("获取所有蔬菜最低价格趋势排名（采用线性拟合）")
	@RequestMapping("/tendencylpricelist")
	public List<List<SysVegetableEntity>>  tendencylpricelist(Integer days, String area) {
		Map<String, Double> items = sysVegetableService.getVegetableTopFiveLPriecTendency(days, area);
		List<List<SysVegetableEntity>> ves = new LinkedList<>();
		for (Map.Entry<String, Double> entry : items.entrySet()) {
			String key = entry.getKey().toString();
			String value = entry.getValue().toString();
			List<SysVegetableEntity> ve = null;
			System.out.println("key=" + key + " value=" + value);
			if (sysVegetableService.getTendency(days, entry.getKey(), area).size() != 0) {
				 ve= sysVegetableService.getTendency(days, entry.getKey(), area);
				ve.get(0).setTendency(entry.getValue());
				
				ves.add(ve);
			}

		}
		return ves;
	}

	/**
	 * 所有蔬菜列表
	 */
	@RequestMapping("/vegetablePredicData")
	public R vegetablePredicData(@RequestParam String type) {
		List<SysVegetableEntity> veList = sysVegetableService.queryByType(type);
		List<SysVegetablePreEntity> preList = sysVegetablePreService.queryByType(type);

		return R.ok().put("ves", veList);
	}

	/**
	 * 所有蔬菜预测数据测试
	 */
	@RequestMapping("/pre")
	public List<SysVegetablePreEntity> getPreData() {
		List<SysVegetablePreEntity> veList = new ArrayList<SysVegetablePreEntity>();
		veList.add(new SysVegetablePreEntity(2329, "2013/1/24"));
		veList.add(new SysVegetablePreEntity(2302, "2013/1/25"));
		veList.add(new SysVegetablePreEntity(2293, "2013/1/28"));
		veList.add(new SysVegetablePreEntity(2348.22, "2013/1/29"));
		veList.add(new SysVegetablePreEntity(2362.75, "2013/1/30"));
		veList.add(new SysVegetablePreEntity(2381.43, "2013/1/31"));
		veList.add(new SysVegetablePreEntity(2377.41, "2013/2/1"));
		veList.add(new SysVegetablePreEntity(2426.92, "2013/2/4"));
		veList.add(new SysVegetablePreEntity(2410, "2013/2/5"));
		veList.add(new SysVegetablePreEntity(2431.68, "2013/2/6"));
		veList.add(new SysVegetablePreEntity(2438.69, "2013/2/7"));
		veList.add(new SysVegetablePreEntity(2421.62, "2013/2/8"));
		veList.add(new SysVegetablePreEntity(2431.91, "2013/2/18"));
		veList.add(new SysVegetablePreEntity(2410.26, "2013/2/19"));
		veList.add(new SysVegetablePreEntity(2387.49, "2013/2/20"));
		veList.add(new SysVegetablePreEntity(2368.82, "2013/2/21"));
		veList.add(new SysVegetablePreEntity(2312.94, "2013/2/22"));
		veList.add(new SysVegetablePreEntity(2325.62, "2013/2/25"));
		veList.add(new SysVegetablePreEntity(2323.74, "2013/2/26"));
		veList.add(new SysVegetablePreEntity(2287.77, "2013/2/27"));
		veList.add(new SysVegetablePreEntity(2332.32, "2013/2/28"));
		veList.add(new SysVegetablePreEntity(2344.54, "2013/3/1"));
		veList.add(new SysVegetablePreEntity(2322.08, "2013/3/4"));
		veList.add(new SysVegetablePreEntity(2264.81, "2013/3/5"));
		veList.add(new SysVegetablePreEntity(2343.61, "2013/3/6"));
		veList.add(new SysVegetablePreEntity(2342.44, "2013/3/7"));
		veList.add(new SysVegetablePreEntity(2316.42, "2013/3/8"));
		veList.add(new SysVegetablePreEntity(2334.68, "2013/3/11"));
		veList.add(new SysVegetablePreEntity(2319.16, "2013/3/12"));
		veList.add(new SysVegetablePreEntity(2282.27, "2013/3/13"));
		veList.add(new SysVegetablePreEntity(2256.77, "2013/3/14"));
		veList.add(new SysVegetablePreEntity(2279.31, "2013/3/15"));
		veList.add(new SysVegetablePreEntity(2227.29, "2013/3/18"));
		veList.add(new SysVegetablePreEntity(2244.26, "2013/3/19"));
		veList.add(new SysVegetablePreEntity(2237.74, "2013/3/20"));
		veList.add(new SysVegetablePreEntity(2328.21, "2013/3/21"));
		veList.add(new SysVegetablePreEntity(2328.4, "2013/3/22"));
		veList.add(new SysVegetablePreEntity(2332.74, "2013/3/25"));
		veList.add(new SysVegetablePreEntity(2328.58, "2013/3/26"));
		veList.add(new SysVegetablePreEntity(2291.38, "2013/3/27"));
		return veList;
	}

}

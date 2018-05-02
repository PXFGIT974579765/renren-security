package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import org.springframework.data.annotation.Transient;

import java.io.Serializable;

/**
 * 蔬菜实体
 * 
 * @author ryanyang
 * 
 * @date 2018年4月18日
 */
@TableName("sys_vegetable")
public class SysVegetableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 蔬菜ID
	 */
	@TableId
	private long id;

	/**
	 * 平均价格
	 */
	private double avePrice;

	/**
	 * 最高价格
	 */
	private double hPrice;

	/**
	 * 最低价格
	 */
	private double lPrice;
	/**
	 * 前三天最低价格平均值
	 */
	private double threeAgoLPrice;
	/**
	 * 前三天最高价格平均值
	 */
	private double threeAgoHPrice;

	public double getThreeAgoLPrice() {
		return threeAgoLPrice;
	}

	public void setThreeAgoLPrice(double threeAgoLPrice) {
		this.threeAgoLPrice = threeAgoLPrice;
	}

	public double getThreeAgoHPrice() {
		return threeAgoHPrice;
	}

	public void setThreeAgoHPrice(double threeAgoHPrice) {
		this.threeAgoHPrice = threeAgoHPrice;
	}

	/**
	 * 蔬菜种类
	 */
	private String name;

	/**
	 * 调查来源区域
	 */
	private String area;

	/**
	 * 时间
	 */
	private String time;

	/**
	 * 预测最高价格
	 */
	private Double predicHPrice;

	/**
	 * 预测最低价格
	 */
	private Double predicLPrice;

	private String updateTime;

	/**
	 * 历史最高的最高价格
	 */
	@Transient
	private double maxHPrice;

	/**
	 * 历史最低的最高价格
	 */
	@Transient
	private double minHPrice;

	/**
	 * 历史最高的最低价格
	 */
	@Transient
	private double maxLPrice;

	/**
	 * 历史最低的最低价格
	 */
	@Transient
	private double minLPrice;

	/**
	 * 历史最高的平均价格
	 */
	@Transient
	private double maxAvePrice;

	/**
	 * 历史最低的平均价格
	 */
	@Transient
	private double minAvePrice;
	
	/**
	 * 趋势值
	 */
	@Transient
	private double tendency;

	public double getTendency() {
		return tendency;
	}

	public void setTendency(double tendency) {
		this.tendency = tendency;
	}

	public SysVegetableEntity() {

	}

	public SysVegetableEntity(double price, String time) {
		this.avePrice = price;
		this.time = time;
	}

	public double getMaxHPrice() {
		return maxHPrice;
	}

	public void setMaxHPrice(double maxHPrice) {
		this.maxHPrice = maxHPrice;
	}

	public double getMinHPrice() {
		return minHPrice;
	}

	public void setMinHPrice(double minHPrice) {
		this.minHPrice = minHPrice;
	}

	public double getMaxLPrice() {
		return maxLPrice;
	}

	public void setMaxLPrice(double maxLPrice) {
		this.maxLPrice = maxLPrice;
	}

	public double getMinLPrice() {
		return minLPrice;
	}

	public void setMinLPrice(double minLPrice) {
		this.minLPrice = minLPrice;
	}

	public double getMaxAvePrice() {
		return maxAvePrice;
	}

	public void setMaxAvePrice(double maxAvePrice) {
		this.maxAvePrice = maxAvePrice;
	}

	public double getMinAvePrice() {
		return minAvePrice;
	}

	public void setMinAvePrice(double minAvePrice) {
		this.minAvePrice = minAvePrice;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getAvePrice() {
		return avePrice;
	}

	public void setAvePrice(double avePrice) {
		this.avePrice = avePrice;
	}

	public double gethPrice() {
		return hPrice;
	}

	public void sethPrice(double hPrice) {
		this.hPrice = hPrice;
	}

	public double getlPrice() {
		return lPrice;
	}

	public void setlPrice(double lPrice) {
		this.lPrice = lPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Double getPredicHPrice() {
		return predicHPrice;
	}

	public void setPredicHPrice(Double predicHPrice) {
		this.predicHPrice = predicHPrice;
	}

	public Double getPredicLPrice() {
		return predicLPrice;
	}

	public void setPredicLPrice(Double predicLPrice) {
		this.predicLPrice = predicLPrice;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
}

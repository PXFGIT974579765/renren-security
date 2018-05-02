package io.renren.modules.sys.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.*;

/**
 * 蔬菜预测价格实体
 * 
 * @author ryanyang
 * 
 * @date 2018年4月18日
 */
@TableName("sys_vegetable_pre")
public class SysVegetablePreEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 蔬菜ID
	 */
	@TableId
	private long veId;
	
	private double price;
	
	private String type;
	
	private String area;
	
	private String time;

	public SysVegetablePreEntity() {
		
	}
    public SysVegetablePreEntity(double price, String time) {
		this.price=price;
		this.time=time;
	}
	public long getVeId() {
		return veId;
	}

	public void setVeId(long veId) {
		this.veId = veId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
}

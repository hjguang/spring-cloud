package the.spring.cloud.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;

import the.spring.cloud.biz.entity.Goods;
import the.spring.cloud.biz.service.GoodsAdminService;

@RestController
@RequestMapping("/admin/goods")
public class GoodsAdminController {

	@Autowired
	GoodsAdminService goodsAdminService;

	@RequestMapping("/{id}")
	public String info(@PathVariable("id") Integer id) {
		Goods goods = goodsAdminService.selectById(id);
		return JSONObject.toJSONString(goods);
	}

	@RequestMapping("/list")
	public Page<Goods> list() {
		Page<Goods> page = goodsAdminService.selectList(null);
		return page;
	}
}

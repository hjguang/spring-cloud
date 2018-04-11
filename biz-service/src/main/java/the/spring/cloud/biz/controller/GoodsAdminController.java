package the.spring.cloud.biz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.google.gson.Gson;

import the.spring.cloud.biz.entity.Goods;
import the.spring.cloud.biz.service.GoodsAdminService;

@RestController
@RequestMapping("/admin/goods")
public class GoodsAdminController {

	@Autowired
	GoodsAdminService goodsAdminService;

	@RequestMapping("/{id}")
	public Goods info(@PathVariable("id") Integer id) {
		return goodsAdminService.selectById(id);
	}

	@RequestMapping("/list")
	public Page<Goods> list() {
		Page<Goods> page = goodsAdminService.selectList(null);
		return page;
	}
}

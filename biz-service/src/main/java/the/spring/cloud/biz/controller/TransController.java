package the.spring.cloud.biz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import the.spring.cloud.biz.entity.test.TransTest;
import the.spring.cloud.biz.service.TransService;
import the.spring.cloud.biz.util.JsonUtils;

import java.util.List;

@RestController
@RequestMapping("/trans")
public class TransController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransController.class);

    @RequestMapping("/{id}")
    public TransTest info(@PathVariable("id") Integer id) {
        return transService.getById(id);
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST)
    public void save(@RequestBody  TransTest entity) {
        LOGGER.info(JsonUtils.toJsonString(entity));
        transService.save(entity);
    }

    @RequestMapping("/list")
    public List<TransTest> list() {
        return transService.list();
    }

    @Autowired
    TransService transService;
}

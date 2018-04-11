package the.spring.cloud.client.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("biz-service")
public interface BizFeignClient {

	@RequestMapping(value="/admin/goods/{id}",method=RequestMethod.GET)
	String getGoodsInfo(@PathVariable("id") Integer id);
}

/**
 * 
 */
package the.spring.cloud.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author houjianguang
 *
 */
@RestController
@RequestMapping("/book")
public class BizController {

	private static final Logger logger = LoggerFactory.getLogger(BizController.class);
	
	@Autowired
	DataSource dataSource;

	// 初始化书籍列表
	public static List<Map<String, Object>> bookList = new ArrayList<>();
	static {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1000);
		map.put("bookName", "Pro Spring Boot");
		bookList.add(map);

		map = new HashMap<>();
		map.put("id", 1010);
		map.put("bookName", "Spring Microservice");
		bookList.add(map);
	}

	/**
	 * 根据id获取书籍信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public ModelMap getBookById(@PathVariable("id") Integer id) {
		logger.info("入参Id:{}", id);
		System.out.println(dataSource);
		ModelMap mm = new ModelMap();
		for (Map<String, Object> book : bookList) {
			Integer bookId = (Integer) book.get("id");
			if (id.intValue() == bookId.intValue()) {
				mm.addAttribute("book", book);
				break;
			}
		}
		return mm;
	}

	@RequestMapping("/queryAll")
	public List<?> queryAllBook() {
		return service.queryAllBook();
	}

	@Autowired
	BookComponent service;
}

@Component
class BookComponent {

	@HystrixCommand(fallbackMethod = "queryDefaultFallback")
	public List<?> queryAllBook() {
		return BizController.bookList;
	}

	public List<?> queryDefaultFallback() {
		return new ArrayList<>();
	}
}

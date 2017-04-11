package com.study.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.study.po.ItemsCustom;
import com.study.po.ItemsqueryVo;
import com.study.service.ItemsService;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;

/**
 * 对于不同的适配器写不同handler 具体需要实现什么接口看适配器标准
 * 
 * @author Administrator
 *
 */

@Controller // 这个表示这是对应的handler
@RequestMapping("/items")
public class ItemController3 {

	@Autowired
	private ItemsService itemsService;

	@RequestMapping(value = "/queryItems", method = { RequestMethod.POST, RequestMethod.GET }) // 对应的映射器
																								// 的注解
	public ModelAndView queryItems(HttpServletRequest request, HttpServletResponse response, ItemsqueryVo itemsqueryVo)
			throws Exception {

		// 调用service查找 数据库，查询商品列表，这里使用静态数据模拟
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsqueryVo);
		// 向list中填充静态数据

		// 返回ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		// 相当 于request的setAttribut，在jsp页面中通过itemsList取数据
		modelAndView.addObject("itemsList", itemsList);

		// 指定视图
		modelAndView.setViewName("items/itemsList");

		return modelAndView;
	}

	// method 可以进行方法的限定 requestParam id 和 jsp 的形参进行绑定
	@RequestMapping(value = "/editItem", method = { RequestMethod.GET })
	public String editItems(Model model,
			@RequestParam(value = "id", required = true, defaultValue = "1") Integer items_id, MultipartFile imaFile)
					throws Exception {

		ItemsCustom item = itemsService.findItmeByid(items_id);

		if (imaFile != null) {
			String originName = imaFile.getOriginalFilename();
			if (originName != null && !originName.equals("")) {
				String filePath = "D:\\devTools\\upload\\";

				// 写代码首先你要找到你要的东西，明确知道自己需要的是哪个部分的内容
				String fileNewName = UUID.randomUUID() + originName.substring(originName.lastIndexOf("."));

				// 构建一个新的file对象
				File file = new File(filePath + fileNewName);

				imaFile.transferTo(file);

				item.setPic(fileNewName);

			}
		}

		model.addAttribute("itemsCustom", item);

		return "items/editItems";
	}

	@RequestMapping(value = "/updateItem", method = { RequestMethod.POST }) // 对应的映射器
																			// 的注解
	public String updateItem(Model model, Integer id, @Validated ItemsCustom custom, BindingResult bindingResult)
			throws Exception {

		if (bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			List<String> errorsMessage = new ArrayList<String>();
			for (ObjectError error : errors) {

				// tomcat 这个东西默认编码是 ISO-8859-1 的
				System.out.println(
						"11111111111---->" + new String(error.getDefaultMessage().getBytes("ISO-8859-1"), "utf-8"));
				String defaultMessage = new String(error.getDefaultMessage().getBytes("ISO-8859-1"), "utf-8");
				errorsMessage.add(defaultMessage);
			}

			model.addAttribute("allErrors", errorsMessage);

			return "items/editItems";
		}

		itemsService.updateItem(id, custom);

		// 这个是重定向到列表中 修改提交的request数据无法传递
		return "redirect:queryItems";
	}

	@RequestMapping(value = "/deleteList", method = { RequestMethod.POST }) // 对应的映射器 的注解
	public String deleteItem(Integer[] item_id) throws Exception {

		// 这个是重定向到列表中 修改提交的request数据无法传递
		return "redirect:queryItems";
	}

}

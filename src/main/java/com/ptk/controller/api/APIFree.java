package com.ptk.controller.api;

import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ptk.domain.FileUpload;
import com.ptk.domain.FreeVO;
import com.ptk.domain.PageManager;
import com.ptk.domain.PageVO;
import com.ptk.persistence.FreeDAO;

@RestController
@RequestMapping("/apifree")
public class APIFree {
	
	@Inject
	private FreeDAO dao;
	
	@Resource(name = "uploadPath")
	private String uploadPath;
	
	private static final Logger logger = LoggerFactory.getLogger(APIFree.class);
	
	@RequestMapping(value = "/Posting", method = RequestMethod.POST, produces = "application/text; charset=UTF-8")
	public String freebbsposting(FreeVO vo, @RequestParam(value = "file", required = false) MultipartFile file) {
		String result;		
		if(file == null) {
			vo.setImg("");
		} else {
			FileUpload fileupload = new FileUpload(file, uploadPath);
			vo.setImg(fileupload.getFileName());			
		}
		dao.FreebbsPosting(vo);
		result = "{\"msg\":\"성공\",\"comment\":\"글이 작성되었습니다.\"}";
		return result;
	}
	
	@RequestMapping(value = "/GetList", method = RequestMethod.GET, produces = "application/text; charset=UTF-8")
	public String getFreeList() {
		PageVO page = new PageVO();
		page.setTotallist(getTotalList());
		PageManager pmg = new PageManager(page);
		page = pmg.getPage();
		String result;
		List<FreeVO> list = dao.getList();
		
		if(list.isEmpty()) {
			result = "{\"count\":\"0\"}";
		} else {
			result = "{\"count\":\""+getTotalList()+"\",\"list\":[";
			for(int i=0; i<list.size(); i++) {
				FreeVO vo = list.get(i);
				result += vo.getJSONString();
				if(i+1 == list.size()) {
					result += "],";
				} else {
					result += ",";
				}
			}
			result += "\"page\":"+page.toString()+"}";
		}
		//logger.info(result);
		return result;
	}
	
	@RequestMapping(value = "/GetFreeVO", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String getFreeVO(@RequestParam(value = "uid", required = false) Integer uid) {
		String result;
		logger.info(uid+"<<<<<<<<<<<<<<<<<<<");
		FreeVO vo = dao.getFreeItem(uid);
		logger.info(vo.getJSONString());
		result = vo.getJSONString();
		return result;
	}
	
	
	private int getTotalList() {		
		return dao.gettotalList();
	}

}

package com.gura.step03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {
	/*
	 * 	jackson 라이브러리가 pom.xml에 명시되고
	 * 	@ResponseBody를 붙여주고
	 * 	Map을 리턴하면 json 문자열이 응답된다.
	 */
	@RequestMapping("/json01")
	@ResponseBody
	// {}
	public Map<String, Object> json01(){
		Map<String, Object> map = new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		return map;
		
	}
	
	//[]
	@RequestMapping("/json02")
	@ResponseBody
	public List<String> json02(){
		List<String> list = new ArrayList<>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");
		return list;
	}
	
	//[{},{},{}]
	@RequestMapping("/json03")
	@ResponseBody
	public List<Map<String, Object>> json03(){
		
		List<Map<String, Object>> list = new ArrayList<>();
		
		Map<String, Object> map1 = new HashMap<>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		
		Map<String, Object> map2 = new HashMap<>();
		map2.put("num", 2);
		map2.put("name", "해골");
		
		Map<String, Object> map3 = new HashMap<>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		return list;
	}
	
	@RequestMapping("/json04")
	@ResponseBody
	// field명이 JSON의 key value가 된다.
	public MemberDto json04(){
		MemberDto dto = new MemberDto(1, "김구라", "노량진");
		return dto;
	}
	
	@RequestMapping("/ajax/test")
	public String ajaxTest(){
		return "ajax/test"; // forward이동, /WEB-INF/viws/ajax/test.jsp가 필요하다는걸 알아채야한다.
	}
	
	@RequestMapping("/ajax/getInfo")
	@ResponseBody
	public MemberDto getInfo(){
		MemberDto dto = new MemberDto(1, "김구라", "노량진");
		return dto;
	}
	
	@RequestMapping("/ajax/test2")
	public String ajaxTest2(){
		return "ajax/test2";
	}
	
	@RequestMapping("/ajax/checkId")
	@ResponseBody
	public Map<String, Object> checkId(@RequestParam String id){
		// 파라미터로 전달될 아이디의 사용 가능 여부를 판단해서
		boolean canUse = false;
		if(id.equals("gura")){
			canUse = false;
		} else {
			canUse = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("canUse", canUse);
		// json 문자열로 응답한다.
		return map;
	}
	
	@RequestMapping("/ajax/test3")
	public String ajaxTest3(){
		return "ajax/test3";
	}
	
	@RequestMapping("/ajax/getMembers")
	@ResponseBody
	public List<MemberDto> getMembers(){
		List<MemberDto> list = new ArrayList<>();
		MemberDto dto1 = new MemberDto(1, "김구라", "노량진");
		MemberDto dto2 = new MemberDto(2, "해골", "행신동");
		MemberDto dto3 = new MemberDto(3, "원숭이", "당구장");
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		return list;
	}
	
	
}

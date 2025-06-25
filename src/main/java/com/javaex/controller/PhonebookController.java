package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PersonVO;


@Controller
public class PhonebookController {
	// 필드
	@Autowired
	private PhonebookService phonebookService;
	// 생성자
	
	// 메소드 gs
	
	// 메소드 일반
	// 리스트
	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhonrbookController.list()");
		
		List<PersonVO> phonebookList = phonebookService.exeGetPhonebookList();
		model.addAttribute("pList",phonebookList);
		
		return "list";
	}
	
	// 등록폼
	@RequestMapping(value = "/wform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonrbookController.wform()");
		
		return "writeForm";
	}
	
	// 등록
	@RequestMapping(value = "/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVO personVO) {
		System.out.println("PhonrbookController.write()");
		
		phonebookService.exeGetPhonebookWrite(personVO);
		
		return "redirect:/list";
	}
	
	// 수정폼
	@RequestMapping(value = "/mform", method = {RequestMethod.GET, RequestMethod.POST})
	public String modifyForm(@RequestParam(value="no") int no, Model model) {
		System.out.println("PhonrbookController.mform()");	
		
		PersonVO personVO = phonebookService.exeGetPhonebookListOne(no);
		model.addAttribute("pVO", personVO);
		System.out.println(personVO);


		return "modifyForm";
	}
	
	// 수정
	@RequestMapping(value = "/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PersonVO personVO) {
		 System.out.println("수정폼에서 넘어온 personVO: " + personVO);
		
		phonebookService.exeGetPhonebookModify(personVO);
		
		System.out.println(personVO);
		
		return "redirect:/list";
	}
	
	// 삭제
	@RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam(value = "no") int no) {
		System.out.println("PhonebookController.delete()");
		
		phonebookService.exeGetPhonebookRemove(no);
		
		return "redirect:/list";
	}
	
	
}

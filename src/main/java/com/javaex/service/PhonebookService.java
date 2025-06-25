package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PersonVO;

@Service
public class PhonebookService {
	// 필드
	@Autowired
	private PhonebookDAO phonebookDAO;

	// 생성자
	// 메소드 gs
	// 메소드 일반
	// - 리스트 전체
	public List<PersonVO> exeGetPhonebookList(){
		System.out.println("phonebookService.exeGetPhonebookList()");
		
		List<PersonVO> phonebookList = phonebookDAO.personSelect();
		
		return phonebookList;
	}

	// - 리스트 하나
	public PersonVO exeGetPhonebookListOne(int no){
		System.out.println("phonebookService.exeGetPhonebookListOne()");
		
		PersonVO personVO = phonebookDAO.personSelectOne(no);
		
		return personVO;
	}

	
	// - 등록
	public int exeGetPhonebookWrite(PersonVO personVO) {
		System.out.println("phonebookService.exeGetPhonebookWrite()");
		
		int count= phonebookDAO.personInsert(personVO);
		
		return count;
	}

	// - 수정
	public int exeGetPhonebookModify(PersonVO personVO) {
		System.out.println("phonebookService.exeGetPhonebookModify()");
		
		int conunt = phonebookDAO.personUpdate(personVO);
		
		return conunt;
	}
	
	
	// - 삭제
	public int exeGetPhonebookRemove(int no) {
		System.out.println("phonebookService.exeGetPhonebookRemove()");
		
		int count = phonebookDAO.personDelete(no);
		
		return count;
	}
	
}

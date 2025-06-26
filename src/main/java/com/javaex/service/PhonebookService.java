package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<PersonVO> exeGetPhonebookList() {
		System.out.println("phonebookService.exeGetPhonebookList()");

		List<PersonVO> phonebookList = phonebookDAO.personSelect();

		return phonebookList;
	}

	// - 리스트 하나
	public PersonVO exeGetPhonebookListOne(int no) {
		System.out.println("phonebookService.exeGetPhonebookListOne()");

		PersonVO personVO = phonebookDAO.personSelectOne(no);

		return personVO;
	}

	// - 등록
	public int exeGetPhonebookWrite(PersonVO personVO) {
		System.out.println("phonebookService.exeGetPhonebookWrite()");
		// int count = phonebookDAO.personInsert(personVO);
		
		/* 가정(데이터가 여기서 생김, 묶어야 하는 상황시 방법)
			선택 1 : VO를 만들어서 묶는다.
			선택 2 : MAP으로 묶는다.
		 */
		// 선택2(MAP사용)
		Map<String, String> personMap = new HashMap<String, String>();
		personMap.put("name", "김동민");
		personMap.put("hp", "010-5230-7781");
		personMap.put("company", "02-427-7781");
		
		int count = phonebookDAO.personInsert2(personMap);
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

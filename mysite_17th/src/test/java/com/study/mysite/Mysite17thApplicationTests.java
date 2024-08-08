package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Mysite17thApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	@Test
	void testJpa() {
//		Question q1 = new Question();
//		q1.setSubject("JPA가 무엇인가요?");
//		q1.setContent("알고싶어요.");
//		q1.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q1); //첫 번째 질문 저장
//		
//		Question q2 = new Question();
//		q2.setSubject("ORM가 무엇인가요?");
//		q2.setContent("궁금합니다.");
//		q2.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q2); //두 번째 질문 저장
		
//		Question q3 = new Question();
//		q3.setSubject("hibernate가 무엇인가요?");
//		q3.setContent("궁금합니다.");
//		q3.setCreateDate(LocalDateTime.now());
//		this.questionRepository.save(q3); //세 번째 질문 저장
//		
//		List<Question> all = this.questionRepository.findAll();  //SELECT * FROM
//		assertEquals(3, all.size());
//		
//		Question q = all.get(0);
//		assertEquals("JPA가 무엇인가요?",q.getSubject());
		
//		Question q = this.questionRepository.findBySubject("ORM가 무엇인가요?");
//		assertEquals(3,q.getId());
		
//		Question q = this.questionRepository.findBySubjectAndContent("ORM가 무엇인가요?", "궁금합니다.");
//		assertEquals(3,q.getId());
		
//		List<Question> qList = this.questionRepository.findBySubjectLike("%무엇%");
//		this.questionRepository.findAll();
		
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.setSubject("무엇이든 궁금하면 물어보세요");
		this.questionRepository.save(q);
	}

}

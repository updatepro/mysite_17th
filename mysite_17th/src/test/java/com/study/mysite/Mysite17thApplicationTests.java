package com.study.mysite;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.mysite.answer.Answer;
import com.study.mysite.answer.AnswerRepository;
import com.study.mysite.question.Question;
import com.study.mysite.question.QuestionRepository;

@SpringBootTest
class Mysite17thApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
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
		
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		q.setSubject("무엇이든 궁금하면 물어보세요");
//		this.questionRepository.save(q);
		
//		assertEquals(4,this.questionRepository.count());
//		Optional<Question> oq = this.questionRepository.findById(1);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		this.questionRepository.delete(q);
//		assertEquals(3, this.questionRepository.count());
		
//		Optional<Question> oq = this.questionRepository.findById(2);
//		assertTrue(oq.isPresent());
//		Question q = oq.get();
//		
//		Answer a = new Answer();
//		a.setContent("스프링부트에서  사용하는 JPA의 인터페이스의 실제 구현체이다.");
//		a.setQuestion(q); //어떤 질문의 답변인지 설정해야 하기 때문에 Question 객체가 필요
//		a.setCreateDate(LocalDateTime.now());
//		this.answerRepository.save(a);
		
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		
		List<Answer> answerList = q.getAnswerList();
		//테스트 코드를 통과하지 못한 이유는 answerList는 q객체를 조회할 때가 아니라 getAnswerList()메소드를 호출하는 시점에 가져오기 때문에 에러가 난다. 이렇게 데이터를 필요한 시점에 가져오는 방식을 지연(lazy)방식이라고 한다. <=>이와 반대로 q객체를 조회할 때 미리 answer 리스트를 모두 가져오는 방식을 즉시(Eager)방식이라고 한다.=>테스트 코드시 이런 오류를 방지할 수 있는 가장 간단한 방법:@Transactional 애너테이션을 사용하여 DB세션이 끊기지 않고 계속 유지가 되어 해결!!
		assertEquals(1, answerList.size());
		assertEquals("스프링부트에서 사용하는 JPA 인터페이스의 실제 구현체이다.", answerList.get(0).getContent());
	}

}

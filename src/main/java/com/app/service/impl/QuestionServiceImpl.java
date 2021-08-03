package com.app.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.app.constants.QuestionState;
import com.app.constants.Role;
import com.app.dto.CreateQuesRequest;
import com.app.dto.SubmitAnsRequest;
import com.app.entities.Tag;
import com.app.entities.elements.Answer;
import com.app.entities.elements.Element;
import com.app.entities.elements.Question;
import com.app.entities.user.Member;
import com.app.entities.user.User;
import com.app.repositories.AnswerRepository;
import com.app.repositories.QuestionRepository;
import com.app.service.QuestionService;
import com.app.service.UserService;

public class QuestionServiceImpl implements QuestionService {

	private QuestionRepository questionRepository;
	
	private AnswerRepository answerRepository;
	
	private UserService userService;
	
	@Override
	public List<Element> searchQ(String query) {
		return questionRepository.values().stream().
				filter(q -> q.isSimilarQuestion(query)).collect(Collectors.toList());
	}

	@Override
	public void addTagsToQuestion(Long userID, Long quesID, Map<String,String> tags) {
		Question q = viewQuestion(quesID);
		
		User u = userService.getUser(userID, Role.MODIFY_Q); 
		
		if(q.getCreatedUserID() != u.getUserID())
			throw new RuntimeException("Question modification access denied");
		
		tags.keySet().stream().map( key -> new Tag(key, tags.get(key))).forEach( tag -> q.addTag(tag));
		
	}

	@Override
	public Question viewQuestion(Long quesID) {
		Question q = questionRepository.get(quesID);
		if(q == null)
			throw new RuntimeException("Question not found!");
		return q;
	}

	@Override
	public Question postQuestion(Long userID, CreateQuesRequest req) {
		User u = userService.getUser(userID, Role.POST_Q);
		
		Question q = req.createQuestion(u.getUserID());
		
		questionRepository.put(q.getElementID(), q);
		
		((Member) u).addActivity(q);
		
		return q;
	}

	@Override
	public Answer answerQuestion(Long userID, SubmitAnsRequest req) {
		User u = userService.getUser(userID, Role.POST_ANS);
		
		Answer ans = req.createAnswer(u.getUserID());
		
		Question q = viewQuestion(ans.getQuestionID());
		
		answerRepository.put(ans.getElementID(), ans);
		
		q.addElement(ans);
		
		((Member) u).addActivity(ans);
		
		return ans;
	}

	@Override
	public Question changeQuestionState(Long userID, Long quesID, QuestionState newState) {
		User u = userService.getUser(userID, newState.role);
		
		Question q = viewQuestion(quesID);
		
		q.updateQuestionState(newState);
		
		return q;
	}
	
	

}

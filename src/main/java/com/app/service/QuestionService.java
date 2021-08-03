package com.app.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.app.constants.QuestionState;
import com.app.dto.CreateQuesRequest;
import com.app.dto.SubmitAnsRequest;
import com.app.entities.elements.Answer;
import com.app.entities.elements.Element;
import com.app.entities.elements.Question;

public interface QuestionService {

	List<Element> searchQ(String query);
	
	void addTagsToQuestion(Long userID, Long quesID, Map<String,String> tags);

	Question viewQuestion(Long quesID);
	
	Question postQuestion(Long userID, CreateQuesRequest req);
	
	Answer answerQuestion(Long userID, SubmitAnsRequest req);
	
	Question changeQuestionState(Long userID, Long quesID, QuestionState newState);
}

package io.larkin.phdplatformer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.Question;
import io.larkin.phdplatformer.repository.QuestionRepository;
import io.larkin.phdplatformer.response.QuestionsResponse;

@Controller
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	
	@RequestMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Question read(@PathVariable("id") int id) {
		Question q = questionRepository.findOne(id);
		return q;
	}

	@RequestMapping("game/{game}/level/{level}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody QuestionsResponse levelQs(@PathVariable("level") String level, @PathVariable("game") String game) {
		return new QuestionsResponse(questionRepository.findByGameLevel(level, game));
	}
}

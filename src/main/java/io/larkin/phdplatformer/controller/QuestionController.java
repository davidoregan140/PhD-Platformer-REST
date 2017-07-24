package io.larkin.phdplatformer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.Level;
import io.larkin.phdplatformer.domain.Question;
import io.larkin.phdplatformer.repository.LevelRepository;
import io.larkin.phdplatformer.repository.QuestionRepository;
import io.larkin.phdplatformer.response.IntegerListResponse;

@Controller
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	LevelRepository levelRepository;
	
	@RequestMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Question read(@PathVariable("id") int id) {
		Question q = questionRepository.findOne(id);
		return q;
	}

	@RequestMapping("/level/{name}/full")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Level levelQs(@PathVariable("name") String name) {
		Level l = levelRepository.findOne(name);
		return l;
	}
	
	@RequestMapping("/level/{name}")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody IntegerListResponse levelQIds(@PathVariable("name") String name) {
		return new IntegerListResponse(questionRepository.getIdByLevelName(name));
	}

}

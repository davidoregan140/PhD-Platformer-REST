package io.larkin.phdplatformer.response;

import io.larkin.phdplatformer.domain.Question;

public class QuestionsResponse {

	public Iterable<Question> questions;

	public Iterable<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Iterable<Question> questions) {
		this.questions = questions;
	}

	public QuestionsResponse(Iterable<Question> questions) {
		super();
		this.questions = questions;
	}
}

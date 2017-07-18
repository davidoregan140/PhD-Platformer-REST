package io.larkin.phdplatformer.response;

import java.util.List;

/**
 * Return a list in a JSON document
 * 
 * @author Larkin.Cunningham
 *
 */
public class IntegerListResponse {

	public IntegerListResponse(List<Integer> list) {
		this.list = list;
	}

	List<Integer> list;

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
}

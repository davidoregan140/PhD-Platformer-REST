package io.larkin.phdplatformer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import io.larkin.phdplatformer.domain.Pickup;
import io.larkin.phdplatformer.repository.PickupRepository;

@Controller
@RequestMapping("/api/pickup")
public class PickupController {

	@Autowired
	PickupRepository pickupRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Pickup getById(@PathVariable("id") String id) {
		Pickup p = pickupRepository.get(id);
		return p;
	}
}

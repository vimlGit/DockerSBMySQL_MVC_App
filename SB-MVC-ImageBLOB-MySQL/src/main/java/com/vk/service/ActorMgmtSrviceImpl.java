package com.vk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.entity.Actor;
import com.vk.repository.IActorRepository;

@Service
public class ActorMgmtSrviceImpl implements IActorMgmtService {

	@Autowired 
	private IActorRepository actorRepo ;
	@Override
	public String registerActor(Actor actor) {		
		Actor save = actorRepo.save(actor);
		return "Actor saved with ID value..::"+save.getId() ;
	}
	@Override
	public List<Actor> showReport() {
        List<Actor> all = actorRepo.findAll();
		return all;
	}
	
	@Override
	public Actor fetchActorById(Integer id) {
	    return actorRepo.findById(id).orElse(null);
	}
}

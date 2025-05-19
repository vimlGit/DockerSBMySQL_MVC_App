package com.vk.service;

import java.util.List;

import com.vk.entity.Actor;

public interface IActorMgmtService {
	public String registerActor(Actor actor);
	public List<Actor>  showReport();
	Actor fetchActorById(Integer id);
}

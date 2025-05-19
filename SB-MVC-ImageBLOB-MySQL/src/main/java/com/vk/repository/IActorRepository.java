package com.vk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vk.entity.Actor;

public interface IActorRepository extends JpaRepository<Actor, Integer> {

}

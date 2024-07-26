package com.networking.demo.repository.unused_repositories;


import org.springframework.data.repository.ListCrudRepository;

import com.networking.demo.entity.unused_entities.PlatformEntity;


public interface PlatformRepository extends ListCrudRepository<PlatformEntity, Long> {
}

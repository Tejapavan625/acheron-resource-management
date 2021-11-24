package org.arm.resource.mngt.repository;

import org.arm.resource.mngt.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepourceRepository extends JpaRepository<Resource, Integer> {

}
